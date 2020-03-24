/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public class Gomb extends Nempoliederek implements TestInterface {
    private double sugar;

    public Gomb(double sugar) {
        this.sugar = sugar;
    }

    public Gomb(String elnevezes, double sugar) {
        this.setElnevezes(elnevezes);
        this.sugar = sugar;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    @Override
    public double terfogat() {
        return 4 * Math.PI * Math.pow(this.getSugar(),3) / 3;
    }

    @Override
    public double felszin() {
        return 4 * Math.PI * Math.pow(this.getSugar(),2);
    }

    @Override
    public String toString() {
        StringBuffer szoveg = new StringBuffer();
        szoveg.append(this.getElnevezes() + " {\n");
        szoveg.append("\t" + "sugar = " + this.getSugar() + "\n");
        szoveg.append("\t" + "tefogat = " + this.terfogat() + "\n");
        szoveg.append("\t" + "felszin = " + this.felszin() + "\n");
        szoveg.append("\t" + "Interface = " + kiir() + "\n");
        szoveg.append("}\n");

        return szoveg.toString();
    }

    public static void main(String[] args) {
        Gomb gomb = new Gomb("Gomb", 1);
        System.out.println(gomb.toString());
    }
}
