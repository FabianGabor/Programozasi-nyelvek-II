import java.util.ArrayList;

public class Oktato extends Ember {
    private String neptunKod;

    public Oktato(String nev, int szuletesiEv, String neptunKod, Hallgato hallgato) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
    }

    public Oktato(String nev, int szuletesiEv, String neptunKod) {
        super(nev, szuletesiEv);
        this.neptunKod = neptunKod;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }


    public void osztalyoz (Hallgato hallgato, Targyak targy, int jegy) {
        System.out.println(hallgato.getNev() + " hallgatot osztalyozom " + targy.getNev() + "-bol " + jegy + "-re" + "\n");
        if (hallgato.getTargyakLista().contains(targy)) {
            System.out.println("\nMegvan a targy");
            System.out.println(hallgato.getTargyakLista().indexOf(targy)+"\n");
            hallgato.getTargyakLista().get(hallgato.getTargyakLista().indexOf(targy)).setJegy(jegy);
        }
        /*
        for (int i=0; i<hallgato.getTargyakLista().size(); i++) {
            if (hallgato.getTargyakLista().get(i).getKod() == targy.getKod()) {
                hallgato.getTargyakLista().get(i).setJegy(jegy);
            }
        }
         */
    }
}
