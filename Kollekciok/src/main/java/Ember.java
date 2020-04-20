import java.io.Serializable;
import java.util.Calendar;

public class Ember implements Serializable, Comparable<Ember> {
    private String nev;
    private int szuletesiEv;
    private boolean nem;
    private int jovedelem;

    public Ember() {
        this.nev = "Teszt Elek";
        this.szuletesiEv = 1900;
        this.nem = true;
        this.jovedelem = 1000000;
    }

    public Ember(String nev, int szuletesiEv) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
    }

    public Ember(String nev, int szuletesiEv, boolean nem, int jovedelem) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
        this.nem = nem;
        this.jovedelem = jovedelem;
    }

    public int eletkor() {
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);
        return now.get(Calendar.YEAR) - getSzuletesiEv();
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

    @Override
    public String toString() {
        return "Ember{" +
                "nev='" + nev + '\'' +
                ", szuletesiEv=" + szuletesiEv +
                ", nem=" + (nem?"ferfi":"no") +
                ", jovedelem=" + jovedelem +
                '}';
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ember ember = (Ember) o;
        return szuletesiEv == ember.szuletesiEv &&
                nem == ember.nem &&
                jovedelem == ember.jovedelem &&
                nev.equals(ember.nev);
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ember)) return false;
        Ember ember = (Ember) o;
        return getSzuletesiEv() == ember.getSzuletesiEv() &&
                getNev().equals(ember.getNev());
    }

    public static void main(String[] args) {
        Ember ember = new Ember("Teszt", 1987);
        System.out.println(ember.eletkor());
    }

    @Override
    public int compareTo(Ember e) {
        return this.getNev().compareTo(e.getNev());
    }
}
