import java.util.*;

/*******************************************************************************
 * Fábián Gábor
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/
 *
 * 2020.4.28.
 ******************************************************************************/

public class Maps {
	public static void main(String[] args) {
		Map<String,Ember> telefonkonyv = new HashMap<>();

		Ember e1 = new Ember("Joe", 1969, true, 0);
		Ember e2 = new Ember("Jim", 1972, true, 0);
		Ember e3 = new Ember("Erik",1993,true,4114);
		Ember e4 = new Ember("Victor",2005,true,9060);

		//telefonkonyv.put(String.valueOf((e1.getNev() + e1.getSzuletesiEv() + e1.isNem() + e1.getJovedelem()).hashCode()), e1);
		//telefonkonyv.put(String.valueOf((e2.getNev() + e2.getSzuletesiEv() + e2.isNem() + e2.getJovedelem()).hashCode()), e2);
		telefonkonyv.put("+26 75 614 5794", e1);
		telefonkonyv.put("+42 25 792 2222", e2);
		telefonkonyv.put("+42 46 603 6697", e3);
		telefonkonyv.put("+15 28 931 9976", e4);

		String keresettSzam = "+42 25 792 2222";
		Ember keresett = telefonkonyv.get(keresettSzam);
		System.out.println(keresett);
		System.out.println(keresettSzam);

		System.out.println("\nKulcsok:");
		System.out.println(telefonkonyv.keySet());

		System.out.println("\nElemek:");
		Collection<Ember> elemek = new Vector<>();
		elemek = telefonkonyv.values();

		for (Ember e : elemek)
			System.out.println(e);

	}
}
