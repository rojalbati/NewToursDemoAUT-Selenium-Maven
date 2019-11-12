package frameworkPackages;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
 
/**
 * This Java program demonstrates how to compress multiple files in ZIP format.
 *
 * 
 */
public class ZipFiles {
 
    public static void zipFiles(String... filePaths) {
        try {
            File firstFile = new File(filePaths[0]);
            //String zipFileName = firstFile.getName().concat(".zip");
            
            //Path of the Zip File to be created. Also use the same path to send in Mail.
            String zipFileName = "./test-output/Report/New-Tours-Demo-AUT-Smoke-Test.zip";
 
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            for (String aFile : filePaths) {
                zos.putNextEntry(new ZipEntry(new File(aFile).getName()));
 
                byte[] bytes = Files.readAllBytes(Paths.get(aFile));
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }
 
            zos.close();
 
        } catch (FileNotFoundException ex) {
            System.err.println("A file does not exist: " + ex);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
 
    public static void main(String[] args) {
        zipFiles(args);
    }
}