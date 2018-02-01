/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EscalarVector.java
 *
 * Created on 19/04/2013, 11:29:18 AM
 */
package analisisNumerico;

/**
 *
 * @author gustavo
 */
public class Base10ABaseX extends javax.swing.JFrame {

    /** Creates new form EscalarVector */
    public Base10ABaseX() {
        initComponents();
        setLocationRelativeTo(null);
    }
    int decimal,baseX,resultado[];
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDecimal = new javax.swing.JTextArea();
        botonCalcular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textResultado = new javax.swing.JTextArea();
        textBaseX = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transformar un número decimal a base X (2<=x<=16)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Decimal:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        textDecimal.setColumns(20);
        textDecimal.setRows(5);
        jScrollPane1.setViewportView(textDecimal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 497, 50));

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel4.setText("Resultado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel5.setText("Base destino:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, -1, -1));

        textResultado.setColumns(20);
        textResultado.setEditable(false);
        textResultado.setRows(5);
        jScrollPane7.setViewportView(textResultado);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 216, 441, 52));

        textBaseX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
        getContentPane().add(textBaseX, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 131, 110, -1));

        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
    Metodos.validarTextArea(textDecimal);
    String texto1=textDecimal.getText();
    try{
        decimal=Integer.parseInt(texto1);
        baseX=textBaseX.getSelectedIndex()+2;
        if(textDecimal.getLineCount()==1){
            resultado=Metodos.decimalABaseX(decimal,baseX);
            Metodos.imprimirExadecimal(resultado,textResultado);
        }else Metodos.error("El dato ingresado no corresponde a un vector");
    }catch(Exception ex){
        Metodos.error(ex);
    }
}//GEN-LAST:event_botonCalcularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Inicio rr = new Inicio();
        rr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JComboBox textBaseX;
    private javax.swing.JTextArea textDecimal;
    private javax.swing.JTextArea textResultado;
    // End of variables declaration//GEN-END:variables

}