/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public class Kocka extends Teglatest implements TestInterface {
    public Kocka(String elnevezes, double aEl) {
        this.setElnevezes(elnevezes);
        this.setaEl(aEl);
    }

    @Override
    public double terfogat() {
        return Math.pow(this.getaEl(),3);
    }

    @Override
    public double felszin() {
        return 6 * Math.pow(this.getaEl(),2);
    }

    @Override
    public String toString() {
        StringBuffer szoveg = new StringBuffer();
        szoveg.append(this.getElnevezes() + " {\n");
        szoveg.append("\t" + "a el = " + this.getaEl() + "\n");
        szoveg.append("\t" + "tefogat = " + this.terfogat() + "\n");
        szoveg.append("\t" + "felszin = " + this.felszin() + "\n");
        szoveg.append("\t" + "Interface = " + kiir() + "\n");
        szoveg.append("}\n");

        return szoveg.toString();
    }

    public static void main(String[] args) {
        Kocka kocka = new Kocka("Kocka", 2);
        System.out.println(kocka.toString());
    }
}
