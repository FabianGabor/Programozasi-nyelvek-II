/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Monitor extends Hardware implements NumberFormatInterface {
	private int meret;
	private int xfelbontas;
	private int yfelbontas;
	private boolean led = false;

	public Monitor() {
	}

	public Monitor(int cikkszam, String megnevezes, int beszerzesiAr) {
		super(cikkszam, megnevezes, beszerzesiAr);
	}

	public Monitor(int cikkszam, String megnevezes, int beszerzesiAr, int meret, int xfelbontas, int yfelbontas) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.meret = meret;
		this.xfelbontas = xfelbontas;
		this.yfelbontas = yfelbontas;
	}

	public Monitor(int cikkszam, String megnevezes, int beszerzesiAr, int meret, int xfelbontas, int yfelbontas, boolean led) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.meret = meret;
		this.xfelbontas = xfelbontas;
		this.yfelbontas = yfelbontas;
		this.led = led;
	}

	public int getMeret() {
		return meret;
	}

	public void setMeret(int meret) {
		this.meret = meret;
	}

	public int getXfelbontas() {
		return xfelbontas;
	}

	public void setXfelbontas(int xfelbontas) {
		this.xfelbontas = xfelbontas;
	}

	public int getYfelbontas() {
		return yfelbontas;
	}

	public void setYfelbontas(int yfelbontas) {
		this.yfelbontas = yfelbontas;
	}

	public boolean isLed() {
		return led;
	}

	public void setLed(boolean led) {
		this.led = led;
	}

	@Override
	public String toString() {
		String tmp = (led)?"igen":"nem";
		return "Monitor" +
				"\n\tcikkszam:\t\t" + cikkszam +
				"\n\tmegnevezes:\t\t" + megnevezes +
				"\n\tbeszerzesiAr:\t" + customFormat(beszerzesiAr) +
				"\n\tmeret:\t\t\t" + meret +
				"\n\txfelbontas:\t\t" + xfelbontas +
				"\n\tyfelbontas:\t\t" + yfelbontas +
				"\n\tled:\t\t\t" + tmp +
				"\n";
	}



	public Monitor beolvas (int cikkszam) {
		Scanner scan = new Scanner(System.in);
		Monitor monitor = new Monitor();

		monitor.setCikkszam(cikkszam);

		System.out.println("Megnevezés: ");
		monitor.setMegnevezes( scan.next() );

		System.out.println("Beszerzési ár: ");
		monitor.setBeszerzesiAr(beolvasInt());

		System.out.println("Méret: ");
		monitor.setMeret(beolvasInt());

		System.out.println("X felbontás: ");
		monitor.setXfelbontas(beolvasInt());

		System.out.println("Y felbontás: ");
		monitor.setYfelbontas(beolvasInt());

		System.out.println("LED (i/n): ");
		monitor.setLed( (scan.next().equals("i")) );

		return monitor;
	}

	@Override
	public String customFormat(double value) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###.###", dfs);

		return df.format(value);
	}
}
