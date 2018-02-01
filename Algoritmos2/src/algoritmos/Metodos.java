/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import javax.swing.JTextArea;

public class Metodos {
    public static int[] llenarArregloAleatorio(int n, int min, int max) {
        int a[] = new int[n];
        max++;
        for(int i = 0; i < n; i++){
            a[i] = (int)((Math.random()*(max-min))+min);
        }
        return a;
    }
    
    public static int[] leerArreglo(JTextArea area) {
            /*Éste método tranforma una linea de texto en un vector*/
        if(area.getLineCount() == 1){
            String texto = area.getText();
            texto=Metodos.quitarEspaciosVector(texto);//se quitan los espacios que están de más
            texto=texto+" ";
            int vec[];
            String vecS[],elemento="";/*vecS es un vector de cadenas donde cada elemento es un número
                                        elemento es cada número encontrado el la cadena*/
            int n=contarElementos(texto);//cuenta el número de elmentos que tiene el vector
            int pos=0;//posiciones del vector final 
            vec=new int[n];
            vecS=new String[n];
            for(int i=0;i<texto.length();i++){
                if(!texto.substring(i,i+1).equals(" "))//recorre la cadena hasta que encuentre una separación de elementos
                    elemento=elemento+texto.substring(i,i+1);//va aumentando los caracteres del elemento
                else{
                    vecS[pos]=elemento;/*cuando encuentra un espacio vacio, significa que acabó el número,
                     entonces lo guarda en vecS*/
                    pos++;
                    elemento="";//reinicia la cedena elemento para leer un nuevo número
                }
            }
            for(int i=0;i<n;i++){
                if(!vecS[i].equals(" ")){
                    vec[i]=Integer.parseInt(vecS[i]);/*tranforma cada elemento del vector de cadenas en números,
                                                        y los almacena en elvector que se va a devolver*/ 
                }
            }
            return vec;
        } else return null;
    }
    
        public static int[] leerArreglo2(String texto) {
            /*Éste método tranforma una linea de texto en un vector*/
        
            texto=quitarEspaciosVector(texto);//se quitan los espacios que están de más
            texto=texto+" ";
            int vec[];
            String vecS[],elemento="";/*vecS es un vector de cadenas donde cada elemento es un número
                                        elemento es cada número encontrado el la cadena*/
            int n=contarElementos(texto);//cuenta el número de elmentos que tiene el vector
            int pos=0;//posiciones del vector final 
            vec=new int[n];
            vecS=new String[n];
            for(int i=0;i<texto.length();i++){
                if(!texto.substring(i,i+1).equals(" "))//recorre la cadena hasta que encuentre una separación de elementos
                    elemento=elemento+texto.substring(i,i+1);//va aumentando los caracteres del elemento
                else{
                    vecS[pos]=elemento;/*cuando encuentra un espacio vacio, significa que acabó el número,
                     entonces lo guarda en vecS*/
                    pos++;
                    elemento="";//reinicia la cedena elemento para leer un nuevo número
                }
            }
            for(int i=0;i<n;i++){
                if(!vecS[i].equals(" ")){
                    vec[i]=Integer.parseInt(vecS[i]);/*tranforma cada elemento del vector de cadenas en números,
                                                        y los almacena en elvector que se va a devolver*/ 
                }
            }
            return vec;
        
    }
        
        /*Éste método verifica que no hayan caracteres no válidos en una matrizr*/
    public static boolean validarMatriz(JTextArea area) {
        String texto=area.getText();
        String lista[]=texto.split("\n");
        if(texto.equals(""))return false;
        for(int i=0;i<lista.length;i++){
            lista[i]=Metodos.quitarEspaciosVector(lista[i]);
        }
        int columnas=Metodos.contarElementos(lista[0]);
        for(int i=0;i<lista.length;i++){
            if(columnas!=Metodos.contarElementos(lista[i]))return false;
        }
        for(int i=0;i<texto.length();i++){
            if(!Character.isDigit(texto.charAt(i))&&!texto.substring(i,i+1).equals(" ")
                    &&!texto.substring(i,i+1).equals(".")
                    &&!texto.substring(i,i+1).equals("-")
                    &&!texto.substring(i,i+1).equals("\n")
                    &&!texto.substring(i,i+1).equals("\t"))return false;
        }
        return true;
    }
    
