import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class Negyzet extends Teglalap {
    public Negyzet() {
    }

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
        return this.getElnevezes() + "\n"
                + "aoldal: " + this.getAoldal() + "\n"
                + "kerulet: " + this.kerulet() + "\n"
                + "terulet: " + this.terulet();
    }

    public static void main (String[] args) {
        Negyzet negyzet = new Negyzet(8);
        System.out.println(negyzet.toString());
    }
}
