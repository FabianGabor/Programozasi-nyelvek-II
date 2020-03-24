/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public class Henger extends Nempoliederek implements TestInterface {
    private double sugar;
    private double magassag;

    public Henger(double sugar, double magassag) {
        this.sugar = sugar;
        this.magassag = magassag;
    }

    public Henger(String elnevezes, double sugar, double magassag) {
        this.setElnevezes(elnevezes);
        this.sugar = sugar;
        this.magassag = magassag;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getMagassag() {
        return magassag;
    }

    public void setMagassag(double magassag) {
        this.magassag = magassag;
    }

    @Override
    public double terfogat() {
        return Math.PI * Math.pow(this.getSugar(),2) * this.getMagassag();
    }

    @Override
    public double felszin() {
        return 2 * Math.PI * this.getSugar() * (this.getSugar() + this.getMagassag());
    }

    @Override
    public String toString() {
        StringBuffer szoveg = new StringBuffer();
        szoveg.append(this.getElnevezes() + " {\n");
        szoveg.append("\t" + "sugar = " + this.getSugar() + "\n");
        szoveg.append("\t" + "magassag = " + this.getMagassag() + "\n");
        szoveg.append("\t" + "tefogat = " + this.terfogat() + "\n");
        szoveg.append("\t" + "felszin = " + this.felszin() + "\n");
        szoveg.append("\t" + "Interface = " + kiir() + "\n");
        szoveg.append("}\n");

        return szoveg.toString();
    }

    public static void main(String[] args) {
        Henger henger = new Henger("Henger", 1, 5);
        System.out.println(henger.toString());
    }
}
