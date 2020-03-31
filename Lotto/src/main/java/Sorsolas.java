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

    public void sorsolas () {
        for (int i=0; i<5; i++)
            kihuzottSzamok[i] = rand.nextInt(90) + 1;
        Arrays.sort(kihuzottSzamok);
    }

    @Override
    public String toString() {
        return "Sorsolt szamok: " + Arrays.toString(this.getKihuzottSzamok());
    }

    public static void main(String[] args) {
        Sorsolas sorsolas = new Sorsolas();
        sorsolas.sorsolas();
        System.out.println(sorsolas.toString());
    }
}
