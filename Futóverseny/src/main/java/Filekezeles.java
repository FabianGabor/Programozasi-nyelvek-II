/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Idojaras/src/main/java
 */

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filekezeles {
    File file = new File("verseny.txt");

    public void write(Verseny verseny) throws IOException {
        RandomAccessFile stream = new RandomAccessFile(file, "rw");
        FileChannel channel = stream.getChannel();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }

        bw.write(verseny.getElnevezes() + "\n");
        bw.write(verseny.getIdopont().format(verseny.getFormatterDateTime()) + "\n");
        bw.write(verseny.getVersenyzok().toString());

        bw.close();
        lock.release();

        stream.close();
        channel.close();
    }

/*
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

 */
}
