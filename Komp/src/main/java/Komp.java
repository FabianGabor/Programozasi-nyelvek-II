import java.util.ArrayDeque;
import java.util.Queue;

public class Komp extends ArrayDeque<Gepjarmu> {
	private double maxTomeg;
	private double aktualisTomeg;
	private int maxhely;
	private int betelthely;
	private int szgkdij;
	private int tgkdij;
	ArrayDeque<Gepjarmu> jarmuvek = new ArrayDeque<Gepjarmu>();

	public Komp() {
		this.maxTomeg = 20;
		this.maxhely = 10;
		aktualisTomeg = 0;
		betelthely = 0;
	}

	public Komp(double teherbiras, int maxhely) {
		this.maxTomeg = teherbiras;
		this.maxhely = maxhely;
		aktualisTomeg = 0;
		betelthely = 0;
	}

	public Komp(double maxTomeg, int maxhely, int szgkdij, int tgkdij) {
		this.maxTomeg = maxTomeg;
		this.maxhely = maxhely;
		this.szgkdij = szgkdij;
		this.tgkdij = tgkdij;
		aktualisTomeg = 0;
		betelthely = 0;
	}

	public Komp(double maxTomeg, int maxhely, int szgkhelyigeny, int tgkhelyigeny, int szgkdij, int tgkdij, ArrayDeque<Gepjarmu> jarmuvek) {
		this.maxTomeg = maxTomeg;
		this.maxhely = maxhely;
		this.szgkdij = szgkdij;
		this.tgkdij = tgkdij;
		this.jarmuvek = jarmuvek;
		aktualisTomeg = 0;
		betelthely = 0;
	}

	public double getMaxTomeg() {
		return maxTomeg;
	}

	public void setMaxTomeg(double maxTomeg) {
		this.maxTomeg = maxTomeg;
	}

	public double getAktualisTomeg() {
		return aktualisTomeg;
	}

	public void setAktualisTomeg(double aktualisTomeg) {
		this.aktualisTomeg = aktualisTomeg;
	}

	public int getMaxhely() {
		return maxhely;
	}

	public void setMaxhely(int maxhely) {
		this.maxhely = maxhely;
	}

	public int getBetelthely() {
		return betelthely;
	}

	public void setBetelthely(int betelthely) {
		this.betelthely = betelthely;
	}

	public int getSzgkdij() {
		return szgkdij;
	}

	public void setSzgkdij(int szgkdij) {
		this.szgkdij = szgkdij;
	}

	public int getTgkdij() {
		return tgkdij;
	}

	public void setTgkdij(int tgkdij) {
		this.tgkdij = tgkdij;
	}

	public Queue<Gepjarmu> getJarmuvek() {
		return jarmuvek;
	}

	public void setJarmuvek(ArrayDeque<Gepjarmu> jarmuvek) {
		this.jarmuvek = jarmuvek;
	}

	@Override
	public String toString() {
		String komp =  "Komp{" +
				"\nteherbiras=" + maxTomeg +
				"\naktualisTomeg=" + aktualisTomeg +
				"\nmaxhely=" + maxhely +
				"\nbetelthely=" + betelthely +
				"\nszgkdij=" + szgkdij +
				"\ntgkdij=" + tgkdij +
				"\nJarmuvek=\n";
		for (Gepjarmu g : this.getJarmuvek()) {
			komp += "\t" + g.toString() + "\n";
		}
		return komp;
	}

	@Override
	public boolean add(Gepjarmu g) {
		int betelthely = this.getBetelthely();
		int helyigeny = g.getHelyigeny();

		double aktualisTomeg = this.getAktualisTomeg();
		double gktomeg = g.getTomeg();

		if ( betelthely + helyigeny <= this.getMaxhely() && gktomeg + aktualisTomeg <= this.getMaxTomeg() ) {
			this.setBetelthely( betelthely + helyigeny );
			this.setAktualisTomeg( aktualisTomeg + gktomeg );
			return this.jarmuvek.add(g);
		}
		return false;
	}

	@Override
	public Gepjarmu peekFirst() {
		return this.jarmuvek.peekFirst();
	}

	public static void main(String[] args) {
		Komp komp = new Komp(20,10);
		komp.add(new Szemelygk(1.5, 4));
		komp.add(new Szemelygk(1.5, 4));
		komp.add(new Szemelygk(2.1, 4));
		komp.add(new Tehergk(5, 1));
		komp.add(new Tehergk(10, 1));
		komp.add(new Tehergk(7.2, 1));

		System.out.println(komp.toString());

		System.out.println(komp.peekFirst());
		System.out.println(komp.jarmuvek.peekFirst());
	}
}
