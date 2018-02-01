/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Integracion.java
 *
 * Created on 25/04/2013, 08:55:53 AM
 */
package analisisNumerico;

/**
 *
 * @author gustavo
 */
public class Derivacion extends javax.swing.JFrame {
    /** Creates new form Integracion */
    public Derivacion() {
        initComponents();
        setLocationRelativeTo(null);
        textFuncion2.setVisible(false);
        elemento=0;
    }
    String funcion1[]=new String[999];
    String funcion2[]=new String[999];
    int elemento;
    double x0,h;
    private void añadirAlVector(String elemento1,String elemento2){
        funcion1[elemento]=elemento1;
        funcion2[elemento]=elemento2;
        elemento++;
        actualizar();
    }
    private void actualizar(){
        textFuncion1.setText("");
        textFuncion2.setText("");
        for(int i=0;i<elemento;i++){
            textFuncion1.append(funcion1[i]);
            textFuncion2.setText(textFuncion2.getText()+funcion2[i]);
        }
    }
    private void limpiar(){
        elemento=0;
        textFuncion1.setText("");
        textFuncion2.setText("");
        textResultado.setText("");
        for(int i=0;i<999;i++){
            funcion1[i]="";
            funcion2[i]="";
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textX0 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textFuncion1 = new javax.swing.JTextArea();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        boton0 = new javax.swing.JButton();
        botonPi = new javax.swing.JButton();
        botonE = new javax.swing.JButton();
        botonAbreParentesis = new javax.swing.JButton();
        botonCierraParentesis = new javax.swing.JButton();
        botonMas = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        botonPor = new javax.swing.JButton();
        botonDividir = new javax.swing.JButton();
        botonPotencia = new javax.swing.JButton();
        botonRaiz = new javax.swing.JButton();
        botonSen = new javax.swing.JButton();
        botonCos = new javax.swing.JButton();
        botonTan = new javax.swing.JButton();
        textFuncion2 = new javax.swing.JLabel();
        botonBorrar1 = new javax.swing.JButton();
        botonBorrarTodo = new javax.swing.JButton();
        botonLn = new javax.swing.JButton();
        botonCalcular = new javax.swing.JButton();
        botonPunto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textResultado = new javax.swing.JTextField();
        botonX = new javax.swing.JButton();
        botonComa = new javax.swing.JButton();
        botonAbs = new javax.swing.JButton();
        botonASen = new javax.swing.JButton();
        botonACos = new javax.swing.JButton();
        botonATan = new javax.swing.JButton();
        comboMetodo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Derivación numérica");
        setResizable(false);

        jLabel1.setText("x0:");

        jLabel2.setText("h:");

        jLabel4.setText("Función:");

        textFuncion1.setColumns(20);
        textFuncion1.setEditable(false);
        textFuncion1.setRows(5);
        jScrollPane1.setViewportView(textFuncion1);

        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });

        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });

        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });

        boton0.setText("0");
        boton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0ActionPerformed(evt);
            }
        });

        botonPi.setText("pi");
        botonPi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPiActionPerformed(evt);
            }
        });

        botonE.setText("e");
        botonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEActionPerformed(evt);
            }
        });

        botonAbreParentesis.setText("(");
        botonAbreParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbreParentesisActionPerformed(evt);
            }
        });

        botonCierraParentesis.setText(")");
        botonCierraParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCierraParentesisActionPerformed(evt);
            }
        });

        botonMas.setText("+");
        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });

        botonMenos.setText("-");
        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });

        botonPor.setText("*");
        botonPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPorActionPerformed(evt);
            }
        });

        botonDividir.setText("/");
        botonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDividirActionPerformed(evt);
            }
        });

        botonPotencia.setText("pot(base,exponente)");
        botonPotencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPotenciaActionPerformed(evt);
            }
        });

        botonRaiz.setText("raíz");
        botonRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRaizActionPerformed(evt);
            }
        });

        botonSen.setText("sen");
        botonSen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSenActionPerformed(evt);
            }
        });

        botonCos.setText("cos");
        botonCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCosActionPerformed(evt);
            }
        });

        botonTan.setText("tan");
        botonTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTanActionPerformed(evt);
            }
        });

        textFuncion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botonBorrar1.setText("<-");
        botonBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar1ActionPerformed(evt);
            }
        });

        botonBorrarTodo.setText("AC");
        botonBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarTodoActionPerformed(evt);
            }
        });

        botonLn.setText("ln");
        botonLn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLnActionPerformed(evt);
            }
        });

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        botonPunto.setText(".");
        botonPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuntoActionPerformed(evt);
            }
        });

        jLabel5.setText("Resultado:");

        textResultado.setEditable(false);

        botonX.setText("x");
        botonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonXActionPerformed(evt);
            }
        });

        botonComa.setText(",");
        botonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComaActionPerformed(evt);
            }
        });

        botonAbs.setText("abs");
        botonAbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbsActionPerformed(evt);
            }
        });

        botonASen.setText("arcsen");
        botonASen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonASenActionPerformed(evt);
            }
        });

        botonACos.setText("arccos");
        botonACos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonACosActionPerformed(evt);
            }
        });

        botonATan.setText("arctan");
        botonATan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonATanActionPerformed(evt);
            }
        });

        comboMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diferencia progresiva", "Diferencia regresiva", "Diferencia centrada" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(boton1)
                                .addGap(6, 6, 6)
                                .addComponent(boton2)
                                .addGap(6, 6, 6)
                                .addComponent(boton3)
                                .addGap(12, 12, 12)
                                .addComponent(botonAbreParentesis)
                                .addGap(6, 6, 6)
                                .addComponent(botonCierraParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(botonX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textX0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textH, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFuncion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonSen)
                                        .addGap(6, 6, 6)
                                        .addComponent(botonCos)
                                        .addGap(10, 10, 10)
                                        .addComponent(botonASen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonACos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonBorrarTodo)
                                            .addComponent(botonBorrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(comboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton4)
                                .addGap(6, 6, 6)
                                .addComponent(boton5)
                                .addGap(6, 6, 6)
                                .addComponent(boton6)
                                .addGap(12, 12, 12)
                                .addComponent(botonMas)
                                .addGap(6, 6, 6)
                                .addComponent(botonMenos)
                                .addGap(18, 18, 18)
                                .addComponent(botonComa)
                                .addGap(11, 11, 11)
                                .addComponent(botonTan)
                                .addGap(4, 4, 4)
                                .addComponent(botonAbs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonATan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonLn)
                                .addGap(114, 114, 114))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton7)
                                .addGap(7, 7, 7)
                                .addComponent(boton8)
                                .addGap(6, 6, 6)
                                .addComponent(boton9)
                                .addGap(12, 12, 12)
                                .addComponent(botonPor)
                                .addGap(6, 6, 6)
                                .addComponent(botonDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(textResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(botonE)
                                    .addGap(6, 6, 6)
                                    .addComponent(boton0)
                                    .addGap(6, 6, 6)
                                    .addComponent(botonPi)
                                    .addGap(6, 6, 6)
                                    .addComponent(botonPunto)
                                    .addGap(8, 8, 8)
                                    .addComponent(botonPotencia)
                                    .addGap(6, 6, 6)
                                    .addComponent(botonRaiz)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(12, 12, 12)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textX0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(textH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textFuncion2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton1)
                    .addComponent(boton2)
                    .addComponent(boton3)
                    .addComponent(botonAbreParentesis)
                    .addComponent(botonCierraParentesis)
                    .addComponent(botonX)
                    .addComponent(botonSen)
                    .addComponent(botonCos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonASen)
                        .addComponent(botonACos)
                        .addComponent(botonBorrar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton4)
                            .addComponent(boton5)
                            .addComponent(boton6)
                            .addComponent(botonMas)
                            .addComponent(botonMenos)
                            .addComponent(botonComa)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonTan)
                                .addComponent(botonAbs)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton7)
                            .addComponent(boton8)
                            .addComponent(boton9)
                            .addComponent(botonPor)
                            .addComponent(botonDividir)))
                    .addComponent(botonATan)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonBorrarTodo)
                        .addComponent(botonLn)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonE)
                    .addComponent(boton0)
                    .addComponent(botonPi)
                    .addComponent(botonPunto)
                    .addComponent(botonPotencia)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonRaiz)
                        .addComponent(botonCalcular)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(textResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonBorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarTodoActionPerformed
    limpiar();
}//GEN-LAST:event_botonBorrarTodoActionPerformed

