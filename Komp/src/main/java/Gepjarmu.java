import java.util.Objects;

public class Gepjarmu {
	private String rendszam;
	private double tomeg;
	private int letszam;
	private int helyigeny;

	public Gepjarmu(String rendszam, double tomeg) {
		this.rendszam = rendszam;
		this.tomeg = tomeg;
	}

	public Gepjarmu(String rendszam, double tomeg, int letszam) {
		this.rendszam = rendszam;
		this.tomeg = tomeg;
		this.letszam = letszam;
	}

	public Gepjarmu(String rendszam, double tomeg, int letszam, int helyigeny) {
		this.rendszam = rendszam;
		this.tomeg = tomeg;
		this.letszam = letszam;
		this.helyigeny = helyigeny;
	}

	public String getRendszam() {
		return rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Gepjarmu)) return false;
		Gepjarmu gepjarmu = (Gepjarmu) o;
		return getRendszam().equals(gepjarmu.getRendszam());
	}

	@Override
	public String toString() {
		return "{" +
				"rendszam=" + rendszam +
				", tomeg=" + tomeg +
				", letszam=" + letszam +
				", helyigeny=" + helyigeny +
				'}';
	}
}
