public class Trapez extends Negyszogek {

    public Trapez () {}

    public Trapez(double aoldal, double boldal, double coldal, double doldal) {
        this.setElnevezes("Trapez");
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setColdal(coldal);
        this.setDoldal(doldal);
        //this.setMagassag(magassag);
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
        return this.getElnevezes() + "\n"
                + "aoldal: " + this.getAoldal() + "\n"
                + "boldal: " + this.getBoldal() + "\n"
                + "coldal: " + this.getColdal() + "\n"
                + "doldal: " + this.getDoldal() + "\n"
                + "szog: " + this.getSzog() + "\n"
                + "kerulet: " + this.kerulet() + "\n"
                + "terulet: " + this.terulet();
    }

    public static void main (String[] args) {
        Trapez trapez = new Trapez(9, 5, 5, 6);
        System.out.println(trapez.toString());
    }
}
