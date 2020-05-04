public class Csokolade implements CsokiInterface, Comparable<Csokolade> {
	@SuppressWarnings("NonAsciiCharacters")
	public enum Tipus {
		TEJ, ÉT, FEHÉR;

		public static int getKaloria(Tipus t) {
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

	private String nev;
	private Tipus csokitipus;
	private int tomeg;
	private String toltelek;
	private int ar;

	public Csokolade(String nev, Tipus csokitipus, int tomeg, String toltelek, int ar) {
		this.nev = nev;
		this.csokitipus = csokitipus;
		this.tomeg = tomeg;
		this.toltelek = toltelek;
		this.ar = ar;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public Tipus getCsokitipus() {
		return csokitipus;
	}

	public void setCsokitipus(Tipus csokitipus) {
		this.csokitipus = csokitipus;
	}

	public int getTomeg() {
		return tomeg;
	}

	public void setTomeg(int tomeg) {
		this.tomeg = tomeg;
	}

	public String getToltelek() {
		return toltelek;
	}

	public void setToltelek(String toltelek) {
		this.toltelek = toltelek;
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	@Override
	public void aremeles(int osszeg) {
		this.setAr(this.getAr() + osszeg);
	}

	@Override
	public void akcio(int szazalek) {
		this.setAr((int) (this.getAr() * (1.0 - szazalek / 100.0)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Csokolade)) return false;
		Csokolade csokolade = (Csokolade) o;
		return getNev().equals(csokolade.getNev()) &&
				getCsokitipus() == csokolade.getCsokitipus();
	}

	@Override
	public int compareTo(Csokolade csokolade) {
		return this.getAr() - csokolade.getAr();
	}

	@Override
	public String toString() {
		return "Csokolade{" +
				"nev='" + nev + '\'' +
				", csokitipus=" + csokitipus +
				", tomeg=" + tomeg +
				", toltelek='" + toltelek + '\'' +
				", ar=" + ar +
				'}';
	}

	public int getOsszKaloria() {
		return (int)( this.getTomeg() / 100.0 * Tipus.getKaloria(this.getCsokitipus()) );
	}
}
