/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fachadas;
import java.util.Vector;
import objetoProyecto.*;
import persistencias.*;
import interfaces.*;
import excepciones.*;

/**
 *
 * @author ALEXIS
 */
public class ListadoUbicaciones implements IFachadaUbicacion {

    private Ubicaciones listaUbicaciones;

    public ListadoUbicaciones(){
        listaUbicaciones = new Ubicaciones("ubicaciones.dat");

    }

    public Ubicacion obten(Ubicacion ubicacion) throws FachadaException{

         try{
             return listaUbicaciones.obten(ubicacion);
             }
    catch (PersistenciaException pe) {
    throw new FachadaException("No se puede obtener la ubicacion", pe);
}
}


    public void agrega(Ubicacion ubicacion) throws FachadaException {
       Ubicacion ubicacionBuscada=null;
         // Agrega el nuevo candidato
        try{
            ubicacionBuscada= listaUbicaciones.obten(ubicacion);
             // Agrega el nuevo candidato a la lista.
            if(ubicacionBuscada!=null)throw new FachadaException("La ubicacion ya existe");
        }catch(PersistenciaException pe){

       }
        try{
            listaUbicaciones.agrega(ubicacion);
        }catch(PersistenciaException pe){
       // Aquí se envuelve la excepción PersistenciaException
      // en la excepción FachadaException y se relanza
            throw new FachadaException("No se puede agregar la ubicacion.",pe);
    }
    }


    public void actualiza(Ubicacion ubicacion) throws FachadaException {
       try {
listaUbicaciones.actualiza(ubicacion);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede actualizar la ubicacion", pe);
    }
    }


    public void elimina(Ubicacion ubicacion) throws FachadaException {
        try {
listaUbicaciones.elimina(ubicacion);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede eliminar la ubicacion", pe);
  }
  }

    public Vector consultaNombreUbicacion(String nombreUbicacion) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return  listaUbicaciones.listaNombreUbicacion(nombreUbicacion);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de nombres de ubicaciones",pe);
    }
    }

    public Vector consultaUbicaciones() throws FachadaException {
        try {
return  listaUbicaciones.lista();
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de ubicaciones",pe);
    }

    }

    public Vector consultaCodigoUbicacon(String codigoUbicacion) throws FachadaException {
      try {
return  listaUbicaciones.listaCodigoUbicacon(codigoUbicacion);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de codigos de Ubicacion",pe);
    }
    }
}
