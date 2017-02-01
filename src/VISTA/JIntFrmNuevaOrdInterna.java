/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.OrdenBLL;
import BLL.ProyectoBLL;
import BLL.UsuarioBLL;
import ENTIDAD.Articulo;
import ENTIDAD.Cliente;
import ENTIDAD.Componente;
import ENTIDAD.Orden;
import ENTIDAD.Proyecto;
import ENTIDAD.Usuario;

import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Informatica
 */
public class JIntFrmNuevaOrdInterna extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIntFrmNuevaOrdInterna
     */
    public int ud;
    public JIntFrmNuevaOrdInterna() throws SQLException {
        initComponents();
        cargarCBClientes();
        cargarCBProyectos();
    }
   
    
    public double nuevaOrd(Articulo art,boolean palet) {         
        UsuarioBLL usBLL=new UsuarioBLL();
        double entradaOrd=0;
        Usuario us=new Usuario();
        try {
            us = usBLL.obtenerUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        String[] vCliente=jCBClientes.getSelectedItem().toString().split("-");
        ClienteBLL cBLL=new ClienteBLL();        
        Cliente cli=new Cliente();
        cli.setCodigo(vCliente[0]);
        
        String[] vProyecto=jCBProyecto.getSelectedItem().toString().split("-");  
        ProyectoBLL pBLL=new ProyectoBLL();
        Proyecto pro=new Proyecto();
        pro.setNumero(vProyecto[0]);   
        
        
        OrdenBLL ordBLL=new OrdenBLL();
        Orden ord=new Orden();
        ord.setEntrada(-1);
        ord.setSerOrden("I");
        ord.setEstado("Y");
        ord.setTipo("I");
        ord.setAlmacen("013");
        
       // Articulo art=new Articulo();
        //art.setCodigo(articulo);
        
        ord.setArticulo(art);
        String unid= JOptionPane.showInputDialog("UNIDADES: ");
        ud=Integer.parseInt(unid);
        ord.setUnidades(ud);    
        String respuestaOrden="";
        String[] respuestaSeparada = null;
        
       
        try {
            try {       
              
                respuestaOrden = ordBLL.nuevaOrden(ord,us,cli,pro);
                respuestaSeparada=respuestaOrden.split("\\|");   
                entradaOrd=Double.parseDouble(respuestaSeparada[1]);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(palet==false){     
                JOptionPane.showMessageDialog(null,"Numero:"+respuestaSeparada[2], "Orden Creada", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entradaOrd;
    }
    public void nuevaLineaOrd(Articulo art,Double entradaOrd,int ud) {
        UsuarioBLL usBLL=new UsuarioBLL();
        
        Usuario us=new Usuario();
        try {
            us = usBLL.obtenerUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         String[] vCliente=jCBClientes.getSelectedItem().toString().split("-");
        ClienteBLL cBLL=new ClienteBLL();        
        Cliente cli=new Cliente();
        cli.setCodigo(vCliente[0]);
        
        String[] vProyecto=jCBProyecto.getSelectedItem().toString().split("-");  
        ProyectoBLL pBLL=new ProyectoBLL();
        Proyecto pro=new Proyecto();
        pro.setNumero(vProyecto[0]);   
        
        
        OrdenBLL ordBLL=new OrdenBLL();
        Orden ord=new Orden();
        ord.setEntrada(entradaOrd);
        ord.setSerOrden("I");
        ord.setEstado("Y");
        ord.setTipo("I");
        ord.setAlmacen("013");
        
       
     
        ord.setArticulo(art);
        
        ord.setUnidades(ud);    
        String respuestaOrden="";
        String[] respuestaSeparada = null;
        try {
            try {       
              
                respuestaOrden = ordBLL.nuevaOrden(ord,us,cli,pro);
                respuestaSeparada=respuestaOrden.split("\\|");  
              
               
            } catch (InterruptedException ex) {
                Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
            JOptionPane.showMessageDialog(null,"Numero:"+respuestaSeparada[2], "Orden Creada", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanelCabecera = new javax.swing.JPanel();
        jCBProyecto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTabbedOrdenesInternas = new javax.swing.JTabbedPane();
        jPanelMarcos = new javax.swing.JPanel();
        jButton07770 = new javax.swing.JButton();
        jButton07771 = new javax.swing.JButton();
        jButton10358 = new javax.swing.JButton();
        jButton07772 = new javax.swing.JButton();
        jPanelPaneles = new javax.swing.JPanel();
        jButton07464 = new javax.swing.JButton();
        jButton07460 = new javax.swing.JButton();
        jButton07466 = new javax.swing.JButton();
        jButton07465 = new javax.swing.JButton();
        jButton07469 = new javax.swing.JButton();
        jButton07467 = new javax.swing.JButton();
        jButton07468 = new javax.swing.JButton();
        jButton07474 = new javax.swing.JButton();
        jButton07607 = new javax.swing.JButton();
        jButton07608 = new javax.swing.JButton();
        jButton10013 = new javax.swing.JButton();
        jButton10014 = new javax.swing.JButton();
        jButton10015 = new javax.swing.JButton();
        javax.swing.JButton jButton07470 = new javax.swing.JButton();
        jButton07471 = new javax.swing.JButton();
        jPanelMotores = new javax.swing.JPanel();
        jButton07420 = new javax.swing.JButton();
        jButton07524 = new javax.swing.JButton();
        jButton07450 = new javax.swing.JButton();
        jButton07451 = new javax.swing.JButton();
        jButton07581 = new javax.swing.JButton();
        jButton07678 = new javax.swing.JButton();
        jButton07582 = new javax.swing.JButton();
        jButton07679 = new javax.swing.JButton();
        jButton07386 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton07911 = new javax.swing.JButton();
        jPanelTuria = new javax.swing.JPanel();
        jButton08256 = new javax.swing.JButton();
        jPanelPaletsParis = new javax.swing.JPanel();
        jCBArticulos = new javax.swing.JComboBox<>();
        jCBClientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCrearPalet = new javax.swing.JButton();
        jCBMandos = new javax.swing.JComboBox<>();
        jCBTeclados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlblAviso = new javax.swing.JLabel();
        jCBMotor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel5.setText("Proyecto");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(832, Short.MAX_VALUE))
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedOrdenesInternas.setToolTipText("");
        jTabbedOrdenesInternas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedOrdenesInternas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton07770.setText("CONJUNTO MARCOS LATERALES PARIS 2400");
        jButton07770.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07770ActionPerformed(evt);
            }
        });

        jButton07771.setText("CONJUNTO MARCOS SUPERIOR PARIS 2400");
        jButton07771.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07771ActionPerformed(evt);
            }
        });

        jButton10358.setText("CONJUNTO MARCOS LATERALES PARIS 3000");
        jButton10358.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10358ActionPerformed(evt);
            }
        });

        jButton07772.setText("CONJUNTO MARCOS SUPERIOR PARIS 3000");
        jButton07772.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07772ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMarcosLayout = new javax.swing.GroupLayout(jPanelMarcos);
        jPanelMarcos.setLayout(jPanelMarcosLayout);
        jPanelMarcosLayout.setHorizontalGroup(
            jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMarcosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton07770, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jButton10358, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton07771, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07772, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMarcosLayout.setVerticalGroup(
            jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMarcosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07770, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07771, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelMarcosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10358, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07772, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(430, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.addTab("MARCOS", jPanelMarcos);

        jButton07464.setText("CONJ.PANELES SL_W_9010");
        jButton07464.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07464ActionPerformed(evt);
            }
        });

        jButton07460.setText("CONJ.PANELES SL_W_7016");
        jButton07460.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07460ActionPerformed(evt);
            }
        });

        jButton07466.setText("CONJ.PANELES CU_W_9010");
        jButton07466.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07466ActionPerformed(evt);
            }
        });

        jButton07465.setText("CONJ.PANELES CU_W_7016");
        jButton07465.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07465ActionPerformed(evt);
            }
        });

        jButton07469.setText("CONJ.PANELES CU_W_9010_3000");
        jButton07469.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07469ActionPerformed(evt);
            }
        });

        jButton07467.setText("CONJ.PANELES 1S_L_MADERA_CLARA");
        jButton07467.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07467ActionPerformed(evt);
            }
        });

        jButton07468.setText("CONJ.PANELES CU_W_G_9010");
        jButton07468.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07468ActionPerformed(evt);
            }
        });

        jButton07474.setText("CONJ.PANELES 1S_W_9010");
        jButton07474.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07474ActionPerformed(evt);
            }
        });

        jButton07607.setText("CONJ.PANELES SL_L_9016P-HIV");
        jButton07607.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07607ActionPerformed(evt);
            }
        });

        jButton07608.setText("CONJ.PANELES SL_L_7016P-HIV");
        jButton07608.setToolTipText("");
        jButton07608.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07608ActionPerformed(evt);
            }
        });

        jButton10013.setText("CONJ.PANELES CU_W_7016_3000");
        jButton10013.setToolTipText("");
        jButton10013.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10013ActionPerformed(evt);
            }
        });

        jButton10014.setText("CONJ.PANELES CU_W_MC");
        jButton10014.setToolTipText("");
        jButton10014.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10014ActionPerformed(evt);
            }
        });

        jButton10015.setText("CONJ.PANELES CU_W_MC_3000");
        jButton10015.setToolTipText("");
        jButton10015.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10015ActionPerformed(evt);
            }
        });

        jButton07470.setText("CONJ.PANELES CU_W_H_9010");
        jButton07470.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07470ActionPerformed(evt);
            }
        });

        jButton07471.setText("CONJ.PANELES CU_W_H_7016");
        jButton07471.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07471ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPanelesLayout = new javax.swing.GroupLayout(jPanelPaneles);
        jPanelPaneles.setLayout(jPanelPanelesLayout);
        jPanelPanelesLayout.setHorizontalGroup(
            jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelesLayout.createSequentialGroup()
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPanelesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton07607, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton07460, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton07464, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelPanelesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton07608)))
                .addGap(31, 31, 31)
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton07471)
                    .addComponent(jButton07470)
                    .addGroup(jPanelPanelesLayout.createSequentialGroup()
                        .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton07466, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton07465, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton07468, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton07474, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton07467))
                        .addGap(50, 50, 50)
                        .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10014)
                            .addComponent(jButton10013)
                            .addComponent(jButton10015)))
                    .addComponent(jButton07469))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPanelesLayout.setVerticalGroup(
            jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07464, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07466, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07474, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10013, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07460, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07465, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07467, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10014, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07468, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07607, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10015, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07469, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07608, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton07470, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton07471, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.addTab("PANELES PARIS", jPanelPaneles);

        jButton07420.setText("MOTOR ET 600L(PARIS) 1 MANDO");
        jButton07420.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07420ActionPerformed(evt);
            }
        });

        jButton07524.setText("MOTOR ET 600 L  PARIS 2 EMISORES");
        jButton07524.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07524ActionPerformed(evt);
            }
        });

        jButton07450.setText("MOTOR ET 600L(PARIS) 1 MANDO 1 TECLADO");
        jButton07450.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07450ActionPerformed(evt);
            }
        });

        jButton07451.setText("MOTOR ET 600L(PARIS)  2 MANDOS 1 TECLADO");
        jButton07451.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07451ActionPerformed(evt);
            }
        });

        jButton07581.setText("MOTOR ET 600 E 2 EMISORES");
        jButton07581.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07581ActionPerformed(evt);
            }
        });

        jButton07678.setText("MOTOR ET 600 E 3 EMISORES");
        jButton07678.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07678ActionPerformed(evt);
            }
        });

        jButton07582.setText("MOTOR ET 1000E 2 EMISORES");
        jButton07582.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07582ActionPerformed(evt);
            }
        });

        jButton07679.setText("MOTOR ET 1000E 3 EMISORES");
        jButton07679.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07679ActionPerformed(evt);
            }
        });

        jButton07386.setText("DESPIEZE MOTOR ET 600 L (MOTOR)");
        jButton07386.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07386ActionPerformed(evt);
            }
        });

        jButton07911.setText("REVISAR MOTOR ET600L (TURIA SUELTO)");
        jButton07911.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07911ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMotoresLayout = new javax.swing.GroupLayout(jPanelMotores);
        jPanelMotores.setLayout(jPanelMotoresLayout);
        jPanelMotoresLayout.setHorizontalGroup(
            jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoresLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton07450, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton07420, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton07524, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton07386, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07451, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMotoresLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelMotoresLayout.createSequentialGroup()
                                .addComponent(jButton07678, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jButton07679, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMotoresLayout.createSequentialGroup()
                                .addComponent(jButton07581, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton07582, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMotoresLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton07911, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelMotoresLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanelMotoresLayout.setVerticalGroup(
            jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoresLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton07581, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07524, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07582, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07420, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07678, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07679, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton07450, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton07451, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanelMotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton07386, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton07911, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.addTab("MOTORES", jPanelMotores);

        jButton08256.setText("CAJA AZUL");
        jButton08256.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton08256ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTuriaLayout = new javax.swing.GroupLayout(jPanelTuria);
        jPanelTuria.setLayout(jPanelTuriaLayout);
        jPanelTuriaLayout.setHorizontalGroup(
            jPanelTuriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTuriaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton08256, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTuriaLayout.setVerticalGroup(
            jPanelTuriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTuriaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton08256, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.addTab("TURIA", jPanelTuria);

        jCBArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBArticulosActionPerformed(evt);
            }
        });

        jCBClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBClientesItemStateChanged(evt);
            }
        });
        jCBClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClientesActionPerformed(evt);
            }
        });

        jLabel1.setText("Modelo palet");

        jLabel2.setText("Cliente");

        btnCrearPalet.setText("ACEPTAR");
        btnCrearPalet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPaletActionPerformed(evt);
            }
        });

        jCBMandos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jCBTeclados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));

        jLabel3.setText("Mandos");

        jLabel4.setText("Teclados");

        jlblAviso.setText(".");

        jCBMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ET", "LIFE" }));

        jLabel6.setText("Motor");

        javax.swing.GroupLayout jPanelPaletsParisLayout = new javax.swing.GroupLayout(jPanelPaletsParis);
        jPanelPaletsParis.setLayout(jPanelPaletsParisLayout);
        jPanelPaletsParisLayout.setHorizontalGroup(
            jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaletsParisLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPaletsParisLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPaletsParisLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jlblAviso))
                    .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCBTeclados, javax.swing.GroupLayout.Alignment.LEADING, 0, 44, Short.MAX_VALUE)
                        .addComponent(jCBMandos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCBMotor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearPalet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanelPaletsParisLayout.setVerticalGroup(
            jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaletsParisLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCBMandos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPaletsParisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTeclados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnCrearPalet)
                .addGap(197, 197, 197)
                .addComponent(jlblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedOrdenesInternas.addTab("PALETS PARIS", jPanelPaletsParis);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedOrdenesInternas, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(106, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jTabbedOrdenesInternas, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jPanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(600, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton07608ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07608ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07608");
        nuevaOrd(art,false);
    }//GEN-LAST:event_jButton07608ActionPerformed

    private void jButton07607ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07607ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07607");
        nuevaOrd(art,false);
    }//GEN-LAST:event_jButton07607ActionPerformed

    private void jButton07474ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07474ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07474");
        nuevaOrd(art,false);        
    }//GEN-LAST:event_jButton07474ActionPerformed

    private void jButton07468ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07468ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07468");
        nuevaOrd(art,false);        
    }//GEN-LAST:event_jButton07468ActionPerformed

    private void jButton07467ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07467ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07467");
        nuevaOrd(art,false);          
    }//GEN-LAST:event_jButton07467ActionPerformed

    private void jButton07469ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07469ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07469");
        nuevaOrd(art,false);         
    }//GEN-LAST:event_jButton07469ActionPerformed

    private void jButton07465ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07465ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07465");
        nuevaOrd(art,false);     
    }//GEN-LAST:event_jButton07465ActionPerformed

    private void jButton07466ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07466ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07466");
        nuevaOrd(art,false);      
    }//GEN-LAST:event_jButton07466ActionPerformed

    private void jButton07460ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07460ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07460");
        nuevaOrd(art,false);     
    }//GEN-LAST:event_jButton07460ActionPerformed

    private void jButton07464ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07464ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07464");
        nuevaOrd(art,false); 
    }//GEN-LAST:event_jButton07464ActionPerformed

    private void jButton07386ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07386ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07386");
        nuevaOrd(art,false);         
    }//GEN-LAST:event_jButton07386ActionPerformed

    private void jButton07679ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07679ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07679");
        nuevaOrd(art,false);
        
    }//GEN-LAST:event_jButton07679ActionPerformed

    private void jButton07582ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07582ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07582");
        nuevaOrd(art,false); 
        
    }//GEN-LAST:event_jButton07582ActionPerformed

    private void jButton07678ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07678ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07678");
        nuevaOrd(art,false); 
       
    }//GEN-LAST:event_jButton07678ActionPerformed

    private void jButton07581ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07581ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07581");
        nuevaOrd(art,false); 
        
    }//GEN-LAST:event_jButton07581ActionPerformed

    private void jButton07451ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07451ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07451");
        nuevaOrd(art,false); 

    }//GEN-LAST:event_jButton07451ActionPerformed

    private void jButton07450ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07450ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07450");
        nuevaOrd(art,false);
    }//GEN-LAST:event_jButton07450ActionPerformed

    private void jButton07524ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07524ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07524");
        nuevaOrd(art,false); 
    }//GEN-LAST:event_jButton07524ActionPerformed

    private void jButton07420ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07420ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07420");
        nuevaOrd(art,false); 
    }//GEN-LAST:event_jButton07420ActionPerformed

    private void jButton07771ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07771ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07771");
        nuevaOrd(art,false); 

    }//GEN-LAST:event_jButton07771ActionPerformed

    private void jButton07770ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07770ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07770");
        nuevaOrd(art,false); 
  
    }//GEN-LAST:event_jButton07770ActionPerformed

    private void jButton10013ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10013ActionPerformed
         Articulo art=new Articulo();
        art.setCodigo("10013");
        nuevaOrd(art,false); 

    }//GEN-LAST:event_jButton10013ActionPerformed

    private void jButton10014ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10014ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("10014");
        nuevaOrd(art,false);
    }//GEN-LAST:event_jButton10014ActionPerformed

    private void jButton10015ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10015ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("10015");
        nuevaOrd(art,false);       
    }//GEN-LAST:event_jButton10015ActionPerformed

    private void jButton07911ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07911ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07911");
        nuevaOrd(art,false); 
    }//GEN-LAST:event_jButton07911ActionPerformed

    private void jCBClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClientesActionPerformed
       Cliente cli=new Cliente();
        String cliente=(String)jCBClientes.getSelectedItem();
        String[] vCliente;
        vCliente=cliente.split("-");
        cli.setCodigo(vCliente[0]);       
        Articulo art=new Articulo();
        art.setFamilia("1102");     
        try {
            cargarCBArticulos(art,cli);
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jCBClientesActionPerformed

    private void jCBClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBClientesItemStateChanged
 
    }//GEN-LAST:event_jCBClientesItemStateChanged

    private void jCBArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBArticulosActionPerformed
             

        
    }//GEN-LAST:event_jCBArticulosActionPerformed

    private void btnCrearPaletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPaletActionPerformed
        double entradaOrd;
        String[] vArticulo=jCBArticulos.getSelectedItem().toString().split("-");
        ArticuloBLL aBLL=new ArticuloBLL();
        Articulo art=new Articulo();
        art.setCodigo(vArticulo[1]);
        
        String[] vCliente=jCBClientes.getSelectedItem().toString().split("-");
        ClienteBLL cBLL=new ClienteBLL();        
        Cliente cli=new Cliente();
        cli.setCodigo(vCliente[0]);
        
        
        String variables="\\\\[MOTOR]:"+jCBMotor.getSelectedItem().toString();        
        art.setVariables(variables);
                  
        String accesorios;
        accesorios="[N_MANDOS]="+jCBMandos.getSelectedItem().toString()+";[N_TECLADOS]="+jCBTeclados.getSelectedItem().toString()+";[PARISWEB]=NO";
        
        System.out.println(art.getCodigo());
        ArrayList<Componente> componentes = null;
        try {
            componentes=aBLL.listaComponentes(art);
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        entradaOrd=nuevaOrd(art,true);
        int unidades; //Unidades del componente que añadiremos en la nueva linea de la orden
        Iterator it=componentes.iterator();
        
        
        while(it.hasNext()){
            Componente c=((Componente)it.next());
            art.setCodigo(c.getComponente());
            unidades=c.getUdComponente()*ud;
            
            try {
                art=aBLL.obtenerAlias(art,cli,accesorios);
                if(art.getAlias()==null){
                    JOptionPane.showMessageDialog(this,"Alias no encontrado, la orden se creara sin alias, reviselo", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIntFrmNuevaOrdInterna.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            nuevaLineaOrd(art,entradaOrd,unidades);                       
        }
    }//GEN-LAST:event_btnCrearPaletActionPerformed

    private void jButton07470ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07470ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07470");
        nuevaOrd(art,false);
        
    }//GEN-LAST:event_jButton07470ActionPerformed

    private void jButton07471ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07471ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07471");
        nuevaOrd(art,false);        
    }//GEN-LAST:event_jButton07471ActionPerformed

    private void jButton10358ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10358ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("10358");
        nuevaOrd(art,false);   
    }//GEN-LAST:event_jButton10358ActionPerformed

    private void jButton07772ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07772ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("07772");
        nuevaOrd(art,false);      
    }//GEN-LAST:event_jButton07772ActionPerformed

    private void jButton08256ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton08256ActionPerformed
        Articulo art=new Articulo();
        art.setCodigo("08256");
        nuevaOrd(art,false);       
    }//GEN-LAST:event_jButton08256ActionPerformed

    public void cargarCBClientes() throws SQLException{
        ClienteBLL cBLL=new ClienteBLL();
        jCBClientes.removeAllItems();
        ArrayList <Cliente> clientes;
        clientes=cBLL.listaClientes();
        Iterator it=clientes.iterator();
        while(it.hasNext()){
            Cliente c=((Cliente)it.next());
            jCBClientes.addItem(c.toString());
        }
       
    }
    
    public void cargarCBArticulos(Articulo art,Cliente cli) throws SQLException{ //Requiere familia
        ArticuloBLL aBLL=new ArticuloBLL();
        jCBArticulos.removeAllItems();
        ArrayList<Articulo> articulos;
        articulos=aBLL.listaArticulos(art, cli);
        Iterator it=articulos.iterator();
        while(it.hasNext()){
            Articulo a=((Articulo)it.next());
            jCBArticulos.addItem(a.toString());
        }
        
    }
    
    public void cargarCBProyectos() throws SQLException{
        ProyectoBLL pBLL=new ProyectoBLL();
        jCBProyecto.removeAllItems();
        ArrayList<Proyecto> proyectos;
        proyectos=pBLL.listaProyectos();
        Iterator it=proyectos.iterator();
        while(it.hasNext()){
            Proyecto p=((Proyecto)it.next());
            jCBProyecto.addItem(p.toString());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPalet;
    private javax.swing.JButton jButton07386;
    private javax.swing.JButton jButton07420;
    private javax.swing.JButton jButton07450;
    private javax.swing.JButton jButton07451;
    private javax.swing.JButton jButton07460;
    private javax.swing.JButton jButton07464;
    private javax.swing.JButton jButton07465;
    private javax.swing.JButton jButton07466;
    private javax.swing.JButton jButton07467;
    private javax.swing.JButton jButton07468;
    private javax.swing.JButton jButton07469;
    private javax.swing.JButton jButton07471;
    private javax.swing.JButton jButton07474;
    private javax.swing.JButton jButton07524;
    private javax.swing.JButton jButton07581;
    private javax.swing.JButton jButton07582;
    private javax.swing.JButton jButton07607;
    private javax.swing.JButton jButton07608;
    private javax.swing.JButton jButton07678;
    private javax.swing.JButton jButton07679;
    private javax.swing.JButton jButton07770;
    private javax.swing.JButton jButton07771;
    private javax.swing.JButton jButton07772;
    private javax.swing.JButton jButton07911;
    private javax.swing.JButton jButton08256;
    private javax.swing.JButton jButton10013;
    private javax.swing.JButton jButton10014;
    private javax.swing.JButton jButton10015;
    private javax.swing.JButton jButton10358;
    private javax.swing.JComboBox<String> jCBArticulos;
    private javax.swing.JComboBox<String> jCBClientes;
    private javax.swing.JComboBox<String> jCBMandos;
    private javax.swing.JComboBox<String> jCBMotor;
    private javax.swing.JComboBox<String> jCBProyecto;
    private javax.swing.JComboBox<String> jCBTeclados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelMarcos;
    private javax.swing.JPanel jPanelMotores;
    private javax.swing.JPanel jPanelPaletsParis;
    private javax.swing.JPanel jPanelPaneles;
    private javax.swing.JPanel jPanelTuria;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedOrdenesInternas;
    private javax.swing.JLabel jlblAviso;
    // End of variables declaration//GEN-END:variables
}
