import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;

public class Hallgato extends Ember {
    private String neptunKod;
    private String szak;
    private int evfolyam;
    private int targyakSzama;
    //private String tantargyNev;
    //private Tantargy[] tantargyak = new Tantargy[10];
    private ArrayList<Tantargy> tantargyArrayList;

    public Hallgato(String nev, int szuletesiEv, boolean nem, int jovedelem, String neptunKod, String szak, int evfolyam) {
        super(nev, szuletesiEv, nem, jovedelem);
        this.neptunKod = neptunKod;
        this.szak = szak;
        this.evfolyam = evfolyam;
        this.targyakSzama = targyakSzama;
    }

    public Hallgato(int targyakSzama, ArrayList<Tantargy> tantargyArrayList) {
        this.targyakSzama = targyakSzama;
        this.tantargyArrayList = tantargyArrayList;
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

    public int getTargyakSzama() {
        return targyakSzama;
    }

    public void setTargyakSzama(int targyakSzama) {
        this.targyakSzama = targyakSzama;
    }

    public ArrayList<Tantargy> getTantargyArrayList() {
        return tantargyArrayList;
    }

    public void setTantargyArrayList(ArrayList<Tantargy> tantargyArrayList) {
        this.tantargyArrayList = tantargyArrayList;
        //this.tantargyArrayList = new ArrayList<Tantargy>();
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