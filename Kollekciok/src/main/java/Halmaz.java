import java.util.*;

/*******************************************************************************
 * Fábián Gábor
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/
 *
 * 2020.4.27
 ******************************************************************************/

public class Halmaz {
	public static void main(String[] args) {
		Set<Double> halmaz = new HashSet<>();

		System.out.println("HashSet:");
		halmaz.add(5.0);
		halmaz.add(-55.0);
		halmaz.add(20.0);
		halmaz.add(20.0);
		halmaz.add(3.0);

		for (Double i:halmaz) {
			System.out.println(i);
		}

		System.out.println("TreeSet:");

		Set<Double> rendezett =  new TreeSet<>();
		rendezett.add(3.14);
		rendezett.add(-3.14);
		rendezett.add(100.56);
		rendezett.add(3.0);

		Iterator<Double> iterator = rendezett.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("Metszet:");

		rendezett.retainAll(halmaz);
		for (Double i:rendezett) {
			System.out.println(i);
		}

	}
}
