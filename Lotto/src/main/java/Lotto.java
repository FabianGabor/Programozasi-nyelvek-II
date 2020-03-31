public class Lotto {
    Szelveny szelveny = new Szelveny();
    Sorsolas sorsolas = new Sorsolas();
    public int[] talalatok = new int[5];
    public int talalatokSzama = 0;

    private void mainMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Szelveny kitoltes", this, "szelvenyKitoltes"));
        menu.addItem(new MenuItem("Lottohuzas", this, "lottohuzas"));
        menu.execute();
    }

    public int[] getTalalatok() {
        return talalatok;
    }

    private void setTalalatok(int[] talalatok) {
        this.talalatok = talalatok;
    }

    public int getTalalatokSzama() {
        return talalatokSzama;
    }

    public void setTalalatokSzama(int talalatokSzama) {
        this.talalatokSzama = talalatokSzama;
    }

    public void szelvenyKitoltes() {
        szelveny.kitoltes();
    }

    public void lottohuzas() {
        System.out.println(szelveny.toString());

        sorsolas.sorsolas(90);
        System.out.println(sorsolas.toString());

        int[] valasztottSzamok = szelveny.getValasztottSzamok();
        int[] talalatok = new int[5];
        int talalatokSzama = 0;

        for (int i = 0; i < 5; i++)
            if (Szelveny.benneVan(sorsolas.getKihuzottSzamok(), valasztottSzamok[i])) {
                talalatok[talalatokSzama] = valasztottSzamok[i];
                talalatokSzama++;
            }

        this.setTalalatok(talalatok);
        this.setTalalatokSzama(talalatokSzama);

        eltalaltSzamok();
    }

    public void eltalaltSzamok() {
        int talalatokSzama = getTalalatokSzama();
        int[] talalatok = getTalalatok();

        System.out.print(talalatokSzama + " talalat: ");
        for (int i=0; i<talalatokSzama - 1; i++)
            System.out.print(talalatok[i] + ", ");
        if (talalatokSzama > 0)
            System.out.println(talalatok[talalatokSzama - 1]);
    }


    public void Kilepes() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Lotto().mainMenu();
    }
}
