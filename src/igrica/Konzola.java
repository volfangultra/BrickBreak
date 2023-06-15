package igrica;

import java.util.Scanner;

import logika.Logika;

// TODO: Auto-generated Javadoc
/**
 * The Class Konzola.
 */
public class Konzola {
	
	/** The sadrzaj. */
	int[][] sadrzaj;
	
	/** The logika. */
	Logika logika;
	
	/** The ulaz. */
	Scanner ulaz;
	
	/**
	 * Instantiates a new konzola.
	 */
	public Konzola() {
		sadrzaj = new int[Konstanta.dimenzija/25][Konstanta.dimenzija/25];
		for(int i = 0; i < sadrzaj.length; i+= 1)
			for(int j = 0; j < sadrzaj[i].length; j+= 1)
				sadrzaj[i][j] = 0;
	}
	
	/**
	 * Povezi konzolu sa logikom.
	 *
	 * @param logika the logika
	 */
	public void povezi_konzolu_sa_logikom(Logika logika) {
		this.logika = logika;
	}
	
	/**
	 * Sadrzaj je matrica u kojoj brojevi iz Konstane označavaju koji objekat je u pitanju(reket, lopta ili cigla)
	 * Taj sadržaj se popunjava ili osvježava ovdje.
	 */
	private void popuni_sadrzaj() {
		for(int i = 0; i < sadrzaj.length; i++) 
			for(int j = 0; j < sadrzaj[i].length; j++) {
				boolean postavio = false;
				if(j == Math.floor(logika.lopta.getX()/25) && i == Math.floor(logika.lopta.getY()/25)) { 
					sadrzaj[i][j] = Konstanta.lopta;
					postavio = true;
				}
				else if(i == sadrzaj.length - 1 && j > logika.reket.getX1()/25 && j < logika.reket.getX2()/25) {
					sadrzaj[i][j] = Konstanta.sredina_reketa;
					postavio = true;
				}
				if(!postavio) {
					for(int k = 0; k < logika.cigle.length; k++)
						if(j >= logika.cigle[k].getX()/25 && j <= logika.cigle[k].getX()/25 + Konstanta.sirina_cigle/25 && i <= logika.cigle[k].getY()/25 && i >= logika.cigle[k].getY()/25 - Konstanta.visina_cigle/25) {
							sadrzaj[i][j] = logika.cigle[k].getTip();
							postavio = true;
							break;
						}
				}
				if(!postavio)
					sadrzaj[i][j] = Konstanta.prazno;
							
				}
		
		
	}
	
	/**
	 * Ispisuje tu matricu u konzolu
	 */
	private void ispisi_sadrzaj() {
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0; i < sadrzaj.length; i++) {
			for(int j = 0; j < sadrzaj[i].length; j++)
				System.out.print(sadrzaj[i][j] + " ");
			System.out.println();
		}
		
	}

	/**
	 * Provjerava da li je unos "A" ili "D" to jest da li korisnik želi da ide desno ili lijevo
	 * i u odnosu na prema to kaže logici eda pomjeri reket.
	 */
	public void pokreni_igricu() {
		System.out.println("BRICK BREAK");
		ulaz = new Scanner(System.in);
		String input;
		boolean zavrsi = false;
		while(logika.trenutni_level != Konstanta.max_level) {
			while(logika.zavrseno == false) {
					popuni_sadrzaj();
					ispisi_sadrzaj();
					input = ulaz.nextLine();
					System.out.println("Vaš input je: " + input);
					if(input.equals("A") || input.equals("a")) {
						logika.idem_desno = false;
						logika.idem_lijevo = true;
					}
					else if(input.equals("D") || input.equals("d")){
						logika.idem_desno = true;
						logika.idem_lijevo = false;
					}
					else {
						zavrsi = true;
						System.out.println("Pogresan input");
						break;
					}
					for(int i = 0; i < 10; i+=1)
						logika.uradi_potez();
					
				}
			if(zavrsi)
				break;
		}
		
	}

}
