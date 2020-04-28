/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Lotto/src/main/java
 */

import java.util.*;

public class Sorsolas {
    Random rand = new Random();
    //private int[] kihuzottSzamok = new int[5];
    private Set<Integer> kihuzottSzamok = new TreeSet<>();

    public Sorsolas() {}

    //public int[] getKihuzottSzamok() {
    public Set<Integer> getKihuzottSzamok() {
        return kihuzottSzamok;
    }

    //public void setKihuzottSzamok(int[] kihuzottSzamok) {
    public void setKihuzottSzamok(Set<Integer> kihuzottSzamok) {
        this.kihuzottSzamok = kihuzottSzamok;
    }

    public void sorsolas (int max) {
        kihuzottSzamok.clear();
        for (int i=0; i<5; i++) {
            int sorsoltSzam = rand.nextInt(max) + 1;
            while ( Szelveny.benneVan(kihuzottSzamok, sorsoltSzam) ) {
                sorsoltSzam = rand.nextInt(max) + 1;
            }
            //kihuzottSzamok[i] = sorsoltSzam;
            kihuzottSzamok.add(sorsoltSzam);
        }
        //Arrays.sort(kihuzottSzamok);
    }

    @Override
    public String toString() {
        //return "Sorsolt szamok: " + Arrays.toString(this.getKihuzottSzamok());
        Iterator<Integer> iterator = this.getKihuzottSzamok().iterator();
        String s = "";
        while (iterator.hasNext()) {
            s += iterator.next() + " ";
        }
        return "Sorsolt szamok: " + s;
    }

    /*
    public static void main(String[] args) {
        Sorsolas sorsolas = new Sorsolas();
        sorsolas.sorsolas(10);
        System.out.println(sorsolas.toString());
    }
     */
}
