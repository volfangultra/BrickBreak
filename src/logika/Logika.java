package logika;
/*
 * 
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import gui.GUI;
import igrica.Konstanta;

// TODO: Auto-generated Javadoc
/**
 * The Class Logika.
 */
public class Logika {
	
	/** The idem desno. */
	public boolean idem_desno = false;
	
	/** The idem lijevo. */
	public boolean idem_lijevo = false;
	
	/** The trenutni level. */
	public int trenutni_level;
	
	/** The cigle. */
	public Cigla[] cigle;
	
	/** The lopta. */
	public Lopta lopta;
	
	/** The reket. */
	public Reket reket;
	
	/** The zavrseno. */
	public boolean zavrseno = false;
	
	/** The gui. */
	GUI gui;
	
	/**
	 * Instantiates a new logika.
	 * posatavi trenutni level na 1 i napravi sadrzaj za konzolno ispisivanje, reket i loptu stavi na defaultne pozicije
	 */
	public Logika(){
		trenutni_level = 1;
		cigle = new Cigla[0];
		reket = new Reket(Konstanta.dimenzija / 2);
		lopta = new Lopta();
		napravi_level();
		
	}
	
	/**
	 * Pomjera loptu te provjerava da li je lopta udarili u zid ili u plafon. Ako primi signal od GUI ili konzole pomjera reket
	 * Ako lopta propadne kroz pod nastaje gubitak a padne na reket odbija se. U svakom momentu se provjerava da li su sve cigle nestale (ako se odbije od ciglu
	 * uništi je) i ako jesu onda je pobjeda.
	 */
	public void uradi_potez() {
			lopta.pomjeri();
			if(lopta.getX() + lopta.getR() >= Konstanta.dimenzija || lopta.getX() <= 0)
				lopta.sudar_zid();
			if(lopta.getY() <= 0)
				lopta.sudar_plafon();
			reket.udario_loptu(lopta);
			for(int i = 0; i < cigle.length; i+=1) {
				cigle[i].udario_loptu(lopta);
			}
			
			if(idem_lijevo || idem_desno) {
				if(idem_desno) {
					reket.pomjeri_desno();
				}
				if(idem_lijevo) {
					reket.pomjeri_lijevo();
				}
			}
			provjeri_pobjedu();
			
	}

	/**
	 * Napravi level samo postavlja cigle
	 */
	private void napravi_level() {
		reket = new Reket(Konstanta.dimenzija / 2);
		switch(trenutni_level) {
			case 1:
				cigle = new Cigla[10];
				for(int i = 0; i < 5; i++) {
					Cigla cigla = new Cigla(Konstanta.slaba_cigla,30 + Konstanta.sirina_cigle * i + 30*i,50);
					cigle[i] = cigla;
					cigla = new Cigla(Konstanta.slaba_cigla,30 + Konstanta.sirina_cigle * i + 30*i,150);
					cigle[5 + i] = cigla;
				}
				break;
			case 2:
				cigle = new Cigla[10];
				for(int i = 0; i < 5; i++) {
					Cigla cigla = new Cigla(Konstanta.slaba_cigla,30 + Konstanta.sirina_cigle * i + 30*i,50);
					cigle[i] = cigla;
					cigla = new Cigla(Konstanta.srednja_cigla,30 + Konstanta.sirina_cigle * i + 30*i,150);
					cigle[5 + i] = cigla;
				}
				break;
			case 3:
				cigle = new Cigla[6];
				for(int i = 0; i < 3; i++) {
					Cigla cigla = new Cigla(Konstanta.srednja_cigla,66 + Konstanta.sirina_cigle * i + 66*i,50);
					cigle[i] = cigla;
					cigla = new Cigla(Konstanta.jaka_cigla,66 + Konstanta.sirina_cigle * i + 66*i,150);
					cigle[3 + i] = cigla;
				}
				break;
			case 4:
				cigle = new Cigla[6];
				int broj = 0;
				for(int i = 0; i < 5; i++) { 
					if(i % 2 == 0) {
						Cigla cigla = new Cigla(Konstanta.jaka_cigla,30 + Konstanta.sirina_cigle * i + 30*i,50);
						cigle[broj] = cigla;
						cigla = new Cigla(Konstanta.jaka_cigla,30 + Konstanta.sirina_cigle * i + 30*i,150);
						cigle[broj + 1] = cigla;
						broj += 2;
					}
					
				}
				
				break;
		
		}
	}
	
	/**
	 * Ponovo igraj.
	 */
	public void ponovo_igraj() {
		lopta = new Lopta();
		reket = new Reket(Konstanta.dimenzija / 2);
		napravi_level();
		zavrseno = false;
		
	}
	

	/**
	 * Provjeri pobjedu.
	 * Provjerava da li je igrac pobjedio to jest da li su sve cigle unistene i ako jesu da li je trenutno na max levelu
	 */
	private void provjeri_pobjedu() {
		if(lopta.getY() > Konstanta.dimenzija) {
			zavrseno = true;
			ponovo_igraj();
		}
		boolean pobjedio = true;
		for(int i = 0; i < cigle.length; i++)
			if(cigle[i].getTip() != Konstanta.prazno)
				pobjedio = false;
		if(pobjedio && trenutni_level == Konstanta.max_level) {
			zavrseno = true;
		}
		else if(pobjedio) {
			trenutni_level++;
			lopta = new Lopta();
			napravi_level();
		}
		
	}

}
