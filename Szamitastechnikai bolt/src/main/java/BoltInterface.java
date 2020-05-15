/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II
 */

public interface BoltInterface {
	void feltolt(String allomanynev);
	boolean vesz(Hardware ezt); //beolvas  a billentyűzetről egy megvett hardwer elem adatait. A map-hez hozzáadja az új hardware elemet, a forgótőkéből levonja az eszköz beszerzési árát.
	boolean elad(int ezt);
	Hardware kerescikkszam(int ezt);
	int keresmegnevezes(String ezt); // szerintem hibas a keresmegnevezes(int ezt) (int) specifikacioban az int ezt parameter, mert nev szerint kene keresni
}
