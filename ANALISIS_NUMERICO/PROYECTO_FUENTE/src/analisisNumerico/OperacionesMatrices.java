/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisNumerico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JTextArea;

/**
 *
 * @author gustavo
 */
public class OperacionesMatrices {
    public static void intercambioFilas(double A[][],int n,int m,int i,int j,JTextArea area){
        //Intercambia la fila i por la fila j
        area.append("\nFila "+(i+1)+" por fila "+(j+1)+"\n");
        if(i>=0&&i<n&&j>=0&&j<n){
            double temp;
            for(int k=0;k<m;k++){
                temp=A[i][k];
                A[i][k]=A[j][k];
                A[j][k]=temp;
            }
        }else Metodos.error("Las filas no son válidas");
    }
    public static void escalarFila(double A[][],int n,int m,int i,double a,JTextArea area){
        //Multiplica la fila i por a
        area.append("\nFila "+(i+1)+" por "+a+"\n");
        if(i>=0&&i<n&&a!=0){
            for(int k=0;k<m;k++){
                A[i][k]=A[i][k]*a;
            }
        }else Metodos.error("La fila no es válida o el escalar en cero");
    }
    public static void filaMasEscalarFila(double A[][],int n,int m,int i,int j,double a,JTextArea area){
        //Reemplaza la fila i por la fila i más a por la fila j
        area.append("\nFila "+(i+1)+" más "+a+" veces la fila "+(j+1)+"\n");
        if(i>=0&&i<n&&j>=0&&j<n&&a!=0){
            for(int k=0;k<m;k++){
                A[i][k]=A[i][k]+A[j][k]*a;
            }
        }else Metodos.error("Las filas no son válidas o el escalar en cero");
    }
    public static void gauss_jordan(double A[][],int n,int m,JTextArea area,int tipo){
        int filaPivote=0,columnaPivote=0;
        if(tipo==0){
            while(filaPivote<n&&columnaPivote<m){
                if(A[filaPivote][columnaPivote]!=0){
                    for(int k=filaPivote+1;k<n;k++){
                        if(A[k][columnaPivote]!=0){
                            filaMasEscalarFila(A,n,m,k,filaPivote,-A[k][columnaPivote]/A[filaPivote][columnaPivote],area);
                            imprimirMatriz(A,n,m,area);
                            area.append("\n\n");
                        }
                    }
                    filaPivote++;
                    columnaPivote++;
                }else{
                    int k=filaPivote+1;
                    while(k<n){
                        if(A[k][columnaPivote]!=0){
                            intercambioFilas(A,n,m,filaPivote,k,area);
                            k=n;
                            imprimirMatriz(A,n,m,area);
                            area.append("\n\n");
                        }
                        k++;
                        if(k==n){
                            columnaPivote++;
                        }
                    }
                }
            }
        }else if(tipo==1){
            while(filaPivote<n&&columnaPivote<m){
                if(A[filaPivote][columnaPivote]!=0){
                    escalarFila(A,n,m,filaPivote,1/A[filaPivote][columnaPivote],area);
                    imprimirMatriz(A,n,m,area);
                    area.append("\n\n");
                    for(int k=filaPivote+1;k<n;k++){
                        if(A[k][columnaPivote]!=0){
                            filaMasEscalarFila(A,n,m,k,filaPivote,-A[k][columnaPivote]/A[filaPivote][columnaPivote],area);
                            imprimirMatriz(A,n,m,area);
                            area.append("\n\n");
                        }
                    }
                    for(int k=filaPivote-1;k>=0;k--){
                        if(A[k][columnaPivote]!=0){
                            filaMasEscalarFila(A,n,m,k,filaPivote,-A[k][columnaPivote]/A[filaPivote][columnaPivote],area);
                            imprimirMatriz(A,n,m,area);
                            area.append("\n\n");
                        }
                    }
                    filaPivote++;
                    columnaPivote++;
                }else{
                    int k=filaPivote+1;
                    while(k<n){
                        if(A[k][columnaPivote]!=0){
                            intercambioFilas(A,n,m,filaPivote,k,area);
                            k=n;
                            imprimirMatriz(A,n,m,area);
                            area.append("\n\n");
                        }
                        k++;
                        if(k==n){
                            columnaPivote++;
                        }
                    }
                }
            }
        }
        
    }

    private static void imprimirMatriz(double mat[][],int filas,int columnas,JTextArea area){
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
}
