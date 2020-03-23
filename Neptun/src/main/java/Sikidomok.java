abstract class Sikidomok {
    private String elnevezes;

    abstract double kerulet();
    abstract double terulet();

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
        Sikidomok alakzat;
        alakzat = new Sikidomok("teglalap") {
            @Override
            double kerulet() {
                return 0;
            }

            @Override
            double terulet() {
                return 0;
            }
        };
    }
}
