public class Paralelogramma extends Negyszogek {
    double szog;

    public Paralelogramma(double aoldal, double boldal, double szog) {
        this.setElnevezes("Paralelogramma");
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setSzog(szog);
    }

    public double getSzog() {
        return szog;
    }

    public void setSzog(double szog) {
        this.szog = szog;
    }

    @Override
    public String toString() {
        return this.getElnevezes() + " { \n"
                + "\taoldal = " + this.getAoldal() + "\n"
                + "\tboldal = " + this.getBoldal() + "\n"
                + "\tszog = " + this.getSzog() + "\n"
                + "\tkerulet = " + this.kerulet() + "\n"
                + "\tterulet = " + this.terulet() + "\n"
                + "}\n";
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
