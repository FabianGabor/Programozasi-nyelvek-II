/*
 * Fábián Gábor
 * CXNU8T
 * 2020.
 */

public interface TestInterface {
    String azonosito = "TestInterface";

    public double terfogat();
    public double felszin();

    default String kiir() {
        return  azonosito;
    }
}
