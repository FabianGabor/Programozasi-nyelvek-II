import java.io.*;
import java.util.ArrayList;

public class Filekezeles {
    File file = new File("idojaras.dat");
    DataOutputStream out = null;
    DataInputStream in = null;


    public void writeToFile (Data data) {

        try {
            out = new DataOutputStream(new FileOutputStream(file, true));

            out.writeUTF(data.datum);
            out.writeDouble(data.reggeliHomerseklet);
            out.writeDouble(data.deliHomerseklet);
            out.writeDouble(data.estiHomerseklet);

            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File nem letezik!");
        } catch (IOException e) {
            System.out.println("IO hiba!");
        } finally {

        }
    }
    public ArrayList<Data> readFromFile () {
        ArrayList<Data> data = new ArrayList<Data>();


        try {
            in = new DataInputStream(new FileInputStream(file));
            boolean eof = false;

            while (!eof) {
                Data obj = new Data();
                try {
                    obj.setDatum(in.readUTF());
                    obj.setReggeliHomerseklet(in.readDouble());
                    obj.setDeliHomerseklet(in.readDouble());
                    obj.setEstiHomerseklet(in.readDouble());

                    data.add(obj);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File nem letezik!");
        } catch (IOException e) {
            System.out.println("IO hiba!");
        }

        return data;
    }
}
