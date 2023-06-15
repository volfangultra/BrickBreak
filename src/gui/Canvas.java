package gui;
/*
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import igrica.Konstanta;
import logika.Cigla;
import logika.Lopta;
import logika.Reket;

// TODO: Auto-generated Javadoc
/**
 * The Class Canvas.
 * Klasa koja iscrtava na ekran
 */
public class Canvas extends JPanel{
	
	/** The g. */
	Graphics g;
	
	/** The lopta. */
	Lopta lopta;
	
	/** The reket. */
	Reket reket;
	
	/** The cigle. */
	Cigla[] cigle;
	
	/** The trenutni level. */
	private int trenutni_level;
	
	/**
	 * Instantiates a new canvas.
	 *
	 * @param lopta the lopta
	 * @param reket the reket
	 * @param cigle the cigle
	 * @param trenutni_level the trenutni level
	 */
	Canvas(Lopta lopta, Reket reket, Cigla[] cigle, int trenutni_level){
		this.trenutni_level = trenutni_level;
		this.lopta = lopta;
		this.reket = reket;
		this.cigle = cigle;
		this.setBackground(Konstanta.boja_pozadine);
		LineBorder ram = new LineBorder(Color.white);
		this.setBorder(ram);
		
	}
	
	/**
	 * Paint component.
	 * Overridam metodu pomocu koje mogu da se repaintom iscrtam na ekran, na ekran iscrtavam loptu kao kruznicu, cigle kao pravougaonik, reket kao pravoganik
	 * i pisem sa g.drawString koji je trenutno level.
	 * @param g the g
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String level = "Level " + trenutni_level;
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.drawString(level, Konstanta.dimenzija - 100, 10 + g.getFontMetrics().getHeight());
		
		g.setColor(Konstanta.boja_lopte);
		g.fillOval(lopta.getX(), lopta.getY(), lopta.getR(), lopta.getR());
		
		g.setColor(Konstanta.boja_reketa);
		g.fillRect(reket.getX1(), Konstanta.dimenzija - Konstanta.visina_reketa, Konstanta.sirina_reketa, Konstanta.visina_reketa);
		if(cigle != null)
		for(int i = 0; i < cigle.length; i+=1) {
			if(cigle[i].getTip() == Konstanta.slaba_cigla)
				g.setColor(Konstanta.boja_slabe_cigle);
			else if(cigle[i].getTip() == Konstanta.srednja_cigla)
				g.setColor(Konstanta.boja_srednje_cigle);
			else if(cigle[i].getTip() == Konstanta.jaka_cigla)
				g.setColor(Konstanta.boja_jake_cigle);
			if(cigle[i].getTip() != Konstanta.prazno)
				g.fillRect(cigle[i].getX(), cigle[i].getY(), Konstanta.sirina_cigle, Konstanta.visina_cigle);
		}
	}

	
	/**
	 * Sets the.
	 *
	 * @param lopta the lopta
	 * @param reket the reket
	 * @param cigle the cigle
	 * @param trenutni_level the trenutni level
	 * da mogu na drugim mjestima mjenjat sta iscrtavam
	 */
	public void set(Lopta lopta, Reket reket, Cigla[] cigle, int trenutni_level) {
		this.lopta = lopta;
		this.reket = reket;
		this.cigle = cigle;
		this.trenutni_level = trenutni_level;
		
	}


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	

}
