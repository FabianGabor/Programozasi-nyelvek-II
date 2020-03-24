/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

abstract class Poliederek extends Testek {
    public Poliederek() {
    }

    public static void main(String[] args) {
        Teglatest teglatest = new Teglatest("Teglatest", 1,2,3);
        System.out.println(teglatest.toString());

        Kocka kocka = new Kocka("Kocka", 2);
        System.out.println(kocka.toString());
    }
}
