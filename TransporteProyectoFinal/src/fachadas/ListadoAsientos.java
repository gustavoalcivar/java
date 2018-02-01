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
 * @author Gustavo
 */
public class ListadoAsientos implements IFachadaAsiento {
    private Asientos listaAsientos;

    public ListadoAsientos(){
        listaAsientos = new Asientos("asientos.dat");

    }

    public Asiento obten(Asiento asiento) throws FachadaException{

         try{
             return listaAsientos.obten(asiento);
             }
    catch (PersistenciaException pe) {
    throw new FachadaException("No se puede obtener el asiento", pe);
}
}


    public void agrega(Asiento asiento) throws FachadaException {
       Asiento asientoBuscado=null;
         // Agrega el nuevo candidato
        try{
            asientoBuscado=listaAsientos.obten(asiento);
             // Agrega el nuevo candidato a la lista.
            if(asientoBuscado!=null)throw new FachadaException("El asiento ya existe");
        }catch(PersistenciaException pe){

       }
        try{
            listaAsientos.agrega(asiento);
        }catch(PersistenciaException pe){
       // Aquí se envuelve la excepción PersistenciaException
      // en la excepción FachadaException y se relanza
            throw new FachadaException("No se puede agregar el asiento",pe);
    }
    }


    public void actualiza(Asiento asiento) throws FachadaException {
       try {
listaAsientos.actualiza(asiento);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede actualizar el asiento", pe);
    }
    }


    public void elimina(Asiento asiento) throws FachadaException {
        try {
listaAsientos.elimina(asiento);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede eliminar el asiento", pe);
  }
  }


    public Vector consultaCodigoAsiento(String codigoAsiento) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return  listaAsientos.listaCodigoAsiento(codigoAsiento);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista del codigo del asiento",pe);
    }
    }

    public Vector consultaAsientos() throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaAsientos.listaAsientos();
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de asientos",pe);
        }
}

    public Vector consultaNumeroAsiento(int numeroAsiento) throws FachadaException {
        try {
return  listaAsientos.listaNumeroAsiento(numeroAsiento);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista del número del asiento",pe);
    }
    }

    public Vector consultaAsientoUnidad(String unidad) throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaAsientos.listaAsientoUnidad(unidad);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de asientos de la unidad",pe);
        }
    }

    public Vector consultaTipoAsiento(String tipoAsiento) throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaAsientos.listaTipoAsiento(tipoAsiento);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de tipos de asiento",pe);
        }
    }

    public Vector consultaAsientoCodBoleto(String codBoleto) throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaAsientos.listaAsientoCodBoleto(codBoleto);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de tipos de asiento",pe);
        }
    }
}

