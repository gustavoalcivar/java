

package interfaces;


import java.util.Vector;
import objetoProyecto.*;
import excepciones.FachadaException;
import objetoServicio.Fecha;

/**
 *
 * @author my_life
 */
public interface IFachadaRuta {

    public Ruta obten(Ruta ruta) throws FachadaException;
    public void agrega(Ruta ruta) throws FachadaException;
    public void actualiza(Ruta ruta) throws FachadaException;
    public void elimina(Ruta ruta) throws FachadaException;

    public Vector consultaRutas() throws FachadaException;

    public Vector consultaCodigoRuta(String codigoRuta) throws FachadaException;
    public Vector consultaLugarSalida(String lugarSalida) throws FachadaException;
    public Vector consultaLugarLlegada(String lugarLlegada) throws FachadaException;
    public Vector consultaTiampoAproximado(float tiempoAproximado) throws FachadaException;
    public Vector consultaCostoRuta(float costoRuta) throws FachadaException;
    public Vector consultaHora(float hora) throws FachadaException;
    public Vector consultaDistancia(float distancia) throws FachadaException;
    public Vector consultaUnidadRuta(String unidad) throws FachadaException;
    public Vector consultaFechaRuta(Fecha fecha) throws FachadaException;




}
