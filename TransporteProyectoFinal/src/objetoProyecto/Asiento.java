/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;

/**
 *
 * @author Gustavo
 */
public class Asiento {

    private String codigoAsiento;
    private int numeroAsiento;
    private String numeroUnidad;
    private String tipoAsiento;
    private String codBoleto;

    public Asiento(){

    }
    public Asiento(String codigoAsiento,int numeroAsiento,String numeroUnidad,
            String tipoAsiento,String codBoleto){
        this.codigoAsiento=codigoAsiento;
        this.numeroAsiento=numeroAsiento;
        this.numeroUnidad=numeroUnidad;
        this.tipoAsiento=tipoAsiento;
        this.codBoleto=codBoleto;
    }
    @Override
    public String toString(){
        return codigoAsiento+numeroAsiento+numeroUnidad+tipoAsiento+codBoleto;
    }
    
    /**
     * @return the nombreAsiento
     */
    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    /**
     * @param nombreAsiento the nombreAsiento to set
     */
    public void setCodigoAsiento(String codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
    }

    /**
     * @return the numeroAsiento
     */
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * @param numeroAsiento the numeroAsiento to set
     */
    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * @return the numeroUnidad
     */
    public String getNumeroUnidad() {
        return numeroUnidad;
    }

    /**
     * @param numeroUnidad the numeroUnidad to set
     */
    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    /**
     * @return the tipoAsiento
     */
    public String getTipoAsiento() {
        return tipoAsiento;
    }

    /**
     * @param tipoAsiento the tipoAsiento to set
     */
    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    /**
     * @return the codBoleto
     */
    public String getCodBoleto() {
        return codBoleto;
    }

    /**
     * @param codBoleto the codBoleto to set
     */
    public void setCodBoleto(String codBoleto) {
        this.codBoleto = codBoleto;
    }
}