private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
    añadirAlVector("1","1");
}//GEN-LAST:event_boton1ActionPerformed

private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
    añadirAlVector("2","2");
}//GEN-LAST:event_boton2ActionPerformed

private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
    añadirAlVector("3","3");
}//GEN-LAST:event_boton3ActionPerformed

private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
    añadirAlVector("4","4");
}//GEN-LAST:event_boton4ActionPerformed

private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
    añadirAlVector("5","5");
}//GEN-LAST:event_boton5ActionPerformed

private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
    añadirAlVector("6","6");
}//GEN-LAST:event_boton6ActionPerformed

private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
    añadirAlVector("7","7");
}//GEN-LAST:event_boton7ActionPerformed

private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
    añadirAlVector("8","8");
}//GEN-LAST:event_boton8ActionPerformed

private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
    añadirAlVector("9","9");
}//GEN-LAST:event_boton9ActionPerformed

private void boton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton0ActionPerformed
    añadirAlVector("0","0");
}//GEN-LAST:event_boton0ActionPerformed

private void botonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEActionPerformed
    añadirAlVector("e","Math.E");
}//GEN-LAST:event_botonEActionPerformed

private void botonPiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPiActionPerformed
    añadirAlVector("pi","Math.PI");
}//GEN-LAST:event_botonPiActionPerformed

private void botonAbreParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbreParentesisActionPerformed
    añadirAlVector("(","(");
}//GEN-LAST:event_botonAbreParentesisActionPerformed

private void botonCierraParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCierraParentesisActionPerformed
    añadirAlVector(")",")");
}//GEN-LAST:event_botonCierraParentesisActionPerformed

