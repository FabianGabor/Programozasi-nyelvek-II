/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class HDD extends Hardware implements NumberFormatInterface {
	// "Winchester" is a code-name for an HDD introduced by IBM in 1973
	int kapacitas;
	int fordulatszam;
	double eleresiIdo;

	public HDD() {
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr) {
		super(cikkszam, megnevezes, beszerzesiAr);
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas, int fordulatszam, double eleresiIdo) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
		this.fordulatszam = fordulatszam;
		this.eleresiIdo = eleresiIdo;
	}

	public int getKapacitas() {
		return kapacitas;
	}

	public void setKapacitas(int kapacitas) {
		this.kapacitas = kapacitas;
	}

	public int getFordulatszam() {
		return fordulatszam;
	}

	public void setFordulatszam(int fordulatszam) {
		this.fordulatszam = fordulatszam;
	}

	public double getEleresiIdo() {
		return eleresiIdo;
	}

	public void setEleresiIdo(double eleresiIdo) {
		this.eleresiIdo = eleresiIdo;
	}

	@Override
	public String toString() {
		return "HDD" +
				"\n\tcikkszam:\t\t" + cikkszam +
				"\n\tmegnevezes:\t\t" + megnevezes +
				"\n\tbeszerzesiAr:\t" + customFormat(beszerzesiAr) +
				"\n\tkapacitas:\t\t" + kapacitas +
				"\n\tfordulatszam:\t" + fordulatszam +
				"\n\teleresiIdo:\t\t" + eleresiIdo +
				"\n";
	}



	public HDD beolvas (int cikkszam) {
		Scanner scan = new Scanner(System.in);
		HDD hdd = new HDD();

		hdd.setCikkszam(cikkszam);

		System.out.println("Megnevezés: ");
		hdd.setMegnevezes( scan.next() );
		System.out.println("Beszerzési ár: ");
		hdd.setBeszerzesiAr(beolvasInt());
		System.out.println("Kapacitás: ");
		hdd.setKapacitas(beolvasInt());
		System.out.println("Fordulatszám: ");
		hdd.setFordulatszam(beolvasInt());
		System.out.println("Elérési idő: ");
		hdd.setEleresiIdo(beolvasDouble());

		return hdd;
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
