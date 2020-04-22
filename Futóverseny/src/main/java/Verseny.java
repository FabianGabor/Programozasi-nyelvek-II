import com.google.common.collect.Iterables;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Verseny {
    private String elnevezes;
    private LocalDateTime idopont;
    private DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm");
    private List<Versenyzo> versenyzok = new ArrayList<>();

    public Verseny(String elnevezes, LocalDateTime idopont, List<Versenyzo> versenyzok) {
        this.elnevezes = elnevezes;
        this.idopont = idopont;
        this.versenyzok = versenyzok;
    }

    public Verseny(String elnevezes, LocalDateTime idopont) {
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

    public LocalDateTime getIdopont() {
        return idopont;
    }

    public void setIdopont(LocalDateTime idopont) {
        this.idopont = idopont;
    }

    public DateTimeFormatter getFormatterDateTime() {
        return formatterDateTime;
    }

    public List<Versenyzo> getVersenyzok() {
        return versenyzok;
    }

    public void setVersenyzok(List<Versenyzo> versenyzok) {
        this.versenyzok = versenyzok;
    }

    @Override
    public String toString() {
        return "Verseny{" +
                "\n\tElnevezes:\t" + elnevezes +
                "\n\tIdopont: \t" + idopont.format(this.getFormatterDateTime()) +
                "\n}";
    }

    public void versenyNevIdopontMegadasa() {
        Scanner s = new Scanner(System.in);

        System.out.println("Verseny neve:");
        this.setElnevezes(s.nextLine());
        System.out.println("Verseny idopontja (éééé.hh.nn. óó:pp):");

        LocalDateTime formatDateTime = null;
        while (formatDateTime == null) {
            String date = s.nextLine();
            try {
                formatDateTime = LocalDateTime.parse(date, formatterDateTime);
            } catch (Exception e) {
                System.out.println("Rossz időpont formátum! Add meg újra az időpontot (éééé.hh.nn. óó:pp):");
            }
        }

        this.setIdopont( formatDateTime );
        System.out.println(this);
    }

    public void versenyzoFelvitele() {
        Versenyzo versenyzo = new Versenyzo();
        Scanner s = new Scanner(System.in);
        int rajtszam;
        int helyezes;

        System.out.println("Versenyző neve:");
        versenyzo.setNev(s.nextLine());  // azonos nevu versenyzok letezhetnek valosagban is, nem ellenorizzuk

        System.out.println("Versenyző rajtszáma:");
        rajtszam = s.nextInt();

        while (rajtszam<=0 || containsRajtszam(versenyzok, rajtszam)) {
            System.out.println("A rajtszám már létezik!");
            System.out.println("Versenyző rajtszáma:");
            rajtszam = s.nextInt();
        }
        versenyzo.setRajtszam(rajtszam);

        System.out.println("Versenyző helyezése:");
        helyezes = s.nextInt();
        while (helyezes<=0 || containsHelyezes(versenyzok, helyezes)) {
            System.out.println("A helyezés már létezik!");
            System.out.println("Versenyző helyezése:");
            helyezes = s.nextInt();
        }
        versenyzo.setHelyezes(helyezes);

        versenyzok.add(versenyzo);
        try {
            //System.out.println(Class.forName("com.google.common.collect.Iterables"));
            Iterable<Versenyzo> lastElement = Iterables.getLast(versenyzok, null);
            System.out.println("Felvittem:\n" + lastElement);
        } catch(Exception e) {
            //System.out.println("com.google.common.collect.Iterables MISS");
            Versenyzo lastElement = versenyzok.get(versenyzok.size() - 1);
            System.out.println("Felvittem:\n" + lastElement);
        }
    }

    public boolean containsRajtszam(final List<Versenyzo> versenyzok, final int rajtszam){
        return versenyzok.stream().anyMatch(o -> o.getRajtszam() == rajtszam);
    }
    public boolean containsHelyezes(final List<Versenyzo> versenyzok, final int helyezes){
        return versenyzok.stream().anyMatch(o -> o.getHelyezes() == helyezes);
    }

    public void versenyzokNevSzerint() {
        Collections.sort(versenyzok, new compareNev());
        for (Versenyzo v : versenyzok)
            System.out.println(v);
    }

    public void versenyzokRajtszamSzerint() {
        Collections.sort(versenyzok, new compareRajtszam());
        for (Versenyzo v : versenyzok)
            System.out.println(v);
    }

    public void versenyzokHelyezesSzerint() {
        Collections.sort(versenyzok, new compareHelyezes());
        for (Versenyzo v : versenyzok)
            System.out.println(v);
    }

    public static void main(String[] args) {
        Verseny verseny = new Verseny();
        System.out.println(verseny);
    }
}
