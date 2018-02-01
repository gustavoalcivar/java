/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatosiii;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author GUSTAVO
 */
public class Conexion {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    static String bd = "XE";
    
    public static String login;
    public static String password;
    public static String url = "jdbc:oracle:thin:@localhost:1521:XE";

    public static Connection enlace(Connection conn) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" + ex, 0);
        }
        return conn;
    }

    public static Statement sta(Statement st) throws SQLException {
        conn = enlace(conn);
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st;
    }

    public static ResultSet consulta(ResultSet rs, String consul) throws SQLException {
        st = sta(st);
        rs = st.executeQuery(consul);
        return rs;
    }
}
