/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JTextArea;
import objetos.Lista;
import objetos.Nodo;

public class Utilidades {
    public static void imprimirLista(Lista lista, JTextArea area) {
        // Imprime la lista en el área de texto
        Nodo nodo = lista.primero;
        area.append("\n");
        while(nodo != null){
            area.append(nodo.valor+" ");
            nodo = nodo.siguiente;
        }
    }
}
