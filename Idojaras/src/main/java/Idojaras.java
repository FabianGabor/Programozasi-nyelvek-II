public class Idojaras {

    Data data = new Data();

    private void mainMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Adatok megadása", data, "adatokMegadasa"));
        menu.addItem(new MenuItem("Random adatokkal feltöltés (lusta vagyok beírni)", data, "randomAdatokMegadasa"));
        menu.addItem(new MenuItem("Adatok megjelenítése", data, "adatokMegjelenitese"));
        menu.addItem(new MenuItem("Adatok elemzése", data, "adatokElemzese"));
        menu.addItem(new MenuItem("Keresés", data, "kereses"));
        menu.execute();
    }

    public static void main(String[] args) {
        new Idojaras().mainMenu();
    }
}
