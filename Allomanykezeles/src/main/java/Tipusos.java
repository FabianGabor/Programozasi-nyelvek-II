import java.io.*;

public class Tipusos {
    public static void main (String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;
        File file = new File("data.dat");
        File fileObject = new File("object");

        try {
            out = new DataOutputStream(new FileOutputStream(file));
            out.writeInt(1848);
            out.writeDouble(3.14);
            out.writeBoolean(true);
            out.writeUTF("Ékezetes karakterek");
            out.flush();
            out.close();

            in = new DataInputStream(new FileInputStream(file));
            int x = in.readInt();
            double pi = in.readDouble();
            boolean igaz = in.readBoolean();
            String string = in.readUTF();
            System.out.println(x + "\t" + pi + "\t" + igaz + "\t" + string);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("A file nem letezik!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Hiba a filekezeles soran!");
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                System.out.println("Hiba a filekezeles soran!");
                e.printStackTrace();
            }

        }
    }
}