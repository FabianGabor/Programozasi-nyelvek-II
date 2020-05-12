public class Monitor extends Hardware {
	private int meret;
	private int xfelbontas;
	private int yfelbontas;
	private boolean led = false;

	public Monitor(int cikkszam, String megnevezes, int beszerzesiAr, int meret, int xfelbontas, int yfelbontas) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.meret = meret;
		this.xfelbontas = xfelbontas;
		this.yfelbontas = yfelbontas;
	}

	public Monitor(int cikkszam, String megnevezes, int beszerzesiAr, int meret, int xfelbontas, int yfelbontas, boolean led) {
		super(cikkszam, megnevezes, beszerzesiAr);
		this.meret = meret;
		this.xfelbontas = xfelbontas;
		this.yfelbontas = yfelbontas;
		this.led = led;
	}

	public int getMeret() {
		return meret;
	}

	public void setMeret(int meret) {
		this.meret = meret;
	}

	public int getXfelbontas() {
		return xfelbontas;
	}

	public void setXfelbontas(int xfelbontas) {
		this.xfelbontas = xfelbontas;
	}

	public int getYfelbontas() {
		return yfelbontas;
	}

	public void setYfelbontas(int yfelbontas) {
		this.yfelbontas = yfelbontas;
	}

	public boolean isLed() {
		return led;
	}

	public void setLed(boolean led) {
		this.led = led;
	}
}
