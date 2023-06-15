package gui;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import igrica.Konstanta;
import logika.Cigla;
import logika.Logika;
import logika.Lopta;
import logika.Reket;

// TODO: Auto-generated Javadoc
/**
 * The Class GUI.
 */
public class GUI {
	
	/** The logika. */
	Logika logika;
	
	/** The glavni prozor. */
	Okvir glavni_prozor;

	public boolean idem_lijevo;

	public boolean idem_desno;

	
	/**
	 * Instantiates a new gui.
	 */
	public GUI(){
		glavni_prozor = new Okvir("BrickBreak", this);
	}
	
	/**
	 * Povezi sa logikom.
	 *
	 * @param logika the logika
	 */
	public void povezi_sa_logikom(Logika logika) {
		this.logika = logika;
	}
	

	public void pokreni_igricu() {
		// TODO Auto-generated method stub
		glavni_prozor.setVisible(true);
		while(logika.trenutni_level != Konstanta.max_level) {
			glavni_prozor.postavi_sadrzaj(logika.lopta, logika.reket, logika.cigle, logika.trenutni_level);
			while(logika.zavrseno == false) {
					try {
						Thread.sleep(Konstanta.brzina_igrice);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					logika.idem_desno = idem_desno;
					logika.idem_lijevo = idem_lijevo;
					logika.uradi_potez();
					glavni_prozor.update(logika.lopta, logika.reket, logika.cigle, logika.trenutni_level);
					
				}
		}
	}
		
	
}
