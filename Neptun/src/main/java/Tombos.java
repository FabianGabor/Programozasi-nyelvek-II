import java.util.Arrays;

public class Tombos {
    public static void main(String[] args) {
        int[] tomb = new int[10];

        Arrays.fill(tomb, 0, 9, 3);
        Arrays.fill(tomb, 3, 6, 5);
        tomb[7] = 7;

        System.out.println(Arrays.toString(tomb));

        // rendezes
        Arrays.sort(tomb);
        System.out.println(Arrays.toString(tomb));

        // kereses
        int key = 7;
        int pos = Arrays.binarySearch(tomb, key);
        System.out.println("Index of " + key + ": " + pos);

        int a = 5;
        Integer egesz = 5;
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        String szo = "Alma";
        szo = "Alma es korte";
        StringBuffer sb = new StringBuffer("szilva");
        sb.append(" fa");
        System.out.println(szo + " " + sb);


    }
}
