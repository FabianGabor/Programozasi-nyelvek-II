public class Szemelygk extends Gepjarmu {
	public Szemelygk(double tomeg, int letszam) {
		super(tomeg, letszam);
		this.setHelyigeny(1);
	}

	public Szemelygk(double tomeg, int letszam, int helyigeny) {
		super(tomeg, letszam, helyigeny);
	}

	@Override
	public String toString() {
		return "Szemelygk " + super.toString();
	}
}
