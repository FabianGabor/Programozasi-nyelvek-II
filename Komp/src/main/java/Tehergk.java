public class Tehergk extends Gepjarmu {
	public Tehergk(String rendszam, double tomeg, int letszam) {
		super(rendszam, tomeg, letszam, 2);
	}

	public Tehergk(String rendszam, double tomeg, int letszam, int helyigeny) {
		super(rendszam, tomeg, letszam, helyigeny);
	}

	@Override
	public String toString() {
		return "Tehergépkocsi   " + super.toString();
	}
}
