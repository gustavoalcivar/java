/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JTextArea;
import objetos.Lista;

public class Ordenamiento {
    public static void insercion(Lista lista, JTextArea area) {
        Utilidades.imprimirLista(lista, area);
        int temp, n = lista.tamaño();
        for(int i = 1; i < n; i++) {
            temp = lista.obtener(i);
            int j;
            for(j = i-1; j >= 0 && lista.obtener(j) > temp; j--) {
                area.append("\nIntercambia "+lista.obtener(j+1)+" por "+lista.obtener(j));
                lista.intercambio(j+1, j);
                
                Utilidades.imprimirLista(lista, area);
            }
        }
    }
    public static void burbula(Lista lista, JTextArea area) {
        Utilidades.imprimirLista(lista, area);
        int n = lista.tamaño();
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(lista.obtener(j) > lista.obtener(j+1)){
                    area.append("\nIntercambia "+lista.obtener(j)+" por "+lista.obtener(j+1));
                    lista.intercambio(j, j+1);
                    
                    Utilidades.imprimirLista(lista, area);
                }
            }
        }
    }

    public static void seleccion(Lista lista, JTextArea area) {
        Utilidades.imprimirLista(lista, area);
        int n = lista.tamaño();
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(lista.obtener(j) <= lista.obtener(i)) {
                    area.append("\nIntercambia "+lista.obtener(i)+" por "+lista.obtener(j));
                    lista.intercambio(i, j);
                    
                    Utilidades.imprimirLista(lista, area);
                }
            }
        }
    }
    public static void shell(Lista lista, JTextArea area) {
        Utilidades.imprimirLista(lista, area);
        int n = lista.tamaño();
        int k = n/2;
        boolean intercambio;
        do{
            intercambio = false;
            for(int i = 0; i < n-k; i++){
                if(lista.obtener(i) > lista.obtener(i+k)) {
                    area.append("\nIntercambia "+lista.obtener(i)+"por "+lista.obtener(i+k));
                    lista.intercambio(i, i+k);
                    intercambio = true;
                    
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
                area.append("\nIntercambia "+lista.obtener(i)+" por "+lista.obtener(j));
                lista.intercambio(i, j);
                i++;
                j--;
                
                Utilidades.imprimirLista(lista, area);
            }
        }while(i<=j);
        if(j > inf) quicksort(lista, inf, j, area);
        if(i < sup) quicksort(lista, i, sup, area);
    }
}