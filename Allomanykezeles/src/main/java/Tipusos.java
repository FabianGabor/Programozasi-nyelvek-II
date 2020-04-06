import java.io.*;

public class Tipusos {
    public static void main (String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;
        ObjectOutputStream outObject = null;
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


            Ember ember1 = new Ember("Teszt 1", 1987);
            Ember ember2 = new Ember("Teszt 2", 1989);
            Ember ember3 = new Ember("Teszt 3", 1991);

            outObject = new ObjectOutputStream(new FileOutputStream(fileObject));
            outObject.writeObject(ember1);
            outObject.writeObject(ember2);
            outObject.writeObject(ember3);
            outObject.flush();
            outObject.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileObject));
            Ember emberIn1 = (Ember) objectInputStream.readObject();
            Ember emberIn2 = (Ember) objectInputStream.readObject();
            Ember emberIn3 = (Ember) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(emberIn1);
            System.out.println(emberIn2);
            System.out.println(emberIn3);



        } catch (FileNotFoundException e) {
            System.out.println("A file nem letezik!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Hiba a filekezeles soran!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Az osztaly nem talalhato.");
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                outObject.close();
            } catch (IOException e) {
                System.out.println("Hiba a filekezeles soran!");
                e.printStackTrace();
            }

        }
    }
}