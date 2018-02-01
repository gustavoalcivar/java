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
        double a[]=new double[n];
        for(int i=0;i<n;i++){
            a[i]=choques(i,lambda,c,alfa,area);
            area.append("Horas de la simulación "+(i+1)+" = "+a[i]+"\n");
        }
        double promedio=promedio(a);
        area.append("\nEl promedio es "+promedio+" horas"+"\n");
    }
    private static double choques(int n,double lambda,double c,double alfa,JTextArea area){
        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');//se establece el caracter para separar los decimales
        DecimalFormat df = new DecimalFormat("0.00000",dfs);//número de cifras después del punto decimal
        double daño[]=new double[9999];
        double tiempo[]=new double[9999];
        double DT=0,x,y,hora=0;
        int i=0;
        area.append(Ventana.inicial);
        while(DT<=c){
            x=exponencial(lambda);
            hora+=x;
            tiempo[i]=hora;
            y=distf();
            daño[i]=y;
            DT=dañoTotal(daño,hora,tiempo,alfa,i);
            area.append((n+1)+"\t"+df.format(hora)+"\t"+(i+1)+"\t"+df.format(y)+"\t\t"+df.format(DT)+"\n");
            area.append(Ventana.linea);
            i++;
        }
        area.append("Daño total final = "+DT+"\n");
        return tiempo[i-1];
    }
    private static double distf(){
        double u1,u2,temp,_y;
        do{
            u1=Math.random();
            _y=u1*Math.E;
            u2=Math.random();
            temp=_y*Math.exp(1-_y);
        }while(u2>temp);
        return _y;
    }
    private static double exponencial(double lambda){
        double u=Math.random();
        double x=-Math.log(1-u)/lambda;
        return x;
    }
    
    /*private static int poisson(double lambda){
        double u,p,F;
        int _i;
        u=Math.random();
        _i=0;
        p=Math.exp(-lambda);
        F=p;
        while(u>=F){
            p=lambda*p/(_i+1);
            F=F+p;
            _i++;
        }
        return _i;
    }*/
    private static double dañoTotal(double daño[],double hora,double tiempo[],double alfa,int i){
        double dt=0;
        for(int _i=0;_i<=i;_i++){
            dt+=daño[_i]*Math.exp(-alfa*(hora-tiempo[_i]));
        }
        return dt;
    }
    private static double promedio(double x[]){
        int n=x.length;
        double pro=0;
        for(int _i=0;_i<n;_i++){
            pro+=x[_i];
        }
        pro=pro/n;
        return pro;
    }
}
