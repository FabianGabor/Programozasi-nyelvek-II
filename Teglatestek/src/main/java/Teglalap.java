public class Teglalap extends Negyszogek {
    public Teglalap () {
    }

    public Teglalap(double aoldal, double boldal) {
        this.setAoldal(aoldal);
        this.setBoldal(boldal);
        this.setElnevezes("Teglalap");
        //super(elnevezes, aoldal, boldal, coldal, doldal);
    }

    @Override
    public String toString() {
        return this.getElnevezes() + "\n"
                + "aoldal: " + this.getAoldal() + "\n"
                + "boldal: " + this.getBoldal() + "\n"
                + "kerulet: " + this.kerulet() + "\n"
                + "terulet: " + this.terulet();
    }

    @Override
    double kerulet() {
        return 2 * (this.getAoldal() + this.getBoldal());
    }

    @Override
    double terulet() {
        return this.getAoldal() * this.getBoldal();
    }

    public static void main (String[] args) {
        Teglalap t = new Teglalap(4.0, 5.0);
        System.out.println(t.toString());

        Negyszogek n;
    }


}
