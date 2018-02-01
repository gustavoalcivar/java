/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionChoque;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JTextArea;

/**
 *
 * @author gustavo
 */
public class Metodos{
    public static void simular(int n,double lambda,double c,double alfa,JTextArea area){
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=choques(i,lambda,c,alfa,area);
            area.append("Horas de la simulación "+(i+1)+" = "+a[i]+"\n");
        }
        double promedio=promedio(a);
        area.append("\nEl promedio es "+promedio+" horas"+"\n");
    }
    
    private static int choques(int n,double lambda,double c,double alfa,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.0000",dfs);//número de cifras después del punto decimal
        double DxH[]=new double[99999];
        double DT=0,x,y,D;
        int hora=0,i;
        area.append(Ventana.inicial);
        while(DT<=c){
            x=Math.random()*10;
            i=0;
            D=0;
            if(x==0){
                DxH[hora]=D;
                DT=dañoTotal(DxH,hora,alfa);
                area.append((n+1)+"\t"+(hora+1)+"\t"+i+"\t0\t"+df.format(D)+"\t"+df.format(DT)+"\n");
            }
            while(i<x&&DT<=c){
                y=Math.random();
                D+=y;
                DxH[hora]=D;
                DT=dañoTotal(DxH,hora,alfa);
                area.append((n+1)+"\t"+(hora+1)+"\t"+(i+1)+"\t"+df.format(y)+"\t"+df.format(D)+"\t"+df.format(DT)+"\n");
                i++;
            }
            area.append(Ventana.linea);
            hora++;
        }
        area.append("Daño total final = "+DT+"\n");
        return hora;
    }

    private static double dañoTotal(double x[],int hora,double alfa){
        double dt=0;
        for(int _i=0;_i<=hora;_i++){
            dt+=x[_i]*Math.exp(-alfa*(hora-_i));
        }
        return dt;
    }
    private static double promedio(int x[]){
        int n=x.length;
        double pro=0;
        for(int _i=0;_i<n;_i++){
            pro+=x[_i];
        }
        pro=pro/n;
        return pro;
    }
}
