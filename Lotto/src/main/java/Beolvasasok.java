import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Beolvasasok {
    public static void main (String[] args) {
        try {

            BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Kerek egy szoveget: ");
            String sor = be.readLine();
            System.out.println(sor);

            /*
            System.out.println("Kerek egy szamot: ");
            sor = be.readLine();
            int szam = Integer.parseInt(sor);
            System.out.println("A szam negyzete: " + Math.pow(szam, 2));


            Scanner sbe = new Scanner(System.in);
            System.out.println("Kerek egy szoveget: ");
            sor = sbe.nextLine();
            System.out.println(sor);
            System.out.println("Kerek egy valos szamot: ");
            double valos = sbe.nextDouble();
            System.out.println("A szam negyzete: " + Math.pow(valos,2));
            sbe.close();
             */

            Scanner darabol = new Scanner("Ez egy feldarabolando szoveg.");
            while (darabol.hasNext())
                System.out.println(darabol.next());
        } catch (IOException e) {
            System.out.println("Hiba beolvasas soran!");
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Nem szamot adtal meg!");
        }
    }
}
