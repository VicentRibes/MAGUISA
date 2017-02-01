/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import VISTA.JIntFrmNuevaOrdInterna;
import VISTA.MAGUISA;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/**
 *
 * @author Informatica
 */
public class CargandoEspere extends Thread {

    public CargandoEspere(String msg) {
        super(msg);
    }      
    public void run(){           
                         
            JFrame frame = new JFrame();
            JLabel input = new JLabel("Creando orden");   
            frame.setSize(100,100);
            frame.add( input, BorderLayout.NORTH );                             
            frame.pack();
            frame.setVisible( true );             
            
            while(!Thread.currentThread().isInterrupted()){
             
            /*System.out.println("Cargando.....");          */
            }
            
            frame.setVisible(false);
            
    } 
}
