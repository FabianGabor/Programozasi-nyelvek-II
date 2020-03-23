/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public class Teglatest extends Poliederek {
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


}
