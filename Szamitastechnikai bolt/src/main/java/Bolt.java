import java.io.*;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Bolt implements BoltInterface{
	SortedMap<Integer, Hardware> arukeszlet;
	int forgotoke;

	public Bolt() {
	}

	public Bolt(int forgotoke) {
		this.forgotoke = forgotoke;
	}

	public Bolt(SortedMap<Integer, Hardware> arukeszlet, int forgotoke) {
		this.arukeszlet = arukeszlet;
		this.forgotoke = forgotoke;
	}

	public SortedMap<Integer, Hardware> getArukeszlet() {
		return arukeszlet;
	}

	public void setArukeszlet(SortedMap<Integer, Hardware> arukeszlet) {
		this.arukeszlet = arukeszlet;
	}

	public int getForgotoke() {
		return forgotoke;
	}

	public void setForgotoke(int forgotoke) {
		this.forgotoke = forgotoke;
	}

	@Override
	public void feltolt(String allomanynev) {
		SortedMap<Integer, Hardware> arukeszlet = new TreeMap<Integer, Hardware>();
		//Monitor monitor = new Monitor();
		//HDD hdd = new HDD();
		int cikkszam = 1;

		String megnevezes;
		int beszerzesiAr;

		int meret;
		int xfelbontas;
		int yfelbontas;
		boolean led = false;

		int kapacitas;
		int fordulatszam;
		double eleresiIdo;

		try (Scanner scan = new Scanner(new File(allomanynev))) {
			scan.useDelimiter("#");
			while (scan.hasNext()) {
				//MONITOR#Dell SE2416H#85900#24#1920#1080#led
				//Kateg.# megnevezes # beszerzesiAr # meret # xfelbontas # yfelbontas # led
				//WINCHESTER#Seagate Spinpoint ST160LM003#7870#160#7200#4
				//Kateg.# megnevezes # beszerzesiAr # kapacitas # fordulatszam
				String tmp = scan.next();

				megnevezes = scan.next();
				beszerzesiAr = Integer.parseInt(scan.next());

				switch (tmp) {
					case "MONITOR" :
						{
							/*
							Monitor monitor = new Monitor(cikkszam++, scan.next(), Integer.parseInt(scan.next()),
									Integer.parseInt(scan.next()), Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
							 */
							meret = Integer.parseInt(scan.next());
							xfelbontas = Integer.parseInt(scan.next());
							yfelbontas = Integer.parseInt(scan.next());
							tmp = scan.nextLine().substring(1);
							led = (tmp.equalsIgnoreCase("led"));

							Monitor monitor = new Monitor(cikkszam, megnevezes, beszerzesiAr, meret, xfelbontas, yfelbontas, led);
							arukeszlet.put(cikkszam++, monitor);
							break;
						}
					case "WINCHESTER" :
						{
							kapacitas = Integer.parseInt(scan.next());
							fordulatszam = Integer.parseInt(scan.next());
							tmp = scan.nextLine().substring(1);
							try {
								eleresiIdo = Double.parseDouble(tmp);
								HDD hdd = new HDD(cikkszam, megnevezes, beszerzesiAr, kapacitas, fordulatszam, eleresiIdo);
								arukeszlet.put(cikkszam++, hdd);
							}
							catch (Exception e) {
								System.out.println(e);
							}
							break;
						}
					default:
						throw new IllegalStateException("Unexpected value: " + tmp);
				}
			}
			this.setArukeszlet(arukeszlet);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean vesz(Hardware ezt) {
		return false;
	}

	@Override
	public boolean elad(int ezt) {
		return false;
	}

	@Override
	public Hardware kerescikkszam(int ezt) {
		return null;
	}

	@Override
	public int keresmegnevezes(String ezt) {
		return 0;
	}

	//@Override
	public static int arukOsszBeszerzesiErteke(Bolt bolt) {
		int sum = 0;
		for (Integer i : bolt.arukeszlet.keySet() )
			sum += bolt.arukeszlet.get(i).getBeszerzesiAr();
		return sum;
	}

	@Override
	public String toString() {
		String str =
		"Bolt{" +
				"\nforgotoke: " + forgotoke +
				"\narukeszlet: ";

		for (Integer i : arukeszlet.keySet() )
		{
			str += "\n" + arukeszlet.get(i).toString();
		}

		str += "\n}";
		return str;
	}

	public static void main(String[] args) {
		Bolt bolt = new Bolt(1000000);
		bolt.feltolt("src/" + "arukeszlet.txt");
		System.out.println(bolt.toString());
		System.out.println("Áruk össz beszerzési értéke: " + arukOsszBeszerzesiErteke(bolt));
	}
}
