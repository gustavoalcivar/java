/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import algoritmos.ElementoMochila;
import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class MochilaFraccionaria extends javax.swing.JFrame {
    
    private double peso[], beneficio[], pmaximo, solucion[];

    public MochilaFraccionaria() {
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
        textPeso = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textValor = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSolucion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        textPmaximo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOCHILA FRACCIONARIA");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MOCHILA FRACCIONARIA");

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        textPeso.setBackground(new java.awt.Color(102, 102, 102));
        textPeso.setColumns(20);
        textPeso.setForeground(new java.awt.Color(255, 255, 255));
        textPeso.setRows(5);
        jScrollPane1.setViewportView(textPeso);

        textValor.setBackground(new java.awt.Color(102, 102, 102));
        textValor.setColumns(20);
        textValor.setForeground(new java.awt.Color(255, 255, 255));
        textValor.setRows(5);
        jScrollPane2.setViewportView(textValor);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese los pesos de los elementos separados por espacios:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese los beneficios de los elementos separados por espacios:");

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solución:");

        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setEditable(false);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane3.setViewportView(textSolucion);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Peso máximo soportado por la mochila:");

        textPmaximo.setBackground(new java.awt.Color(102, 102, 102));
        textPmaximo.setForeground(new java.awt.Color(255, 255, 255));
        textPmaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPmaximoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mochila.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(17, 17, 17))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPmaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonAceptar)))
                        .addGap(0, 250, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textPmaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAceptar))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(93, 93, 93)
                                .addComponent(botonRegresar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(35, 35, 35))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(92, 92, 92))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
Metodos.validarTextArea(textPeso);
Metodos.validarTextArea(textValor);
        try {
            pmaximo = Double.parseDouble(textPmaximo.getText());
            peso = algoritmos.Metodos.leerArregloDoble(textPeso);
            beneficio = algoritmos.Metodos.leerArregloDoble(textValor);
            if(peso.length == beneficio.length) {
                ElementoMochila[] elementos= new ElementoMochila[peso.length];
                for(int i = 0; i < peso.length; i++) {
                    elementos[i] = new ElementoMochila(i+1, beneficio[i], peso[i]);
                }
                solucion = new double[peso.length];
                solucion = algoritmos.Algoritmos.mochilaFraccionaria(elementos, elementos.length, pmaximo, solucion);
                textSolucion.setText("");
                for(int i = 0; i < peso.length; i++) {
                    textSolucion.append("Del elemento "+elementos[i].elemento+" se toma un peso de "+solucion[i]*elementos[i].peso+"\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad de pesos no es igual a la de veneficios", "ERROR", 0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada", "ERROR", 0);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void textPmaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPmaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPmaximoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textPeso;
    private javax.swing.JTextField textPmaximo;
    private javax.swing.JTextArea textSolucion;
    private javax.swing.JTextArea textValor;
    // End of variables declaration//GEN-END:variables

}
