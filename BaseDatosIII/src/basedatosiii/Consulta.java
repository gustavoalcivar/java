/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatosiii;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUSTAVO
 */
public class Consulta {

    private static Connection conn = null;
    private static ResultSet rs = null;
//Realiza una consulta el la base de datos
    public static void realizarConsulta(String consult) {
        try {
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
    }
//Realiza una consulta el la base de datos y devuelve verdadero si la consulta se realizó correctamente
    public static boolean realizarConsultaBoolean(String consult) {
        boolean exito = true;
        try {
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }
//Realiza una consulta el la base de datos y muestra los latos en una JTable
    public static void realizarConsultaTabla(String consult, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        try {
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            ResultSetMetaData rsMd = rs.getMetaData();
            int col = rsMd.getColumnCount();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[col];
                for (int i = 0; i < col; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
    }
//Realiza una consulta el la base de datos y muestra los datos en un JList
    public static void realizarConsultaLista(String consult, JList lista) {
        try {
            DefaultListModel modelo = new DefaultListModel();
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            while (rs.next()) {
                Object[] fila = new Object[1];
                fila[0] = rs.getObject(1);
                modelo.addElement(fila[0]);
            }
            lista.setModel(modelo);
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
    }
//Obtiene los tipos de datos de las columnas de una consulta
    public static String[] obtenerTiposDeDatosConsulta(String consult) {
        String columnasLabels[] = null;
        try {
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            ResultSetMetaData rsMd = rs.getMetaData();
            int col = rsMd.getColumnCount();
            columnasLabels = new String[col];
            for (int i = 0; i < col; i++) {
                columnasLabels[i] = rsMd.getColumnTypeName(i + 1);
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
        return columnasLabels;
    }
//Obtiene los nombres de las columnas de una consulta
    public static String[] obtenerNombresColumnasConsulta(String consult) {
        String columnasLabels[] = null;
        try {
            conn = Conexion.enlace(conn);
            rs = Conexion.consulta(rs, consult);
            ResultSetMetaData rsMd = rs.getMetaData();
            int col = rsMd.getColumnCount();
            columnasLabels = new String[col];
            for (int i = 0; i < col; i++) {
                columnasLabels[i] = rsMd.getColumnLabel(i + 1);
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
        return columnasLabels;
    }
}
