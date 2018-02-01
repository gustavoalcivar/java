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
public class InterpolacionLagrange extends javax.swing.JFrame {

    /** Creates new form EscalarVector */
    public InterpolacionLagrange() {
        initComponents();
        setLocationRelativeTo(null);
    }
    double componentesX[],componentesY[],resultado,_x;
    int tam1=-1,tam2=-1;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComponentesX = new javax.swing.JTextArea();
        botonCalcular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textResultado = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textComponentesY = new javax.swing.JTextArea();
        botonLeerArchivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        text_x = new javax.swing.JTextField();
        panelGrafico = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPolinomio = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interpolación (Lagrange)");
        setResizable(false);

        jLabel2.setText("Componentes x:");

        jLabel3.setText("Ingrese las componentes de los puntos en una sola linea y separados por espacios;");

        botonGenerar.setText("Generar puntos aleatorios");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        textComponentesX.setColumns(20);
        textComponentesX.setRows(5);
        jScrollPane1.setViewportView(textComponentesX);

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        textResultado.setEditable(false);
        textResultado.setColumns(20);
        textResultado.setRows(5);
        jScrollPane2.setViewportView(textResultado);

        jLabel4.setText("Resultado:");

        jLabel5.setText("Componentes y:");

        textComponentesY.setColumns(20);
        textComponentesY.setRows(5);
        jScrollPane3.setViewportView(textComponentesY);

        botonLeerArchivo.setText("Leer datos del archivo");
        botonLeerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLeerArchivoActionPerformed(evt);
            }
        });

        jLabel1.setText("x =");

        text_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_xActionPerformed(evt);
            }
        });

        panelGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jLabel6.setText("o genere puntos aleatorios");

        jLabel7.setText("Las componentes x deben estar ordenados ascendentemente");

        textPolinomio.setEditable(false);
        textPolinomio.setColumns(20);
        textPolinomio.setRows(5);
        jScrollPane4.setViewportView(textPolinomio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(text_x, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonLeerArchivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(botonCalcular))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1))
                            .addComponent(text_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonGenerar)
                            .addComponent(botonLeerArchivo))
                        .addGap(12, 12, 12)
                        .addComponent(botonCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
    llenar(1);
}//GEN-LAST:event_botonGenerarActionPerformed

private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
    Metodos.validarTextArea(textComponentesX);
    Metodos.validarTextArea(textComponentesY);
    String texto1=textComponentesX.getText();
    String texto2=textComponentesY.getText();
    texto1=Metodos.quitarEspaciosVector(texto1);
    texto2=Metodos.quitarEspaciosVector(texto2);
    if(Metodos.validarVector(texto1)&&textComponentesX.getLineCount()==1
            &&Metodos.validarVector(texto2)&&textComponentesY.getLineCount()==1){
        if(Metodos.contarElementos(texto1)==Metodos.contarElementos(texto2)){
            try{
                componentesX=Metodos.leerVector(texto1);
                try{
                    if(Metodos.estaOrdenado(componentesX)){
                        if(!Metodos.tieneElementosRepetidos(componentesX)){
                            _x=Double.parseDouble(text_x.getText());
                            if(_x>=componentesX[0]&&_x<=componentesX[componentesX.length-1]){
                                componentesY=Metodos.leerVector(texto2);
                                Metodos.imprimirVector(componentesX,textComponentesX);
                                Metodos.imprimirVector(componentesY,textComponentesY);
                                text_x.setText(String.valueOf(_x));
                                resultado=Metodos.interpolacionLagrange(componentesX,componentesY,_x);
                                Metodos.interpolacionLagrange(componentesX,componentesY,textPolinomio);
                                Metodos.imprimirResultado(resultado,textResultado);
                                new GraficoLagrange().GraficaFinal(componentesX,componentesY,panelGrafico);
                            }else Metodos.error("x debe estar entre "+componentesX[0]+" y "+componentesX[componentesX.length-1]);
                        }else Metodos.error("Los elementos de x no se deben repetir");
                    }else Metodos.error("Las componentes x no están ordenadas");
                }catch(Exception ex){
                    Metodos.error(ex);
                }
            }catch(Exception ex){
                Metodos.error(ex);
            }
            }else Metodos.error("La cantidad de componentes x debe ser igual a la de componentes y");
    }else Metodos.error("Los datos ingresados no corresponden a puntos en el plano\n"
            + "O el valor de x no es válido");
}//GEN-LAST:event_botonCalcularActionPerformed

    private void botonLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLeerArchivoActionPerformed
        if(Inicio.vecArchivo!=null){
            llenar(2);
        }else Metodos.errorArchivo();
    }//GEN-LAST:event_botonLeerArchivoActionPerformed

    private void text_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_xActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonLeerArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JTextArea textComponentesX;
    private javax.swing.JTextArea textComponentesY;
    private javax.swing.JTextArea textPolinomio;
    private javax.swing.JTextArea textResultado;
    private javax.swing.JTextField text_x;
    // End of variables declaration//GEN-END:variables

    private void llenar(int k) {
        try{
            String n1;
            n1=JOptionPane.showInputDialog(null,"Ingrese la cantidad de puntos","",3);
            try{
                tam1=Integer.parseInt(n1);
            }catch(Exception ex){
                Metodos.error(ex);
            }
        }catch(Exception ex){
            Metodos.error(ex);
        }
        if(tam1>=1){
            tam2=tam1;
            componentesX=new double[tam1];
            componentesY=new double[tam2];
            do{
                if(k==1)componentesX=Metodos.llenarVectorAleatorio(tam1);
                else componentesX=Metodos.llenarVectorArchivo(tam1);
                Metodos.burbuja(componentesX);
            }while(Metodos.tieneElementosRepetidos(componentesX));
            try{
                String _x1;
                do{
                    _x1=JOptionPane.showInputDialog(null,"Ingrese el punto donde desea evaluar el polinomio\n"
                            + "Entre "+componentesX[0]+" y "+componentesX[tam1-1],"",3);
                    _x=Double.parseDouble(_x1);
                    if(_x>=componentesX[0]&&_x<=componentesX[tam1-1]){
                        if(k==1)componentesY=Metodos.llenarVectorAleatorio(tam1);
                        else componentesY=Metodos.llenarVectorArchivo(tam1);
                        Metodos.imprimirVector(componentesX,textComponentesX);
                        Metodos.imprimirVector(componentesY,textComponentesY);
                        text_x.setText(String.valueOf(_x));
                        resultado=Metodos.interpolacionLagrange(componentesX,componentesY,_x);
                        Metodos.interpolacionLagrange(componentesX,componentesY,textPolinomio);
                        Metodos.imprimirResultado(resultado,textResultado);
                        new GraficoLagrange().GraficaFinal(componentesX,componentesY,panelGrafico);
                    }else Metodos.error("x debe estar entre "+componentesX[0]+" y "+componentesX[componentesX.length-1]);
                }while(_x<componentesX[0]||_x>componentesX[tam1-1]);
            }catch(Exception ex){
                Metodos.error(ex);
            }
        }
    }

}