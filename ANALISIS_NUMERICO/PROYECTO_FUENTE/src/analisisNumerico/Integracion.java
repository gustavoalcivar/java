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
public class Integracion extends javax.swing.JFrame {
    /** Creates new form Integracion */
    public Integracion() {
        initComponents();
        setLocationRelativeTo(null);
        textFuncion2.setVisible(false);
    }
    String funcion1[]=new String[999];
    String funcion2[]=new String[999];
    int elemento=0,n;
    double inferior,superior;
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
        textInferior = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textSuperior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textN = new javax.swing.JTextField();
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
        comboMetodo = new javax.swing.JComboBox();
        botonPunto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textResultado = new javax.swing.JTextField();
        botonX = new javax.swing.JButton();
        botonComa = new javax.swing.JButton();
        botonAbs = new javax.swing.JButton();
        botonASen = new javax.swing.JButton();
        botonACos = new javax.swing.JButton();
        botonATan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Integración numérica");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Límite inferior:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        getContentPane().add(textInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 93, -1));

        jLabel2.setText("Límite superior:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));
        getContentPane().add(textSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 93, -1));

        jLabel3.setText("Número de particiones:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));
        getContentPane().add(textN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 93, -1));

        jLabel4.setText("Función:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 244, -1, -1));

        textFuncion1.setEditable(false);
        textFuncion1.setColumns(20);
        textFuncion1.setRows(5);
        jScrollPane1.setViewportView(textFuncion1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 574, 55));

        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 115, -1, -1));

        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 115, -1, -1));

        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        getContentPane().add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 115, -1, -1));

        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        getContentPane().add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 144, -1, -1));

        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });
        getContentPane().add(boton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 144, -1, -1));

        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });
        getContentPane().add(boton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 144, -1, -1));

        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });
        getContentPane().add(boton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, -1, -1));

        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });
        getContentPane().add(boton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 173, -1, -1));

        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });
        getContentPane().add(boton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 173, -1, -1));

        boton0.setText("0");
        boton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0ActionPerformed(evt);
            }
        });
        getContentPane().add(boton0, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 202, -1, -1));

        botonPi.setText("pi");
        botonPi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPiActionPerformed(evt);
            }
        });
        getContentPane().add(botonPi, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 202, -1, -1));

        botonE.setText("e");
        botonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEActionPerformed(evt);
            }
        });
        getContentPane().add(botonE, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 202, -1, -1));

        botonAbreParentesis.setText("(");
        botonAbreParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbreParentesisActionPerformed(evt);
            }
        });
        getContentPane().add(botonAbreParentesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 115, -1, -1));

        botonCierraParentesis.setText(")");
        botonCierraParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCierraParentesisActionPerformed(evt);
            }
        });
        getContentPane().add(botonCierraParentesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 115, 44, -1));

        botonMas.setText("+");
        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });
        getContentPane().add(botonMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 144, -1, -1));

        botonMenos.setText("-");
        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });
        getContentPane().add(botonMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 144, -1, -1));

        botonPor.setText("*");
        botonPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPorActionPerformed(evt);
            }
        });
        getContentPane().add(botonPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 173, -1, -1));

        botonDividir.setText("/");
        botonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDividirActionPerformed(evt);
            }
        });
        getContentPane().add(botonDividir, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 173, 67, -1));

        botonPotencia.setText("pot(base,exponente)");
        botonPotencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPotenciaActionPerformed(evt);
            }
        });
        getContentPane().add(botonPotencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 202, -1, -1));

        botonRaiz.setText("raíz");
        botonRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRaizActionPerformed(evt);
            }
        });
        getContentPane().add(botonRaiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        botonSen.setText("sen");
        botonSen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSenActionPerformed(evt);
            }
        });
        getContentPane().add(botonSen, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 115, -1, -1));

        botonCos.setText("cos");
        botonCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCosActionPerformed(evt);
            }
        });
        getContentPane().add(botonCos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        botonTan.setText("tan");
        botonTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTanActionPerformed(evt);
            }
        });
        getContentPane().add(botonTan, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 144, -1, -1));

        textFuncion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(textFuncion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 58, 345, 24));

        botonBorrar1.setText("<-");
        botonBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 52, -1));

        botonBorrarTodo.setText("AC");
        botonBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(botonBorrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        botonLn.setText("ln");
        botonLn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLnActionPerformed(evt);
            }
        });
        getContentPane().add(botonLn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 202, 109, -1));

        comboMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sumas de Riemann", "Regla del trapecio", "Regla de Simpson 1/3", "Regla de Simpson 3/8" }));
        getContentPane().add(comboMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 20, 198, -1));

        botonPunto.setText(".");
        botonPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuntoActionPerformed(evt);
            }
        });
        getContentPane().add(botonPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 202, -1, -1));

        jLabel5.setText("Resultado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 319, -1, -1));

        textResultado.setEditable(false);
        getContentPane().add(textResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 317, 540, -1));

        botonX.setText("x");
        botonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonXActionPerformed(evt);
            }
        });
        getContentPane().add(botonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 115, 44, -1));

        botonComa.setText(",");
        botonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComaActionPerformed(evt);
            }
        });
        getContentPane().add(botonComa, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 144, -1, -1));

        botonAbs.setText("abs");
        botonAbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbsActionPerformed(evt);
            }
        });
        getContentPane().add(botonAbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        botonASen.setText("arcsen");
        botonASen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonASenActionPerformed(evt);
            }
        });
        getContentPane().add(botonASen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        botonACos.setText("arccos");
        botonACos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonACosActionPerformed(evt);
            }
        });
        getContentPane().add(botonACos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));

        botonATan.setText("arctan");
        botonATan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonATanActionPerformed(evt);
            }
        });
        getContentPane().add(botonATan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, -1, -1));

        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

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
            inferior=Double.parseDouble(textInferior.getText());
            superior=Double.parseDouble(textSuperior.getText());
            n=Integer.parseInt(textN.getText());
            if(n>0){
                int opcion=comboMetodo.getSelectedIndex();
                switch(opcion){
                    case 0:
                        resultado=Metodos.integralRiemann(inferior,superior,n,funcion);
                        textResultado.setText(String.valueOf(resultado));
                        break;
                    case 1:
                        resultado=Metodos.integralTrapecios(inferior,superior,n,funcion);
                        textResultado.setText(String.valueOf(resultado));
                        break;
                    case 2:
                        if(n%2==0){
                            resultado=Metodos.integralSimpson13(inferior,superior,n,funcion);
                            textResultado.setText(String.valueOf(resultado));
                        }else Metodos.error("El número de particiones para el método Simpson 1/3 debe ser par");
                        break;
                    case 3:
                        if(n%2!=0){
                            resultado=Metodos.integralSimpson38(inferior,superior,n,funcion);
                            textResultado.setText(String.valueOf(resultado));
                        }else Metodos.error("El número de particiones para el método Simpson 3/8 debe ser impar");
                        break;
                }
            }else Metodos.error("El número de particiones debe ser mayor que cero");
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textFuncion1;
    private javax.swing.JLabel textFuncion2;
    private javax.swing.JTextField textInferior;
    private javax.swing.JTextField textN;
    private javax.swing.JTextField textResultado;
    private javax.swing.JTextField textSuperior;
    // End of variables declaration//GEN-END:variables

    private boolean datosValidos() {
        if(textInferior.getText().equals("")||textSuperior.getText().equals("")
                ||textFuncion1.getText().equals("")||textN.getText().equals(""))
            return false;
        return true;
    }
}
