package edu.javacourse.zip.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class MyZip implements Consumer<ZipEntry> {

    private ZipFile zf;

    public MyZip(ZipFile zf) {
        this.zf = zf;
    }

    @Override
    public void accept(ZipEntry ze) {
        try {
            System.out.println("Entry:" + ze.getName());
            if (!ze.isDirectory()) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(zf.getInputStream(ze)));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("------------------>>>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}