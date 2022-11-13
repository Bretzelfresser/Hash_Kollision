package exercise;

import main.AHashCracker;
import main.AMain;
import main.Kandidatengenerator;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends AMain {

    private static final List<AHashCracker> crackerThreads = new ArrayList<>();
    public static volatile boolean irgendwerHatLoesungGefunden = false;

    public static void main(String[] args) {
        String[] possibleValues = Kandidatengenerator.generiereSequenzKElemente(erlaubteZeichen, kSequenzLaenge);
        System.out.println(possibleValues.length);
        for (int i = 0; i < nAnzahlThreads; i++) {
            crackerThreads.add(new HashCracker(possibleValues, i, nAnzahlThreads, hash, "Thread: " + i));
        }
        crackerThreads.forEach(Thread::start);


    }
}
