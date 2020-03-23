/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public class Teglatest extends Poliederek implements TestInterface {
    private double aEl;
    private double bEl;
    private double cEl;

    public Teglatest() {
    }

    public Teglatest(double aEl, double bEl, double cEl) {
        this.aEl = aEl;
        this.bEl = bEl;
        this.cEl = cEl;
    }

    public Teglatest(String elnevezes, double aEl, double bEl, double cEl) {
        this.aEl = aEl;
        this.bEl = bEl;
        this.cEl = cEl;
        this.setElnevezes(elnevezes);
    }

    public double getaEl() {
        return aEl;
    }

    public void setaEl(double aEl) {
        this.aEl = aEl;
    }

    public double getbEl() {
        return bEl;
    }

    public void setbEl(double bEl) {
        this.bEl = bEl;
    }

    public double getcEl() {
        return cEl;
    }

    public void setcEl(double cEl) {
        this.cEl = cEl;
    }

    @Override
    public double terfogat() {
        return this.getaEl() * this.getbEl() * this.getcEl();
    }

    @Override
    public double felszin() {
        return 2 * ( this.getaEl() * this.getbEl() + this.getaEl() * this.getcEl() + this.getbEl() * this.getcEl() );
    }

    @Override
    public String toString() {
        StringBuffer szoveg = new StringBuffer();
        szoveg.append(this.getElnevezes() + " {\n");
        szoveg.append("\t" + "a el = " + this.getaEl() + "\n");
        szoveg.append("\t" + "b el = " + this.getbEl() + "\n");
        szoveg.append("\t" + "c el = " + this.getcEl() + "\n");
        szoveg.append("\t" + "tefogat = " + this.terfogat() + "\n");
        szoveg.append("\t" + "felszin = " + this.felszin() + "\n");
        szoveg.append("\t" + "Interface = " + kiir() + "\n");
        szoveg.append("}\n");

        return szoveg.toString();
    }

    public static void main(String[] args) {
        Teglatest teglatest = new Teglatest("Teglatest", 1,2,3);
        System.out.println(teglatest.toString());
    }
}
