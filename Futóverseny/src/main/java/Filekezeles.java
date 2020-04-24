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
import java.util.List;


public class Filekezeles {
    String filename = "verseny.txt";
    File file = new File(filename);

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
        for (Versenyzo v : verseny.getVersenyzok())
            bw.write(v.getNev() + ";" + v.getRajtszam() + ";" + v.getHelyezes() + "\n");

        bw.close();
        lock.release();

        stream.close();
        channel.close();
    }

    public Verseny read() {
        Verseny verseny = new Verseny();
        List<Versenyzo> versenyzok = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            verseny.setElnevezes(reader.readLine());
            verseny.setIdopont(reader.readLine());

            String line;

            while ((line = reader.readLine()) != null) {
                Versenyzo versenyzo = new Versenyzo();

                String[] versenyzoStr = line.split(";");

                versenyzo.setNev(versenyzoStr[0]);
                versenyzo.setRajtszam(Integer.parseInt(versenyzoStr[1]));
                versenyzo.setHelyezes(Integer.parseInt(versenyzoStr[2]));

                versenyzok.add(versenyzo);
            }

            verseny.setVersenyzok(versenyzok);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return verseny;
    }

    //public List<Versenyzo>
}
