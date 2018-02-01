/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AsignacionTareasVueltaAtras extends javax.swing.JFrame {
    
    private int T[][];
    private int funMejor[];
    private int asignada[];
    private int fun[];
    private int coste;
    private int costeMin;
    private int n;
    private int solucion[];
    
    public AsignacionTareasVueltaAtras() {
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
        comboTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASIGNACIÓN DE TAREAS CON VUELTA ATRAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASIGNACION DE TAREAS CON VUELTA ATRAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 692, -1));

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, -1));

        textCostes.setBackground(new java.awt.Color(102, 102, 102));
        textCostes.setColumns(20);
        textCostes.setForeground(new java.awt.Color(255, 255, 255));
        textCostes.setRows(5);
        jScrollPane1.setViewportView(textCostes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 544, 137));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la matriz de costes separando los elementos con espacios y saltos de linea:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, -1, -1));

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solución:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        textSolucion.setEditable(false);
        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane3.setViewportView(textSolucion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 615, 130));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trabajador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tarea");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asignación 1", "Asignación 2" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 370, -1));

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
                T = algoritmos.Metodos.leerMatriz(textCostes);
                if(textCostes.getLineCount() == Metodos.contarColumnas(textCostes)) {
                    costeMin = 9999;
                    coste = 0;
                    n = textCostes.getLineCount();
                    fun = new int[n];
                    asignada = new int[n];
                    funMejor = new int[n];
                    if(comboTipo.getSelectedIndex() == 0) {
                        solucion = asignacionTareasVueltaAtras(0);
                    } else {
                        solucion = asignacionTareasVueltaAtras2(0, 999999);
                    }
                    textSolucion.setText("");
                    for(int i = 0; i < n; i++) {
                        textSolucion.append("Al trabajador "+(i+1)+" se le asigna la tarea "+(solucion[i]+1)+"\n");
                    }
                    textSolucion.append("\nEl coste total es: "+costeMin); 
                } else {
                    JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

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
    private javax.swing.JTextArea textCostes;
    private javax.swing.JTextArea textSolucion;
    // End of variables declaration//GEN-END:variables
    
    private int[] asignacionTareasVueltaAtras(int q) {
        for(int ntarea = 0; ntarea < n; ntarea++) {
            if(asignada[ntarea] == 0) {
                fun[q] = ntarea;
                coste += T[q][ntarea];
                asignada[ntarea] = 1;
                if(q == n-1) {
                    if(coste < costeMin){
                        costeMin = coste;
                        for(int i = 0; i < n; i++) {
                            funMejor[i] = fun[i];
                        }
                    }
                } else {
                    asignacionTareasVueltaAtras(q+1);
                }
                coste = coste-T[q][ntarea];
                asignada[ntarea] = 0;
            }
        }
        return funMejor;
    }
    
    private int[] asignacionTareasVueltaAtras2(int q, int minimo) {
        for(int ntarea = 0; ntarea < n; ntarea++) {
            if(asignada[ntarea] == 0) {
                fun[q] = ntarea;
                coste += T[q][ntarea];
                asignada[ntarea] = 1;
                if(q == n-1) {
                    if(coste < costeMin && coste < minimo){
                        costeMin = coste;
                        for(int i = 0; i < n; i++) {
                            funMejor[i] = fun[i];
                        }
                        minimo = coste;
                    }
                } else {
                    asignacionTareasVueltaAtras2(q+1, minimo);
                }
                coste = coste-T[q][ntarea];
                asignada[ntarea] = 0;
            }
        }
        return funMejor;
    }
    
}
