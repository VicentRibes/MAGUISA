/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELOS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Miguel
 */
public class FormatoTabla extends DefaultTableCellRenderer{
    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
        public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {
        /*if(String.valueOf(table.getValueAt(row,column)).equals("")){
            setBackground(Color.yellow);         
        }*/
        if(String.valueOf(table.getValueAt(row,column)).equals("")||String.valueOf(table.getValueAt(row,column)).equals("EL OPERARIO NO ESTA EN NINGÚN CENTRO")){            
            table.setValueAt("EL OPERARIO NO ESTA EN NINGÚN CENTRO", row, column);
            setBackground(Color.black); //color fondo                        
            table.setForeground(Color.red);//color texto
            table.setFont(negrilla);//formato texto
        }
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
    }
}
