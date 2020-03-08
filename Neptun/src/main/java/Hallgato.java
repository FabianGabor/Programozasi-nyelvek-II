import java.util.ArrayList;

public class Hallgato extends Ember {
    private String neptunKod;
    private String szak;
    private int evfolyam;
    private ArrayList<Targyak> targyakLista;

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

    public boolean targyFelvetel(Targyak targyak){
        if (targyak==null || targyakLista.contains(targyak)) {
            return false;
        }
        targyakLista.add(targyak);
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

    public static void printHallgatok(ArrayList<Hallgato> h) {
        for(Hallgato hallgato : h) {
            System.out.println(hallgato.getNev() + " " + hallgato.getSzuletesiEv() + " " + hallgato.getNeptunKod() + " " + hallgato.getSzak() );

            if (hallgato.getTargyakLista() != null)
                for (Targyak targy : hallgato.getTargyakLista())
                    System.out.println(targy.getNev() + " " + targy.getOktato());
            System.out.println();
        }
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

        // Hallgatok letrehozasa
        h.add(new Hallgato("Fabian Gabor", 1987, "CXNU8T", "Programtervezo informatikus", 2019));
        h.add(new Hallgato("Teszt Teszter", 1024, "0xDEADCODE", "Programtervezo informatikus", 2048));

        // Targyak letrehozasa
        t.add(new Targyak("Teszt targy 1", "Teszt Oktato"));
        t.add(new Targyak("Teszt targy 2", "Teszt Oktato"));
        t.add(new Targyak("Teszt targy 3", "Teszt Oktato"));

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


        // Targyleadas
        String leadandoTargyNeve = "Teszt targy 1";
        for (Hallgato hallgato : h) {
            //hallgato.targyLeadasIndex(0);
            for (int i=0; i<hallgato.targyakLista.size(); i++)
                if (hallgato.targyakLista.get(i).getNev() == leadandoTargyNeve)
                    hallgato.targyLeadasIndex(i);
        }

        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK d+ "Leadott targy neve: " + leadandoTargyNeve + ANSI_RESET);
        Hallgato.printHallgatok(h);

        System.out.println("Targyak hallgatoi:");
        Targyak.printTargyak(t);
    }
}