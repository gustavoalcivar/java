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
public class Base2ABase10 extends javax.swing.JFrame {

    /** Creates new form EscalarVector */
    public Base2ABase10() {
        initComponents();
        setLocationRelativeTo(null);
    }
    int binario[],resultado;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        botonCalcular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textBinario = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        textResultado = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transformar un número binario a decimal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Binario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, -1, -1));

        jLabel4.setText("Resultado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        textBinario.setColumns(20);
        textBinario.setRows(5);
        jScrollPane3.setViewportView(textBinario);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 521, 50));

        textResultado.setEditable(false);
        textResultado.setColumns(20);
        textResultado.setRows(5);
        jScrollPane7.setViewportView(textResultado);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 465, 52));

        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
    Metodos.validarTextArea(textBinario);
    String texto=textBinario.getText();
    try{
        binario=Metodos.leerVectorEntero(texto);
        binario=Metodos.invertirVector(binario);
        if(Metodos.esBinario(binario)&&textBinario.getLineCount()==1){
            resultado=Metodos.horner(binario,2);
            textResultado.setText("");
            textResultado.append(String.valueOf(resultado));
        }else Metodos.error("Es posible que el número ingresado no sea binario");
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea textBinario;
    private javax.swing.JTextArea textResultado;
    // End of variables declaration//GEN-END:variables

}
