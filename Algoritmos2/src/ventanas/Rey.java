/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Reinas.java
 *
 * Created on 06/07/2013, 09:52:06 PM
 */
package ventanas;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Rey extends javax.swing.JFrame {

    int n, x, y;
    int mov_x[] = new int[8];
    int mov_y[] = new int[8];
    int tablero[][], mejor[][];
    int coste, costeMinimo;
    
    
    public Rey() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textN = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSolucion = new javax.swing.JTextArea();
        botonRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textX = new javax.swing.JTextField();
        textY = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RECORRIDO DEL REY DE AJEDRÉZ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECORRIDO DEL REY DE AJEDRÉZ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 376, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la dimensión del tablero:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, -1, -1));

        textN.setBackground(new java.awt.Color(102, 102, 102));
        textN.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textN, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 52, 101, -1));

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        textSolucion.setBackground(new java.awt.Color(102, 102, 102));
        textSolucion.setColumns(20);
        textSolucion.setEditable(false);
        textSolucion.setForeground(new java.awt.Color(255, 255, 255));
        textSolucion.setRows(5);
        jScrollPane1.setViewportView(textSolucion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 207, 713, 222));

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 470, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fila inicial:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Columna inicial:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 122, -1, -1));

        textX.setBackground(new java.awt.Color(102, 102, 102));
        textX.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textX, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 83, 101, -1));

        textY.setBackground(new java.awt.Color(102, 102, 102));
        textY.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textY, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 120, 101, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rey.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 26, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rey", "Rey modificado" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Algoritmos al = new Algoritmos();
        dispose();
        al.setVisible(true);
}//GEN-LAST:event_botonRegresarActionPerformed

private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        try {
            n = Integer.parseInt(textN.getText());
            x = Integer.parseInt(textX.getText());
            y = Integer.parseInt(textY.getText());
            tablero = new int[n][n];
            mejor = new int[n][n];
            costeMinimo = 999999;
            textSolucion.setText("");
            tablero[x][y] = 1;
            textSolucion.setText("");
            if(comboTipo.getSelectedIndex() == 0) {
                Rey(2, x, y, false,tablero,n);
                algoritmos.Metodos.imprimirMatriz2(tablero, n, n, textSolucion);
            } else {
                ReyModificado(2, x, y,tablero,n);
                algoritmos.Metodos.imprimirMatriz2(mejor, n, n, textSolucion);
            }
            
            
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos de entrada","ERROR", 0);
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
    private javax.swing.JTextField textN;
    private javax.swing.JTextArea textSolucion;
    private javax.swing.JTextField textX;
    private javax.swing.JTextField textY;
    // End of variables declaration//GEN-END:variables

        public void movimientos(){
        mov_x[0]=0;
        mov_y[0]=1;
        mov_x[1]=-1;
        mov_y[1]=1;
        mov_x[2]=-1;
        mov_y[2]=0;
        mov_x[3]=-1;
        mov_y[3]=-1;
        mov_x[4]=0;
        mov_y[4]=-1;
        mov_x[5]=1;
        mov_y[5]=-1;
        mov_x[6]=1;
        mov_y[6]=0;
        mov_x[7]=1;
        mov_y[7]=1;
    }
        
        public boolean Rey(int k,int x,int y,boolean exito,int[][]tablero1,int n){
       this.tablero=tablero1;
        int orden=-1,v,u;
        exito=false;
        movimientos();
        do{
            orden++;
            u=x+mov_x[orden];
            v=y+mov_y[orden];
            if(0<=u&&u<n&&0<=v&&v<n&&tablero[u][v]==0){
                tablero[u][v]=k;
                if(k<n*n){
                 
                    exito=Rey(k+1, u, v, exito,tablero, n);
                    if(!exito){
                       
                        tablero[u][v]=0;
                    }

                }else{
                    exito=true;
                   

                }
            }

        }while(!exito&&orden!=7);
        return exito;

    }
        
        public void ReyModificado(int k,int x,int y,int[][]tablero1,int n){
       this.tablero=tablero1;
        int orden=-1,v,u;
        
        movimientos();
        do{
            orden++;
            u=x+mov_x[orden];
            v=y+mov_y[orden];
            if(0<=u&&u<n&&0<=v&&v<n&&tablero[u][v]==0){
                tablero[u][v]=k;
                if(k<n*n){
                 ReyModificado(k+1, u, v, tablero, n);
                } else {
                    coste = calcularCoste(tablero);
                    if(coste < costeMinimo) {
                        costeMinimo = coste;
                        for(int i = 0; i < n; i++) {
                            for(int j = 0; j < n; j++) {
                                mejor[i][j] = tablero[i][j];
                            }
                        }
                    }
                }
                tablero[u][v] = 0;
            }

        }while(orden!=7);
    
    }

    private int calcularCoste(int[][] tablero) {
        int i, j, c;
        c = 0;
        for(i = 0; i < n;i++) {
            for(j = 0; j < n;j++) {
                c = c+tablero[i][j]*i*j;
            }
        }
        return c;
    }
}
