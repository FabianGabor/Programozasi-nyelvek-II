import java.io.*;

public class FileRW {
     public static void main (String[] args)
     {
         File fileIn = new File("src/main/java/FileRW.java");
         File fileOut = new File("output.txt");

         System.out.println(fileIn.getAbsolutePath());
         System.out.println(fileOut.getAbsolutePath());

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


         try (BufferedWriter fileBufferedOut = new BufferedWriter(new FileWriter(fileOut, true))) {
             fileBufferedOut.write("Buffered output string");
             fileBufferedOut.newLine();
             fileBufferedOut.flush();
             fileBufferedOut.close();
         } catch (FileNotFoundException e) {
             System.out.println("A file nem letezik!");
             e.printStackTrace();
         } catch (IOException e) {
             System.out.println("Hiba a filekezeles soran!");
             e.printStackTrace();
         }


         try (BufferedReader fileBufferedIn = new BufferedReader(new FileReader(fileOut))) {
             String sor = null;
             while ( (sor = fileBufferedIn.readLine()) != null)
                 System.out.println(sor);
         } catch (FileNotFoundException e) {
             System.out.println("A file nem letezik!");
             e.printStackTrace();
         } catch (IOException e) {
             System.out.println("Hiba a filekezeles soran!");
             e.printStackTrace();
         }

     }
}
