/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author eduar_000
 */
public class FileReader {
    
    public String getFileContentScanner(File filePath) throws FileNotFoundException{
        Scanner scannerFile;
        FileInputStream fileInputStream;
        StringBuilder builder;
        
        fileInputStream = new FileInputStream(filePath);
        scannerFile = new Scanner(fileInputStream);
        builder = new StringBuilder();
        
        try {
            while (scannerFile.hasNextLine()) {
                builder.append(scannerFile.nextLine());
                builder.append("\n");
            }
            return builder.toString();
        } catch (Exception e) {
            System.out.println("Controle.LeituraDeArquivo.getFileContent()" + e);
            return null;
        } finally {
            scannerFile.close();
        }
    }
    
//    public String getFileContentInputStream (String filePath) throws FileNotFoundException, IOException{
//        static String readFile(String path, Charset encoding) throws IOException{
//            byte[] encoded = Files.readAllBytes(Paths.get(path));
//            return encoding.decode(ByteBuffer.wrap(encoded)).toString();
//        }
//        String content = readFile(filePath, StandardCharsets.UTF_8);
//        
//        
//        
//        //return null;
//    }
}
