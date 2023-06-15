package igrica;
import gui.GUI;
import logika.Logika;

// TODO: Auto-generated Javadoc
/**
 * The Class BrickBreak.
 * Klasa koja veze logiku i GUI
 */
public class BrickBreak {
	
	/** The logika. */
	Logika logika;
	
	/** The gui. */
	GUI gui;
	
	Konzola konzola;
	
	/**
	 * Instantiates a new brick break.
	 */
	public BrickBreak() {
		logika = new Logika();
		gui = new GUI();
		konzola = new Konzola();
		gui.povezi_sa_logikom(logika);
		konzola.povezi_konzolu_sa_logikom(logika);
		
	}
	
	/**
	 * Pokrene gui verziju igrice.
	 */
	public void pokreni_gui() {
		gui.pokreni_igricu();
	}
	
	/**
	 * Pokrene konzolnu verziju igrice.
	 */
	public void pokreni_konzolu() {
		konzola.pokreni_igricu();
	}
	
}
