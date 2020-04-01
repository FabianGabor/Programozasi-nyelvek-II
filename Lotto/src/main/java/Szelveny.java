/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Lotto/src/main/java
 */


import java.util.Arrays;
import java.util.Scanner;

public class Szelveny {
    private int[] valasztottSzamok = new int[5];

    public Szelveny() {}

    public Szelveny(int[] valasztottSzamok) {
        this.valasztottSzamok = valasztottSzamok;
    }

    public int[] getValasztottSzamok() {
        return valasztottSzamok;
    }

    private void setValasztottSzamok(int[] valasztottSzamok) {
        this.valasztottSzamok = valasztottSzamok;
    }

    public static boolean benneVan(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public void kitoltes () {
        int[] szamok = new int[5];
        Arrays.fill(szamok, Integer.MIN_VALUE); // esetleges 0 input eseten ne azt a hibat adja, hogy mar valasztva volt

        Scanner s = new Scanner(System.in);
        System.out.println("Kerem az 5 szamot:");

        for(int i=0; i<5; i++ ) {
            int szam = Integer.parseInt(s.next());

            while ( (szam < 1) || (szam > 90) ||  (benneVan(szamok, szam)) ) {
                if (benneVan(szamok, szam))
                    System.out.println("Nem lehet " + szam + "-t tobbszor valasztani!");
                else
                    if ((szam < 1) || (szam > 90))
                        System.out.println("A szamok 1-90 kozott kell legyenek!");

                szam = Integer.parseInt(s.next());
            }

            szamok[i] = szam;
        }
        Arrays.sort(szamok);
        this.setValasztottSzamok(szamok);
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Valasztott szamok: " + Arrays.toString(this.getValasztottSzamok());
    }

    public static void main (String[] args) {
        Szelveny szelveny = new Szelveny();
        szelveny.kitoltes();
        System.out.println("Valasztott szamok: " + Arrays.toString(szelveny.getValasztottSzamok()));
    }
}