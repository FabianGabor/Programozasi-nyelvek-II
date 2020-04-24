import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

public class Versenyzo implements Serializable, Comparable<Versenyzo>, Iterable<Versenyzo> {
	private String nev;
	private int rajtszam;
	private int helyezes;

	public Versenyzo() {
	}

	public Versenyzo(String nev, int rajtszam, int helyezes) {
		this.nev = nev;
		this.rajtszam = rajtszam;
		this.helyezes = helyezes;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getRajtszam() {
		return rajtszam;
	}

	public void setRajtszam(int rajtszam) {
		this.rajtszam = rajtszam;
	}

	public int getHelyezes() {
		return helyezes;
	}

	public void setHelyezes(int helyezes) {
		this.helyezes = helyezes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Versenyzo)) return false;
		Versenyzo versenyzo = (Versenyzo) o;
		return getRajtszam() == versenyzo.getRajtszam() &&
				getHelyezes() == versenyzo.getHelyezes() &&
				getNev().equals(versenyzo.getNev());
	}

	@Override
	public String toString() {
		return
				nev +
						"\n\t Rajtszám: " + rajtszam +
						"\n\t Helyezés: " + helyezes +
						'\n';
	}

	public static void main(String[] args) {
		Versenyzo versenyzo = new Versenyzo("Versenyzo 1", 1, 3);
		System.out.println(versenyzo);;
	}

	@Override
	public int compareTo(Versenyzo versenyzo) {
		return this.getNev().compareToIgnoreCase(versenyzo.getNev());
	}

	@Override
	public Iterator<Versenyzo> iterator() {
		return null;
	}
}

class compareNev implements Comparator<Versenyzo> {
	@Override
	public int compare(Versenyzo v1, Versenyzo v2) {
		return v1.getNev().compareToIgnoreCase(v2.getNev());
	}
}

class compareRajtszam implements Comparator<Versenyzo> {
	@Override
	public int compare(Versenyzo v1, Versenyzo v2) {
		return v1.getRajtszam()- v2.getRajtszam();
	}
}

class compareHelyezes implements Comparator<Versenyzo> {
	@Override
	public int compare(Versenyzo v1, Versenyzo v2) {
		return v1.getHelyezes()- v2.getHelyezes();
	}
}