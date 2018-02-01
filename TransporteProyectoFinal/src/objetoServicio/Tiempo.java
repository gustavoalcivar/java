/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoServicio;

/**
 *
 * @author Gustavo
 */
public class Tiempo {
   
    private int hora;
    private int minutos;
    public Tiempo(){

    }
    public Tiempo(int hora,int minutos){
        this.hora=hora;
        this.minutos=minutos;

    }
    @Override
    public String toString(){
        return hora+":"+minutos;
    }
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMimutos(int minutos) {
        this.minutos = minutos;
    }
}
