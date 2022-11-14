package exercise;

import main.AHashCracker;
import main.StringHasher;

public class HashCracker extends AHashCracker {
    public static volatile boolean irgendwerHatLoesungGefunden = false;

    public HashCracker(String[] searchThrew, int offset, int step, String searchingForHash) {
        this.kandidatenListe = searchThrew;
        this.offset = offset;
        this.gesuchterHash = searchingForHash;
        this.schrittweite = step;
    }

    public HashCracker(String[] searchThrew, int offset, int step, String searchingForHash, String threadName) {
        this(searchThrew, offset, step, searchingForHash);
        setName(threadName);
    }

    @Override
    public void run() {
        for (int i = offset; i < kandidatenListe.length; i += schrittweite) {
            if (StringHasher.erzeugeSHA512Hash(kandidatenListe[i]).equals(gesuchterHash)) {
                loesung = kandidatenListe[i];
                threadHatLoesungGefunden = true;
                irgendwerHatLoesungGefunden = true;
                System.out.println("found similar Hash from Thread " + Thread.currentThread().getName());
                System.out.println("and by the way the found String was: " + loesung);
                System.out.println("found the match at [" + i + "/" + kandidatenListe.length + "]");
                break;
            }
            if (irgendwerHatLoesungGefunden) {
                System.out.println("ein anderer Thread hat eine Loesung gefunden");
                System.out.println("got interrupted from other thread at [" + i + "/" + kandidatenListe.length + "]");
                return;
            }
        }
    }
}
