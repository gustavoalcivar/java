/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

public class Algoritmos {
    
    public static int busquedaBinaria(int a[], int dato) {
        int inicio = 0;
        int fin = a.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( a[pos] == dato )
                return pos;
            else if ( a[pos] < dato ) {
                inicio = pos+1;
            } else {
                  fin = pos-1;
            }
        }
        return -1;
    }
    
    public static int mediana(int[]v1,int[]v2,int primX,int ultX,int primY,int ultY){
    if(primX==ultX){
       
        return Metodos.min(v1[primX], v2[primY]);
    }else{
        if(v1[primX+1]==v1[ultX]){
      

            if(v1[ultX]<v2[primY]){
                return v1[ultX];
            }else{
                if(v1[primX]>v2[ultY]){
                    return v2[ultY];
                }else{
                    return Metodos.max(v1[primX], v2[primY]);
                }
            }
        }else{
            int medX=(ultX+primX)/2;    //Medianas de x e y
            int medY=(ultY+primY)/2;
          

            if(v1[medX]==v2[medY]){
                return v1[medX];
            }else{
                if(v1[medX]>v2[medY]){
                
                    return mediana(v1, v2, primX, primX+medX-primX, ultY-medY, ultY);
                }else{
                    return mediana(v1, v2, ultX-medX, ultX, primY,(primY+medY-primY));

                }
            }
        }
    }
}

    public static int[] cambio(int monedas[], int valor) {
        int solucion[] = new int[monedas.length];
        for(int i = monedas.length-1; i >= 0; i--) {
            while(monedas[i] <= valor) {
                solucion[i]++;
                valor -= monedas[i];
            }
        }
        return solucion;
    }
    
    public static double[] mochilaFraccionaria(ElementoMochila e[], int n,double peso_maximo,double[]solucion) {
        Metodos.shellElementosMochila(e);
        double peso_en_curso=0;
        int j=0;
        while((peso_en_curso<peso_maximo)&&(j<n)){
            if((e[j].getPeso()+peso_en_curso)<peso_maximo){
                solucion[j]=1;
            }else{
                solucion[j]=(peso_maximo-peso_en_curso)/e[j].getPeso();
            }
            peso_en_curso=peso_en_curso+(solucion[j]*e[j].getPeso());
            j++;
        }
        return solucion;
    }
    
    public static double[] mochilaEntera(ElementoMochila e[], int n,double peso_maximo,double[]solucion) {
        Metodos.shellElementosMochila(e);
        double peso_en_curso=0;
        int j=0;
        while((peso_en_curso<peso_maximo)&&(j<n)){
            if((e[j].getPeso()+peso_en_curso)<peso_maximo){
                solucion[j]=1;
            }
            peso_en_curso=peso_en_curso+(solucion[j]*e[j].getPeso());
            j++;
        }
        return solucion;
    }
    
    public static int[][] asignacionTareas1(int costes[][], int n) {
        int asignacion[][] = new int[n][n];
        int trabajador;
        for(trabajador = 0; trabajador < n; trabajador++){
            asignacion[trabajador][mejorTarea(n, costes, asignacion, trabajador)]=1;
        }
        return asignacion;
    }

    private static int mejorTarea(int n, int[][] costes, int[][] asignacion, int trabajador) {
        int tarea, min = 9999999, mejorTarea = 0;
        for(tarea = 0; tarea < n; tarea++){
            if(costes[trabajador][tarea] < min && !yaEscogida(asignacion, trabajador, tarea)){
                min = costes[trabajador][tarea];
                mejorTarea = tarea;
            }
        }
        return mejorTarea;
    }
    private static boolean yaEscogida(int[][] asignacion, int trabajador, int tarea) {
        for(int i = 0; i < trabajador; i++) {
            if(asignacion[i][tarea] == 1) return true;
        }
        return false;
    }
    public static int[][] asignacionTareas2(int costes[][], int n) {
        int asignacion[][] = new int[n][n];
        int tarea;
        for(tarea = 0; tarea < n; tarea++){
            asignacion[mejorTrabajador(n, costes, asignacion, tarea)][tarea]=1;
        }
        return asignacion;
    }

    private static int mejorTrabajador(int n, int[][] costes, int[][] asignacion, int tarea) {
        int trabajador, min = 9999999, mejorTrabajador = 0;
        for(trabajador = 0; trabajador < n; trabajador++){
            if(costes[trabajador][tarea] < min && !yaEscogido(asignacion, trabajador, tarea)){
                min = costes[trabajador][tarea];
                mejorTrabajador = trabajador;
            }
        }
        return mejorTrabajador;
    }

    private static boolean yaEscogido(int[][] asignacion, int trabajador, int tarea) {
        for(int i = 0; i < tarea; i++) {
            if(asignacion[trabajador][i] == 1) return true;
        }
        return false;
    }
  
}
