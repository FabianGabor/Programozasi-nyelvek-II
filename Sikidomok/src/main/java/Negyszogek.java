/********************
 *** Fábián Gábor ***
 *** CXNU8T       ***
 ********************/

abstract public class Negyszogek extends Sikidomok {
    private double aoldal;
    private double boldal;
    private double coldal;
    private double doldal;
    //private double szog;

    public Negyszogek() {
    }

    public Negyszogek(String elnevezes, double aoldal, double boldal, double coldal, double doldal, double szog) {
        super(elnevezes);
        this.aoldal = aoldal;
        this.boldal = boldal;
        this.coldal = coldal;
        this.doldal = doldal;
        //this.szog = szog;
    }

    public double getAoldal() {
        return aoldal;
    }

    public void setAoldal(double aoldal) {
        this.aoldal = aoldal;
    }

    public double getBoldal() {
        return boldal;
    }

    public void setBoldal(double boldal) {
        this.boldal = boldal;
    }

    public double getColdal() {
        return coldal;
    }

    public void setColdal(double coldal) {
        this.coldal = coldal;
    }

    public double getDoldal() {
        return doldal;
    }

    public void setDoldal(double doldal) {
        this.doldal = doldal;
    }

    //public double getSzog() { return szog; }

    //public void setSzog(double szog) { this.szog = szog; }

    @Override
    public String toString() {
        return super.toString() + "Negyszogek{" +
                "\n aoldal=" + aoldal +
                "\n boldal=" + boldal +
                "\n coldal=" + coldal +
                "\n doldal=" + doldal +
                '}';
    }
}
