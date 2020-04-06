import java.io.*;

public class FileRW {
     public static void main (String[] args)
     {
         File fileIn = new File("src/main/java/FileRW.java");
         System.out.println(fileIn.getAbsolutePath());

         try (FileInputStream in = new FileInputStream(fileIn)){
             int data = in.read();

             while (data != -1) {
                 System.out.print((char)data);
                 data = in.read();
             }
             in.close();

         } catch (FileNotFoundException e) {
             System.out.println("A file nem letezik!");
             e.printStackTrace();
         } catch (IOException e) {
             System.out.println("Hiba a filekezeles soran!");
             e.printStackTrace();
         }

         File fileOut = new File("output.txt");
         try (FileOutputStream out = new FileOutputStream(fileOut)) {
             String s1 = "Output string 1 ";
             String s2 = "Output string 2 ";
             String newLine = System.getProperty("line.separator");
             out.write((s1 + newLine + s2 + newLine).getBytes());

             out.flush();
             out.close();
         } catch (FileNotFoundException e) {
             System.out.println("A file nem letezik!");
             e.printStackTrace();
         } catch (IOException e) {
             System.out.println("Hiba a filekezeles soran!");
             e.printStackTrace();
         }


     }
}
