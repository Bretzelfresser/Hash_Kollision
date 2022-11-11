package main;

/*
 * TODO:
 * Klasse Main von dieser Klasse ableiten und fehlende Methoden
 * implementieren:
 * - main()
 */

public abstract class AMain {
	
	/*
	 * Menge der erlaubten Zeichen
	 */
	protected static char[] erlaubteZeichen = {
			'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 'ä', 'ö', 'ü', 'ß'
	};
	
	/*
	 * Länge der Zeichensequenz mit Elementen aus erlaubteZeichen,
	 *  aus der der gesuchte Hash erzeugt wurde
	 */
	protected static int kSequenzLaenge = 4;
	
	/*
	 * der gesuchte Hash
	 */
	protected static String hash = "b6312dafdff3b71325f1946daae1b665c3e1d7cf3c66837cc6426805edd967bec0c07c89b278790fb3f73271035f38c1989fb2b5a487e18461b12264";
	
	/*
	 * Anzahl der nebenläufigen Threads, die Brute-Force mäßig nach dem
	 * gesuchten Hash suchen sollen.
	 */
	protected static int nAnzahlThreads = 4;

}
