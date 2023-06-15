package igrica;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 * Provjerava da li korisnik želi pokreniti konzolnu ili gui verziju.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrickBreak igrica = new BrickBreak();
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite 1 za konzolnu igru a 2 za GUI");
		if(ulaz.nextInt() == 1)
			igrica.pokreni_konzolu();
		else {
			igrica.pokreni_gui();
		}

	}

}
