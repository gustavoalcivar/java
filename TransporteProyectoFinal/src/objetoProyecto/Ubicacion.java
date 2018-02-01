/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;

/**
 *
 * @author Gustavo
 */
public class Ubicacion {
    private String codigoUbicacon;
    private String nombreUbicacion;
    public void Ubicacion(){

    }
    public void Ubicacion(String codigoUbicacion, String nombreUbicacion){
        this.codigoUbicacon=codigoUbicacion;
        this.nombreUbicacion= nombreUbicacion;
    }
    @Override
    public String toString(){
        return codigoUbicacon+nombreUbicacion;
    }
    public String getCodigoUbicacon() {
        return codigoUbicacon;
    }

    public void setCodigoUbicacon(String codigoUbicacon) {
        this.codigoUbicacon = codigoUbicacon;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }
}
