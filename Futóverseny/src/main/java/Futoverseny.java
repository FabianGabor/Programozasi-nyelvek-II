/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Fut%C3%B3verseny
 */

public class Futoverseny {
	Verseny verseny = new Verseny();

	private void mainMenu() {
		Menu menu = new Menu();
		menu.addItem(new MenuItem("A verseny nevének és időpontjának megadása", verseny, "versenyNevIdopontMegadasa"));
		menu.addItem(new MenuItem("Versenyző felvitele", verseny, "versenyzoFelvitele"));
		menu.addItem(new MenuItem("Random versenyzők generálása", verseny, "RandomVersenyzok"));
		menu.addItem(new MenuItem("Versenyző adatainak módosítása", verseny, "versenyzoAdatmodositas"));
		menu.addItem(new MenuItem("Versenyző keresése", verseny, "versenyzoKereses"));
		menu.addItem(new MenuItem("Versenyző törlése", verseny, "versenyzoTorlese"));
		menu.addItem(new MenuItem("Versenyzők listázása név szerint ", verseny, "versenyzokNevSzerint"));
		menu.addItem(new MenuItem("Versenyzők listázása rajtszám szerint ", verseny, "versenyzokRajtszamSzerint"));
		menu.addItem(new MenuItem("Versenyzők listázása eredmény szerint ", verseny, "versenyzokHelyezesSzerint"));
		menu.addItem(new MenuItem("Mentés", verseny, "Mentes"));
		menu.addItem(new MenuItem("Betöltés", verseny, "Betoltes"));
		menu.execute();
	}

	public static void main(String[] args) {
		new Futoverseny().mainMenu();
	}
}
