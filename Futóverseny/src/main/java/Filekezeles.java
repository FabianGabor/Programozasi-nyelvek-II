/*
 * Fábián Gábor
 * CXNU8T
 * https://github.com/FabianGabor/Programozasi-nyelvek-II/tree/master/Fut%C3%B3verseny
 */

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


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

    public List<String> getTokens(String str) {
        return Collections.list(new StringTokenizer(str, ";")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
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

                /*
                // Nem volt egyértelmű, hogy így is megoldható-e vagy csak Scanner/StringTokkenizer-rel vagy esetleg String split method-dal is

                String[] versenyzoStr = line.split(";");
                versenyzo.setNev(versenyzoStr[0]);
                versenyzo.setRajtszam(Integer.parseInt(versenyzoStr[1]));
                versenyzo.setHelyezes(Integer.parseInt(versenyzoStr[2]));
                 */

                List<String> tokens = this.getTokens(line);
                versenyzo.setNev(tokens.get(0));;
                versenyzo.setRajtszam(Integer.parseInt(tokens.get(1)));
                versenyzo.setHelyezes(Integer.parseInt(tokens.get(2)));

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
