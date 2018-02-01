/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificarUnidades.java
 *
 * Created on 09/07/2011, 10:23:53 PM
 */

package interfazGraficaModificar;

import excepciones.FachadaException;
import fachadas.ListadoRutas;
import fachadas.ListadoUnidades;
import interfazGraficaAgregar.AgregarRutas;
import java.util.Vector;
import javax.swing.JOptionPane;
import objetoProyecto.Unidad;
import objetoServicio.NumeroInt;

/**
 *
 * @author Gustavo
 */
public class ModificarUnidades extends javax.swing.JFrame {

    /** Creates new form ModificarUnidades */
    public ModificarUnidades() {
        initComponents();
        setLocationRelativeTo(null);
    }
private ListadoUnidades listaUnidades = new ListadoUnidades();
private ListadoRutas listaRutas = new ListadoRutas();
    private Unidad buscado;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigo = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        capacidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ayudante = new javax.swing.JTextField();
        chofer = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cooperativa");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("MODIFICAR UNIDADES");

        jLabel2.setText("Código:");

        jLabel3.setText("Matricula:");

        jLabel4.setText("Capacidad:");

        matricula.setEnabled(false);

        jLabel5.setText("Chofer:");

        capacidad.setEnabled(false);
        capacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacidadKeyTyped(evt);
            }
        });

        jLabel6.setText("Ayudante:");

        ayudante.setEnabled(false);

        chofer.setEnabled(false);

        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(125, 125, 125)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(115, 115, 115)
                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(108, 108, 108)
                        .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(125, 125, 125)
                        .addComponent(chofer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modificar)
                                .addGap(60, 60, 60)
                                .addComponent(limpiar)
                                .addGap(51, 51, 51)
                                .addComponent(cancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(111, 111, 111)
                                .addComponent(ayudante, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(chofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(ayudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(limpiar)
                    .addComponent(modificar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_codigoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        AgregarRutas me=new AgregarRutas();
        dispose();
        me.setVisible(true);
}//GEN-LAST:event_cancelarActionPerformed

    private void capacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacidadKeyTyped
        // TODO add your handling code here:
        NumeroInt.Validar(evt);
        NumeroInt.numeroCaracteres(capacidad, 2, evt);
}//GEN-LAST:event_capacidadKeyTyped

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        matricula.setText("");
        chofer.setText("");
        ayudante.setText("");
        capacidad.setText("");
}//GEN-LAST:event_limpiarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        matricula.setText("");
        chofer.setText("");
        ayudante.setText("");
        capacidad.setText("");
        buscado=null;
        if(!codigo.getText().equals("")){
            Unidad unidad=new Unidad();
            unidad.setCodigoUnidad(codigo.getText());
            try{
                buscado=listaUnidades.obten(unidad);
            }catch(FachadaException fe){
                JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
            }
            if(buscado!=null){
                matricula.setText(buscado.getMatricula());
                capacidad.setText(String.valueOf(buscado.getCapacidadUnidad()));
                chofer.setText(buscado.getChofer());
                ayudante.setText(buscado.getAyudante());

                matricula.setEnabled(true);
                capacidad.setEnabled(true);
                chofer.setEnabled(true);
                ayudante.setEnabled(true);
            }
 else{
                JOptionPane.showMessageDialog(null,"La unidad no existe");
                matricula.setEnabled(false);
                capacidad.setEnabled(false);
                chofer.setEnabled(false);
                ayudante.setEnabled(false);
 }
        }
 else{
            JOptionPane.showMessageDialog(null,"Ingrese el código de la unidad");
 }
    }//GEN-LAST:event_buscarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        if(codigo.getText().equals("")||matricula.getText().equals("")||
                capacidad.getText().equals("")||chofer.getText().equals("")
                ||ayudante.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos" );
            }else{
        if(buscado!=null){
            buscado.setAyudante(ayudante.getText());
            buscado.setCapacidadUnidad(Integer.parseInt(capacidad.getText()));
            buscado.setDisponibles(Integer.parseInt(capacidad.getText()));
            buscado.setChofer(chofer.getText());
            buscado.setCodigoUnidad(codigo.getText());
            buscado.setMatricula(matricula.getText());
            Vector lista=new Vector();
                try{
                lista=listaRutas.consultaUnidadRuta(buscado.getCodigoUnidad());
                }catch(FachadaException fe){
                    JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
                }
            if(lista.isEmpty()){
            try {
                listaUnidades.actualiza(buscado);
                JOptionPane.showMessageDialog(null,"Unidad modificada con éxito");
                AgregarRutas me=new AgregarRutas();
        dispose();
        me.setVisible(true);
            } catch (FachadaException fe) {
                JOptionPane.showMessageDialog(null,"Error: " + fe.getMessage());
            }
            }
            else{
                    JOptionPane.showMessageDialog(null, "Error: La unidad está siendo utilizada en una ruta");
 }
        }
        else{
            JOptionPane.showMessageDialog(null,"No se encotró la unidad");
         }
        }
    }//GEN-LAST:event_modificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ayudante;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField capacidad;
    private javax.swing.JTextField chofer;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField matricula;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables

}