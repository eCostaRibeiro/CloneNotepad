/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.FileMenu;

import Controle.FileSaver;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author eduar_000
 */
public class FileSaveController {
    private FileSaver fileSaver;
    
    public void FileSaveControllerMethod(File file, String content) throws IOException{
        fileSaver = new FileSaver();
        
        fileSaver.setFileContent(file, content);
    }
    
    
    public void FileSaveAsControllerMethod(JFileChooser chooser, String textAreaContent) throws IOException{
        fileSaver = new FileSaver();
        File localFile = chooser.getSelectedFile();
        String fileName = chooser.getSelectedFile().getAbsolutePath();
        
        fileSaver.createLocalFile(localFile, fileName, textAreaContent);
    }
}
