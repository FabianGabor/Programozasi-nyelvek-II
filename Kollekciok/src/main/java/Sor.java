import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/*******************************************************************************
 * Fábián Gábor
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/
 *
 * 2020.4.28.
 ******************************************************************************/

public class Sor {
	public static void main(String[] args) {
		Queue<Integer> lancolt = new LinkedList<>();
		lancolt.add(5);
		lancolt.add(15);
		lancolt.add(4);
		lancolt.add(-56);

		System.out.println(lancolt.peek() + "\n");

		Integer elem;
		while ((elem = lancolt.poll()) != null) {
			System.out.println(elem);
		}

		try {
			while ((elem = lancolt.remove()) != null) {
				System.out.println(elem);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Lista vége. " + e);
		}


	}
}
