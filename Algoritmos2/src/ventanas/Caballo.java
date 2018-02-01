/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Caballo.java
 *
 * Created on 06/07/2013, 08:06:56 PM
 */
package ventanas;

import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Caballo extends javax.swing.JFrame {

    private int n, tablero[][], x, y, cont;
    
    public Caballo() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textY = new javax.swing.JTextField();
        textX = new javax.swing.JTextField();
        textN = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSolucion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RECORRIDO DEL CABALLO DE AJEDRÉZ");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECORRIDO DEL CABALLO DE AJEDRÉZ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dimensión tablero:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fila inicial:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Columna inicial:");

        textY.setBackground(new java.awt.Color(102, 102, 102));
        textY.setForeground(new java.awt.Color(255, 255, 255));

        textX.setBackground(new java.awt.Color(102, 102, 102));
        textX.setForeground(new java.awt.Color(255, 255, 255));

        textN.setBackground(new java.awt.Color(102, 102, 102));
        textN.setForeground(new java.awt.Color(255, 255, 255));

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Solución:");

        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setEditable(false);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane1.setViewportView(textSolucion);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("--> Número de filas y columnas");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caballo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textY, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textX, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(botonAceptar)))
                                .addGap(52, 52, 52)
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(683, Short.MAX_VALUE)
                        .addComponent(botonRegresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(104, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(textX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(textY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(botonAceptar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(botonRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
    try {
        n = Integer.parseInt(textN.getText());
        x = Integer.parseInt(textX.getText());
        y = Integer.parseInt(textY.getText());
        tablero = new int[n][n];
        caballo();
        Metodos.imprimirMatriz2(tablero, n, n, textSolucion);
        textSolucion.append("\nSe recorrieron "+cont+" casillas");
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, "Error en los datos de estrada","ERROR", 0);
    }
}//GEN-LAST:event_botonAceptarActionPerformed

private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
}//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textN;
    private javax.swing.JTextArea textSolucion;
    private javax.swing.JTextField textX;
    private javax.swing.JTextField textY;
    // End of variables declaration//GEN-END:variables
    
    private boolean caballo() {
        
        for(cont = 1; cont <= n*n; cont++) {
            tablero[x][y] = cont;
            if(!nuevoMov() && cont < n*n) {
                return false;
            }
        }
        return true;
    }
    
    private boolean nuevoMov() {
        int accesibles, minasAccesibles, i, solx, soly, nuevax = 0, nuevay = 0;
        minasAccesibles = 9;
        solx = x;
        soly = y;
        for(i = 0; i < 8; i++) {
            switch(i) {
                case 0: nuevax = x-2; nuevay = y+1; break;
                case 1: nuevax = x-1; nuevay = y+2; break;
                case 2: nuevax = x+1; nuevay = y+2; break;
                case 3: nuevax = x+2; nuevay = y+1; break;
                case 4: nuevax = x+2; nuevay = y-1; break;
                case 5: nuevax = x+1; nuevay = y-2; break;
                case 6: nuevax = x-1; nuevay = y-2; break;
                case 7: nuevax = x-2; nuevay = y-1; break;
            }
            if(salto(i, nuevax, nuevay)) {
                accesibles = cuenta(nuevax, nuevay);
                if(accesibles > 0 && accesibles < minasAccesibles) {
                    minasAccesibles = accesibles;
                    solx = nuevax;
                    soly = nuevay;
                }
            }
        }
        x = solx;
        y = soly;
        return (minasAccesibles < 9);
    }
    
    private boolean salto(int i, int nx, int ny) {
        switch(i) {
            case 0: nx = x-2; ny = y+1; break;
            case 1: nx = x-1; ny = y+2; break;
            case 2: nx = x+1; ny = y+2; break;
            case 3: nx = x+2; ny = y+1; break;
            case 4: nx = x+2; ny = y-1; break;
            case 5: nx = x+1; ny = y-2; break;
            case 6: nx = x-1; ny = y-2; break;
            case 7: nx = x-2; ny = y-1; break;
        }
        return (nx >= 0 && nx < n && ny >= 0 && ny < n && tablero[nx][ny] == 0);
    }
    
    private int cuenta(int nx, int ny) {
        int acc = 0;
        for(int i = 0; i < 8; i++) {
            if(salto(i, nx, ny)) {
                acc++;
            }
        }
        return acc;
    }
}
