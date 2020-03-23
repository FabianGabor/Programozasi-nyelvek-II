abstract class Sikidomok {
    private String elnevezes;

    abstract double kerulet();
    abstract double terulet();

    public Sikidomok () {
    }

    public Sikidomok(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    @Override
    public String toString() {
        return "Sikidom: " +
                this.getElnevezes() + '\'';
    }

    public static void main(String[] args) {
        Teglalap teglalap = new Teglalap(2,3);
        System.out.println(teglalap.toString());

        Negyzet negyzet = new Negyzet(5);
        System.out.println(negyzet.toString());

        Paralelogramma paralelogramma = new Paralelogramma(2,5,30);
        System.out.println(paralelogramma.toString());

        Trapez trapez = new Trapez(9,5,5,6);
        System.out.println(trapez.toString());

        Kor kor = new Kor(10);
        System.out.println(kor.toString());
    }
}
