import java.util.LinkedList;
import java.util.Queue;

public class Komp {
	private double teherbiras;
	private int maxhely;
	private int betelthely;
	private int szgkdij;
	private int tgkdij;
	Queue<Gepjarmu> jarmuvek = new LinkedList<Gepjarmu>();

	public Komp() {
		betelthely = 0;
	}

	public Komp(double teherbiras, int maxhely) {
		this.teherbiras = teherbiras;
		this.maxhely = maxhely;
		betelthely = 0;
	}

	public Komp(double teherbiras, int maxhely, int szgkdij, int tgkdij) {
		this.teherbiras = teherbiras;
		this.maxhely = maxhely;
		this.szgkdij = szgkdij;
		this.tgkdij = tgkdij;
		betelthely = 0;
	}

	public double getTeherbiras() {
		return teherbiras;
	}

	public void setTeherbiras(double teherbiras) {
		this.teherbiras = teherbiras;
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

	public void setJarmuvek(Queue<Gepjarmu> jarmuvek) {
		this.jarmuvek = jarmuvek;
	}

	@Override
	public String toString() {
		String komp =  "Komp{" +
				"\nteherbiras=" + teherbiras +
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

	public static void main(String[] args) {
		Komp komp = new Komp(20,10);
		komp.jarmuvek.add( new Szemelygk(1.5, 4));
		komp.jarmuvek.add(new Tehergk(5, 1));

		System.out.println(komp.toString());
	}
}
