import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Nyilvantarto {
    //Vector<Ember> tarolo = new Vector<>();
    //List<Ember> tarolo = new ArrayList<>();
    ArrayList<Ember> tarolo = new ArrayList<>();

    public static void main(String[] args) {
        Nyilvantarto adattarolo = new Nyilvantarto();
        adattarolo.tarolo.add(new Ember());
        adattarolo.tarolo.add(new Ember("Teszt 3", 1984));
        adattarolo.tarolo.add(new Ember("Teszt 4", 1990));
        adattarolo.tarolo.add(new Ember("Teszt 2", 2000));

        System.out.println("Meret: " + adattarolo.tarolo.size());
        //System.out.println("Kapacitas: " + adattarolo.tarolo.capacity()); // List nem tud capacity()-t

        Iterator<Ember> emberIterator = adattarolo.tarolo.iterator();
        while (emberIterator.hasNext()) {
            System.out.println(emberIterator.next());
        }
        System.out.println();

        adattarolo.tarolo.add(0, new Ember("0. elem", 2010));
        adattarolo.tarolo.set(0, new Ember("0. elem felulirva", 1990));

        for (Ember ember: adattarolo.tarolo) {
            System.out.println(ember.getNev());
        }
        System.out.println();

        if (adattarolo.tarolo.contains(new Ember("Teszt 2", 2000))) {
            System.out.println("Benne van");
        } else {
            System.out.println("Nincs benne");
        }
        System.out.println();

        Collections.sort(adattarolo.tarolo);
        for (Ember ember: adattarolo.tarolo) {
            System.out.println(ember.getNev());
        }
        System.out.println();

        Collections.sort(adattarolo.tarolo, new EmberEvHasonlito());
        for (Ember ember: adattarolo.tarolo) {
            System.out.println(ember.getNev() + " " + ember.getSzuletesiEv());
        }
        System.out.println();
    }
}

class EmberEvHasonlito implements Comparator<Ember> {
    @Override
    public int compare(Ember e1, Ember e2) {
        return e1.getSzuletesiEv() - e2.getSzuletesiEv();
    }
}
