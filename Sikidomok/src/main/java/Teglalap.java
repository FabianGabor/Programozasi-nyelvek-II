/********************
 *** Fábián Gábor ***
 *** CXNU8T       ***
 ********************/

public class Teglalap extends Negyszogek {
    public Teglalap () {
    }

    public Teglalap(double aoldal, double boldal) {
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setElnevezes("Teglalap");
    }

    @Override
    double kerulet() {
        return 2 * (this.getAoldal() + this.getBoldal());
    }

    @Override
    double terulet() {
        return this.getAoldal() * this.getBoldal();
    }

    @Override
    public String toString() {
        return this.getElnevezes() + " {\n"
                + "\taoldal = " + this.getAoldal() + "\n"
                + "\tboldal = " + this.getBoldal() + "\n"
                + "\tkerulet = " + this.kerulet() + "\n"
                + "\tterulet = " + this.terulet() + "\n"
                + "}\n";
    }

    public static void main (String[] args) {
        Teglalap t = new Teglalap(4.0, 5.0);
        System.out.println(t.toString());

        Negyszogek n;
    }


}
