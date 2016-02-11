/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.FormatMenu;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author eduar_000
 */
public class FormatWordWrapController {
    private final JTextArea componente;
    private final JCheckBoxMenuItem menuItem;
    
    public FormatWordWrapController(JTextArea componente, JCheckBoxMenuItem menuItem) {
        this.componente = componente;
        this.menuItem = menuItem;
    }
    
    public void setWordWrap(){
        try {
            if (!componente.getLineWrap()) {
                componente.setLineWrap(true);
                menuItem.setSelected(true);
            } else {
                componente.setLineWrap(false);
                menuItem.setSelected(false);
            }
        } catch (Exception e) {
            System.out.println("Controle.FormatMenu.FormatWordWrap.setWordWarp()" + e);
        }
    }
    
}
