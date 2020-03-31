import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class BeolvasAllomany {
    public static void main(String[] args) {
        File f = new File("input.txt");
        //System.out.println(System.getProperty("user.dir"));
        /*
        System.setProperty("user.dir", ".\\test");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(f.getAbsolutePath());

         */
        try {
            //System.out.println(f.getCanonicalPath());
            //boolean letrehoz = f.createNewFile();
            File temp = File.createTempFile("input", ".tmp");
            if (temp.exists())
                System.out.println("temp lezezik: " + temp.getAbsolutePath());
            f.deleteOnExit();
            temp.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File("/tmp");
        File[] filelist = dir.listFiles();

        for (File file: filelist)
            System.out.println(file.getName());

        FileFilter filtered = new FileFilter() {
            @Override
            public boolean accept(File pn) {
                if (pn.isFile()) {
                    String nev = pn.getName().toLowerCase();
                    if (nev.endsWith(".tmp")) {
                        return true;
                    }
                }
                return false;
            }
        };

        System.out.println(".tmp files in " + dir);
        filelist = dir.listFiles(filtered);
        for (File file: filelist)
            System.out.println(file.getName());



    }
}
