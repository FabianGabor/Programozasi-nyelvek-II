public class HDD extends Hardware {
	// "Winchester" is a code-name for an HDD introduced by IBM in 1973
	int kapacitas;
	int fordulatszam;
	int buffer;
	double eleresiIdo;

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas, int fordulatszam) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
		this.fordulatszam = fordulatszam;
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas, int fordulatszam, int buffer) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
		this.fordulatszam = fordulatszam;
		this.buffer = buffer;
	}

	public HDD(int cikkszam, String megnevezes, int beszerzesiAr, int kapacitas, int fordulatszam, int buffer, double eleresiIdo) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.kapacitas = kapacitas;
		this.fordulatszam = fordulatszam;
		this.buffer = buffer;
		this.eleresiIdo = eleresiIdo;
	}
}
