package main;

import java.util.LinkedList;
import java.util.List;

public class Kandidatengenerator { 
	
	/**
	 * Gibt ein Array mit möglichen Kombinationen der Zeichen in
	 * erlaubteZeichen mit der Laenge sequenzLaengeK zurück.
	 * @param erlaubteZeichen
	 * @param sequenzLaengeK
	 * @return Array mit den Strings mit Zeichen aus erlaubteZeichen
	 */
	public static String[] generiereSequenzKElemente(
			char[] erlaubteZeichen,
			int sequenzLaengeK) 
	{ 
		int nAnzahlErlaubteZeichen = erlaubteZeichen.length;
		List<String> ergebnisListe = new LinkedList<>();
		generiereKombinationenRekursiv(erlaubteZeichen, "", nAnzahlErlaubteZeichen, sequenzLaengeK, ergebnisListe);
		return ergebnisListe.toArray(new String[0]);
	} 

	private static List<String> generiereKombinationenRekursiv(
			char[] erlaubteZeichen,
			String praefix,  
			int nAnzahlErlaubteZeichen,
			int kAnzahlNochZuKombinieren,
			List<String> ergebnisListe) 
	{  
		if (kAnzahlNochZuKombinieren == 0)  
		{ 
			ergebnisListe.add(praefix);
			return ergebnisListe; 
		}  
		for (int i = 0; i < nAnzahlErlaubteZeichen; ++i)
		{  
			String newPrefix = praefix + erlaubteZeichen[i];
			generiereKombinationenRekursiv(erlaubteZeichen, newPrefix,
					nAnzahlErlaubteZeichen, kAnzahlNochZuKombinieren - 1,ergebnisListe);
		}
		return ergebnisListe;
	}
}
