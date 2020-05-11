public class Tehergk extends Gepjarmu {
	public Tehergk(double tomeg, int letszam) {
		super(tomeg, letszam);
		this.setHelyigeny(2);
	}

	public Tehergk(double tomeg, int letszam, int helyigeny) {
		super(tomeg, letszam, helyigeny);
	}

	@Override
	public String toString() {
		return "Tehergk " + super.toString();
	}
}
