import java.util.ArrayList;

public class Oktato extends Ember {
    private String neptunKod;

    public Oktato(String nev, int szuletesiEv, String neptunKod, Hallgato hallgato) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
    }

    public Oktato(String nev, int szuletesiEv, String neptunKod) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }


    public void osztalyoz (Hallgato hallgato, Targyak targy, int jegy) {
        System.out.println(hallgato.getNev() + " hallgatot osztalyozom \"" + targy.getNev() + "\"-bol " + jegy + "-re");
        if (hallgato.getTargyakLista().contains(targy)) {
            System.out.println("A targy a(z) + " + hallgato.getTargyakLista().indexOf(targy)+" indexen talalhato.\n");

            // Talán itt lehet a hiba:
            hallgato.getTargyakLista().get(hallgato.getTargyakLista().indexOf(targy)).setJegy(jegy);
        }
    }
}
