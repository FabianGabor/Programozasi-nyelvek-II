/********************
 *** Fábián Gábor ***
 *** CXNU8T       ***
 ********************/

public class Negyzet extends Teglalap {

    public Negyzet(double aoldal) {
        this.setAoldal(aoldal);
        this.setElnevezes("Negyzet");
    }

    @Override
    double kerulet() {
        return 4 * this.getAoldal();
    }

    @Override
    double terulet() {
        return Math.pow(this.getAoldal(),2);
    }

    @Override
    public String toString() {
        return this.getElnevezes() + " {\n"
                + "\taoldal: " + this.getAoldal() + "\n"
                + "\tkerulet: " + this.kerulet() + "\n"
                + "\tterulet: " + this.terulet() + "\n"
                + "}\n";
    }

    public static void main (String[] args) {
        Negyzet negyzet = new Negyzet(8);
        System.out.println(negyzet.toString());
    }
}
