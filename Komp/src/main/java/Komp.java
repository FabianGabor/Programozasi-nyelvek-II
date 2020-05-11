import java.util.ArrayDeque;
import java.util.Queue;

public class Komp extends ArrayDeque<Gepjarmu> {
	private double maxTomeg;
	private double aktualisTomeg;
	private int maxhely;
	private int betelthely;
	private int szgkdij;
	private int tgkdij;
	private int bevetel;
	ArrayDeque<Gepjarmu> jarmuvek = new ArrayDeque<Gepjarmu>();

	public Komp() {
		this.maxTomeg = 20;
		this.maxhely = 10;
		aktualisTomeg = 0;
		betelthely = 0;
		bevetel = 0;
		szgkdij = 0;
		tgkdij = 0;
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
		bevetel = 0;
	}

	public Komp(double maxTomeg, int maxhely, int szgkhelyigeny, int tgkhelyigeny, int szgkdij, int tgkdij, ArrayDeque<Gepjarmu> jarmuvek) {
		this.maxTomeg = maxTomeg;
		this.maxhely = maxhely;
		this.szgkdij = szgkdij;
		this.tgkdij = tgkdij;
		this.jarmuvek = jarmuvek;
		aktualisTomeg = 0;
		betelthely = 0;
		bevetel = 0;
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
		if (jarmuvek == null)
			this.jarmuvek.clear();
		else
			this.jarmuvek = jarmuvek;
	}

	public int getBevetel() {
		return bevetel;
	}

	public void setBevetel(int bevetel) {
		this.bevetel = bevetel;
	}

	public void kiurit(Komp k) {
		k.setBevetel(0);
		k.setBetelthely(0);
		k.setAktualisTomeg(0);
		//k.jarmuvek.clear();
		k.setJarmuvek(null);
	}

	@Override
	public String toString() {
		String komp =  "Komp {" +
				"\n\tteherbiras: " + maxTomeg +
				"\n\taktualisTomeg: " + aktualisTomeg +
				"\n\tmaxhely: " + maxhely +
				"\n\tbetelthely: " + betelthely +
				"\n\tszgkdij: " + szgkdij +
				"\n\ttgkdij: " + tgkdij +
				"\n\tbevetel: " + bevetel +
				"\n\tJarmuvek: \n";
		if (this.getJarmuvek().isEmpty())
			komp += "\t\t" + "A komp üres" + "\n";
		else {
			for (Gepjarmu g : this.getJarmuvek()) {
				komp += "\t\t" + g.toString() + "\n";
			}
		}
		komp += "}";
		return komp;
	}

	@Override
	public boolean add(Gepjarmu g) {
		if (!this.getJarmuvek().contains(g)) {
			int betelthely = this.getBetelthely();
			int helyigeny = g.getHelyigeny();

			double aktualisTomeg = this.getAktualisTomeg();
			double gktomeg = g.getTomeg();

			if (betelthely + helyigeny <= this.getMaxhely() && gktomeg + aktualisTomeg <= this.getMaxTomeg()) {
				this.setBetelthely(betelthely + helyigeny);
				this.setAktualisTomeg(aktualisTomeg + gktomeg);

				if (g instanceof Szemelygk)
					this.setBevetel(this.getBevetel() + this.getSzgkdij());
				else if (g instanceof Tehergk)
					this.setBevetel(this.getBevetel() + this.getTgkdij());


				return this.jarmuvek.add(g);
			}
		}
		return false;
	}

	@Override
	public Gepjarmu peekFirst() {
		return this.jarmuvek.peekFirst();
	}

	@Override
	public Gepjarmu pop() {
		this.setBetelthely( this.getBetelthely() - this.peekFirst().getHelyigeny() );
		this.setAktualisTomeg( this.getAktualisTomeg() - this.peekFirst().getTomeg() );
		return this.jarmuvek.pop();
	}

	public static void main(String[] args) {
		Komp komp = new Komp(20,10, 1500, 3000);
		komp.add(new Szemelygk("VHR-918", 1.4, 1));
		komp.add(new Szemelygk("NJK-365", 1.5, 4));
		komp.add(new Szemelygk("KHJ-492", 2.1, 4));
		komp.add(new Tehergk("BUT-854", 5, 1));
		komp.add(new Tehergk("KNP-245",10, 1));
		komp.add(new Tehergk("FGI-621",7.2, 1));

		System.out.println(komp.toString());

		System.out.println("A legelső jármű: " + komp.peekFirst() + "\n");

		for (Gepjarmu g:komp.getJarmuvek()) {
			System.out.println("Lement: " + komp.pop());
		}

		System.out.println(komp.toString());

		komp.kiurit(komp);
		System.out.println(komp.toString());
	}
}
