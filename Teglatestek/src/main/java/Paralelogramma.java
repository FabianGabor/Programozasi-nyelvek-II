public class Paralelogramma extends Negyszogek {
    public Paralelogramma () {
    }

    public Paralelogramma(double aoldal, double boldal, double szog) {
        this.setElnevezes("Paralelogramma");
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setSzog(szog);
    }

    @Override
    public String toString() {
        return this.getElnevezes() + "\n"
                + "aoldal: " + this.getAoldal() + "\n"
                + "boldal: " + this.getBoldal() + "\n"
                + "szog: " + this.getSzog() + "\n"
                + "kerulet: " + this.kerulet() + "\n"
                + "terulet: " + this.terulet();
    }

    @Override
    double kerulet() {
        return 2 * (this.getAoldal() + this.getBoldal());
    }

    @Override
    double terulet() {
        return this.getAoldal() * this.getBoldal() * Math.sin(Math.toRadians(this.getSzog()));
    }

    public static void main (String[] args) {
        Paralelogramma p = new Paralelogramma(4,5,45);
        System.out.println(p.toString());
    }
}
