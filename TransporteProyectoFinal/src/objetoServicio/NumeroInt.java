/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoServicio;

import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Gustavo
 */
public class NumeroInt {
    /*
     * Permite validar que los datos ingresados en un jTextField sean
     * solo datos numericos
     */

    public static void Validar(KeyEvent event) {
        char a = event.getKeyChar();

        if (!(a >= KeyEvent.VK_0 && a <= KeyEvent.VK_9 )) {
            event.consume();


        }
    }
       public static boolean Validar_B(KeyEvent event) {
        char a = event.getKeyChar();
        boolean r=false;

        if (!(a >= KeyEvent.VK_0 && a <= KeyEvent.VK_9 )) {
            event.consume();
            r= true;


        }
        return r;
    }
    /*
     * Permite validar el numero de carcteres en
     * un jTextField
     */

    public static void numeroCaracteres(JTextField jTextField1, int i, KeyEvent event) {
        if (jTextField1.getText().toString().length() == i) {
            event.consume();
        }


    }
     /*
     * Permite validar el numero de carcteres en
     * un jTextPane
     */

    public static void numeroCaracteres(JTextPane jTextPane1, int i, KeyEvent event) {
        if (jTextPane1.getText().toString().length() == i) {
            event.consume();
        }
}
 /*
     * Permite validar el numero de carcteres en
     * un jPaswordField
     */

    public static void numeroCaracteres(JPasswordField jp1, int i, KeyEvent event) {
        if (jp1.getText().toString().length() == i) {
            event.consume();
        }
}
}