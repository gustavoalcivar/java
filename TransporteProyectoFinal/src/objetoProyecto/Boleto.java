/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;
/**
 *
 * @author Gustavo
 */
public class Boleto {
    private String codigoBoleto;
    private String nombreCliente;
    private String apellidoCliente;
    private String cedulaCliente;
    private String unidad;
    private String ruta;
    private String codRuta;
    private String fecha;
    private float hora;
    private int numAsientosNormales;
    private int numAsientosEspeciales;
    private String detalleAsientosNormales;
    private String detalleAsientosEspeciales;
    private float costoTotal;
    public void boleto(){

    }
    public void boleto(String codigoBoleto,String nombreCliente,
            String apellidoCliente,String cedulaCliente,String unidad,
            String ruta,String fecha,float hora,int numAsientosNormales,int numAsientosEspeciales,
            String detalleAsientosNormales,String detalleAsientosEspeciales,float costoTotal,String codRuta){
        this.codigoBoleto=codigoBoleto;
        this.nombreCliente=nombreCliente;
        this.apellidoCliente=apellidoCliente;
        this.cedulaCliente=cedulaCliente;
        this.unidad=unidad;
        this.ruta=ruta;
        this.fecha=fecha;
        this.hora=hora;
        this.numAsientosNormales=numAsientosNormales;
        this.numAsientosEspeciales=numAsientosEspeciales;
        this.detalleAsientosNormales=detalleAsientosNormales;
        this.detalleAsientosEspeciales=detalleAsientosEspeciales;
        this.costoTotal=costoTotal;
        this.codRuta=codRuta;
    }

    @Override
    public String toString(){
        return codigoBoleto+nombreCliente+apellidoCliente+unidad+ruta+fecha+hora+numAsientosNormales+
                numAsientosEspeciales+detalleAsientosNormales+detalleAsientosEspeciales+costoTotal+codRuta;
    }

    /**
     * @return the codigoBoleto
     */
    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    /**
     * @param codigoBoleto the codigoBoleto to set
     */
    public void setCodigoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    /**
     * @return the cliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numAsientosNormales
     */
    public int getNumAsientosNormales() {
        return numAsientosNormales;
    }

    /**
     * @param numAsientosNormales the numAsientosNormales to set
     */
    public void setNumAsientosNormales(int numAsientosNormales) {
        this.numAsientosNormales = numAsientosNormales;
    }

    /**
     * @return the numAsientosEspeciales
     */
    public int getNumAsientosEspeciales() {
        return numAsientosEspeciales;
    }

    /**
     * @param numAsientosEspeciales the numAsientosEspeciales to set
     */
    public void setNumAsientosEspeciales(int numAsientosEspeciales) {
        this.numAsientosEspeciales = numAsientosEspeciales;
    }

    /**
     * @return the costoTotal
     */
    public float getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
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
     * @return the detalleAsientosNormales
     */
    public String getDetalleAsientosNormales() {
        return detalleAsientosNormales;
    }

    /**
     * @param detalleAsientosNormales the detalleAsientosNormales to set
     */
    public void setDetalleAsientosNormales(String detalleAsientosNormales) {
        this.detalleAsientosNormales = detalleAsientosNormales;
    }

    /**
     * @return the detalleAsientosEspeciales
     */
    public String getDetalleAsientosEspeciales() {
        return detalleAsientosEspeciales;
    }

    /**
     * @param detalleAsientosEspeciales the detalleAsientosEspeciales to set
     */
    public void setDetalleAsientosEspeciales(String detalleAsientosEspeciales) {
        this.detalleAsientosEspeciales = detalleAsientosEspeciales;
    }

    /**
     * @return the apellidoCliente
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * @param apellidoCliente the apellidoCliente to set
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     * @return the cedulaCliente
     */
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    /**
     * @param cedulaCliente the cedulaCliente to set
     */
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
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
     * @return the codRuta
     */
    public String getCodRuta() {
        return codRuta;
    }

    /**
     * @param codRuta the codRuta to set
     */
    public void setCodRuta(String codRuta) {
        this.codRuta = codRuta;
    }
}
