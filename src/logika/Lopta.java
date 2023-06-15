package logika;
/*
 * 
 */
import java.util.Random;

import igrica.Konstanta;

// TODO: Auto-generated Javadoc
/**
 * The Class Lopta.
 */
public class Lopta {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The r. */
	private int r;
	
	/** The k. */
	private double k;
	
	/** The n. */
	private double n;
	
	/** The dole. */
	private boolean dole;
	
	/**
	 * Instantiates a new lopta.
	 * Postavi loptu na sredinu ekrana i daje joj random smjer ali prema dole
	 */
	Lopta(){
		x = Konstanta.dimenzija / 2 - Konstanta.velicina_lopte/2;
		y = Konstanta.dimenzija / 2 - Konstanta.velicina_lopte/2 - 100;
		r = Konstanta.velicina_lopte;
		Random rand = new Random();
		k = 0;
		while(k == 0)
			k = rand.nextInt(-10,10);
		n = y - k*x;
		dole = true;
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
	 * Gets the r.
	 *
	 * @return the r
	 */
	public int getR() {
		return r;
	}
	
	/**
	 * Pomjeri. Pomjera je konstantnom brzinom u nekom smjeru
	 */
	public void pomjeri() {
		if(dole)
			y += Math.abs(Math.sin(Math.atan(k))) * Konstanta.brzina_lopte;
		else
			y -= Math.abs(Math.sin(Math.atan(k))) * Konstanta.brzina_lopte;
	
		x = (int) ((y-n)/k);
	}
	
	/**
	 * Sudar zid.
	 * Ako lopta udari u zid onda joj se pravac mjenja a smjer ostaje siti
	 */
	public void sudar_zid() {
		k = -1*k;
		n = y - k*x;
	}
	
	/**
	 * Sudar plafon.
	 * Ako lopta udari u plafon ili u reket onda joj se pravac i smjer mjenjaju
	 */
	public void sudar_plafon() {
		k = -1*k;
		n = y - k*x;
		dole = !dole;
		
	}

	/**
	 * Odbiji lijevo.
	 * Ako udari u lijevi cosak reket odbija se randomly ali lijevo
	 */
	public void odbiji_lijevo() {
		Random rand = new Random();
		k = rand.nextDouble(0.2,1);
		n = y - k*x;
		dole = !dole;
		
	}

	/**
	 * Odbiji desno.
	 * Ako udari u desni cosak reket odbija se randomly ali desno
	 */
	public void odbiji_desno() {
		Random rand = new Random();
		k = -1*rand.nextDouble(0.2,1);
		n = y - k*x;
		dole = !dole;
		
	}

	
	

}
