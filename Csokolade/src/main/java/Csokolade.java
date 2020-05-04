public class Csokolade {
	public enum Tipus {
		TEJ, ÉT, FEHÉR;

		public int getKaloria(Tipus t) {
			switch (t) {
				case TEJ:
					return 535;
				case ÉT:
					return 598;
				case FEHÉR:
					return 539;
				default:
					return 0;
			}

		}

	}

	public static void main(String[] args) {

	}
}
