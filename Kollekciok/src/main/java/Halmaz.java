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
	}
}
