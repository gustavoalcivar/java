/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;

public class Algoritmos extends javax.swing.JFrame {

    public Algoritmos() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuBusquedaBinaria = new javax.swing.JMenuItem();
        menuMediana = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCambio = new javax.swing.JMenuItem();
        menuMochila1 = new javax.swing.JMenuItem();
        menuMochila2 = new javax.swing.JMenuItem();
        menuAsignacion = new javax.swing.JMenuItem();
        menuCaballo = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuReinas = new javax.swing.JMenuItem();
        menuAsignacion2 = new javax.swing.JMenuItem();
        menuRey = new javax.swing.JMenuItem();
        menuLaberinto = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALGORITMOS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escudo2.jpg"))); // NOI18N

        jMenu1.setText("Divide y Vencerás");

        menuBusquedaBinaria.setText("Búsqueda Binaria");
        menuBusquedaBinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBusquedaBinariaActionPerformed(evt);
            }
        });
        jMenu1.add(menuBusquedaBinaria);

        menuMediana.setText("Mediana de dos Vectores");
        menuMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMedianaActionPerformed(evt);
            }
        });
        jMenu1.add(menuMediana);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ávidos");

        menuCambio.setText("Cambio de la Moneda");
        menuCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCambioActionPerformed(evt);
            }
        });
        jMenu2.add(menuCambio);

        menuMochila1.setText("Mochila Fraccionaria");
        menuMochila1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMochila1ActionPerformed(evt);
            }
        });
        jMenu2.add(menuMochila1);

        menuMochila2.setText("Mochila Entera");
        menuMochila2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMochila2ActionPerformed(evt);
            }
        });
        jMenu2.add(menuMochila2);

        menuAsignacion.setText("Asignación de Tareas");
        menuAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAsignacionActionPerformed(evt);
            }
        });
        jMenu2.add(menuAsignacion);

        menuCaballo.setText("Recorrido del Caballo de Ajedréz");
        menuCaballo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCaballoActionPerformed(evt);
            }
        });
        jMenu2.add(menuCaballo);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Vuelta Atrás");

        menuReinas.setText("n Reinas");
        menuReinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReinasActionPerformed(evt);
            }
        });
        jMenu3.add(menuReinas);

        menuAsignacion2.setText("Asignación de Tareas");
        menuAsignacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAsignacion2ActionPerformed(evt);
            }
        });
        jMenu3.add(menuAsignacion2);

        menuRey.setText("Recorrido del Rey de Ajedréz");
        menuRey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReyActionPerformed(evt);
            }
        });
        jMenu3.add(menuRey);

        menuLaberinto.setText("El Laberinto");
        menuLaberinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaberintoActionPerformed(evt);
            }
        });
        jMenu3.add(menuLaberinto);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBusquedaBinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBusquedaBinariaActionPerformed
        BusquedaBinaria bb = new BusquedaBinaria();
        dispose();
        bb.setVisible(true);
    }//GEN-LAST:event_menuBusquedaBinariaActionPerformed

    private void menuMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMedianaActionPerformed
        Mediana med = new Mediana();
        dispose();
        med.setVisible(true);
    }//GEN-LAST:event_menuMedianaActionPerformed

    private void menuCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCambioActionPerformed
        Cambio cam = new Cambio();
        dispose();
        cam.setVisible(true);
    }//GEN-LAST:event_menuCambioActionPerformed

    private void menuMochila1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMochila1ActionPerformed
        MochilaFraccionaria cam = new MochilaFraccionaria();
        dispose();
        cam.setVisible(true);
    }//GEN-LAST:event_menuMochila1ActionPerformed

private void menuMochila2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMochila2ActionPerformed
        MochilaEntera cam = new MochilaEntera();
        dispose();
        cam.setVisible(true);
}//GEN-LAST:event_menuMochila2ActionPerformed

private void menuAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAsignacionActionPerformed
        AsignacionTareas cam = new AsignacionTareas();
        dispose();
        cam.setVisible(true);
}//GEN-LAST:event_menuAsignacionActionPerformed

private void menuCaballoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCaballoActionPerformed
        Caballo cam = new Caballo();
        dispose();
        cam.setVisible(true);
}//GEN-LAST:event_menuCaballoActionPerformed

private void menuReinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReinasActionPerformed
        Reinas cam = new Reinas();
        dispose();
        cam.setVisible(true);
}//GEN-LAST:event_menuReinasActionPerformed

private void menuReyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReyActionPerformed
        Rey cam = new Rey();
        dispose();
        cam.setVisible(true);
}//GEN-LAST:event_menuReyActionPerformed

private void menuAsignacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAsignacion2ActionPerformed
        AsignacionTareasVueltaAtras bb = new AsignacionTareasVueltaAtras();
        dispose();
        bb.setVisible(true);
}//GEN-LAST:event_menuAsignacion2ActionPerformed

private void menuLaberintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaberintoActionPerformed
        Laberinto bb = new Laberinto();
        dispose();
        bb.setVisible(true);
}//GEN-LAST:event_menuLaberintoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuAsignacion;
    private javax.swing.JMenuItem menuAsignacion2;
    private javax.swing.JMenuItem menuBusquedaBinaria;
    private javax.swing.JMenuItem menuCaballo;
    private javax.swing.JMenuItem menuCambio;
    private javax.swing.JMenuItem menuLaberinto;
    private javax.swing.JMenuItem menuMediana;
    private javax.swing.JMenuItem menuMochila1;
    private javax.swing.JMenuItem menuMochila2;
    private javax.swing.JMenuItem menuReinas;
    private javax.swing.JMenuItem menuRey;
    // End of variables declaration//GEN-END:variables
}
