import java.util.ArrayList;
import java.util.Arrays;

public class Hallgato extends Ember implements Comparable<Hallgato> {
    private String neptunKod;
    private String szak;
    private int evfolyam;
    private ArrayList<Targyak> targyakLista;
    //private Targyak[] targyakTomb;
    private int targyakSzama = 0;

    public Hallgato(String nev, int szuletesiEv, String neptunKod, String szak, int evfolyam, Targyak[] targyakTomb) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
        this.szak = szak;
        this.evfolyam = evfolyam;
        this.targyakLista = targyakLista;
        //this.targyakTomb = targyakTomb;
    }

    public Hallgato(String nev, int szuletesiEv, String neptunKod, String szak, int evfolyam) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
        this.szak = szak;
        this.evfolyam = evfolyam;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    public int getEvfolyam() {
        return evfolyam;
    }

    public void setEvfolyam(int evfolyam) {
        this.evfolyam = evfolyam;
    }

    public ArrayList<Targyak> getTargyakLista() {
        return targyakLista;
    }

    public void setTargyakLista() {
        this.targyakLista = new ArrayList<Targyak>();
    }

    public void setTargyakLista(ArrayList<Targyak> targyakLista) {
        this.targyakLista = targyakLista;
    }

    /*
    public Targyak[] getTargyakTomb() {
        return targyakTomb;
    }

    public void setTargyakTomb(Targyak[] targyakTomb) {
        this.targyakTomb = targyakTomb;
    }
     */

    public int getTargyakSzama() {
        return targyakSzama;
    }

    public void setTargyakSzama(int targyakSzama) {
        this.targyakSzama = targyakSzama;
    }

    public boolean targyFelvetel(Targyak targy){
        /*
        if (targy==null || targyakLista.contains(targy)) {
            return false;
        }
         */
        targyakLista.add(targy);
        targyakSzama++;
        return true;
    }

    public boolean targyLeadasIndex(int index) {
        targyakLista.remove(index);
        return true;
    }

    public boolean targyLeadasNev(String nev) {
        targyakLista.remove(nev);
        return true;
    }

    /*
    public boolean tantargyFelvetel (Targyak t) {
        if (t==null) return false;
        if (this.getTargyakTomb().length==targyakSzama) return false;
        for (int i=0; i<targyakSzama; i++) {
            if (targyakTomb[i].getKod().equals(t.getKod()))
                return false;
        }
        targyakTomb[targyakSzama] = t;
        targyakSzama++;
        return true;
    }
     */

    /*
    public boolean tantargyLeadas (Targyak t) {
        if (t == null) return false;
        if (this.targyakSzama == 0) return false;

        for (int i=0; i<targyakSzama; i++)
            //if (targyakTomb[i].getKod().equals(t.getKod()))
            if (targyakTomb[i].equals(t)) {
                for (int j=i; i<targyakSzama-1; j++)
                    targyakTomb[j] = targyakTomb[j+1];
                targyakSzama--;
                for (int j=targyakSzama; j<targyakTomb.length; j++)
                    targyakTomb[j] = null;
                return true;
            }
        return false;
    }
     */



    public static void printHallgatok(ArrayList<Hallgato> h) {
        for(Hallgato hallgato : h) {
            System.out.println(hallgato.getNev() + " - " + hallgato.getSzuletesiEv() + " - " + hallgato.getNeptunKod() + " " + hallgato.getSzak() );

            if (hallgato.getTargyakLista() != null)
                for (Targyak targy : hallgato.getTargyakLista())
                    System.out.println(targy.getNev() + " - " + targy.getOktato() + " - " + targy.getJegy());
            System.out.println();
        }
    }


    @Override
    public String toString() {
        StringBuilder szoveg = new StringBuilder();
        szoveg.append(super.toString() + "\nneptunkod: " + neptunKod + "\nszak: " + szak);
        Arrays.sort(targyakLista.toArray());
        szoveg.append(Arrays.toString(targyakLista.toArray()));
        return szoveg.toString();
    }


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";


    public static void main (String[] args) {

        /*
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Array Hallgato x ArrayList<Targyak>" + ANSI_RESET);

        Hallgato[] hallgatok = new Hallgato[5];

        hallgatok[0] = new Hallgato("Fabian Gabor", 1987, "CXNU8T", "Programtervezo informatikus", 2019);
        hallgatok[0].setTargyakLista();
        hallgatok[0].targyakLista.add(0, new Targyak("Teszt targy", "Teszt oktato"));
        hallgatok[0].targyFelvetel(new Targyak("Masik teszt targy", "Teszt oktato"));

        hallgatok[1] = new Hallgato("Teszt Teszter", 1024, "0xDEADCODE", "Programtervezo informatikus", 2019);
        hallgatok[1].setTargyakLista();
        hallgatok[1].targyakLista.add(0, new Targyak("Valami targy", "Teszt oktato"));
        hallgatok[1].targyFelvetel(new Targyak("Valami masik targy", "Teszt oktato"));


        for (int i=0; i<2; i++)
        {
            System.out.println(hallgatok[i].getNev());
            for (Targyak targy : hallgatok[i].targyakLista)
                System.out.println(targy.getNev() + " " + targy.getOktato());
            System.out.println();
        }
         */
        /*
         */

        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "ArrayList<Hallgato> x ArrayList<Targyak>" + ANSI_RESET);

        ArrayList<Hallgato> h = new ArrayList<Hallgato>();
        ArrayList<Targyak> t = new ArrayList<Targyak>();
        Oktato o = new Oktato("Oktato 1", 1951, "MS0331");

        // Hallgatok letrehozasa
        h.add(new Hallgato("Fabian Gabor", 1987, "CXNU8T", "Programtervezo informatikus", 2019));
        h.add(new Hallgato("Teszt Teszter", 1024, "0xDEADCODE", "Programtervezo informatikus", 2048));

        // Targyak letrehozasa
        t.add(new Targyak("Teszt targy 1", "Teszt Oktato 1", "ABC123"));
        t.add(new Targyak("Teszt targy 2", "Teszt Oktato 2", "ASD321"));
        t.add(new Targyak("Teszt targy 3", "Teszt Oktato 3", "QWE456"));

        h.get(0).setTargyakLista();


        /*
        h.get(0).targyFelvetel(new Targyak("Teszt targy 1", "Teszt Oktato"));
        h.get(0).targyFelvetel(new Targyak("Teszt targy 2", "Teszt Oktato"));
        h.get(0).targyFelvetel(new Targyak("Teszt targy 3", "Teszt Oktato"));
         */
        h.get(0).targyFelvetel(t.get(0));
        h.get(0).targyFelvetel(t.get(1));
        h.get(0).targyFelvetel(t.get(2));

        h.get(1).setTargyakLista();
        /*
        h.get(1).targyFelvetel(new Targyak("Teszt targy 1", "Oktato"));
        h.get(1).targyFelvetel(new Targyak("Teszt targy 2", "Oktato"));
        h.get(1).targyFelvetel(new Targyak("Teszt targy 3", "Oktato"));
         */
        h.get(1).targyFelvetel(t.get(0));
        h.get(1).targyFelvetel(t.get(1));
        h.get(1).targyFelvetel(t.get(2));

        Hallgato.printHallgatok(h);


        // Hallgatok hozzaadasa a targyakhoz
        t.get(0).setHallgatoLista();
        //t.get(0).hallgatoFelvetel(new Hallgato("Fabian Gabor", 1987, "CXNU8T", "Programtervezo informatikus", 2019));
        //t.get(0).hallgatoFelvetel(new Hallgato("Teszt Teszter", 1024, "0xDEADCODE", "Programtervezo informatikus", 2048));
        t.get(0).hallgatoFelvetel(h.get(0));

        t.get(1).setHallgatoLista();
        t.get(1).hallgatoFelvetel(h.get(0));
        t.get(1).hallgatoFelvetel(h.get(1));


        /*
        // Targyleadas
        String leadandoTargyNeve = "Teszt targy 1";
        for (Hallgato hallgato : h) {
            //hallgato.targyLeadasIndex(0);
            for (int i=0; i<hallgato.targyakLista.size(); i++)
                if (hallgato.targyakLista.get(i).getNev() == leadandoTargyNeve)
                    hallgato.targyLeadasIndex(i);
        }
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Leadott targy neve: " + leadandoTargyNeve + ANSI_RESET);
        Hallgato.printHallgatok(h);

         */

        /*
        System.out.println("Targyak hallgatoi:");
        Targyak.printTargyak(t);

         */

        System.out.println("\nOsztalyozas:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                //o.osztalyoz(h.get(i), h.get(i).targyakLista.get(j), i + j);
            }
        }
        o.osztalyoz(h.get(0), h.get(0).targyakLista.get(1), 5);
        //h.get(1).getTargyakLista().get(1).setJegy(42);

        Hallgato.printHallgatok(h);
    }

    @Override
    public int compareTo(Hallgato hallgato) {
        if (this.getNev().compareTo(hallgato.getNev()) == 0) {
            if (this.getSzuletesiEv() != hallgato.getSzuletesiEv())
                return this.getSzuletesiEv() - hallgato.getSzuletesiEv();
            else
                return this.getNeptunKod().compareTo(hallgato.getNeptunKod());
        }
        return this.getNev().compareTo(hallgato.getNev());
    }
}