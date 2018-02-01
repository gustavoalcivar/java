/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisNumerico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author gustavo
 */
public class Metodos {
    /*Este método lee el archivo linea por linea y almacena los datos en un vector.
     Este método es llamado al iniciar el programa en la pantalla inicio*/
    public static double[] leerArchivo(){
        File archivo = new File ("numeros.txt");//Archivo que contiene los números
        double vec[]=null;//Vector que va ha almacenar los datos del archivo
        try{
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String aux=br.readLine();//aux contiene la siguiente linea del archivo
            String linea="";//linea va ha contener todos los datos del archivo
            while(aux != null){
                linea=linea+" "+aux;//a la cadena linea se le aumenta la nueva linea del archivo
                aux=br.readLine();//se lee una nueva linea del archivo
            }
            linea=linea.replaceAll("\t"," ");//Quita las tabulaciones y mantiene un único espacio
            linea=linea.replaceAll("\n"," ");//Quita los saltos de linea y mantiene un único espacio
            linea=linea.replaceAll(" +"," ");//Quita los espacios primero y ultimo y mantiene un único espacio al medio
            vec=leerVector(linea);//se llena vec con los datos de la cadena linea que ya contiene todos los datos del archivo
            br.close();
        }catch(Exception ex){
            error(ex);
        }
        return vec;
    }
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
    public static double[] llenarVectorArchivo(int tamaño){
        double x[]=new double[tamaño];
        for(int i=0;i<x.length;i++){
            if(Inicio.posArchivo==Inicio.vecArchivo.length){//si se llegó al final del archivo, se regresa al inicio
                Inicio.posArchivo=0;
            }
            x[i]=Inicio.vecArchivo[Inicio.posArchivo];
            Inicio.posArchivo++;
        }
        return x;
    }
    public static double[][] llenarMatrizAleatorio(int filas,int columnas){
        double x[][]=new double[filas][columnas];
        double signo;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                signo=Math.random();
                if(signo<0.5)signo=-1;
                else signo=1;
                x[i][j]=signo*Math.random()*100;
            }
        }
        return x;
    }
    public static double[][] llenarMatrizArchivo(int filas,int columnas){
        double x[][]=new double[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if(Inicio.posArchivo==Inicio.vecArchivo.length){//si se llegó al final del archivo, se regresa al inicio
                    Inicio.posArchivo=0;
                }
                x[i][j]=Inicio.vecArchivo[Inicio.posArchivo];
                Inicio.posArchivo++;
                
            }
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
    public static void imprimirVectorEntero(int vec[],JTextArea area){
        area.setText("");
        for(int i=0;i<vec.length;i++){
            area.append(vec[i]+"");
            
        }
    }
    public static void imprimirMatriz(double mat[][],int filas,int columnas,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs); //número de cifras después del punto decimal       
        area.setText("");
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                area.append(df.format(mat[i][j])+"\t");
            }
            area.append("\n");
        }
    }
    public static void imprimirMatriz2(double mat[][],int filas,int columnas,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs); //número de cifras después del punto decimal       
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                area.append(df.format(mat[i][j])+"\t");
            }
            area.append("\n");
        }
    }
    public static void imprimirResultado(double resultado,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.0000",dfs);        
        area.setText("");
        area.append(String.valueOf(df.format(resultado)));
    }
    public static double[] escalarVector(double a,double x[]){
        for(int i=0;i<x.length;i++)x[i]=x[i]*a;
        return x;
    }
    public static void error(Exception ex) {
        JOptionPane.showMessageDialog(null,ex,"ERROR",0);
    }
    public static void error(String er) {
        JOptionPane.showMessageDialog(null,"Error en los datos de entrada\n"+er,"ERROR",0);
    }
    public static void errorArchivo() {
        JOptionPane.showMessageDialog(null,"Error en los datos de entrada\n"
                + "No se encontró el archivo numeros.txt en la carpeta del proyecto\n"
                + "O el archivo contiene datos no numéricos","ERROR",0);
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
    /*Éste método lee la matriz que esté escrita en el textArea*/
    public static double[][] leerMatriz(JTextArea area){
        int filas=area.getLineCount();//cuenta las lineas el textArea para saber el número de filas
        String lista[]=area.getText().split("\n");/*guarda cada fila del textArea en el vector lista,
                                                    split("\n") es para separar los elementos del vector lista
                                                    cada vez que encuentre un salto de linea*/
        for(int i=0;i<lista.length;i++){
            lista[i]=Metodos.quitarEspaciosVector(lista[i]);//quita los espacios que estén de más
        }
        int columnas=Metodos.contarElementos(lista[0])+1;//establece el número de columnas
        double vec[];
        double mat[][]=new double[filas][columnas];
        for(int i=0;i<filas;i++){    
            vec=leerVector(lista[i]);/*cada linea del vector lista corresponede a una fila de la matriz,
                                        y se guarda en el vector vec*/
            for(int j=0;j<columnas;j++){
                mat[i][j]=vec[j];//el vector vec se transforma en la fila i de la matriz
            }
        }
        return mat;
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
    /*Éste método es para leer los números binarios y octales que no tienen espacios entre los elementos*/
    public static int[] leerVectorEntero(String texto){
        texto=Metodos.quitarEspaciosVectorTodos(texto);
        int n=texto.length();
        int vec[]=new int[n];
        for(int i=0;i<n;i++){
            vec[i]=Integer.parseInt(texto.substring(i,i+1));
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
    public static double normaEuclideana(double x[]){
        double norma=0;
        for(int i=0;i<x.length;i++)
            norma=norma+Math.pow(x[i],2);
        norma=Math.pow(norma,0.5);
        return norma;
    }
    public static double[] sumaVectores(double x[],double y[]){
        double z[]=new double[x.length];
        for(int i=0;i<x.length;i++){
            z[i]=x[i]+y[i];
        }
        return z;
    }
    public static double productoPunto(double x[],double y[]){
        double resultado=0;
        for(int i=0;i<x.length;i++)
            resultado=resultado+x[i]*y[i];
        return resultado;
    }
    public static double[][] sumaMatrices(double a[][],double b[][],int filas,int columnas){
        double c[][];
        c=new double[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }
    /*Método para eliminar los espacios de más de un texto*/
    public static String quitarEspaciosVector(String texto){
        texto=texto.replaceAll("\t"," ").trim();//Quita las tabulaciones y mantiene un único espacio
        texto=texto.replaceAll(" +"," ").trim();//Quita los espacios primero y ultimo y mantiene un único espacio al medio
        return texto;
    }
    public static double[][] multiplicaciónMatrices(double a[][],double b[][],
            int filas1,int columnas1,int filas2,int columnas2){
        double c[][];
        c=new double[filas1][columnas2];
        for(int i=0;i<filas1;i++){
            for(int j=0;j<columnas2;j++){
                c[i][j]=0;
            }
        }
        for(int i=0;i<filas1;i++){
            for(int j=0;j<columnas2;j++){
                for(int k=0;k<columnas1;k++){
                    c[i][j]=c[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    /*Elimina las lineas vacias que estén de más en el textArea*/
    public static void validarTextArea(JTextArea area){
        String texto=area.getText();
        texto=texto.trim();
        area.setText(texto);
    }
    public static double ánguloEntreVectores(double x[],double y[]){
        return Math.toDegrees(Math.acos((productoPunto(x,y))/(normaEuclideana(x)*normaEuclideana(y))));
    }
    public static double[] baseOrtogonal1(double x[],double y[]){
        double lambda=productoPunto(x,y)/Math.pow(normaEuclideana(y),2);
        return escalarVector(lambda,y);
    }
    public static double[] baseOrtogonal2(double x[],double y[]){
        double c[],c1[],c2[];
        c1=escalarVector(productoPunto(x,y)/Math.pow(normaEuclideana(y),2),y);
        c2=escalarVector(-1,c1);
        c=sumaVectores(x,c2);
        return c;
    }
    public static int[] decimalABaseX(int M,int x){
        int n=-1;
        do{
            n++;
        }while(!(Math.pow(x,n)<=M && Math.pow(x,n+1)>M));
        int[] r=new int[n+1];
        for(int i=0;i<n+1;i++){
            r[i]=M%x;
            M=(M-r[i])/x;
        }
        return r; 
    }
    public static void imprimirExadecimal(int x[],JTextArea area){
        area.setText("");
        for(int i=x.length-1;i>=0;i--){
            if(x[i]<10){
                area.append(String.valueOf(x[i]));
            }else{
                switch(x[i]){
                    case 10:
                        area.append("A");
                        break;
                    case 11:
                        area.append("B");
                        break;
                    case 12:
                        area.append("C");
                        break;
                    case 13:
                        area.append("D");
                        break;
                    case 14:
                        area.append("E");
                        break;
                    case 15:
                        area.append("F");
                        break;
                }
            }
        }
    }
    public static int horner(int a[],int base){
        int n=a.length-1;
        if(n==0)return a[0];
        int r=a[n-1]+a[n]*base;
        if(n==1)return r;
        for(int i=n-2;i>=0;i--){
            r=r*base+a[i];
        }
        return r;
    }
    /*Verifica que un número sea binario*/
    public static boolean esBinario(int x[]){
        for(int i=0;i<x.length;i++){
            if(x[i]!=0&&x[i]!=1)return false;
        }
        return true;
    }
    /*Verifica que un número sea octal*/
    public static boolean esOctal(int x[]){
        for(int i=0;i<x.length;i++){
            if(x[i]!=0&&x[i]!=1&&x[i]!=2&&x[i]!=3&&x[i]!=4&&x[i]!=5&&x[i]!=6&&x[i]!=7)return false;
        }
        return true;
    }
    /*Quita todos los espacios de un texto, también los intermedios*/
    public static String quitarEspaciosVectorTodos(String texto) {
        texto=texto.replaceAll(" ", "");
        texto=texto.replaceAll("\t", "");
        return texto;
    }
    /*Invierte un vector para obtener los binarios y octales correctamente*/
    public static int[] invertirVector(int[] vec){
        int n=vec.length;
        int aux[]=new int[n];
        for(int a=0,b=n-1;b>=0;a++,b--){
            aux[a]=vec[b];
        }
        return aux;
    }
    public static double integralRiemann(double a,double b,int n,String funcion){
        double h=(b-a)/n,s=0,c=a,valorFuncion;
        Funcion f=new Funcion();
        for(int i=1;i<=n;i++){
            f.evaluar(funcion,String.valueOf(c));
            valorFuncion=Double.parseDouble(f.getResultadoOperacion());
            s=s+h*valorFuncion;
            c=c+h;
        }
        return s;
    }
    public static double integralTrapecios(double a,double b,int n,String funcion){
        double h=(b-a)/n,s=0,c=a+h,valorFuncion;
        Funcion f=new Funcion();
        for(int i=1;i<=n-1;i++){
            f.evaluar(funcion,String.valueOf(c));
            valorFuncion=Double.parseDouble(f.getResultadoOperacion());
            s=s+valorFuncion;
            c=c+h;
        }
        f.evaluar(funcion,String.valueOf(a));
        double valorFuncionA=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(b));
        double valorFuncionB=Double.parseDouble(f.getResultadoOperacion());
        s=2*s;
        s=(s+valorFuncionA+valorFuncionB)*h/2;
        return s;
    }
    public static double integralSimpson13(double a,double b,int n,String funcion){
        double h=(b-a)/n,s=0,c=a+h,valorFuncion;
        Funcion f=new Funcion();
        for(int i=1;i<n;i++){
            f.evaluar(funcion,String.valueOf(c));
            valorFuncion=Double.parseDouble(f.getResultadoOperacion());
            if(i%2!=0)s=s+4*valorFuncion;
            else s=s+2*valorFuncion;
            c=c+h;
        }
        f.evaluar(funcion,String.valueOf(a));
        double valorFuncionA=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(b));
        double valorFuncionB=Double.parseDouble(f.getResultadoOperacion());
        return (s+valorFuncionA+valorFuncionB)*(h/3);
    }
    public static double integralSimpson38(double a,double b,int n,String funcion){
        double h=(b-a)/n,s=0,c=a+h,valorFuncion;
        Funcion f=new Funcion();
        for(int i=1;i<n;i++){
            f.evaluar(funcion,String.valueOf(c));
            valorFuncion=Double.parseDouble(f.getResultadoOperacion());
            s=s+3*valorFuncion;
            c=c+h;
        }
        f.evaluar(funcion,String.valueOf(a));
        double valorFuncionA=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(b));
        double valorFuncionB=Double.parseDouble(f.getResultadoOperacion());
        return (s+valorFuncionA+valorFuncionB)*(3*h/8);
    }
    public static double derivadaDiferenciaAdelante(double x0,double h,String funcion){
        double valorFuncion1,valorFuncion2;
        Funcion f=new Funcion();
        f.evaluar(funcion,String.valueOf(x0+h));
        valorFuncion1=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(x0));
        valorFuncion2=Double.parseDouble(f.getResultadoOperacion());
        return (valorFuncion1-valorFuncion2)/h;
    }
    public static double derivadaDiferenciaAtras(double x0,double h,String funcion){
        double valorFuncion1,valorFuncion2;
        Funcion f=new Funcion();
        f.evaluar(funcion,String.valueOf(x0));
        valorFuncion1=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(x0-h));
        valorFuncion2=Double.parseDouble(f.getResultadoOperacion());
        return (valorFuncion1-valorFuncion2)/h;
    }
    public static double derivadaDiferenciaCentrada(double x0,double h,String funcion){
        double valorFuncion1,valorFuncion2;
        Funcion f=new Funcion();
        f.evaluar(funcion,String.valueOf(x0+h));
        valorFuncion1=Double.parseDouble(f.getResultadoOperacion());
        f.evaluar(funcion,String.valueOf(x0-h));
        valorFuncion2=Double.parseDouble(f.getResultadoOperacion());
        return (valorFuncion1-valorFuncion2)/(2*h);
    }
    public static void interpolacionLagrange(double x[],double y[],JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs);//número de cifras después del punto decimal
        int n=x.length;
        if(n==2){
            double a=y[0]/(x[0]-x[1])+y[1]/(x[1]-x[0]);
            double b=-(x[1]*y[0]/(x[0]-x[1])+x[0]*y[1]/(x[1]-x[0]));
            area.setText("");
            area.append(df.format(a)+"x");
            if(b>0)area.append("+"+df.format(b));
            else area.append(""+df.format(b));
        }else if(n==3){
            double a=y[0]/((x[0]-x[1])*(x[0]-x[2]));
            double b=-((x[1]+x[2])*y[0]/((x[0]-x[1])*(x[0]-x[2]))+(x[0]+x[2])*y[1]/((x[1]-x[0])*(x[1]-x[2]))+(x[0]+x[1])*y[2]/((x[2]-x[0])*(x[2]-x[1])));
            double c=x[1]*x[2]*y[0]/((x[0]-x[1])*(x[0]-x[2]))+x[1]*x[2]*y[1]/((x[1]-x[0])*(x[1]-x[2]))+x[0]*x[2]*y[2]/((x[2]-x[0])*(x[2]-x[1]));
            area.setText("");
            area.append(df.format(a)+"x²");
            if(b>0)area.append("+"+df.format(b)+"x");
            else area.append(b+"x");
            if(c>0)area.append("+"+df.format(c));
            else area.append(""+df.format(c));
        }else if(n==4){
            double a=y[0]/((x[0]-x[1])*(x[0]-x[2])*(x[0]-x[3]))+y[1]/((x[1]-x[0])*(x[1]-x[2])*(x[1]-x[3]))+y[2]/((x[2]-x[0])*(x[2]-x[1])*(x[2]-x[3]))+y[3]/((x[3]-x[0])*(x[3]-x[1])*(x[3]-x[2]));
            double b=-((x[1]+x[2]+x[3])*y[0]/((x[0]-x[1])*(x[0]-x[2])*(x[0]-x[3]))+(x[0]+x[2]+x[3])*y[1]/((x[1]-x[0])*(x[1]-x[2])*(x[1]-x[3]))+(x[0]+x[1]+x[3])*y[2]/((x[2]-x[0])*(x[2]-x[1])*(x[2]-x[3]))+(x[0]+x[1]+x[2])*y[3]/((x[3]-x[0])*(x[3]-x[1])*(x[3]-x[2])));
            double c=(x[1]*x[2]+x[1]*x[3]+x[2]*x[3])*y[0]/((x[0]-x[1])*(x[0]-x[2])*(x[0]-x[2]))+(x[0]*x[3]+x[2]*x[3]+x[2]*x[3])*y[1]/((x[1]-x[0])*(x[1]-x[2])*(x[1]-x[3]))+(x[0]*x[1]+x[0]*x[3]+x[2]*x[3])*y[2]/((x[2]-x[0])*(x[2]-x[1])*(x[2]-x[3]))+(x[0]*x[1]+x[0]*x[2]+x[1]*x[2])*y[3]/((x[3]-x[0])*(x[3]-x[1])*(x[3]-x[2]));
            double d=-(x[1]*x[2]*x[3]*y[0]/((x[0]-x[1])*(x[0]-x[2])*(x[0]-x[3]))+x[0]*x[2]*x[3]*y[1]/((x[1]-x[0])*(x[1]-x[2])*(x[1]-x[3]))+x[0]*x[1]*x[3]*y[2]/((x[2]-x[0])*(x[2]-x[1])*(x[2]-x[3]))+x[0]*x[1]*x[2]*y[3]/((x[3]-x[0])*(x[3]-x[1])*(x[3]-x[2])));
            area.setText("");
            area.append(df.format(a)+"x³");
            if(b>0)area.append("+"+df.format(b)+"x²");
            else area.append(df.format(b)+"x²");
            if(c>0)area.append("+"+df.format(c)+"x");
            else area.append(df.format(c)+"x");
            if(d>0)area.append("+"+df.format(d));
            else area.append(df.format(d)+"");
        }else area.setText("");
    }
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

    static double[][] interpolacionSplines(double[] x, double[] a,double[] h,
            JTextArea vectorH,JTextArea resultado) {
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs);//número de cifras después del punto decimal
        int n=x.length-1;
        double A[][]=new double[n+1][n+2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)A[i][j]=0;
        }
        
        
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(i==j){
                    A[i][j]=2*(h[i-1]+h[i]);
                }
            }
        }
        //----------------------------------
        for(int i=1;i<n;i++){
            for(int j=2;j<=n;j++){
                if(i==j-1){
                    A[i][j]=h[j-1];
                }
            }
        }
        //--------------------------------
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j+1){
                    A[i][j]=h[j];
                }
            }
        }
        
        
        vectorH.setText("");
        for(int i=0;i<n;i++){
            vectorH.append(df.format(h[i])+" ");
        }
        A[0][0]=1;
        A[n][n]=1;
        double b[]=new double[n+1];
        b[0]=0;
        b[n]=0;
        for(int i=1;i<=n-1;i++){
            b[i]=(3/h[i])*(a[i+1]-a[i])-(3/h[i-1])*(a[i]-a[i-1]);
            A[i][n+1]=b[i];
        }

        return A;
    }
    public static boolean puntoValido;
        public static double evaluarSpines(double _x,double x[],double a[],double b[],double c[],double d[]) {
        if(_x>=x[0]&&_x<=x[x.length-1]){
            puntoValido=true;
            for(int i=0;i<x.length;i++){
                if(_x==x[i])return a[i];
                else{
                    if(_x>x[i]&&_x<x[i+1])
                        return a[i]+b[i]*(_x-x[i])+c[i]*Math.pow(_x-x[i],2)+d[i]*Math.pow(_x-x[i],3);
                }
            }
        }else{
            Metodos.error("El valor debe estar entre\n"+x[0]+"\ny\n"+x[x.length-1]);
            puntoValido=false;
        }
        return 0;
    }
}
