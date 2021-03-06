/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Idojaras/src/main/java
 */

import java.io.Serializable;
import java.text.DecimalFormat;
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
    boolean randomValues = false;
    DecimalFormat df = new DecimalFormat("#.##");

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

    public void addData(Data data) { this.data.add(data); }

    public boolean isRandomValues() {
        return randomValues;
    }

    public void setRandomValues(boolean randomValues) {
        this.randomValues = randomValues;
    }

    public void randomAdatokMegadasa() {
        setRandomValues(true);
        adatokMegadasa();
        setRandomValues(false);
    }

    public void adatokMegadasa () {
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("Dátum:");

        int honap = rand.nextInt((12 - 1) + 1) + 1 ;

        if (isRandomValues())
            this.setDatum( String.valueOf(rand.nextInt((2020 - 2010) + 1) + 2010 ) + "." + String.valueOf(honap) + "." + String.valueOf(rand.nextInt((31 - 1) + 1) + 1 ) + ".");
        else
            this.setDatum(s.next());
        System.out.println(this.getDatum());

        double temp;
        double mult;
        mult = Math.sin(Math.toRadians((double)(honap-1+9) * 360 / 12)); // evszak/honap szerint magasabb/alacsonyabb random homersekletek

        do {
            System.out.println("Reggeli hőmérséklet:");
            if (isRandomValues()) {
                temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
                System.out.println(df.format(temp));
            }
            else
                temp = Double.parseDouble(s.next());
        } while ((temp > 60) || (temp < -70));
        this.setReggeliHomerseklet(temp);

        do {
            System.out.println("Déli hőmérséklet:");
            if (isRandomValues()) {
                temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
                System.out.println(df.format(temp));
            }
            else
                temp = Double.parseDouble(s.next());
        } while ((temp > 60) || (temp < -70));
        this.setDeliHomerseklet(temp);

        do {
            System.out.println("Esti hőmérséklet:");
            if (isRandomValues()) {
                temp = (rand.nextInt((60 + 70) + 1) - 70) * mult;
                System.out.println(df.format(temp));
            }
            else
                temp = Double.parseDouble(s.next());
        } while ((temp > 60) || (temp < -70));
        this.setEstiHomerseklet(temp);

        Filekezeles out = new Filekezeles();
        out.writeToFile(this);

        // meglevo adatokhoz hozzafuzes, hogy ne kelljen majd ezt is kiolvasni a filebol, ha az uj adatokat is meg szeretnenk jeleniteni
        ArrayList<Data> data = this.getData();
        Data newData = new Data(datum,reggeliHomerseklet,deliHomerseklet,estiHomerseklet);
        if (! data.isEmpty() ) {
            this.addData(newData);
            this.setData(data);
        }
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
        System.out.println("\tÁtlaghőmérséklet:    " + df.format(atlagHomerseklet(d)) );
        System.out.println("\tHőingadozás:         " + df.format(hoingadozas(d)) );
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

        System.out.println("Részleges dátum keresése: ");
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
                "\tReggeli hőmérséklet: " + df.format(reggeliHomerseklet) + "\n" +
                "\tDéli hőmérséklet:    " + df.format(deliHomerseklet) + "\n" +
                "\tEsti hőmérséklet:    " + df.format(estiHomerseklet);
    }


    @Override
    public int compareTo(Data o) {
        String compareDate = ((Data)o).getDatum();
        return this.getDatum().compareTo(compareDate);
    }
}
