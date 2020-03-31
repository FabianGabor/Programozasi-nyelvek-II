public class Lotto {
    Szelveny szelveny = new Szelveny();
    Sorsolas sorsolas = new Sorsolas();

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

        sorsolas.sorsolas(10);
        System.out.println(sorsolas.toString());

        int[] valasztottSzamok = szelveny.getValasztottSzamok();
        int[] talalatok = new int[5];
        int talalatokSzama = 0;

        for (int i = 0; i < 5; i++) {
            if (Szelveny.benneVan(sorsolas.getKihuzottSzamok(), valasztottSzamok[i])) {
                talalatok[talalatokSzama] = valasztottSzamok[i];
                talalatokSzama++;
            }
        }

        for (int i=0; i<talalatokSzama; i++)
            System.out.println(talalatok[i]);
    }

    public void Kilepes() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Lotto().mainMenu();
    }
}
