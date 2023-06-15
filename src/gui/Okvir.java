package gui;
/*
 * 
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import igrica.Konstanta;
import logika.Cigla;
import logika.Lopta;
import logika.Reket;

// TODO: Auto-generated Javadoc
/**
 * The Class Okvir.
 */
public class Okvir extends JFrame{
	
	/** The gui. */
	GUI gui;
	
	/** The canvas. */
	Canvas canvas;
	
	/** The postavljen. */
	public boolean postavljen = false;

	/**
	 * Instantiates a new okvir.
	 * Postavlja akcije na dugmad za lijevo i desno da posalju signal ka logici kada je pritisnuto dugme za kretanje reketa
	 * 
	 * @param string the string
	 * @param gui the gui
	 */
	public Okvir(String string, GUI gui) {
		this.gui = gui;
		this.setName(string);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					gui.idem_desno = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					gui.idem_lijevo = true;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					gui.idem_desno = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					gui.idem_lijevo = false;
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(Konstanta.dimenzija + 17,Konstanta.dimenzija + 40);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Postavi sadrzaj.
	 * Ovo nam pravi okvir samo kada krene igra
	 * 
	 * @param lopta the lopta
	 * @param reket the reket
	 * @param cigle the cigle
	 * @param trenutni_level the trenutni level
	 */
	public void postavi_sadrzaj(Lopta lopta, Reket reket, Cigla[] cigle, int trenutni_level) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		canvas = new Canvas(lopta, reket, cigle, trenutni_level);
		add(canvas, c);
		canvas.repaint();
		postavljen = true;
	}
	
	/**
	 * Update.
	 * Ovo updejta canvas i poziva repaint() koje poziva paintComponent
	 * 
	 * @param lopta the lopta
	 * @param reket the reket
	 * @param cigle the cigle
	 * @param trenutni_level the trenutni level
	 */
	public void update(Lopta lopta, Reket reket, Cigla[] cigle, int trenutni_level) {
		canvas.set(lopta, reket, cigle, trenutni_level);
		canvas.repaint();
	}

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

}
