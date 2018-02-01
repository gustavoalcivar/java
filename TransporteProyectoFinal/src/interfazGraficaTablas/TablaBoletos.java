/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TablaClientes.java
 *
 * Created on 06/07/2011, 09:43:26 PM
 */

package interfazGraficaTablas;

import excepciones.FachadaException;
import fachadas.ListadoBoletos;
import interfazGrafica.Menu;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import objetoProyecto.Boleto;

/**
 *
 * @author Gustavo
 */
public class TablaBoletos extends javax.swing.JFrame {
private ListadoBoletos listaBoletos = new ListadoBoletos();
    
    /** Creates new form TablaClientes */
    public TablaBoletos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private class MyTableModel extends AbstractTableModel {

        private boolean DEBUG = true;
        private String[] columnNames = {"Codigo",
            "Cliente",
            "Ruta",
            "Unidad",
            "Fecha",
            "Hora","Asientos normales","Asientos Especiales","Costo",
            "Detalle normales","Detalle especiales"
        };
        private Object[][] data = null;

        public MyTableModel(Object[][] data1) {
            this.data = data1;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public boolean isCellEditable(int fila, int col) {
            return true;
        }

        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBoletos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        listarTodos = new javax.swing.JButton();
        buscaCodigo = new javax.swing.JButton();
        buscaCliente = new javax.swing.JButton();
        buscaUnidad = new javax.swing.JButton();
        buscaFecha = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cooperativa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        aceptar.setText("ACEPTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        tablaBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Ruta", "Unidad", "Fecha", "Hora", "Asientos normales", "Asientos especiales", "Costo", "Detalle normales", "Detalle especiales"
            }
        ));
        tablaBoletos.setEnabled(false);
        tablaBoletos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaBoletos);

        jLabel1.setText("CONSULTA BOLETOS");

        listarTodos.setText("LISTAR TODOS");
        listarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarTodosActionPerformed(evt);
            }
        });

        buscaCodigo.setText("POR CÓDIGO");
        buscaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaCodigoActionPerformed(evt);
            }
        });

        buscaCliente.setText("POR CLIENTE");
        buscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaClienteActionPerformed(evt);
            }
        });

        buscaUnidad.setText("POR UNIDAD");
        buscaUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaUnidadActionPerformed(evt);
            }
        });

        buscaFecha.setText("POR FECHA");
        buscaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaFechaActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(listarTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(buscaCodigo)
                        .addGap(81, 81, 81)
                        .addComponent(buscaCliente)
                        .addGap(75, 75, 75)
                        .addComponent(buscaUnidad)
                        .addGap(38, 38, 38)
                        .addComponent(buscaFecha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(listarTodos)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaFecha)
                    .addComponent(buscaUnidad)
                    .addComponent(buscaCliente)
                    .addComponent(buscaCodigo))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(aceptar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        Menu me=new Menu();
        dispose();
        me.setVisible(true);
    }//GEN-LAST:event_aceptarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formComponentShown

    private void listarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTodosActionPerformed
        // TODO add your handling code here:
        Vector lista = new Vector();
        try {
            lista = listaBoletos.consultaBoleto();
        } catch (FachadaException fe) {
            JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
        }
        Object[][] tabla = new Object[lista.size()][11];
        this.tablaBoletos.removeAll();
        if(!lista.isEmpty()){
        for (int i = 0; i < lista.size(); i++) {
            Boleto c = (Boleto) lista.get(i);
            tabla[i][0] = c.getCodigoBoleto();
            tabla[i][1] = c.getNombreCliente()+" "+c.getApellidoCliente();
            tabla[i][2] = c.getRuta();
            tabla[i][3] = c.getUnidad();
            tabla[i][4] = c.getFecha();
            tabla[i][5] = c.getHora();
            tabla[i][6] = c.getNumAsientosNormales();
            tabla[i][7] = c.getNumAsientosEspeciales();
            tabla[i][8] = c.getCostoTotal();
            tabla[i][9] = c.getDetalleAsientosNormales();
            tabla[i][10] = c.getDetalleAsientosEspeciales();
        }
        this.tablaBoletos.setModel(new MyTableModel(tabla));
        }
 else{
            JOptionPane.showMessageDialog(null, "No se encontraron boletos");
 }
        
    }//GEN-LAST:event_listarTodosActionPerformed

    private void buscaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaCodigoActionPerformed
        // TODO add your handling code here:
        Vector lista = new Vector();
        String busca=JOptionPane.showInputDialog("Ingrese el código del boleto a buscar");
                try {
            lista = listaBoletos.consultaBoletoCodigo(busca);
        } catch (FachadaException fe) {
            JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
        }
        Object[][] tabla = new Object[lista.size()][11];
        this.tablaBoletos.removeAll();
        if(!lista.isEmpty()){
        for (int i = 0; i < lista.size(); i++) {
            Boleto c = (Boleto) lista.get(i);
            tabla[i][0] = c.getCodigoBoleto();
            tabla[i][1] = c.getNombreCliente()+" "+c.getApellidoCliente();
            tabla[i][2] = c.getRuta();
            tabla[i][3] = c.getUnidad();
            tabla[i][4] = c.getFecha();
            tabla[i][5] = c.getHora();
            tabla[i][6] = c.getNumAsientosNormales();
            tabla[i][7] = c.getNumAsientosEspeciales();
            tabla[i][8] = c.getCostoTotal();
            tabla[i][9] = c.getDetalleAsientosNormales();
            tabla[i][10] = c.getDetalleAsientosEspeciales();
        }
        this.tablaBoletos.setModel(new MyTableModel(tabla));
        }
 else{
            JOptionPane.showMessageDialog(null, "No se encontraron boletos");
 }
        
    }//GEN-LAST:event_buscaCodigoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void buscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaClienteActionPerformed
        // TODO add your handling code here:
     Vector lista = new Vector();
        String busca=JOptionPane.showInputDialog("Ingrese la cédula");
                try {
            lista = listaBoletos.consultaBoletoCedulaCliente(busca);
        } catch (FachadaException fe) {
            JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
        }
        Object[][] tabla = new Object[lista.size()][11];
        this.tablaBoletos.removeAll();
        if(!lista.isEmpty()){
        for (int i = 0; i < lista.size(); i++) {
            Boleto c = (Boleto) lista.get(i);
            tabla[i][0] = c.getCodigoBoleto();
            tabla[i][1] = c.getNombreCliente()+" "+c.getApellidoCliente();
            tabla[i][2] = c.getRuta();
            tabla[i][3] = c.getUnidad();
            tabla[i][4] = c.getFecha();
            tabla[i][5] = c.getHora();
            tabla[i][6] = c.getNumAsientosNormales();
            tabla[i][7] = c.getNumAsientosEspeciales();
            tabla[i][8] = c.getCostoTotal();
            tabla[i][9] = c.getDetalleAsientosNormales();
            tabla[i][10] = c.getDetalleAsientosEspeciales();
        }
        this.tablaBoletos.setModel(new MyTableModel(tabla));
        }
 else{
            JOptionPane.showMessageDialog(null, "No se encontraron boletos");
 }
        
    }//GEN-LAST:event_buscaClienteActionPerformed

    private void buscaUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaUnidadActionPerformed
        // TODO add your handling code here:
        Vector lista = new Vector();
        String busca=JOptionPane.showInputDialog("Ingrese el número de unidad");
                try {
            lista = listaBoletos.consultaBoletoCodigoUnidad(busca);
        } catch (FachadaException fe) {
            JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
        }
        Object[][] tabla = new Object[lista.size()][11];
        this.tablaBoletos.removeAll();
        if(!lista.isEmpty()){
        for (int i = 0; i < lista.size(); i++) {
            Boleto c = (Boleto) lista.get(i);
            tabla[i][0] = c.getCodigoBoleto();
            tabla[i][1] = c.getNombreCliente()+" "+c.getApellidoCliente();
            tabla[i][2] = c.getRuta();
            tabla[i][3] = c.getUnidad();
            tabla[i][4] = c.getFecha();
            tabla[i][5] = c.getHora();
            tabla[i][6] = c.getNumAsientosNormales();
            tabla[i][7] = c.getNumAsientosEspeciales();
            tabla[i][8] = c.getCostoTotal();
            tabla[i][9] = c.getDetalleAsientosNormales();
            tabla[i][10] = c.getDetalleAsientosEspeciales();
        }
        this.tablaBoletos.setModel(new MyTableModel(tabla));
        }
 else{
            JOptionPane.showMessageDialog(null, "No se encontraron boletos");
 }
        
        
    }//GEN-LAST:event_buscaUnidadActionPerformed

    private void buscaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaFechaActionPerformed
        // TODO add your handling code here:
        Vector lista = new Vector();
        String fecha=JOptionPane.showInputDialog("Ingrese la fecha del boleto a buscar(dd/mm/aaaa)");

                try {
            lista = listaBoletos.consultaBoletoFecha(fecha);
        } catch (FachadaException fe) {
            JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
        }
        Object[][] tabla = new Object[lista.size()][11];
        this.tablaBoletos.removeAll();
        if(!lista.isEmpty()){
        for (int i = 0; i < lista.size(); i++) {
            Boleto c = (Boleto) lista.get(i);
            tabla[i][0] = c.getCodigoBoleto();
            tabla[i][1] = c.getNombreCliente()+" "+c.getApellidoCliente();
            tabla[i][2] = c.getRuta();
            tabla[i][3] = c.getUnidad();
            tabla[i][4] = c.getFecha();
            tabla[i][5] = c.getHora();
            tabla[i][6] = c.getNumAsientosNormales();
            tabla[i][7] = c.getNumAsientosEspeciales();
            tabla[i][8] = c.getCostoTotal();
            tabla[i][9] = c.getDetalleAsientosNormales();
            tabla[i][10] = c.getDetalleAsientosEspeciales();
        }
        this.tablaBoletos.setModel(new MyTableModel(tabla));
        }
 else{
            JOptionPane.showMessageDialog(null, "No se encontraron boletos");
 }
        
        
    }//GEN-LAST:event_buscaFechaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton buscaCliente;
    private javax.swing.JButton buscaCodigo;
    private javax.swing.JButton buscaFecha;
    private javax.swing.JButton buscaUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarTodos;
    private javax.swing.JTable tablaBoletos;
    // End of variables declaration//GEN-END:variables

}
