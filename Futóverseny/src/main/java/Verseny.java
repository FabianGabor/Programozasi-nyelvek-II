import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Verseny implements Serializable {
    private String elnevezes;
    private Calendar idopont;
    private List<Versenyzo> versenyzok = new ArrayList<>();

    public Verseny(String elnevezes, Calendar idopont, List<Versenyzo> versenyzok) {
        this.elnevezes = elnevezes;
        this.idopont = idopont;
        this.versenyzok = versenyzok;
    }

    public Verseny(String elnevezes, Calendar idopont) {
        this.elnevezes = elnevezes;
        this.idopont = idopont;
    }

    public Verseny() {
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public Calendar getIdopont() {
        return idopont;
    }

    public void setIdopont(int ev, int honap, int nap, int ora, int perc) {
        Calendar calendar = new GregorianCalendar(ev, honap-1 , nap, ora, perc);
        this.idopont = calendar;
    }

    public List<Versenyzo> getVersenyzok() {
        return versenyzok;
    }

    public void setVersenyzok(List<Versenyzo> versenyzok) {
        this.versenyzok = versenyzok;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
        return "Verseny{" +
                "\n\tElnevezes:\t" + elnevezes +
                "\n\tIdopont: \t" + sdf.format(idopont.getTime()) +
                "\n}";
    }

    public static void main(String[] args) {
        Verseny verseny = new Verseny();
        verseny.setElnevezes("Zombie Shuffle");
        verseny.setIdopont(2020,04,22,9,00);
        System.out.println(verseny);
    }
}
