/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class Lista {
    public Nodo primero; // Referencia al último elemento de la lista
    private int numElementos; // Número de elementos que tiene la lista
    
    public Lista() { // Constructor
        primero = null;
        numElementos = 0;
    }
     
     public int tamaño() {
         return numElementos;
     }
     
     public Lista insertarPrimero(int val) {
         Nodo nuevo = new Nodo(val);
         nuevo.siguiente = primero;
         if(primero != null) {
             primero.anterior = nuevo;
         }
         primero = nuevo;
         numElementos ++;
         return this;
     }
     
     public Lista insertarDespues(int pos, int val) {
         Nodo nuevo = new Nodo(val);
         Nodo nodo = buscar(pos);
         nuevo.siguiente = nodo.siguiente;
         if(nodo.siguiente != null) {
             nodo.siguiente.anterior = nuevo;
         }
         nodo.siguiente = nuevo;
         nuevo.anterior = nodo;
         numElementos++;
         return this;
     }
     
     public int obtener(int i) { // Obtiene el valor del nodo de la posición i
         Nodo buscado;
         buscado = buscar(i);
         return buscado.valor;
     }
     
     public void establecer(int pos, int val) { // Establece el valor val en el nodo de la posicion pos
         Nodo nodo;
         nodo = buscar(pos);
         nodo.valor = val;
     }

    public Nodo buscar(int pos) { // Busca el nodo de la posición pos
        Nodo nodo = primero;
        int i = 0;
        while(i < pos) {
            if(nodo.siguiente != null) {
                nodo = nodo.siguiente;
            }
            i++;
        }
        return nodo;
    }
    
    public void intercambio(int i, int j) {
        // Intercambia el nodo de la posición i con el de la posición j
        Nodo nodo1 = buscar(i);
        Nodo nodo2 = buscar(j);
        
        insertarDespues(i, nodo2.valor);
        borrar(i);
        
        insertarDespues(j, nodo1.valor);
        borrar(j);
    }
    
    public void borrar(int pos) {
        // Elimina el nodo de la posición pos
        Nodo nodo = buscar(pos);
        if(nodo == primero) {
            primero = nodo.siguiente;
            if(nodo.siguiente != null){
                nodo.siguiente.anterior = null;
            }
        } else if(nodo.siguiente != null) {
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        } else {
            nodo.anterior.siguiente = null;
        }
        numElementos--;
    }
}
