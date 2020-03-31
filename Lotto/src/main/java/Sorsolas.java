import java.util.Arrays;
import java.util.Random;

public class Sorsolas {
    Random rand = new Random();
    private int[] kihuzottSzamok = new int[5];

    public Sorsolas() {}

    public int[] getKihuzottSzamok() {
        return kihuzottSzamok;
    }

    public void setKihuzottSzamok(int[] kihuzottSzamok) {
        this.kihuzottSzamok = kihuzottSzamok;
    }

    public void sorsolas (int max) {
        for (int i=0; i<5; i++) {
            int sorsoltSzam = rand.nextInt(max) + 1;
            while ( Szelveny.benneVan(kihuzottSzamok, sorsoltSzam) ) {
                sorsoltSzam = rand.nextInt(max) + 1;
            }
            kihuzottSzamok[i] = sorsoltSzam;
        }
        Arrays.sort(kihuzottSzamok);
    }

    @Override
    public String toString() {
        return "Sorsolt szamok: " + Arrays.toString(this.getKihuzottSzamok());
    }

    public static void main(String[] args) {
        Sorsolas sorsolas = new Sorsolas();
        sorsolas.sorsolas(10);
        System.out.println(sorsolas.toString());
    }
}
