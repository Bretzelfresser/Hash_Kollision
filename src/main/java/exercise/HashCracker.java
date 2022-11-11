package exercise;

import main.AHashCracker;
import main.StringHasher;

public class HashCracker extends AHashCracker {

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
            if (StringHasher.erzeugeSHA512Hash(kandidatenListe[i]).equals(gesuchterHash)){
                loesung = kandidatenListe[i];
                threadHatLoesungGefunden = true;
                Main.irgendwerHatLoesungGefunden = false;
                System.out.println("found similar Hash from Thread " + Thread.currentThread().getName());
                System.out.println("and by the way the found String was: " + loesung);
                break;
            }
            if (Main.irgendwerHatLoesungGefunden){
                System.out.println("ein anderer Thread hat eine Lösung gefunden");
                return;
            }
        }
    }
}
