/*
    - kod
    - nev
    - oktato
    - kredit
    - jegy
 */

public class Tantargy {
    private String kod;
    private String tantargyNev;
    private String oktato;
    private int kredit;
    private int jegy;

    public Tantargy(String kod, String tantargyNev, String oktato, int kredit, int jegy) {
        this.kod = kod;
        this.tantargyNev = tantargyNev;
        this.oktato = oktato;
        this.kredit = kredit;
        this.jegy = jegy;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getTantargyNev() {
        return tantargyNev;
    }

    public void setTantargyNev(String tantargyNev) {
        this.tantargyNev = tantargyNev;
    }

    public String getOktato() {
        return oktato;
    }

    public void setOktato(String oktato) {
        this.oktato = oktato;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public int getJegy() {
        return jegy;
    }

    public void setJegy(int jegy) {
        this.jegy = jegy;
    }

    /*
    @Override
    public String toString() {
        return super.toString() + " " + "Tantargy{" +
                "tantargyNev='" + tantargyNev + '\'' +
                ", kod='" + kod + '\'' +
                ", oktato=" + oktato +
                '}';
    }

     */
    public void targyfelvetel (String tantargyNev) {
        this.setTantargyNev(tantargyNev);
    }

    public void targyleadas () {

    }



}
