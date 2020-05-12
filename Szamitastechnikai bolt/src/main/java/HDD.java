public class HDD extends Hardware {
	// "Winchester" is a code-name for an HDD introduced by IBM in 1973
	int kapacitas;
	int fordulatszam;
	double eleresiIdo;

	public HDD() {
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr) {
		super(cikkszam, megnevezes, beszerzesiAr);
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas, int fordulatszam, double eleresiIdo) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
		this.fordulatszam = fordulatszam;
		this.eleresiIdo = eleresiIdo;
	}

	public int getKapacitas() {
		return kapacitas;
	}

	public void setKapacitas(int kapacitas) {
		this.kapacitas = kapacitas;
	}

	public int getFordulatszam() {
		return fordulatszam;
	}

	public void setFordulatszam(int fordulatszam) {
		this.fordulatszam = fordulatszam;
	}

	public double getEleresiIdo() {
		return eleresiIdo;
	}

	public void setEleresiIdo(double eleresiIdo) {
		this.eleresiIdo = eleresiIdo;
	}

	@Override
	public String toString() {
		return "HDD" +
				"\n\tcikkszam:\t\t" + cikkszam +
				"\n\tmegnevezes:\t\t" + megnevezes +
				"\n\tbeszerzesiAr:\t" + beszerzesiAr +
				"\n\tkapacitas:\t\t" + kapacitas +
				"\n\tfordulatszam:\t" + fordulatszam +
				"\n\teleresiIdo:\t\t" + eleresiIdo +
				"\n";
	}
}
