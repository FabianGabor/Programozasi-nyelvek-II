import java.util.ArrayList;
import java.util.Objects;

public class Targyak {
    private String nev;
    private String oktato;
    private String kod;
    private ArrayList<Hallgato> hallgatoLista;
    private int jegy = 0;

    public Targyak(String nev, String oktato) {
        this.nev = nev;
        this.oktato = oktato;
    }

    public Targyak(String nev, String oktato, String kod) {
        this.nev = nev;
        this.oktato = oktato;
        this.kod = kod;
    }

    public Targyak(String nev, String oktato, ArrayList<Hallgato> hallgatoLista) {
        this.nev = nev;
        this.oktato = oktato;
        this.hallgatoLista = hallgatoLista;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOktato() {
        return oktato;
    }

    public void setOktato(String oktato) {
        this.oktato = oktato;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public void setHallgatoLista() {
        this.hallgatoLista = new ArrayList<Hallgato>();
    }

    public ArrayList<Hallgato> getHallgatoLista() {
        return hallgatoLista;
    }

    public void setHallgatoLista(ArrayList<Hallgato> hallgatoLista) {
        this.hallgatoLista = hallgatoLista;
    }

    public int getJegy() {
        return jegy;
    }

    public void setJegy(int jegy) {
        this.jegy = jegy;
    }

    public boolean hallgatoFelvetel(Hallgato hallgato){
        if (hallgato==null || hallgatoLista.contains(hallgato)) {
            return false;
        }
        hallgatoLista.add(hallgato);
        return true;
    }

    public static void printTargyak(ArrayList<Targyak> t) {
        for(Targyak targyak : t) {
            System.out.println(targyak.getNev() + " " + targyak.getOktato() );

            if (targyak.getHallgatoLista() != null) {
                for (Hallgato hallgato : targyak.getHallgatoLista())
                    System.out.println(hallgato.getNev() + " " + hallgato.getNeptunKod());
            }
            else {
                System.out.println("Nincsenek hallgatok");
            }

            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Targyak targyak = (Targyak) o;
        return Objects.equals(kod, targyak.kod);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
