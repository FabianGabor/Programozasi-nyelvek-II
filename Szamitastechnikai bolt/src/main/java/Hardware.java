public class Hardware implements HardwareInterface {
	int cikkszam;
	String megnevezes;
	int beszerzesiAr;
	static double haszonkulcs;

	enum tipus
	{
		MONITOR, HDD;
	}

	public Hardware() {
	}

	public Hardware(int cikkszam, String megnevezes, int beszerzesiAr) {
		this.cikkszam = cikkszam;
		this.megnevezes = megnevezes;
		this.beszerzesiAr = beszerzesiAr;
	}

	public int getCikkszam() {
		return cikkszam;
	}

	public void setCikkszam(int cikkszam) {
		this.cikkszam = cikkszam;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}

	public int getBeszerzesiAr() {
		return beszerzesiAr;
	}

	public void setBeszerzesiAr(int beszerzesiAr) {
		this.beszerzesiAr = beszerzesiAr;
	}

	public static double getHaszonkulcs() {
		return haszonkulcs;
	}

	public static void setHaszonkulcs(double haszonkulcs) {
		Hardware.haszonkulcs = haszonkulcs;
	}

	@Override
	public int geteladasiar() {
		return (int) (this.getBeszerzesiAr() * (1 + getHaszonkulcs()));
	}

	@Override
	public int haszon() {
		return (int) (this.getBeszerzesiAr() * getHaszonkulcs());
	}
}
