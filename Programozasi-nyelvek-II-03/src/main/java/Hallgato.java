public class Hallgato extends Ember {
    private String neptunKod;
    private String szak;
    private int evfolyam;

    public Hallgato(String nev, int szuletesiEv, boolean nem, int jovedelem, String neptunKod, String szak, int evfolyam) {
        super(nev, szuletesiEv, nem, jovedelem);
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

    /*
    @Override
    public String toString() {
        return super.toString() + " " + "Hallgato{" +
                "neptunKod='" + neptunKod + '\'' +
                ", szak='" + szak + '\'' +
                ", evfolyam=" + evfolyam +
                '}';
    }

     */
}