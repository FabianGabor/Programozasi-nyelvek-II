public class Ember {
    // osztalyszintu
    public static int jelenEv = 2020;

    // peldanyszintuek:
    private String nev;
    private int szuletesiEv;
    private boolean nem;
    private int jovedelem;

    public int eletkor () {
        return Ember.jelenEv - this.getSzuletesiEv();
    }

    public Ember() {
        this.nev = "Tudo R. Akos";
        this.szuletesiEv = 1987;
        this.nem = true;
        this.jovedelem = 0;
    }

    public Ember(String nev, int szuletesiEv, boolean nem, int jovedelem) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
        this.nem = nem;
        this.jovedelem = jovedelem;
    }

    public Ember(String nev, int szuletesiEv, boolean nem) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
        this.nem = nem;
        this.jovedelem = 0; // nincs atadva parameterkent, de ez lesz az alapertelmezett
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev.toUpperCase();
    }

    public int getSzuletesiEv() {
        return szuletesiEv;
    }

    public void setSzuletesiEv(int szuletesiEv) {
        this.szuletesiEv = szuletesiEv;
    }

    public boolean isNem() {
        return nem;
    }

    public void setNem(boolean nem) {
        this.nem = nem;
    }

    public int getJovedelem() {
        return jovedelem;
    }

    public void setJovedelem(int jovedelem) {
        this.jovedelem = jovedelem;
    }

    /*
    @Override
    public String toString() {
        return "Ember{" +
                "nev='" + nev + '\'' +
                ", szuletesiEv=" + szuletesiEv +
                ", nem=" + (nem  ? "no" : "ferfi") +
                ", jovedelem=" + jovedelem +
                ", eletkor=" + this.eletkor() +
                '}';
    }
     */

    public static void main (String[] args) {
        /*
        Ember akos = new Ember();
        System.out.println(akos.nev + '\n' + akos.szuletesiEv);

        akos.nev = "Vegh Bela";
        System.out.println(akos.nev + '\n' + akos.szuletesiEv);

        akos.setNev("Akos");
        System.out.println(akos.getNev());

        Ember bela = new Ember("Vegh Bela", 1987, false, 10);
        System.out.println(bela.nev);
        System.out.println(bela);

        Hallgato joco = new Hallgato( "Joco", 1987, false, 10, "FFFFFF", "eroszak", 2);
        System.out.println(joco);
         */

        Hallgato[] hallgatok = new Hallgato[1];

        hallgatok[0] = new Hallgato("Fabian Gabor", 1987, false, 0, "CXNU8T", "Programtervezo informatikus", 2019 );

        hallgatok[0].setTargyakSzama(1);

        Tantargy[] tantargyak;
        tantargyak = new Tantargy[hallgatok[0].getTargyakSzama()];
        //tantargyak[0].targyfelvetel("teszt");
        tantargyak[0].setTantargyNev("Teszt");


        for (int i = 0; i < hallgatok.length; i++) {
            System.out.println(i + ". " +
                    hallgatok[i].getNev() + " " +
                    hallgatok[i].getNeptunKod() + " " +
                    hallgatok[i].getSzak()
            );
            for (int j=0; i<hallgatok[i].getTargyakSzama(); j++) {
                System.out.println(hallgatok[i].getTantargyak());
            }
        }


        //hallgatok[0].tantargyak[0].targyfelvetel("Teszt");
        //hallgatok[0].setTantargyak();





    }
}
