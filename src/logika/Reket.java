package logika;
import igrica.Konstanta;

// TODO: Auto-generated Javadoc
/**
 * The Class Reket.
 */
public class Reket {
	
	/** The x 1. */
	private int x1;
	
	/** The x 2. */
	private int x2;

	/**
	 * Instantiates a new reket.
	 *
	 * @param x1 the x 1
	 */
	public Reket(int x1) {
		this.x1 = x1 - Konstanta.sirina_reketa / 2;
		this.x2 = x1 + Konstanta.sirina_reketa / 2;
	}

	/**
	 * Pomjeri lijevo.
	 */
	public void pomjeri_lijevo() {
		if(x1 != 0) {
			x1 -= Konstanta.brzina_reketa;
			x2 -= Konstanta.brzina_reketa;
		}
		
	}

	/**
	 * Pomjeri desno.
	 */
	public void pomjeri_desno() {
		if(x2 != Konstanta.dimenzija) {
			x1 += Konstanta.brzina_reketa;
			x2 += Konstanta.brzina_reketa;
		}
		
	}

	/**
	 * Gets the x1.
	 *
	 * @return the x1
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * Gets the x2.
	 *
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * Udario loptu.
	 * Kada reket udari loptu treba provjeriti u koje mjesto rekete je udarilo da znamo kako odbiti loptu
	 *
	 * @param lopta the lopta
	 */
	public void udario_loptu(Lopta lopta) {
		if(lopta.getX() >= x1 && lopta.getX() <= x2 && lopta.getY() + lopta.getR() >= Konstanta.dimenzija - Konstanta.visina_reketa && lopta.getY() + lopta.getR() <= Konstanta.dimenzija - Konstanta.visina_reketa / 2)
			if(lopta.getX() <= x1 + Konstanta.sirina_reketa / 3)
				lopta.odbiji_lijevo();
			else if(lopta.getX() <= x1 + 2*Konstanta.sirina_reketa / 3)
				lopta.sudar_plafon();
			else
				lopta.odbiji_desno();
	}

}
