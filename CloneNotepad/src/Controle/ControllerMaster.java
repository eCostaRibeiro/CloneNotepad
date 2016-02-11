/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Controle.FileMenu.FileNewController;
import Controle.FileMenu.FileOpenController;
import Controle.FileMenu.FileSaveController;
import Controle.FormatMenu.FormatWordWrapController;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author eduar_000
 */
public class ControllerMaster {
    private final FileNewController fileNewController;
    private final FormatWordWrapController wordWrapController;
    private final FileOpenController fileOpenController;
    private final FileSaveController fileSaveController;
    
    private final JTextArea textArea;
    private final JFileChooser fileChooser;
    private final ExtensionFileFilter FILTER = new ExtensionFileFilter("txt", "Arquivo de Texto");

    
    public ControllerMaster(JScrollPane conteiner, JTextArea textComponent, JCheckBoxMenuItem chkBoxWarp, JFileChooser fileChooser) {
        //componentes
        textArea = textComponent;
        this.fileChooser = fileChooser;
        this.fileChooser.setFileFilter(FILTER);
        
        //classes controle
        fileNewController = new FileNewController(textArea);
        wordWrapController = new FormatWordWrapController(textComponent, chkBoxWarp);
        fileOpenController = new FileOpenController();
        fileSaveController = new FileSaveController();
        
    }
    
    public void FileNewMethod(){
        fileNewController.setEmptyText();
        fileNewController.setFocus();
    }
    
    public void FormatWordWrapMethod(){
        wordWrapController.setWordWrap();
    }
    
    public void OpenFileMethod(JFrame mainFrame) throws FileNotFoundException, IOException{
        
        int result = fileChooser.showOpenDialog(mainFrame);
        if (result == JFileChooser.APPROVE_OPTION){
            File filePath = fileChooser.getSelectedFile().getAbsoluteFile();
            String content = fileOpenController.FileOpenControllerMethod(filePath);
            textArea.setText(content);
        }
    }
    
    public void SaveFileMethod(JFrame mainFrame) throws IOException{
        File filePatch = fileChooser.getSelectedFile().getAbsoluteFile();
        String content = textArea.getText();
        
        if (filePatch != null) {
            fileSaveController.FileSaveControllerMethod(filePatch, content);
        } else{
            SaveFileAsMethod(mainFrame);
        }
    }
    
    public void SaveFileAsMethod(JFrame mainFrame) throws IOException{
        
        
        int result = fileChooser.showSaveDialog(mainFrame);
                
        if (result == JFileChooser.APPROVE_OPTION){
            String content = textArea.getText();
            fileSaveController.FileSaveAsControllerMethod(fileChooser, content);
        }
    }
    
    
    
}
