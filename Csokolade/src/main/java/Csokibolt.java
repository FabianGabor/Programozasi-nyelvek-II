import java.util.Collections;
import java.util.Vector;

public class Csokibolt {
	private String nev;
	private int toke;
	private Vector<Csokolade> csokik;

	public Csokibolt(String nev) {
		this.nev = nev;
		this.toke = 1000;
		this.csokik = new Vector<>();
	}

	public Csokibolt(String nev, Vector<Csokolade> csokik) {
		this.nev = nev;
		this.toke = 1000;
		this.csokik = csokik;
	}

	public Csokibolt(String nev, int toke, Vector<Csokolade> csokik) {
		this.nev = nev;
		this.toke = toke;
		this.csokik = csokik;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getToke() {
		return toke;
	}

	public void setToke(int toke) {
		this.toke = toke;
	}

	public Vector<Csokolade> getCsokik() {
		return csokik;
	}

	public void setCsokik(Vector<Csokolade> csokik) {
		this.csokik = csokik;
	}

	public boolean vasarol(Csokolade csoki) {
		if (this.getToke() - csoki.getAr() >= 0) {
			this.setToke(this.getToke() - csoki.getAr());
			return this.csokik.add(csoki);
		}
		else
			return false;
	}

	public boolean elad(Csokolade csoki) {
		if (this.csokik.contains(csoki)) {
			this.setToke(this.getToke() + csoki.getAr());
		}
		return csokik.remove(csoki);
	}

	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		tmp.append("Bolt neve: ").append(this.getNev()).append("\n");
		tmp.append("Bolt tokeje: ").append(this.getToke()).append("\n");
		tmp.append("Arukeszlet: \n");
		for (Csokolade c : this.csokik) {
			tmp.append("\t").append(c.getNev()).append("\t");
			switch (c.getCsokitipus()) {
				case TEJ: tmp.append("\tTejcsokolade \t"); break;
				case ÉT: tmp.append("\tEtcsokolade \t"); break;
				case FEHÉR: tmp.append("\tFehercsokolade \t"); break;
			}
			tmp.append(c.getTomeg()).append("g\t");
			tmp.append(c.getAr()).append("Ft\n");
		}
		return tmp.toString();
	}

	public static void main(String[] args) {
		Csokibolt sajatBolt = new Csokibolt("Csokivarazs");
		Csokolade tej = new Csokolade("Milka", Csokolade.Tipus.TEJ, 200, "nincs", 300);
		Csokolade et = new Csokolade("Tibi", Csokolade.Tipus.ÉT, 250, "nincs", 280);
		Csokolade feher = new Csokolade("Boci", Csokolade.Tipus.FEHÉR, 150, "mogyoro", 350);

		sajatBolt.vasarol(tej);
		sajatBolt.vasarol(et);
		sajatBolt.vasarol(feher);
		sajatBolt.vasarol(feher);
		System.out.println(sajatBolt);
		Collections.sort(sajatBolt.getCsokik());
		//System.out.println("Ár szerint rendezve:");
		//System.out.println(sajatBolt);

		feher.aremeles(100);
		System.out.println(sajatBolt);

		feher.akcio(20);
		System.out.println(sajatBolt);
	}
}