private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
    añadirAlVector("+","+");
}//GEN-LAST:event_botonMasActionPerformed

private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
    añadirAlVector("-","-");
}//GEN-LAST:event_botonMenosActionPerformed

private void botonPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPorActionPerformed
    añadirAlVector("*","*");
}//GEN-LAST:event_botonPorActionPerformed

private void botonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDividirActionPerformed
    añadirAlVector("/","/");
}//GEN-LAST:event_botonDividirActionPerformed

private void botonPotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPotenciaActionPerformed
    añadirAlVector("POT(","Math.pow(");
}//GEN-LAST:event_botonPotenciaActionPerformed

private void botonSenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSenActionPerformed
    añadirAlVector("sen(","Math.sin(");
}//GEN-LAST:event_botonSenActionPerformed

private void botonCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCosActionPerformed
    añadirAlVector("cos(","Math.cos(");
}//GEN-LAST:event_botonCosActionPerformed

private void botonTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTanActionPerformed
    añadirAlVector("tan(","Math.tan(");
}//GEN-LAST:event_botonTanActionPerformed

private void botonLnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLnActionPerformed
    añadirAlVector("ln(","Math.log(");
}//GEN-LAST:event_botonLnActionPerformed

private void botonRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRaizActionPerformed
    añadirAlVector("raiz(","Math.sqrt(");
}//GEN-LAST:event_botonRaizActionPerformed

private void botonBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar1ActionPerformed
    elemento--;
    actualizar();
}//GEN-LAST:event_botonBorrar1ActionPerformed

private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
    textResultado.setText("");
    if(datosValidos()){
        try{
            String funcion=textFuncion2.getText();
            double resultado;
            x0=Double.parseDouble(textX0.getText());
            h=Double.parseDouble(textH.getText());
            if(h>0){
                int opcion=comboMetodo.getSelectedIndex();
                switch(opcion){
                    case 0:
                        resultado=Metodos.derivadaDiferenciaAdelante(x0,h,funcion);
                        textResultado.setText(String.valueOf(resultado));
                        break;
                    case 1:
                        resultado=Metodos.derivadaDiferenciaAtras(x0,h,funcion);
                        textResultado.setText(String.valueOf(resultado));
                        break;
                    case 2:
                        resultado=Metodos.derivadaDiferenciaCentrada(x0,h,funcion);
                        textResultado.setText(String.valueOf(resultado));
                        break;
                }
            }else Metodos.error("h debe ser mayor que cero");
        }catch(Exception ex){
            Metodos.error(ex);
        }
    }else Metodos.error("Se deben llenar todos los campos con datos válidos");
}//GEN-LAST:event_botonCalcularActionPerformed

private void botonPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuntoActionPerformed
    añadirAlVector(".",".");
}//GEN-LAST:event_botonPuntoActionPerformed

private void botonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonXActionPerformed
    añadirAlVector("x","x");
}//GEN-LAST:event_botonXActionPerformed

private void botonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComaActionPerformed
    añadirAlVector(",",",");
}//GEN-LAST:event_botonComaActionPerformed

private void botonAbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbsActionPerformed
    añadirAlVector("abs(","Math.abs(");
}//GEN-LAST:event_botonAbsActionPerformed

private void botonASenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonASenActionPerformed
    añadirAlVector("arcsen(","Math.asin(");
}//GEN-LAST:event_botonASenActionPerformed

private void botonACosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonACosActionPerformed
    añadirAlVector("arccos(","Math.acos(");
}//GEN-LAST:event_botonACosActionPerformed

private void botonATanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonATanActionPerformed
    añadirAlVector("arctan(","Math.atan(");
}//GEN-LAST:event_botonATanActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton0;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JButton botonACos;
    private javax.swing.JButton botonASen;
    private javax.swing.JButton botonATan;
    private javax.swing.JButton botonAbreParentesis;
    private javax.swing.JButton botonAbs;
    private javax.swing.JButton botonBorrar1;
    private javax.swing.JButton botonBorrarTodo;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonCierraParentesis;
    private javax.swing.JButton botonComa;
    private javax.swing.JButton botonCos;
    private javax.swing.JButton botonDividir;
    private javax.swing.JButton botonE;
    private javax.swing.JButton botonLn;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JButton botonPi;
    private javax.swing.JButton botonPor;
    private javax.swing.JButton botonPotencia;
    private javax.swing.JButton botonPunto;
    private javax.swing.JButton botonRaiz;
    private javax.swing.JButton botonSen;
    private javax.swing.JButton botonTan;
    private javax.swing.JButton botonX;
    private javax.swing.JComboBox comboMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textFuncion1;
    private javax.swing.JLabel textFuncion2;
    private javax.swing.JTextField textH;
    private javax.swing.JTextField textResultado;
    private javax.swing.JTextField textX0;
    // End of variables declaration//GEN-END:variables

    private boolean datosValidos() {
        if(textX0.getText().equals("")||textH.getText().equals("")
                ||textFuncion1.getText().equals(""))
            return false;
        return true;
    }
}
