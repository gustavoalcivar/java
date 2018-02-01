/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import algoritmos.Metodos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Laberinto extends javax.swing.JFrame {
    
    private int laberinto[][];
    private int fila;
    private int columna;
    private boolean exito;
    private int n;
    private int k;
    private int recorridoMinimo;
    
    private final int movFil[] = {1, 0, 0, -1};
    private final int movCol[] = {0, 1, -1, 0};

    public Laberinto() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.blue);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLaberinto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSolucion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        botonAleatorio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EL LABERINTO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EL LABERINTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 680, -1));

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, -1, -1));

        textLaberinto.setBackground(new java.awt.Color(102, 102, 102));
        textLaberinto.setColumns(20);
        textLaberinto.setForeground(new java.awt.Color(255, 255, 255));
        textLaberinto.setRows(5);
        jScrollPane1.setViewportView(textLaberinto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 640, 170));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la matriz del laberinto separando los elementos con espacios y saltos de linea:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, -1, -1));

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solución:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        textSolucion.setEditable(false);
        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane3.setViewportView(textSolucion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 630, 180));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("(Use 0 para las casillas transitables y -1 para las casillas no transitables)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        botonAleatorio.setText("Laberinto aleatorio");
        botonAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAleatorioActionPerformed(evt);
            }
        });
        getContentPane().add(botonAleatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laberinto.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 120, 100));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laberinto 1", "Laberinto 2" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 320, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
Metodos.validarTextArea(textLaberinto);
        try{
            if(algoritmos.Metodos.validarMatriz(textLaberinto)){
                laberinto = algoritmos.Metodos.leerMatriz(textLaberinto);
                if(textLaberinto.getLineCount() == Metodos.contarColumnas(textLaberinto)) {
                    if(validarLaberinto()) {
                        n = textLaberinto.getLineCount();
                        if(laberinto[0][0] == 0 && laberinto[n-1][n-1] == 0) {
                            
                            k = 0;
                            fila = 0;
                            columna = 0;
                            if(comboTipo.getSelectedIndex() == 0) {
                                Laberinto(k);
                                if(exito) {
                                    textSolucion.setText("");
                                    algoritmos.Metodos.imprimirMatriz2(laberinto, n, n, textSolucion);
                                } else {
                                    textSolucion.setText("El laberinto no tiene solución");
                                }
                            } else {
                                Laberinto2(k);
                                algoritmos.Metodos.imprimirMatriz2(laberinto, n, n, textSolucion);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Las posiciones (0, 0) y ("+(n-1)+", "+(n-1)+") deben ser cero","ERROR",0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El laberinto debe contener solo ceros y menos unos","ERROR",0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La matriz debe ser cuadrada","ERROR",0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

private void botonAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAleatorioActionPerformed
        try {
            textSolucion.setText("");
            String tam = JOptionPane.showInputDialog(null, "Ingrese la dimensión del laberinto","",3);
            n = Integer.valueOf(tam);
            int lab[][] = new int[n][n];
            double temp;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    temp = Math.random();
                    if(temp < 0.5) {
                        lab[i][j] = -1;
                    } else {
                        lab[i][j] = 0;
                    }
                }
            }
            lab[0][0] = 0;
            lab[n-1][n-1] = 0;
            Metodos.imprimirMatriz2(lab, n, n, textLaberinto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR",0);
        }
}//GEN-LAST:event_botonAleatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAleatorio;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textLaberinto;
    private javax.swing.JTextArea textSolucion;
    // End of variables declaration//GEN-END:variables

    private void Laberinto(int k) {
        int orden = -1;
        exito =false;
        do {
            orden++;
            fila += movFil[orden];
            columna += movCol[orden];
            if(fila >= 0 && fila < n && columna >= 0 && columna < n) {
                if(laberinto[fila][columna] == 0) {
                    laberinto[fila][columna] = k+1;
                    if(fila == n-1 && columna == n-1) {
                        exito = true;
                    } else {
                        Laberinto(k+1);
                        if(!exito) {
                            laberinto[fila][columna] = 0;
                        }
                    }
                    
                }
                
            }
            fila -= movFil[orden];
            columna -= movCol[orden];
        } while(!exito && orden != 3);
    }
    
    
    private void Laberinto2(int k) {
        int orden = -1;
        
        do {
            orden++;
            fila += movFil[orden];
            columna += movCol[orden];
            if(fila >= 0 && fila < n && columna >= 0 && columna < n) {
                if(laberinto[fila][columna] == 0) {
                    laberinto[fila][columna] = k+1;
                    if(fila == n-1 && columna == n-1) {
                        recorridoMinimo = k;
                    } else if(k <= recorridoMinimo) {
                        Laberinto(k+1);
                    }
                    laberinto[fila][columna] = 0;
                    
                }
                
            }
            fila -= movFil[orden];
            columna -= movCol[orden];
        } while(orden != 3);
    }

    private boolean validarLaberinto() {
        for(int i = 0; i < textLaberinto.getLineCount(); i++) {
            for(int j = 0; j < textLaberinto.getLineCount(); j++) {
                if(laberinto[i][j] != 0 && laberinto[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

}
