import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRW {
     public static void main (String[] args)
     {
         File file = new File("src/main/java/FileRW.java");
         System.out.println(file.getAbsolutePath());

         try {
             FileInputStream in = new FileInputStream(file);

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


     }
}
