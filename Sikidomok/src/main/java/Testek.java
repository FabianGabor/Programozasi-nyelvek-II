/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

abstract class Testek {
    private String elnevezes;

    public Testek() {}

    public Testek(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }
}
