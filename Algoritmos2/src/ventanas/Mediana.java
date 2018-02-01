/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Mediana extends javax.swing.JFrame {
    
    private int arreglo1[], arreglo2[];

    public Mediana() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArreglo1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArreglo2 = new javax.swing.JTextArea();
        botonGenerar = new javax.swing.JButton();
        botonCalcular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textResultado = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEDIANA ENTRE DOS ARREGLOS");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MEDIANA ENTRE DOS ARREGLOS");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese los arreglos separando los elementos con espacios; o genere un arreglos aleatorios");

        textArreglo1.setBackground(new java.awt.Color(102, 102, 102));
        textArreglo1.setColumns(20);
        textArreglo1.setForeground(new java.awt.Color(255, 255, 255));
        textArreglo1.setRows(5);
        jScrollPane1.setViewportView(textArreglo1);

        textArreglo2.setBackground(new java.awt.Color(102, 102, 102));
        textArreglo2.setColumns(20);
        textArreglo2.setForeground(new java.awt.Color(255, 255, 255));
        textArreglo2.setRows(5);
        jScrollPane2.setViewportView(textArreglo2);

        botonGenerar.setText("Generar arreglos aleatorios");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        botonCalcular.setText("CALCULAR");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Resultado:");

        textResultado.setForeground(new java.awt.Color(255, 255, 255));
        textResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(botonGenerar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(botonCalcular)))
                        .addGap(0, 215, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(botonRegresar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botonGenerar)
                        .addGap(18, 18, 18)
                        .addComponent(botonCalcular)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(botonRegresar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        try {
            String n = JOptionPane.showInputDialog(null, "Ingrese el tamaño de los arreglos", "", 3);
            int tam = Integer.parseInt(n);
            String minimo = JOptionPane.showInputDialog(null, "Ingrese el menor número posible", "", 3);
            int min = Integer.parseInt(minimo);
            String maximo = JOptionPane.showInputDialog(null, "Ingrese el mayor número posible", "", 3);
            int max = Integer.parseInt(maximo);
            if(max > min) {
                arreglo1 = algoritmos.Metodos.llenarArregloAleatorio(tam, min, max);
                algoritmos.Metodos.shell(arreglo1);
                textArreglo1.setText("");
                algoritmos.Metodos.imprimirArreglo(arreglo1, textArreglo1);
                
                arreglo2 = algoritmos.Metodos.llenarArregloAleatorio(tam, min, max);
                algoritmos.Metodos.shell(arreglo2);
                textArreglo2.setText("");
                algoritmos.Metodos.imprimirArreglo(arreglo2, textArreglo2);
            } else {
                JOptionPane.showMessageDialog(null, "El elemento mínimo debe ser menor que el máximo", "ERROR", 0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada", "ERROR", 0);
        }
    }//GEN-LAST:event_botonGenerarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
Metodos.validarTextArea(textArreglo1);
Metodos.validarTextArea(textArreglo2);
        try{
            arreglo1 = algoritmos.Metodos.leerArreglo(textArreglo1);
            arreglo2 = algoritmos.Metodos.leerArreglo(textArreglo2);
            if(arreglo1 != null && arreglo2 != null){
                if(algoritmos.Metodos.estaOrdenado(arreglo1)
                        && algoritmos.Metodos.estaOrdenado(arreglo2)){
                    try{
                        int media = algoritmos.Algoritmos.mediana(arreglo1, arreglo2, 0, arreglo1.length-1, 0, arreglo2.length-1);
               
                            textResultado.setText("La media es "+media);
                        
                        
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error en los datos de entrada", "ERROR", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Los arreglos no están ordenados", "ERROR", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se han generado arreglos", "ERROR", 0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada", "ERROR", 0);
        }
    }//GEN-LAST:event_botonCalcularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArreglo1;
    private javax.swing.JTextArea textArreglo2;
    private javax.swing.JLabel textResultado;
    // End of variables declaration//GEN-END:variables
}
