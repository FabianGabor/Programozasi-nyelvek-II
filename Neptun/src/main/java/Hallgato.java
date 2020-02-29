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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";


    public static void main (String[] args) {

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
        /*
         */

        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "ArrayList<Hallgato> x ArrayList<Targyak>" + ANSI_RESET);

        ArrayList<Hallgato> h = new ArrayList<Hallgato>();

        h.add(new Hallgato("Fabian Gabor", 1987, "CXNU8T", "Programtervezo informatikus", 2019));
        h.add(new Hallgato("Teszt Teszter", 1024, "0xDEADCODE", "Programtervezo informatikus", 2048));

        h.get(0).setTargyakLista();
        h.get(0).targyFelvetel(new Targyak("Teszt targy", "Teszt Oktato"));

        h.get(1).setTargyakLista();
        h.get(1).targyFelvetel(new Targyak("Teszt targy", "Oktato"));

        for(Hallgato hallgato : h) {
            System.out.println(hallgato.getNev() + " " + hallgato.getSzuletesiEv() + " " + hallgato.getNeptunKod() + " " + hallgato.getSzak() );

            if (hallgato.getTargyakLista() != null)
                for (Targyak targy : hallgato.getTargyakLista())
                    System.out.println(targy.getNev() + " " + targy.getOktato());
            System.out.println();
        }
    }
}