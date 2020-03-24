/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

abstract class Nempoliederek extends Testek {
    public Nempoliederek() {
    }

    public static void main(String[] args) {
        Gomb gomb = new Gomb("Gomb", 1);
        System.out.println(gomb.toString());

        Henger henger = new Henger("Henger", 1, 5);
        System.out.println(henger.toString());
    }
}