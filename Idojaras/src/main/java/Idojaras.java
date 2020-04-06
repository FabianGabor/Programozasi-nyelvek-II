public class Idojaras {

    Data data = new Data();

    private void mainMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Adatok megadása", data, "adatokMegadasa"));
        menu.addItem(new MenuItem("Adatok megjelenítése", data, "adatokMegjelenitese"));
        menu.addItem(new MenuItem("Adatok elemzése", this, "adatokElemzese"));
        menu.addItem(new MenuItem("Keresés", this, "kereses"));
        menu.execute();
    }

    public static void main(String[] args) {
        new Idojaras().mainMenu();
    }
}
