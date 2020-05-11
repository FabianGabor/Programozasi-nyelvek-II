public class Gepjarmu {
	private double tomeg;
	private int letszam;
	private int helyigeny;

	public Gepjarmu(double tomeg) {
		this.tomeg = tomeg;
	}

	public Gepjarmu(double tomeg, int letszam) {
		this.tomeg = tomeg;
		this.letszam = letszam;
	}

	public Gepjarmu(double tomeg, int letszam, int helyigeny) {
		this.tomeg = tomeg;
		this.letszam = letszam;
		this.helyigeny = helyigeny;
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

	public int getHelyigeny() {
		return helyigeny;
	}

	public void setHelyigeny(int helyigeny) {
		this.helyigeny = helyigeny;
	}

	@Override
	public String toString() {
		return "Gepjarmu{" +
				"tomeg=" + tomeg +
				", letszam=" + letszam +
				", helyigeny=" + helyigeny +
				'}';
	}
}
