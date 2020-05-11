public class Gepjarmu {
	private double tomeg;
	private int letszam;

	public Gepjarmu(double tomeg, int letszam) {
		this.tomeg = tomeg;
		this.letszam = letszam;
	}

	public double getTomeg() {
		return tomeg;
	}

	public void setTomeg(double tomeg) {
		this.tomeg = tomeg;
	}

	public int getLetszam() {
		return letszam;
	}

	public void setLetszam(int letszam) {
		this.letszam = letszam;
	}

	@Override
	public String toString() {
		return "{" +
				"tomeg=" + tomeg +
				", letszam=" + letszam +
				'}';
	}
}
