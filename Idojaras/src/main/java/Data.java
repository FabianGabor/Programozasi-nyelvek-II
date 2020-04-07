import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Data implements Serializable, Comparable<Data> {
    String datum;
    double reggeliHomerseklet;
    double deliHomerseklet;
    double estiHomerseklet;
    ArrayList <Data> data = new ArrayList<Data>();

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

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public void adatokMegadasa () {
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("Datum:");
        //this.setDatum(s.next());

        int honap = rand.nextInt((12 - 1) + 1) + 1 ;
        this.setDatum( String.valueOf(rand.nextInt((2020 - 2019) + 1) + 2019 ) + "." + String.valueOf(honap) + "." + String.valueOf(rand.nextInt((31 - 1) + 1) + 1 ));
        System.out.println(this.getDatum());

        double temp;
        double mult;
        mult = Math.sin(Math.toRadians((double)(honap-1+9) * 360 / 12));

        do {
            System.out.println("Reggeli homerseklet:");
            //temp = Double.parseDouble(s.next());
            temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
            this.setReggeliHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));
        System.out.println(temp);

        do {
            System.out.println("Deli homerseklet:");
            //temp = Double.parseDouble(s.next());
            temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
            this.setDeliHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));
        System.out.println(temp);

        do {
            System.out.println("Esti homerseklet:");
            //temp = Double.parseDouble(s.next());
            temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
            this.setEstiHomerseklet(temp);
        } while ((temp > 60) || (temp < -70));
        System.out.println(temp);

        Filekezeles out = new Filekezeles();
        out.writeToFile(this);
    }

    public void adatokMegjelenitese () {
        Filekezeles out = new Filekezeles();

        setData(out.readFromFile());
        ArrayList<Data> data = this.getData();

        // Pluszpont datum szerinti rendezesert //
        adatokRendezese(data);

        for (Data d : data) {
            System.out.println(d);
        }
    }

    public void adatokElemzese () {
        ArrayList<Data> data = this.getData();

        if (data.isEmpty()) {
            Filekezeles out = new Filekezeles();
            setData(out.readFromFile());
            data = this.getData();
            adatokRendezese(data);
        }

        for (Data d : data) {
            kiir(d);
        }
    }

    public void kiir (Data d) {
        System.out.println(d);
        System.out.println("\tAtlaghomerseklet:    " + atlagHomerseklet(d) );
        System.out.println("\tHoingadozas:         " + hoingadozas(d) );
    }

    public double atlagHomerseklet (Data d) {
        return (d.reggeliHomerseklet + d.deliHomerseklet + d.estiHomerseklet)/3;
    }

    public double hoingadozas (Data d) {
        double min = d.reggeliHomerseklet;
        double max = d.reggeliHomerseklet;

        if (min > d.deliHomerseklet) min = d.deliHomerseklet;
        if (min > d.estiHomerseklet) min = d.estiHomerseklet;

        if (max < d.deliHomerseklet) max = d.deliHomerseklet;
        if (max < d.estiHomerseklet) max = d.estiHomerseklet;

        return max-min;
    }

    public void kereses () {
        Scanner s = new Scanner(System.in);

        System.out.println("Reszleges datum keresese: ");
        String search = s.next();

        for (Data d : data) {
            if(d.getDatum() != null && d.getDatum().contains(search))
                kiir(d);
        }
    }

    public void adatokRendezese (ArrayList<Data> data) {
        Collections.sort(data);
    }

    @Override
    public String toString() {
        return  "\n" +
                datum + "\n" +
                "\tReggeli homerseklet: " + reggeliHomerseklet + "\n" +
                "\tDeli homerseklet:    " + deliHomerseklet + "\n" +
                "\tEsti homerseklet:    " + estiHomerseklet;
    }


    @Override
    public int compareTo(Data o) {
        String compareDate = ((Data)o).getDatum();
        return this.getDatum().compareTo(compareDate);
    }
}
