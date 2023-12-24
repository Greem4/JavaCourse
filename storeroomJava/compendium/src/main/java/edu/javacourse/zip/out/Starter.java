package edu.javacourse.zip.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Starter {
    public static final String FILE = "test1.zip";
    public static void main(String[] args) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(FILE));
//
//        ZipEntry ze1 = new ZipEntry("name1.txt");
//        zos.putNextEntry(ze1);
//        zos.write("SUPER1".getBytes());
//
//        ZipEntry ze2 = new ZipEntry("name2.txt");
//        zos.putNextEntry(ze2);
//        zos.write("SUPER2".getBytes());

        createZipDir(zos, new File(".").listFiles(), "");

        zos.close();
    }

    private static void createZipDir(ZipOutputStream zos, File[] files, String path) throws IOException {
        for (File f : files) {
            if (f.isDirectory()) {
                createZipDir(zos, f.listFiles(), path + f.getName() + "/");
            } else if (!f.getName().equals(FILE)){
                ZipEntry ze = new ZipEntry(path + f.getName());
                zos.putNextEntry(ze);

                FileInputStream fis = new FileInputStream(f);
                byte[] buffer = new byte[1024];
                int size = -1;
                while ((size = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, size);
                }
            }
        }
    }
}
