public class Ember {
    private String nev;
    private int szuletesiEv;

    public Ember(String nev, int szuletesiEv) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzuletesiEv() {
        return szuletesiEv;
    }

    public void setSzuletesiEv(int szuletesiEv) {
        this.szuletesiEv = szuletesiEv;
    }
}
