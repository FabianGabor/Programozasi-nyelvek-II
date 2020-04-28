import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*******************************************************************************
 * Fábián Gábor
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/
 *
 * 2020.4.27
 ******************************************************************************/

public class Halmaz {
	public static void main(String[] args) {
		Set<Integer> halmaz = new HashSet<>();
		halmaz.add(5);
		halmaz.add(-55);
		halmaz.add(20);
		halmaz.add(20);
		halmaz.add(3);

		for (Integer i:halmaz) {
			System.out.println(i);
		}

		Set<Double> rendezett =  new TreeSet<>();
		rendezett.add(3.14);
		rendezett.add(-3.14);
		rendezett.add(100.56);
		rendezett.add(3.0);

		Iterator<Double> iterator = rendezett.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
