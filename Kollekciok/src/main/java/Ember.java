import java.io.Serializable;
import java.util.Calendar;

public class Ember implements Serializable {
    private String nev;
    private int szuletesiEv;
    private boolean nem;
    private int jovedelem;

    public Ember(String nev, int szuletesiEv) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
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

    public static void main(String[] args) {
        Ember ember = new Ember("Teszt", 1987);
        System.out.println(ember.eletkor());
    }
}
