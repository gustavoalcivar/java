/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JTextArea;
import objetos.Lista;


public class Ordenamiento {
    public static void insercion(Lista lista, JTextArea area) {
        int n = lista.tamaño();
   for (int i = 1; i <= n; i++) {
       int v = lista.obtener(i);
       area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Extrae el número "+lista.obtener(i)+" (pos "+i+")");
       ventanas.Ordenamiento.numOp++;
       int j = i - 1;
       while (j >= 0 && lista.obtener(j) > v){
           lista.establecer(j+1, lista.obtener(j));
           area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Coloca el número "+lista.obtener(j)+" en la poscición "+(j+1));
           
           j--;
           ventanas.Ordenamiento.numOp++;
           Utilidades.imprimirLista(lista, area);
        }
       area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Coloca el número "+lista.obtener(j)+" en la poscición "+(j+1));
       lista.establecer(j+1, v);
       ventanas.Ordenamiento.numOp++;
           Utilidades.imprimirLista(lista, area);
       
   }
    }
    public static void burbula(Lista lista, JTextArea area) {
         
        for(int i=lista.tamaño();i>=0;i--){
            for(int j=0;j<i;j++){
                if(lista.obtener(j)>lista.obtener(j+1)){
                    int temp=lista.obtener(j);
                    area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Intercambia "+lista.obtener(j)+" (pos "+j+") por "+lista.obtener(j+1)+" (pos "+(j+1)+")");
                    lista.establecer(j, lista.obtener(j+1));
                    lista.establecer(j+1, temp);
                    ventanas.Ordenamiento.numOp++;
           Utilidades.imprimirLista(lista, area);
                }
            }
        }
    }

    public static void seleccion(Lista lista, JTextArea area) {
        
        for(int i=0;i<lista.tamaño();i++){
            for(int j=i+1;j<=lista.tamaño();j++){
                if(lista.obtener(j)<=lista.obtener(i)){
                    int temp=lista.obtener(i);
                    area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Intercambia "+lista.obtener(i)+" (pos "+i+") por "+lista.obtener(j)+" (pos "+j+")");
                    lista.establecer(i, lista.obtener(j));
                    lista.establecer(j, temp);
                    ventanas.Ordenamiento.numOp++;
           Utilidades.imprimirLista(lista, area);
                }
            }
        }
        
    }
    public static void shell(Lista lista, JTextArea area) {
        int n = lista.tamaño();
        int k = n/2;
        boolean intercambio;
        do{
            intercambio = false;
            for(int i = 0; i < n-k; i++){
                if(lista.obtener(i) > lista.obtener(i+k)) {
                    area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Intercambia "+lista.obtener(i)+" (pos "+i+") por "+lista.obtener(i+k)+" (pos "+(i+k)+")");
                    lista.intercambio(i, i+k);
                    intercambio = true;
                    ventanas.Ordenamiento.numOp++;
                    Utilidades.imprimirLista(lista, area);
                }
            }
            if(!intercambio) {
                k = k/2;
            }
        } while(intercambio || k >= 1);
    }
    public static void quicksort(Lista lista, int inf, int sup, JTextArea area) {
        int i = inf, j = sup, pivot = lista.obtener(sup);
        do {
            while(lista.obtener(i) < pivot && i < sup) i++;
            while(lista.obtener(j) > pivot && j > inf) j--;
            if(i <= j){
                area.append("\n\n"+ventanas.Ordenamiento.numOp+"---> Intercambia "+lista.obtener(i)+" (pos "+i+") por "+lista.obtener(j)+" (pos "+j+")");
                lista.intercambio(i, j);
                i++;
                j--;
                ventanas.Ordenamiento.numOp++;
                Utilidades.imprimirLista(lista, area);
            }
        }while(i<=j);
        if(j > inf) quicksort(lista, inf, j, area);
        if(i < sup) quicksort(lista, i, sup, area);
    }
}