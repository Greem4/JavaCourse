package edu.javacourse.zip.in;

import java.util.zip.ZipFile;

public class Starter {
    public static void main(String[] args) throws Exception {
        readZip();
    }

    private static void readZip() throws Exception {
        ZipFile zf = new ZipFile("/home/greem/testZip.zip");
//        for (Enumeration<? extends ZipEntry> iter = zf.entries(); iter.hasMoreElements(); ) {
//            ZipEntry ze = iter.nextElement();
//            System.out.println("Entry:" + ze.getName());
//            if (!ze.isDirectory()) {
//                BufferedReader br = new BufferedReader(
//                        new InputStreamReader(zf.getInputStream(ze)));
//                String line = null;
//                while ((line = br.readLine()) != null) {
//                    System.out.println(line);
//                }
//                System.out.println("------------------>>>");
//            }
//        }

        zf.stream().forEach(new MyZip(zf));
    }
}



