import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Data implements Serializable, Comparable {
    String datum;
    double reggeliHomerseklet;
    double deliHomerseklet;
    double estiHomerseklet;

    public Data() {
    }

    public Data(String datum, double reggeliHomerseklet, double deliHomerseklet, double estiHomerseklet) {
        this.datum = datum;
        this.reggeliHomerseklet = reggeliHomerseklet;
        this.deliHomerseklet = deliHomerseklet;
        this.estiHomerseklet = estiHomerseklet;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getReggeliHomerseklet() {
        return reggeliHomerseklet;
    }

    public void setReggeliHomerseklet(double reggeliHomerseklet) {
        this.reggeliHomerseklet = reggeliHomerseklet;
    }

    public double getDeliHomerseklet() {
        return deliHomerseklet;
    }

    public void setDeliHomerseklet(double deliHomerseklet) {
        this.deliHomerseklet = deliHomerseklet;
    }

    public double getEstiHomerseklet() {
        return estiHomerseklet;
    }

    public void setEstiHomerseklet(double estiHomerseklet) {
        this.estiHomerseklet = estiHomerseklet;
    }

    public void adatokMegadasa () {
        //Filekezeles file = new Filekezeles();

        Scanner s = new Scanner(System.in);
        System.out.println("Datum:");
        this.setDatum(s.next());

        double temp;

        do {
            System.out.println("Reggeli homerseklet:");
            temp = Double.parseDouble(s.next());
            this.setReggeliHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));

        do {
            System.out.println("Deli homerseklet:");
            temp = Double.parseDouble(s.next());
            this.setDeliHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));

        do {
            System.out.println("Esti homerseklet:");
            temp = Double.parseDouble(s.next());
            this.setEstiHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));

        Filekezeles out = new Filekezeles();
        out.writeToFile(this);
    }

    public void adatokMegjelenitese () {
        Filekezeles out = new Filekezeles();
        ArrayList <Data> data = new ArrayList<Data>();

        data = out.readFromFile();

        // Pluszpont datum szerinti rendezesert //
        Collections.sort(data);

        for (Data d : data) {
            System.out.println(d);
        }
    }

    @Override
    public String toString() {
        return
                datum + "\n" +
                "\tReggeli homerseklet: " + reggeliHomerseklet + "\n" +
                "\tDeli homerseklet:    " + deliHomerseklet + "\n" +
                "\tEsti homerseklet:    " + estiHomerseklet + "\n";
    }


    @Override
    public int compareTo(Object o) {
        String compareDate = ((Data)o).getDatum();
        return this.getDatum().compareTo(compareDate);
    }
}
