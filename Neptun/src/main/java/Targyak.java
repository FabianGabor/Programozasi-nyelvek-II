import java.util.ArrayList;

public class Targyak {
    private String nev;
    private String oktato;
    private ArrayList<Hallgato> hallgatoLista;

    public Targyak(String nev, String oktato) {
        this.nev = nev;
        this.oktato = oktato;
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

    public ArrayList<Hallgato> getHallgatoLista() {
        return hallgatoLista;
    }

    public void setHallgatoLista(ArrayList<Hallgato> hallgatoLista) {
        this.hallgatoLista = hallgatoLista;
    }
}
