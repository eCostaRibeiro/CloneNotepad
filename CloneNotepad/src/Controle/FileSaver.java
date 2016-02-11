/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author eduar_000
 */
public class FileSaver {
    
    public void setFileContent(File filePatch, String content) throws FileNotFoundException, IOException{
        OutputStream fileOutputStream;
        OutputStreamWriter fileOutputWriter;
        BufferedWriter buffer;
        
        fileOutputStream = new FileOutputStream(filePatch);
        fileOutputWriter = new OutputStreamWriter(fileOutputStream);
        buffer = new BufferedWriter(fileOutputWriter);
        
        buffer.write(content);
        buffer.close();
        
    }
    
    public void createLocalFile(File localFile,String filePatch, String content) throws IOException{
        localFile = new File(filePatch +".txt");
        localFile.createNewFile();
        
        FileWriter fileWriter = new FileWriter(localFile.getAbsoluteFile());
        try (BufferedWriter buffer = new BufferedWriter(fileWriter)) {
            buffer.write(content);
        }
        
    }
}
