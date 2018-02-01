/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;
import objetoServicio.*;

/**
 *
 * @author Gustavo
 */
public class Ruta {
    private String codigoRuta;
    private String lugarSalida;
    private String lugarLlegada;
    private float tiempoAproximado;
    private float costoRuta;
    private float hora;
    private float distancia;
    private String unidad;
    private Fecha fecha;
    public Ruta(){
        
    }
    public Ruta(String codigoRuta,String lugarSalida,String lugarLlegada,
            float tiempoAproximado,float costoRuta,float hora,float distancia,
            String unidad,Fecha fecha){
        this.codigoRuta=codigoRuta;
        this.lugarSalida=lugarSalida;
        this.lugarLlegada=lugarLlegada;
        this.tiempoAproximado=tiempoAproximado;
        this.costoRuta=costoRuta;
        this.hora=hora;
        this.distancia=distancia;
        this.unidad=unidad;
        this.fecha=fecha;
    }
    @Override
     public String toString(){
         return codigoRuta+lugarSalida+lugarLlegada+tiempoAproximado+costoRuta+hora+
                 distancia+unidad+fecha;
     }

    /**
     * @return the codigoRuta
     */
    public String getCodigoRuta() {
        return codigoRuta;
    }

    /**
     * @param codigoRuta the codigoRuta to set
     */
    public void setCodigoRuta(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    /**
     * @return the lugarSalida
     */
    public String getLugarSalida() {
        return lugarSalida;
    }

    /**
     * @param lugarSalida the lugarSalida to set
     */
    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

     /**
     * @return the lugarLlegada
     */
    public String getLugarLlegada() {
        return lugarLlegada;
    }

    /**
     * @param lugarLlegada the lugarLlegada to set
     */
    public void setLugarLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }

    /**
     * @return the tiempoAproximado
     */
    public float getTiempoAproximado() {
        return tiempoAproximado;
    }

    /**
     * @param tiempoAproximado the tiempoAproximado to set
     */
    public void setTiempoAproximado(float tiempoAproximado) {
        this.tiempoAproximado = tiempoAproximado;
    }

    /**
     * @return the costoRuta
     */
    public float getCostoRuta() {
        return costoRuta;
    }

    /**
     * @param costoRuta the costoRuta to set
     */
    public void setCostoRuta(float costoRuta) {
        this.costoRuta = costoRuta;
    }

    /**
     * @return the hora
     */
    public float getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(float hora) {
        this.hora = hora;
    }

    /**
     * @return the distancia
     */
    public float getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    
}
