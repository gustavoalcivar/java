/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AsignacionTareas extends javax.swing.JFrame {
    
    private int costes[][], asignacion[][];

    public AsignacionTareas() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textCostes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSolucion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textSolucion2 = new javax.swing.JTextArea();
        comboTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASIGNACIÓN DE TAREAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASIGNACION DE TAREAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 692, -1));

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, -1, -1));

        textCostes.setBackground(new java.awt.Color(102, 102, 102));
        textCostes.setColumns(20);
        textCostes.setForeground(new java.awt.Color(255, 255, 255));
        textCostes.setRows(5);
        jScrollPane1.setViewportView(textCostes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 544, 137));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la matriz de costes separando los elementos con espacios y saltos de linea:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, -1, -1));

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solución:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        textSolucion.setEditable(false);
        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane3.setViewportView(textSolucion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 615, 130));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trabajador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tarea");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        textSolucion2.setEditable(false);
        textSolucion2.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion2.setColumns(20);
        textSolucion2.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion2.setRows(5);
        jScrollPane4.setViewportView(textSolucion2);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 392, 123));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asignar el mejor trabajador a la mejor tarea", "Asignar la mejor  tarea al mejor trabajador" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 470, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
Metodos.validarTextArea(textCostes);
        try{
            if(algoritmos.Metodos.validarMatriz(textCostes)){
                costes = algoritmos.Metodos.leerMatriz(textCostes);
                int costeTotal = 0;
                if(textCostes.getLineCount() == Metodos.contarColumnas(textCostes)) {
                    if(comboTipo.getSelectedIndex() == 0) {
                        asignacion = algoritmos.Algoritmos.asignacionTareas1(costes, textCostes.getLineCount());
                    } else {
                        asignacion = algoritmos.Algoritmos.asignacionTareas2(costes, textCostes.getLineCount());
                    }
                    textSolucion.setText("");
                    textSolucion2.setText("");
                    
                    algoritmos.Metodos.imprimirMatriz(asignacion, textCostes.getLineCount(), textCostes.getLineCount(), textSolucion);
                    for(int i = 0; i < textCostes.getLineCount(); i++) {
                        for(int j = 0; j < textCostes.getLineCount(); j++) {
                            if(asignacion[i][j] == 1){
                                costeTotal += costes[i][j];
                                textSolucion2.append("Al trabajador "+(i+1)+" se le asigna la tarea "+(j+1)+"\n");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
                }
               textSolucion2.append("\nEl coste total es: "+costeTotal); 
            } else {
                JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea textCostes;
    private javax.swing.JTextArea textSolucion;
    private javax.swing.JTextArea textSolucion2;
    // End of variables declaration//GEN-END:variables

}
