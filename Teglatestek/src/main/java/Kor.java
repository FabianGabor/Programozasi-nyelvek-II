public class Kor extends Sikidomok {
    private double sugar;

    public Kor(double sugar) {
        this.sugar = sugar;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    @Override
    double kerulet() {
        return 2 * Math.PI * getSugar();
    }

    @Override
    double terulet() {
        return Math.PI * Math.pow(getSugar(),2);
    }

    @Override
    public String toString() {
        return "Kor {" + "\n"
                + "\tsugar = " + this.getSugar() + "\n"
                + "\tkerulet = " + this.kerulet() + "\n"
                + "\tterulet = " + this.terulet() + "\n"
                + "}";
    }

    public static void main (String[] args) {
        Kor kor = new Kor(3.1415);
        System.out.println(kor.toString());
    }
}
