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

    public void osztalyoz(Hallgato hallgato, Targyak targy, int jegy) {

        int targyIndex = -1;

        for (int i=0; i<hallgato.getTargyakLista().size(); i++) {
            if (hallgato.getTargyakLista().get(i).getKod() == targy.getKod()) {
                targyIndex = i;
            }
        }
        hallgato.getTargyakLista().get(targyIndex).setJegy(jegy);
    }


}
