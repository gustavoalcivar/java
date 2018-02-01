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

import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class EscalarVector extends javax.swing.JFrame {

    /** Creates new form EscalarVector */
    public EscalarVector() {
        initComponents();
        setLocationRelativeTo(null);
    }
    double escalar,vector[],resultado[];
    int tam=-1;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textEscalar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textVector = new javax.swing.JTextArea();
        botonCalcular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textResultado = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        botonLeerArchivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Multiplicación de un escalar por un vector");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Escalar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));

        jLabel2.setText("Vector:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));
        getContentPane().add(textEscalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 55, -1));

        jLabel3.setText("Ingrese los elementos del vector en una sola linea y separados por espacios; o genere un vector aleatorio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, 830, -1));

        botonGenerar.setText("Generar vector aleatorio");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, 234, -1));

        textVector.setColumns(20);
        textVector.setRows(5);
        jScrollPane1.setViewportView(textVector);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 582, 50));

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 233, -1, -1));

        textResultado.setColumns(20);
        textResultado.setEditable(false);
        textResultado.setRows(5);
        jScrollPane2.setViewportView(textResultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 592, 52));

        jLabel4.setText("Resultado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, -1, -1));

        botonLeerArchivo.setText("Leer datos del archivo");
        botonLeerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLeerArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(botonLeerArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 233, -1, -1));

        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
    try{
        escalar=Double.parseDouble(textEscalar.getText());
        String n;
        n=JOptionPane.showInputDialog(null,"Ingrese el tamaño del vector","",3);
        try{
            tam=Integer.parseInt(n);
        }catch(Exception ex){
            Metodos.error(ex);
        }
    }catch(Exception ex){
        Metodos.error(ex);
    }
    if(tam>=1){
        vector=new double[tam];
        vector=Metodos.llenarVectorAleatorio(tam);
        Metodos.imprimirVector(vector,textVector);
        resultado=Metodos.escalarVector(escalar,vector);
        Metodos.imprimirVector(resultado,textResultado);
    }
}//GEN-LAST:event_botonGenerarActionPerformed

private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
    Metodos.validarTextArea(textVector);
    String texto=textVector.getText();
    if(Metodos.validarVector(texto)&&textVector.getLineCount()==1){
        try{
            escalar=Double.parseDouble(textEscalar.getText());
            vector=Metodos.leerVector(texto);
            resultado=Metodos.escalarVector(escalar,vector);
            Metodos.imprimirVector(resultado,textResultado);
        }catch(Exception ex){
            Metodos.error(ex);
        }
    }else Metodos.error("El dato ingresado no corresponde a un vector");
}//GEN-LAST:event_botonCalcularActionPerformed

    private void botonLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLeerArchivoActionPerformed
    if(Inicio.vecArchivo!=null){
        try{
        escalar=Double.parseDouble(textEscalar.getText());
        String n;
        n=JOptionPane.showInputDialog(null,"Ingrese el tamaño del vector","",3);
        try{
            tam=Integer.parseInt(n);
        }catch(Exception ex){
            Metodos.error(ex);
        }
    }catch(Exception ex){
        Metodos.error(ex);
    }
    if(tam>=1){
        vector=new double[tam];
        vector=Metodos.llenarVectorArchivo(tam);
        Metodos.imprimirVector(vector,textVector);
        resultado=Metodos.escalarVector(escalar,vector);
        Metodos.imprimirVector(resultado,textResultado);
    }
    }else Metodos.errorArchivo();
    }//GEN-LAST:event_botonLeerArchivoActionPerformed

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
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonLeerArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField textEscalar;
    private javax.swing.JTextArea textResultado;
    private javax.swing.JTextArea textVector;
    // End of variables declaration//GEN-END:variables

}