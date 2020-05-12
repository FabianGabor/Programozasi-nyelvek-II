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

	public int getBuffer() {
		return buffer;
	}

	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	public double getEleresiIdo() {
		return eleresiIdo;
	}

	public void setEleresiIdo(double eleresiIdo) {
		this.eleresiIdo = eleresiIdo;
	}
}
