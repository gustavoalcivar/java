/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class Nodo {
    public int valor; // Valor que contiene el nodo
    //public int posicion; // Posición del nodo en la lista
    public Nodo siguiente; // Referencia al elemento siguiente
    public Nodo anterior; // Referencia al elemento anterior
    
    public Nodo() {// Constructor
        anterior = null;
        siguiente = null;
    } 
    
    public Nodo(int val){
        this.valor = val;
    }
}
