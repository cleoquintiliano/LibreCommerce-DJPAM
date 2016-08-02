/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Clovis
 */
public class Messages {
    
    public static void infoMessage(Component parent, Object mensagem) {
        JOptionPane.showMessageDialog(parent, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void alertMessage(Component parent, Object mensagem) {
        JOptionPane.showMessageDialog(parent, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void errorMessage(Component parent, Object mensagem) {
        JOptionPane.showMessageDialog(parent, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
}
