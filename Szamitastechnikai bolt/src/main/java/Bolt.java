/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class Bolt extends Hardware implements BoltInterface, NumberFormatInterface {
	SortedMap<Integer, Hardware> arukeszlet;
	int forgotoke;

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
		SortedMap<Integer, Hardware> arukeszlet = new TreeMap<>();

		int cikkszam = 1;

		String megnevezes;
		int beszerzesiAr;

		int meret;
		int xfelbontas;
		int yfelbontas;
		boolean led;

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
								System.err.print("Error");
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

	public void vasarlas() {
		Scanner scan = new Scanner(System.in);
		int tipus = 0;
		Hardware ezt = new Hardware();

		for (Enum info : Hardware.tipus.values()) {
			System.out.println(info.ordinal() + 1 + ". " + info);
		}

		while (tipus <= 0 || tipus > Hardware.tipus.values().length)
			try {
				System.out.println("Termék típusa:");
				tipus = scan.nextInt();
				if (tipus <= 0 || tipus > Hardware.tipus.values().length)
					System.out.println("Lehetséges válasz: 1–" + Hardware.tipus.values().length);
			} catch (InputMismatchException inputMismatchException) {
				System.out.println("Lehetséges válasz: 1–" + Hardware.tipus.values().length);
				scan.next();
				//continue;
			}

		int cikkszam;
		if (this.arukeszlet.firstKey() > 1)
			cikkszam = this.arukeszlet.firstKey() - 1;
		else
			cikkszam = this.arukeszlet.lastKey() + 1;

		switch (tipus) {
			case 1:
			{
				ezt = new Monitor().beolvas(cikkszam);
				break;
			}
			case 2:
			{
				ezt = new HDD().beolvas(cikkszam);
				break;
			}
		}
		vesz(ezt);
	}

	public void eladas() {
		System.out.println("Eladni kívánt termék cikkszáma:");
		Scanner scan = new Scanner(System.in);
		int ezt = scan.nextInt();

		Hardware talalat = kerescikkszam(ezt);
		System.out.println( (talalat == null) ? "Nem létezik " + ezt + " cikkszámú termék." : talalat );

		System.out.println("A(z) " + ezt + " cikkszámú árú " + (elad(ezt)?"el":"nem") + " lett eladva." );
	}

	public void keresesCikkszamSzerint() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Keresett cikkszám: ");
		int ezt = scan.nextInt();

		Hardware talalat = kerescikkszam(ezt);
		System.out.println( (talalat == null) ? "Nem létezik " + ezt + " cikkszámú termék." : talalat );
	}

	public void keresesMegnevezesSzerint() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Keresett név: ");
		String ezt = scan.next();

		Hardware talalat = this.getArukeszlet().get( keresmegnevezes(ezt) );
		System.out.println( (talalat == null) ? "Nem létezik " + ezt + " megnevezésű termék." : talalat );
	}

	@SuppressWarnings("unused")
	public void boltArukeszlete() {
		System.out.println(this.toString());
		System.out.println("Árucikkek mennyisége: " + this.arukeszlet.values().size());
		System.out.println("Forgótőke: " + customFormat(this.forgotoke)); // forgótőke úja, hogy látszodjon az árucikkek előtt és után is
		System.out.println("Haszonkulcs: " + customFormat(haszonkulcs * 100) + "%");
		System.out.println("Áruk össz beszerzési értéke: " + customFormat(arukOsszBeszerzesiErteke(this)));
		System.out.println("Áruk cikkszámai: " + this.arukeszlet.keySet());
	}

	@Override
	public boolean vesz(Hardware ezt) {
		if (this.forgotoke >= ezt.beszerzesiAr) {
			this.arukeszlet.put(ezt.getCikkszam(), ezt);
			this.forgotoke -= ezt.beszerzesiAr;
			return true;
		}

		System.out.println("Nem áll elég forgótőke rendelkezésre!");
		return false;
	}

	@Override
	public boolean elad(int ezt) {
		if (this.arukeszlet.containsKey(ezt)) {
			System.out.println("Eladási ár: " + customFormat(this.arukeszlet.get(ezt).getEladasiAr()));
			System.out.println("Haszonkulcs: " + Hardware.getHaszonkulcs() * 100 + '%');
			this.forgotoke += this.arukeszlet.get(ezt).getEladasiAr();
			this.arukeszlet.remove(ezt);
			return true;
		}
		return false;
	}

	@Override
	public Hardware kerescikkszam(int ezt) {
		return this.getArukeszlet().get(ezt);
	}

	@Override
	public int keresmegnevezes(String ezt) {
		for (Integer i : this.getArukeszlet().keySet()) {
			if ( this.getArukeszlet().get(i).megnevezes.contains(ezt) ) // parcialis egyezes
			//if ( this.getArukeszlet().get(i).megnevezes.equalsIgnoreCase(ezt) )
				return i;
		}
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
		StringBuilder str =
				new StringBuilder(
						"\nForgótőke: " + customFormat(forgotoke) +
						"\nÁrukészlet: ");

		for (Integer i : arukeszlet.keySet() )
		{
			str.append("\n").append(arukeszlet.get(i).toString());
		}

		return str.toString();
	}

	public void haszonkulcsBeallitas() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haszonkulcs százalék:");
		Hardware.setHaszonkulcs(beolvasDouble() / 100);
	}


	@Override
	public String customFormat(double value) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###.###", dfs);

		return df.format(value);
	}

	public static void main(String[] args) {
		Bolt bolt = new Bolt(1000000);
		bolt.feltolt("src/" + "arukeszlet.txt");

		Menu menu = new Menu();
		menu.addItem(new MenuItem("Áru vásárlása", bolt , "vasarlas"));
		menu.addItem(new MenuItem("Áru eladása", bolt , "eladas"));
		menu.addItem(new MenuItem("Haszonkulcs beállítása", bolt , "haszonkulcsBeallitas"));
		menu.addItem(new MenuItem("Keresés cikkszám alapján", bolt , "keresesCikkszamSzerint"));
		menu.addItem(new MenuItem("Keresés megnevezés szerint", bolt , "keresesMegnevezesSzerint"));
		menu.addItem(new MenuItem("Bolt árukészlete", bolt , "boltArukeszlete"));

		menu.execute();
	}
}
