/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.FileMenu;

import Controle.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author eduar_000
 */
public class FileOpenController {
    private FileReader fileReader;
    
    public String FileOpenControllerMethod(File filePath) throws FileNotFoundException, IOException{
        fileReader = new FileReader();
        return fileReader.getFileContentScanner(filePath);
    }
    
    
        
}
