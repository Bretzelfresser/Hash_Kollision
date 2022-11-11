package main;

/*
 * TODO:
 * - implementieren Sie den Konstruktor
 * - implementieren Sie die run()-Methode
 * - ergänzen Sie das boolean Attribut irgendwerHatLoesungGefunden
 */

public abstract class AHashCracker extends Thread {

	/*
	 *  Liste mit allen Kandidatenstrings
	 */
	protected String[] kandidatenListe;
	
	/*
	 *  Index des ersten Kandidatenstrings in Kandidatenliste,
	 *  der von diesem Thread überprüft wird
	 */
	protected int offset;
	
	/*
	 * Abstand zwischen den Kandidatenstrings in kandidatenListe,
	 *  die von diesem Thread überprüft werden
	 */
	protected int schrittweite;

	/*
	 * wird nur dann auf True gesetzt, wenn dieser Thread einen Kandidatenstring
	 * gefunden hat, der den gesuchten Hash erzeugt.
	 */
	protected boolean threadHatLoesungGefunden = false;
	
	/*
	 * wenn ein Kandidatenstring gefunden wurde, der den gesuchten Hash erzeugt,
	 * soll er hier abrufbar sein.
	 */
	protected String loesung = null;
	
	/*
	 * enthält den gesuchten Hash
	 */
	protected String gesuchterHash = null;

	public boolean hatThreadLoesungGefunden() {
		return threadHatLoesungGefunden;
	}
	public String getLoesung() {
		return loesung;
	}
	
	public abstract void run();

}
