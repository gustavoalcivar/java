/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.Vector;
import objetoProyecto.*;
import excepciones.FachadaException;
/**
 *
 * @author ALEXIS
 */
public interface IFachadaUbicacion {

    public Ubicacion obten(Ubicacion ubicacion) throws FachadaException;
    public void agrega(Ubicacion ubicacion) throws FachadaException;
    public void actualiza(Ubicacion ubicacion) throws FachadaException;
    public void elimina(Ubicacion ubicacion) throws FachadaException;


    public Vector consultaUbicaciones() throws FachadaException;
    
    public Vector consultaCodigoUbicacon(String codigoUbicacion) throws  FachadaException;
    public Vector consultaNombreUbicacion(String nombreUbicacion) throws FachadaException;




 

}
