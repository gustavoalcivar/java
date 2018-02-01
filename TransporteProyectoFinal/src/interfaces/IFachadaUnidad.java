

package interfaces;


import java.util.Vector;
import objetoProyecto.*;
import excepciones.FachadaException;

/**
 *
 * @author my_life
 */
public interface IFachadaUnidad {

   

    public Unidad obten(Unidad unidad) throws FachadaException;
    public void agrega(Unidad unidad) throws FachadaException;
    public void actualiza(Unidad unidad) throws FachadaException;
    public void elimina(Unidad unidad) throws FachadaException;

    public Vector consultaUnidades() throws FachadaException;
  
    public Vector consultaCodigoUnidad(String codigoUnidad)throws FachadaException;
    public   Vector consultaMatricula(String matricula) throws FachadaException;
    public   Vector consultaCapacidadUnidad(int capacidadUnidad) throws FachadaException;
    public Vector consultaDisponibles(int disponibles) throws FachadaException;
    public   Vector consultaChofer(String chofer) throws FachadaException;
    public   Vector consultaAyudante(String ayudante) throws FachadaException;


}



