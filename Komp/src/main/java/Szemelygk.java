public class Szemelygk extends Gepjarmu {
	public Szemelygk(String rendszam, double tomeg, int letszam) {
		super(rendszam, tomeg, letszam, 1);
	}

	public Szemelygk(String rendszam, double tomeg, int letszam, int helyigeny) {
		super(rendszam, tomeg, letszam, helyigeny);
	}

	@Override
	public String toString() {
		return "Személygépkocsi " + super.toString();
	}
}
