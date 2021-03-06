/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatosiii;

import javax.swing.JOptionPane;

/**
 *
 * @author GUSTAVO
 */
public class AdministrarRolesSystem extends javax.swing.JFrame {

    AdministrarRolesSystem() {
        initComponents();
        setLocationRelativeTo(null);
        listaRoles.removeAll();
        Conexion.login = UserPassword.userOriginal;
        Conexion.password = UserPassword.passOriginal;
        Consulta.realizarConsultaLista("select distinct granted_role from user_role_privs order by granted_role", listaRoles);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPrivilegios = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botNuevoRol = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRoles = new javax.swing.JList();
        botQuitarPriv = new javax.swing.JButton();
        panelNuevoPriv = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPrivAgregar = new javax.swing.JList();
        botonAgregarPrivilegio = new javax.swing.JButton();
        botEliminarRol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRAR ROLES (SYSTEM)");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 90, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRAR ROLES (SYSTEM)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, -1));

        listaPrivilegios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPrivilegiosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPrivilegios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 410, 190));

        jLabel3.setText("Privilegios y roles");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel4.setText("Roles");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        botNuevoRol.setText("Nuevo rol");
        botNuevoRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNuevoRolActionPerformed(evt);
            }
        });
        getContentPane().add(botNuevoRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, -1));

        listaRoles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " ", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaRoles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaRolesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaRoles);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 340, 150));

        botQuitarPriv.setText("Quitar rol o privilegio");
        botQuitarPriv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botQuitarPrivActionPerformed(evt);
            }
        });
        getContentPane().add(botQuitarPriv, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 160, -1));

        panelNuevoPriv.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar rol o privilegio"));
        panelNuevoPriv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaPrivAgregar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPrivAgregarValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaPrivAgregar);

        panelNuevoPriv.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 21, -1, 170));

        botonAgregarPrivilegio.setText("Agregar rol o privilegio");
        botonAgregarPrivilegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPrivilegioActionPerformed(evt);
            }
        });
        panelNuevoPriv.add(botonAgregarPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        getContentPane().add(panelNuevoPriv, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 370, 240));

        botEliminarRol.setText("Eliminar rol");
        botEliminarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEliminarRolActionPerformed(evt);
            }
        });
        getContentPane().add(botEliminarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaRolesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaRolesValueChanged
        listaRoles.removeAll();
        Consulta.realizarConsultaLista("select privilege from role_sys_privs where role='"
                + listaRoles.getSelectedValue()
                + "' union select granted_role from dba_role_privs where grantee='" + listaRoles.getSelectedValue() + "'"
                + " union select privilege from dba_sys_privs where grantee='" + listaRoles.getSelectedValue() + "'", listaPrivilegios);
        Consulta.realizarConsultaLista("select distinct privilege from role_sys_privs "
                + "union select distinct grantee from dba_sys_privs", listaPrivAgregar);
    }//GEN-LAST:event_listaRolesValueChanged

    private void listaPrivilegiosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPrivilegiosValueChanged

    }//GEN-LAST:event_listaPrivilegiosValueChanged

    private void botQuitarPrivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botQuitarPrivActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de revocar este rol o privilegio", "REVOCAR ROL O PRIVILEGIO", 2);
        if (opcion == 0) {
            Consulta.realizarConsulta("revoke " + listaPrivilegios.getSelectedValue() + " from " + listaRoles.getSelectedValue());
            Consulta.realizarConsultaLista("select privilege from role_sys_privs where role='"
                    + listaRoles.getSelectedValue()
                    + "' union select granted_role from dba_role_privs where grantee='" + listaRoles.getSelectedValue() + "'", listaPrivilegios);
            Consulta.realizarConsultaLista("select distinct privilege from role_sys_privs "
                    + "union select distinct grantee from dba_sys_privs", listaPrivAgregar);
        }

    }//GEN-LAST:event_botQuitarPrivActionPerformed

    private void listaPrivAgregarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPrivAgregarValueChanged

    }//GEN-LAST:event_listaPrivAgregarValueChanged

    private void botonAgregarPrivilegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPrivilegioActionPerformed
        Consulta.realizarConsulta("grant " + listaPrivAgregar.getSelectedValue() + " to " + listaRoles.getSelectedValue());
        Consulta.realizarConsultaLista("select privilege from role_sys_privs where role='"
                + listaRoles.getSelectedValue()
                + "' union select granted_role from dba_role_privs where grantee='" + listaRoles.getSelectedValue() + "'", listaPrivilegios);
        Consulta.realizarConsultaLista("select distinct privilege from role_sys_privs "
                + "union select distinct grantee from dba_sys_privs", listaPrivAgregar);
    }//GEN-LAST:event_botonAgregarPrivilegioActionPerformed

    private void botNuevoRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNuevoRolActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo rol", "NUEVO ROL", 3);
        if (!nombre.trim().equals("")) {
            Consulta.realizarConsulta("create role " + nombre);
            Consulta.realizarConsultaLista("select privilege from role_sys_privs where role='" + listaRoles.getSelectedValue() + "' order by privilege", listaPrivilegios);
            Consulta.realizarConsultaLista("select distinct privilege from role_sys_privs "
                    + "union select distinct grantee from dba_sys_privs", listaPrivAgregar);
            Consulta.realizarConsultaLista("select distinct granted_role from user_role_privs order by granted_role", listaRoles);
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el nuevo rol", "ERROR", 0);
        }
    }//GEN-LAST:event_botNuevoRolActionPerformed

    private void botEliminarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEliminarRolActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de revocar este rol", "ELIMINAR ROL", 2);
        if (opcion == 0) {
            Consulta.realizarConsulta("drop role " + listaRoles.getSelectedValue());
            Consulta.realizarConsultaLista("select privilege from role_sys_privs where role='" + listaRoles.getSelectedValue() + "' order by privilege", listaPrivilegios);
            Consulta.realizarConsultaLista("select distinct privilege from role_sys_privs "
                    + "union select distinct grantee from dba_sys_privs", listaPrivAgregar);
            Consulta.realizarConsultaLista("select distinct granted_role from user_role_privs order by granted_role", listaRoles);
        }
    }//GEN-LAST:event_botEliminarRolActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Administrador ad = new Administrador();
        dispose();
        ad.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botEliminarRol;
    private javax.swing.JToggleButton botNuevoRol;
    private javax.swing.JButton botQuitarPriv;
    private javax.swing.JButton botonAgregarPrivilegio;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaPrivAgregar;
    private javax.swing.JList listaPrivilegios;
    private javax.swing.JList listaRoles;
    private javax.swing.JPanel panelNuevoPriv;
    // End of variables declaration//GEN-END:variables

}
