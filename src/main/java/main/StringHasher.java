package main;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringHasher {

	/**
	 * Hasht einen String.
	 * @param klartext
	 * @return Hash des Klartexts in Hex-Schreibweise.
	 */
	public static String erzeugeSHA512Hash(String klartext){
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] hashBytes = md.digest(klartext.getBytes(StandardCharsets.UTF_8));
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<hashBytes.length;i++) {
				hexString.append(Integer.toHexString(0xFF & hashBytes[i]));
			}
			hash = hexString.toString();
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		return hash;
	}

}