        public static void imprimirMatriz(int mat[][],int filas,int columnas,JTextArea area){
        area.setText("");
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                area.append(mat[i][j]+"     ");
            }
            area.append("\n");
        }
    }
            public static void imprimirMatriz2(int mat[][],int filas,int columnas,JTextArea area){
        area.setText("");
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                area.append(mat[i][j]+"\t");
            }
            area.append("\n");
        }
    }
        /*Éste método lee la matriz que esté escrita en el textArea*/
    public static int[][] leerMatriz(JTextArea area){
        int filas=area.getLineCount();//cuenta las lineas el textArea para saber el número de filas
        String lista[]=area.getText().split("\n");/*guarda cada fila del textArea en el vector lista,
                                                    split("\n") es para separar los elementos del vector lista
                                                    cada vez que encuentre un salto de linea*/
        for(int i=0;i<lista.length;i++){
            lista[i]=Metodos.quitarEspaciosVector(lista[i]);//quita los espacios que estén de más
        }
        int columnas=Metodos.contarElementos(lista[0])+1;//establece el número de columnas
        int vec[];
        int mat[][]=new int[filas][columnas];
        for(int i=0;i<filas;i++){    
            vec=leerArreglo2(lista[i]);/*cada linea del vector lista corresponede a una fila de la matriz,
                                        y se guarda en el vector vec*/
            for(int j=0;j<columnas;j++){
                mat[i][j]=vec[j];//el vector vec se transforma en la fila i de la matriz
            }
        }
        return mat;
    }
    public static int contarColumnas(JTextArea area) {
        String lista[]=area.getText().split("\n");/*guarda cada fila del textArea en el vector lista,
                                                    split("\n") es para separar los elementos del vector lista
                                                    cada vez que encuentre un salto de linea*/
        for(int i=0;i<lista.length;i++){
            lista[i]=Metodos.quitarEspaciosVector(lista[i]);//quita los espacios que estén de más
        }
        int columnas=Metodos.contarElementos(lista[0])+1;//establece el número de columnas
        return columnas;
    }
        public static double[] leerArregloDoble(JTextArea area) {
            /*Éste método tranforma una linea de texto en un vector*/
        if(area.getLineCount() == 1){
            String texto = area.getText();
            texto=Metodos.quitarEspaciosVector(texto);//se quitan los espacios que están de más
            texto=texto+" ";
            double vec[];
            String vecS[],elemento="";/*vecS es un vector de cadenas donde cada elemento es un número
                                        elemento es cada número encontrado el la cadena*/
            int n=contarElementos(texto);//cuenta el número de elmentos que tiene el vector
            int pos=0;//posiciones del vector final 
            vec=new double[n];
            vecS=new String[n];
            for(int i=0;i<texto.length();i++){
                if(!texto.substring(i,i+1).equals(" "))//recorre la cadena hasta que encuentre una separación de elementos
                    elemento=elemento+texto.substring(i,i+1);//va aumentando los caracteres del elemento
                else{
                    vecS[pos]=elemento;/*cuando encuentra un espacio vacio, significa que acabó el número,
                     entonces lo guarda en vecS*/
                    pos++;
                    elemento="";//reinicia la cedena elemento para leer un nuevo número
                }
            }
            for(int i=0;i<n;i++){
                if(!vecS[i].equals(" ")){
                    vec[i]=Double.parseDouble(vecS[i]);/*tranforma cada elemento del vector de cadenas en números,
                                                        y los almacena en elvector que se va a devolver*/ 
                }
            }
            return vec;
        } else return null;
    }
    
        /*Éste método cuenta los elementos de una cadena que corresponde a un vector*/
    public static int contarElementos(String texto) {
        int n=0;
        for(int i=0;i<texto.length();i++){
            if(texto.substring(i,i+1).equals(" ")){
                n++;/*se incrementa cuando encuentra un espacio vacio,
                     por que esto indica se se acabó un elemento y empieza otro*/
            }
        }
        return n;
    }
    
        /*Método para eliminar los espacios de más de un texto*/
    public static String quitarEspaciosVector(String texto){
        texto=texto.replaceAll("\t"," ").trim();//Quita las tabulaciones y mantiene un único espacio
        texto=texto.replaceAll(" +"," ").trim();//Quita los espacios primero y ultimo y mantiene un único espacio al medio
        return texto;
    }
    
    public static void imprimirArreglo(int a[], JTextArea area) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            area.append(a[i]+"     ");
        }
    }
    
    public static boolean estaOrdenado(int a[]){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1])return false;
        }
        return true;
    }
    
    public static void shell(int a[]){
    int k=a.length/2;
    boolean inter;
    do{
        inter=false;
        for(int i=0;i<a.length-k;i++){
            if(a[i]>a[i+k]){
                int temp=a[i+k];
                a[i+k]=a[i];
                a[i]=temp;
                inter=true;
            }
        }
        if(!inter)k=k/2;
        }while(inter||k>=1);
    }
    
    public static void shellDouble(double a[]){
    int k=a.length/2;
    boolean inter;
    do{
        inter=false;
        for(int i=0;i<a.length-k;i++){
            if(a[i]>a[i+k]){
                double temp=a[i+k];
                a[i+k]=a[i];
                a[i]=temp;
                inter=true;
            }
        }
        if(!inter)k=k/2;
        }while(inter||k>=1);
    }
    
        public static void shellElementosMochila(ElementoMochila a[]){
    int k=a.length/2;
    boolean inter;
    do{
        inter=false;
        for(int i=0;i<a.length-k;i++){
            if(a[i].beneficio/a[i].peso < a[i+k].beneficio/a[i+k].peso) {
                ElementoMochila temp=a[i+k];
                a[i+k]=a[i];
                a[i]=temp;
                inter=true;
            }
        }
        if(!inter)k=k/2;
        }while(inter||k>=1);
    }
    
    public static int min(int a,int b){
        if(a>=b){
            return b;
        }else{
            return a;
        }
    }

    public static int max(int a,int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }
/*Elimina las lineas vacias que estén de más en el textArea*/
    public static void validarTextArea(JTextArea area){
        String texto=area.getText();
        texto=texto.trim();
        area.setText(texto);
    }
}
