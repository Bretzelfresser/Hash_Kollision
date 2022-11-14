package exercise;

import main.AHashCracker;
import main.AMain;
import main.Kandidatengenerator;

import java.util.ArrayList;
import java.util.List;

public class Main extends AMain {

    private static final List<AHashCracker> crackerThreads = new ArrayList<>();

    public static void main(String[] args) {
        String[] possibleValues = Kandidatengenerator.generiereSequenzKElemente(erlaubteZeichen, kSequenzLaenge);
        System.out.println(possibleValues.length);
        for (int i = 0; i < nAnzahlThreads; i++) {
            crackerThreads.add(new HashCracker(possibleValues, i, nAnzahlThreads, hash, "Thread: " + i));
        }
        crackerThreads.forEach(Thread::start);


    }
}
