/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Lotto/src/main/java
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    Szelveny szelveny = new Szelveny();
    Sorsolas sorsolas = new Sorsolas();
    //public int[] talalatok = new int[5];
    public Set<Integer> talalatok = new TreeSet<>();
    public int talalatokSzama = 0;

    private void mainMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Szelveny kitoltes", this, "szelvenyKitoltes"));
        menu.addItem(new MenuItem("Lottohuzas", this, "lottohuzas"));
        menu.execute();
    }

    //public int[] getTalalatok() {
    public Set<Integer> getTalalatok() {
        return talalatok;
    }

    //private void setTalalatok(int[] talalatok) {
    private void setTalalatok(Set<Integer> talalatok) {
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
        //System.out.println(szelveny.toString());

        sorsolas.sorsolas(90);
        //System.out.println(sorsolas.toString());

        //int[] valasztottSzamok = szelveny.getValasztottSzamok();
        Set<Integer> valasztottSzamok = szelveny.getValasztottSzamok();
        //int[] talalatok = new int[5];
        Set<Integer> talalatok = new TreeSet<>(sorsolas.getKihuzottSzamok());
        int talalatokSzama = 0;

        /*
        for (int i = 0; i < 5; i++)
            if (Szelveny.benneVan(sorsolas.getKihuzottSzamok(), valasztottSzamok[i])) {
                talalatok[talalatokSzama] = valasztottSzamok[i];
                talalatokSzama++;
            }
        */
        talalatok.retainAll(szelveny.getValasztottSzamok());
        talalatokSzama = talalatok.size();

        this.setTalalatok(talalatok);
        this.setTalalatokSzama(talalatokSzama);

        eltalaltSzamok();

    }

    public void eltalaltSzamok() {
        int talalatokSzama = getTalalatokSzama();
        //int[] talalatok = getTalalatok();
        Set<Integer> talalatok = getTalalatok();

        //System.out.print(talalatokSzama + " talalat: ");
        /*
        for (int i=0; i<talalatokSzama - 1; i++)
            System.out.print(talalatok[i] + ", ");
        if (talalatokSzama > 0)
            System.out.println(talalatok[talalatokSzama - 1]);
         */
        //System.out.println(this.getTalalatok().toString() + "ide toString()");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String s = "";

        s += "Választott számok: ";
        for (Integer i : szelveny.getValasztottSzamok())
            s += i + " ";

        s += "\nSorsolt számok: ";
        for (Integer i : sorsolas.getKihuzottSzamok())
            s += i + " ";

        s += "\nTalálatok: ";
        for (Integer i : this.getTalalatok())
            s += i + " ";

        s += "\nTalálatok száma: " + this.getTalalatokSzama();

        /*
        return  "Valasztott szamok: " + szelveny.getValasztottSzamok() +
                "\nSorsolt szamok: " + sorsolas.getKihuzottSzamok() +
                "\nTalalatok: " + talalatok +
                "\nTalalatok szama: " + talalatokSzama;

         */
        return s;
    }

    public void Kilepes() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Lotto().mainMenu();
    }
}
