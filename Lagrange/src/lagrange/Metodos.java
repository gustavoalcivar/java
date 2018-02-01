/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lagrange;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author gustavo
 */
public class Metodos {

    public static double[] llenarVectorAleatorio(int tamaño){
        double x[]=new double[tamaño];
        double signo;
        for(int i=0;i<x.length;i++){
            signo=Math.random();
            if(signo<0.5)signo=-1;
            else signo=1;
            x[i]=signo*Math.random()*100;
        }
        return x;
    }

    

    public static void imprimirVector(double vec[],JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs);//número de cifras después del punto decimal
        area.setText("");
        for(int i=0;i<vec.length;i++){
            area.append(df.format(vec[i])+"\t");
            
        }
    }


    public static void imprimirResultado(double resultado,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.0000",dfs);        
        area.setText("");
        area.append(String.valueOf(df.format(resultado)));
    }
 
    public static void error(Exception ex) {
        JOptionPane.showMessageDialog(null,ex,"ERROR",0);
    }
    public static void error(String er) {
        JOptionPane.showMessageDialog(null,"Error en los datos de entrada\n"+er,"ERROR",0);
    }

    /*Éste método verifica que no hayan caracteres no válidos en un vector*/
    public static boolean validarVector(String texto) {
        if(texto.equals(""))return false;
        for(int i=0;i<texto.length();i++){
            if(!Character.isDigit(texto.charAt(i))&&!texto.substring(i,i+1).equals(" ")
                    &&!texto.substring(i,i+1).equals(".")
                    &&!texto.substring(i,i+1).equals("-")
                    &&!texto.substring(i,i+1).equals("\t"))return false;
        }
        return true;
    }

    /*Éste método tranforma una linea de texto en un vector*/
    public static double[] leerVector(String texto){
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
   
    /*Elimina las lineas vacias que estén de más en el textArea*/
    public static void validarTextArea(JTextArea area){
        String texto=area.getText();
        texto=texto.trim();
        area.setText(texto);
    }
   
    /*Quita todos los espacios de un texto, también los intermedios*/
  
   

    public static double interpolacionLagrange(double x[],double y[],double _x){
        int n=x.length;
        double L[]=new double[n],resultado=0;
        for(int i=0;i<n;i++){
            L[i]=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    L[i]=L[i]*(_x-x[j])/(x[i]-x[j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            resultado+=y[i]*L[i];
        }
        return resultado;
    }
    public static void burbuja(double a[]){
        int n=a.length-1;
        for(int i=n;i>=0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    double temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static boolean estaOrdenado(double a[]){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1])return false;
        }
        return true;
    }

    static boolean tieneElementosRepetidos(double x[]) {
        int n=x.length;
        for(int i=0;i<n-1;i++){
            if(x[i]==x[i+1])return true;
        }
        return false;
    }
}
