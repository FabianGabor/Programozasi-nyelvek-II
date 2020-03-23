public class Trapez extends Negyszogek {

    public Trapez(double aoldal, double boldal, double coldal, double doldal) {
        this.setElnevezes("Trapez");
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setColdal(coldal);
        this.setDoldal(doldal);
    }

    @Override
    double kerulet() {
        return this.getAoldal() + this.getBoldal() + this.getColdal() + this.getDoldal();
    }

    @Override
    double terulet() {
        // source: http://www.1728.org/quadtrap.htm
        if (getAoldal() <= getColdal()) {
            System.out.println("'A' oldal nagyobb kell legyen, mint 'C' oldal");
            return 0;
        }
        double h = ( (getAoldal() + getBoldal() - getColdal() + getDoldal()) * (-getAoldal() + getBoldal() + getColdal() + getDoldal()) * (getAoldal() - getBoldal() - getColdal() + getDoldal()) * (getAoldal() + getBoldal() - getColdal() - getDoldal()) ) / (4 * Math.pow(getAoldal()-getColdal(),2));
        h = Math.sqrt(h);
        return (this.getAoldal() + this.getColdal()) / 2 * h;
    }

    @Override
    public String toString() {
        return this.getElnevezes() + " {\n"
                + "\taoldal: " + this.getAoldal() + "\n"
                + "\tboldal: " + this.getBoldal() + "\n"
                + "\tcoldal: " + this.getColdal() + "\n"
                + "\tdoldal: " + this.getDoldal() + "\n"
                + "\tkerulet: " + this.kerulet() + "\n"
                + "\tterulet: " + this.terulet() + "\n"
                + "}\n";
    }

    public static void main (String[] args) {
        Trapez trapez = new Trapez(9, 5, 5, 6);
        System.out.println(trapez.toString());
    }
}
