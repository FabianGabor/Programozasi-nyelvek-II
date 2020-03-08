public class Oktato extends Ember {
    private String neptunKod;
    Hallgato hallgatok[] = new Hallgato[10];

    public Oktato(String nev, int szuletesiEv, String neptunKod, Hallgato[] hallgatok) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
        this.hallgatok = hallgatok;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public Hallgato[] getHallgatok() {
        return hallgatok;
    }

    public void setHallgatok(Hallgato[] hallgatok) {
        this.hallgatok = hallgatok;
    }
}
