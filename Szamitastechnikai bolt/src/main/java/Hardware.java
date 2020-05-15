/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II
 */

import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("LoopStatementThatDoesntLoop")
public class Hardware implements HardwareInterface {
	int cikkszam;
	String megnevezes;
	int beszerzesiAr;
	static double haszonkulcs;

	enum tipus
	{
		MONITOR, HDD
	}

	public Hardware() {
	}

	public Hardware(int cikkszam, String megnevezes, int beszerzesiAr) {
		this.cikkszam = cikkszam;
		this.megnevezes = megnevezes;
		this.beszerzesiAr = beszerzesiAr;
	}

	public int getCikkszam() {
		return cikkszam;
	}

	public void setCikkszam(int cikkszam) {
		this.cikkszam = cikkszam;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}

	public int getBeszerzesiAr() {
		return beszerzesiAr;
	}

	public void setBeszerzesiAr(int beszerzesiAr) {
		this.beszerzesiAr = beszerzesiAr;
	}

	public static double getHaszonkulcs() {
		return haszonkulcs;
	}

	public static void setHaszonkulcs(double haszonkulcs) {
		Hardware.haszonkulcs = haszonkulcs;
	}

	@Override
	public int getEladasiAr() {
		return (int) (this.getBeszerzesiAr() * (1 + getHaszonkulcs()));
	}

	@Override
	public int haszon() { // ez sehol nincs használva, a feladatsor csak az implementálást kéri
		return (int) (this.getBeszerzesiAr() * getHaszonkulcs()); // ugyanaz, mint a this.getBeszerzesiAr() - geteladasiar()
	}

	@Override
	public String toString() {
		return "Hardware{" +
				"cikkszam=" + getCikkszam() +
				", megnevezes='" + getMegnevezes() + '\'' +
				", beszerzesiAr=" + getBeszerzesiAr() +
				'}';
	}

	public int beolvasInt() {
		Scanner scan = new Scanner(System.in);
		int i;
		while(true) {
			try {
				i = scan.nextInt();
				return i;
			} catch (InputMismatchException inputMismatchException) {
				System.out.println("Nem egész szám!");
				return beolvasInt();
			}
		}
	}

	public double beolvasDouble() {
		Scanner scan = new Scanner(System.in);
		double i;
		while(true) {
			try {
				i = scan.nextDouble();
				return i;
			} catch (InputMismatchException inputMismatchException) {
				System.out.println("Nem valós szám!");
				return beolvasDouble();
			}
		}
	}
}
