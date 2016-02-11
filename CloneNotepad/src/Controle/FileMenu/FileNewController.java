/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.FileMenu;

import javax.swing.JTextArea;

/**
 *
 * @author eduar_000
 */
public class FileNewController {
    private JTextArea component = null;
        
    public FileNewController(JTextArea component) {
        this.component = component;    
    }
    
    public void setFocus(){
        this.component.grabFocus();
    }
    
    public void setEmptyText(){
        this.component.setText("");
    }
    
}
