import com.google.common.collect.Iterables;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.IntStream;

public class Verseny {
	private String elnevezes;
	private LocalDateTime idopont;
	private DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm");
	private List<Versenyzo> versenyzok = new ArrayList<>();

	public Verseny(String elnevezes, LocalDateTime idopont, List<Versenyzo> versenyzok) {
		this.elnevezes = elnevezes;
		this.idopont = idopont;
		this.versenyzok = versenyzok;
	}

	public Verseny(String elnevezes, LocalDateTime idopont) {
		this.elnevezes = elnevezes;
		this.idopont = idopont;
	}

	public Verseny() {
	}

	public String getElnevezes() {
		return elnevezes;
	}

	public void setElnevezes(String elnevezes) {
		this.elnevezes = elnevezes;
	}

	public LocalDateTime getIdopont() {
		return idopont;
	}

	public void setIdopont(LocalDateTime idopont) {
		this.idopont = idopont;
	}

	public DateTimeFormatter getFormatterDateTime() {
		return formatterDateTime;
	}

	public List<Versenyzo> getVersenyzok() {
		return versenyzok;
	}

	public void setVersenyzok(List<Versenyzo> versenyzok) {
		this.versenyzok = versenyzok;
	}

	@Override
	public String toString() {
		return "Verseny{" +
				"\n\tElnevezes:\t" + elnevezes +
				"\n\tIdopont: \t" + idopont.format(this.getFormatterDateTime()) +
				"\n}";
	}

	public void versenyNevIdopontMegadasa() {
		Scanner s = new Scanner(System.in);

		System.out.println("Verseny neve:");
		this.setElnevezes(s.nextLine());
		System.out.println("Verseny idopontja (éééé.hh.nn. óó:pp):");

		LocalDateTime formatDateTime = null;
		while (formatDateTime == null) {
			String date = s.nextLine();
			try {
				formatDateTime = LocalDateTime.parse(date, formatterDateTime);
			} catch (Exception e) {
				System.out.println("Rossz időpont formátum! Add meg újra az időpontot (éééé.hh.nn. óó:pp):");
			}
		}

		this.setIdopont( formatDateTime );
		System.out.println(this);
	}

	public void versenyzoFelvitele() {
		//Versenyzo versenyzo = new Versenyzo();
		Versenyzo versenyzo = new Versenyzo("aaa", 1, 1);
		versenyzok.add(versenyzo);
		versenyzo = new Versenyzo("bbb", 2, 2);
		versenyzok.add(versenyzo);

		/*
		Scanner s = new Scanner(System.in);

		System.out.println("Versenyző neve:");
		versenyzo.setNev(s.nextLine());  // azonos nevu versenyzok letezhetnek valosagban is, nem ellenorizzuk

		System.out.println("Versenyző rajtszáma:");
		versenyzo.setRajtszam(rajtszamInput());

		System.out.println("Versenyző helyezése:");
		versenyzo.setHelyezes(helyezesInput());

		versenyzok.add(versenyzo);
		 */
		try {
			//System.out.println(Class.forName("com.google.common.collect.Iterables"));
			Iterable<Versenyzo> lastElement = Iterables.getLast(versenyzok, null);
			System.out.println("Felvittem:\n" + lastElement);
		} catch(Exception e) {
			//System.out.println("com.google.common.collect.Iterables MISS");
			Versenyzo lastElement = versenyzok.get(versenyzok.size() - 1);
			System.out.println("Felvittem:\n" + lastElement);
		}
	}

	public int keresesNevSzerint(String nev) {
		OptionalInt index = IntStream.range(0, versenyzok.size())
				.filter(i -> nev.equals(versenyzok.get(i).getNev()))
				.findFirst();
		return index.getAsInt();
	}

	public void versenyzoKereses() {
		Scanner s = new Scanner(System.in);
		String nev;

		System.out.println("Versenyzo neve:");
		nev = s.nextLine();

		try {
			Versenyzo v = versenyzok.get(keresesNevSzerint(nev));
			System.out.println(v);
		} catch (Exception e) {
			System.out.println("Nem található versenyző ilyen névvel.");
		}
	}

	public void versenyzoAdatmodositas() {
		Versenyzo versenyzo = new Versenyzo();
		Scanner s = new Scanner(System.in);
		String nev;

		System.out.println("Versenyző neve:");
		nev = s.nextLine();

		try {
			int index = keresesNevSzerint(nev);
			Versenyzo v = versenyzok.get(index);
			System.out.println(v);

			System.out.println("Versenyző új neve:");
			versenyzo.setNev(nevInput());

			System.out.println("Versenyző új rajtszáma:");
			versenyzo.setRajtszam(rajtszamInput());

			System.out.println("Versenyző új helyezése:");
			versenyzo.setHelyezes(helyezesInput());

			versenyzok.set(index, versenyzo);

			System.out.println(versenyzok.get(index));
		} catch (Exception e) {
			System.out.println("Nem található versenyző ilyen névvel.");
		}
	}

	public void versenyzokNevSzerint() {
		Collections.sort(versenyzok, new compareNev());
		for (Versenyzo v : versenyzok)
			System.out.println(v);
	}

	public void versenyzokRajtszamSzerint() {
		Collections.sort(versenyzok, new compareRajtszam());
		for (Versenyzo v : versenyzok)
			System.out.println(v);
	}

	public void versenyzokHelyezesSzerint() {
		Collections.sort(versenyzok, new compareHelyezes());
		for (Versenyzo v : versenyzok)
			System.out.println(v);
	}

	public boolean containsNev(final List<Versenyzo> versenyzok, final String nev){
		return versenyzok.stream().anyMatch(o -> o.getNev() == nev);
	}

	public boolean containsRajtszam(final List<Versenyzo> versenyzok, final int rajtszam){
		return versenyzok.stream().anyMatch(o -> o.getRajtszam() == rajtszam);
	}
	public boolean containsHelyezes(final List<Versenyzo> versenyzok, final int helyezes){
		return versenyzok.stream().anyMatch(o -> o.getHelyezes() == helyezes);
	}

	public String nevInput() {
		Scanner s = new Scanner(System.in);
		String nev;

		nev = s.nextLine();
		while (nev == null || containsNev(versenyzok, nev)) {
			System.out.println("A név már létezik!");
			System.out.println("Versenyző neve:");
			nev = s.nextLine();
		}
		return nev;
	}

	public int rajtszamInput() {
		Scanner s = new Scanner(System.in);
		int rajtszam;

		rajtszam = s.nextInt();
		while (rajtszam<=0 || containsRajtszam(versenyzok, rajtszam)) {
			System.out.println("A rajtszám már létezik!");
			System.out.println("Versenyző rajtszáma:");
			rajtszam = s.nextInt();
		}
		return rajtszam;
	}

	public int helyezesInput() {
		Scanner s = new Scanner(System.in);
		int helyezes;

		helyezes = s.nextInt();
		while (helyezes<=0 || containsRajtszam(versenyzok, helyezes)) {
			System.out.println("A helyezés már létezik!");
			System.out.println("Versenyző helyezése:");
			helyezes = s.nextInt();
		}
		return helyezes;
	}

	public static void main(String[] args) {
		Verseny verseny = new Verseny();
		System.out.println(verseny);
	}
}
