public class Oktato extends Ember {
    private String neptunKod;

    public Oktato(String nev, int szuletesiEv, String neptunKod, Hallgato hallgato) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public void osztalyoz (Hallgato hallgato, Targyak targyak, int jegy) {

    }
}
