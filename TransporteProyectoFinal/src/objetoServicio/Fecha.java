
package objetoServicio;

import java.text.ParseException;


public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(){}

    public Fecha(String fecha) throws ParseException {
        String f="";
        int fen=0;
        int n=0;
       // SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");//La clase SimpleDateFormat nos ayuda a mostrar las fechas en el formato que queramos o a reconstruirlas a partir de una cadena de texto.
       // Date miFecha = formateador.parse(fecha);
       // String laFecha=formateador.format(miFecha);
       int l=fecha.length();
       for(int i=0;i<l;i++){
           char c=fecha.charAt(i);
           String sc=c+"";
           if(sc.equals("/"+"")){
               n++;
               fen=Integer.parseInt(f);
               f="";
                if(n==1){
               this.dia=fen;
                }
               if(n==2){
                   this.mes=fen;
               }
           }else{
               f=f+c;
           }
       }
       this.año=Integer.parseInt(f);

    }

    public Fecha(int dia,int mes,int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }


    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public String toDateString() {
         return getDia()+"/"+getMes()+"/"+getAño();
    }


       @Override
     public String toString() {
        return getDia()+"/"+getMes()+"/"+getAño();
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

}