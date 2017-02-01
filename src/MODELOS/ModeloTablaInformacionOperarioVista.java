/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELOS;

import ENTIDAD.FichajeOperarios;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miguel
 */
public class ModeloTablaInformacionOperarioVista extends AbstractTableModel {
    ArrayList datos = new ArrayList(); 
    //String [] columnas = {"CODIGO","OPERARIO","FICHA_INICIO","FICHA_FIN","CENTRO"/*"VER OPERARIO"/*,"TIPO"*/};
    //String [] columnas = {"CENTRO","HORA ENTRADA","HORA SALIDA"/*"VER OPERARIO"/*,"TIPO"*/};
    String [] columnas = {"CENTRO","HORA","TIPO"/*"VER OPERARIO"/*,"TIPO"*/};
    Class[] types = new Class [] {//tipo de datos de cada columna        
        java.lang.String.class, java.lang.String.class, java.lang.String.class//, java.lang.String.class, java.lang.String.class
    };
    public ModeloTablaInformacionOperarioVista (ArrayList<FichajeOperarios> informacionOperarios) {
        FichajeOperarios fiOp=new FichajeOperarios();
        //Creamos los objetos de una fila
        for(int i=0;i<informacionOperarios.size();i++){
            fiOp=(FichajeOperarios) informacionOperarios.get(i);
            Object [] fila = new Object[3];
            //fila[0] = fiOp.getCodigo();
            //fila[1] = fiOp.getNombre();
            fila[0] = fiOp.getCentro();
//            fila[1] = fiOp.getFicha_inicio();
//            fila[2] = fiOp.getFicha_fin();
///////////////////////////////////////           fila[1] = fiOp.getHora_Entrada();
            fila[1] = fiOp.getHora();
            fila[2]=fiOp.getTipo();
/////////////////////////////////////            fila[2]=fiOp.getHora_Salida();
            //fila[4] =new JButton("VER");
            //fila[4] = fiOp.getTipo();
            

            datos.add(fila);
        }
    }

    public String getColumnName(int col) {
        return columnas[col].toString();
    } 
    public int getRowCount() { 
        return datos.size(); 
    }
    public int getColumnCount() { 
        return columnas.length; 
    }
    public Object getValueAt(int row, int col) {
        Object[] fila = (Object[]) datos.get(row);
        return fila[col];
    }
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
    public void setValueAt(Object value, int row, int col) {
        Object [] fila = (Object []) datos.get(row);
        fila[col] = value;
        fireTableCellUpdated(row, col);
    }
    public void addRow(Object [] fila) {
        datos.add(fila);
        fireTableDataChanged();
    }
    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
}
