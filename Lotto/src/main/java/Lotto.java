public class Lotto {
    Szelveny szelveny = new Szelveny();

    private void mainMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Szelveny kitoltes", this, "szelvenyKitoltes"));
        menu.addItem(new MenuItem("Lottohuzas", this, "lottohuzas"));
        menu.execute();
    }

    public void szelvenyKitoltes() {
        szelveny.kitoltes();
    }

    public void lottohuzas() {
        System.out.println(szelveny.toString());
    }

    public void Kilepes() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Lotto().mainMenu();
    }
}
