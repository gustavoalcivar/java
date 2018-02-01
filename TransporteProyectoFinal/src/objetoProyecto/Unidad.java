/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;

/**
 *
 * @author Gustavo
 */
public class Unidad {
    private String codigoUnidad;
    private String matricula;
    private int capacidadUnidad;
    private int disponibles;
    private String chofer;
    private String ayudante;
    public void Unidad(){

    }
    public void Unidad(String codigoUnidad, String matricula, int
            capacidadUnidad, String chofer,String ayudante,
            int numeroUnidad,int disponibles){
        this.setCodigoUnidad(codigoUnidad);
        this.matricula = matricula;
        this.capacidadUnidad= capacidadUnidad;
        this.chofer=chofer;
        this.ayudante=ayudante;
        this.disponibles=disponibles;
        
    }
    @Override
    public String toString(){
        return codigoUnidad+matricula+capacidadUnidad+chofer+ayudante+disponibles;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidadUnidad() {
        return capacidadUnidad;
    }

    public void setCapacidadUnidad(int capacidadUnidad) {
        this.capacidadUnidad = capacidadUnidad;
    }   
    
    
    /**
     * @return the codigoUnidad
     */
    public String getCodigoUnidad() {
        return codigoUnidad;
    }

    /**
     * @param codigoUnidad the codigoUnidad to set
     */
    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    /**
     * @return the chofer
     */
    public String getChofer() {
        return chofer;
    }

    /**
     * @param chofer the chofer to set
     */
    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    /**
     * @return the ayudante
     */
    public String getAyudante() {
        return ayudante;
    }

    /**
     * @param ayudante the ayudante to set
     */
    public void setAyudante(String ayudante) {
        this.ayudante = ayudante;
    }

    /**
     * @return the disponibles
     */
    public int getDisponibles() {
        return disponibles;
    }

    /**
     * @param disponibles the disponibles to set
     */
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

}
