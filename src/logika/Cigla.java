package logika;
import igrica.Konstanta;

// TODO: Auto-generated Javadoc
/**
 * The Class Cigla.
 */
public class Cigla {
	
	/** The tip koji može biti slaba srednja i jaka cigla*/
	int tip;
	
	/** The health. */
	int health;
	
	/** The x. */
	int x;
	
	/** The y. */
	int y;
	
	/**
	 * Instantiates a new cigla.
	 *
	 * @param tip the tip
	 * @param x the x
	 * @param y the y
	 */
	Cigla(int tip, int x, int y){
		this.x = x;
		this.y = y;
		this.tip = tip;
		switch(tip) {
			case Konstanta.slaba_cigla:
				health = 1;
				break;
			case Konstanta.srednja_cigla:
				health = 2;
				break;
			case Konstanta.jaka_cigla:
				health = 3;
				break;
			default:
				health = 0;
				break;
	
		}
	}
	
	/**
	 * Primi damage. Svako primanje damage smanji health za 1 te smanji tip cigle
	 */
	public void primi_damage() {
		health -= 1;
		switch(health) {
			case 1:
				tip = Konstanta.slaba_cigla;
				break;
			case 2:
				tip = Konstanta.srednja_cigla;
				break;
			default:
				tip = Konstanta.prazno;
				break;
		}

	}
	
	/**
	 * Gets the tip.
	 *
	 * @return the tip
	 */
	public int getTip(){
		return tip;
	}
	
	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Udario loptu.
	 * Provjerava da li je trenutno lopta udarila ciglu i ako jeste cigla primi damage i ako cigla i dalje ostaje ziva lopta se odbija a inace samo nastavi
	 * 
	 * @param lopta the lopta
	 */
	public void udario_loptu(Lopta lopta) {

		if(lopta.getX() + lopta.getR() >= x && lopta.getX() - lopta.getR() <= Konstanta.sirina_cigle + x) {
			if((lopta.getY() + lopta.getR() >= y && lopta.getY() + lopta.getR() <= y + Konstanta.brzina_lopte)
					|| (lopta.getY() - lopta.getR() >= y + Konstanta.visina_cigle - Konstanta.brzina_lopte && lopta.getY() - lopta.getR() <= y + Konstanta.visina_cigle)) {
				
				if(tip != Konstanta.prazno && tip != Konstanta.slaba_cigla) 
					lopta.sudar_plafon();
				
				primi_damage();
			}
			
			else if(lopta.getY() + lopta.getR() >= y && lopta.getY() - lopta.getR() <= y + Konstanta.visina_cigle) {
				
				if(tip != Konstanta.prazno && tip != Konstanta.slaba_cigla) 
					lopta.sudar_zid();
				
				primi_damage();
			}
		}
		
	}

}
