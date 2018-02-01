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
public class ListadoBoletos implements IFachadaBoleto {
    private Boletos listaBoletos;

    public ListadoBoletos(){
        listaBoletos = new Boletos("boletos.dat");

    }

    public Boleto obten(Boleto boleto) throws FachadaException{

         try{
             return listaBoletos.obten(boleto);
             }
    catch (PersistenciaException pe) {
    throw new FachadaException("No se puede obtener el boleto", pe);
}
}


    public void agrega(Boleto boleto) throws FachadaException {
       Boleto boletoBuscado=null;
         // Agrega el nuevo candidato
        try{
            boletoBuscado=listaBoletos.obten(boleto);
             // Agrega el nuevo candidato a la lista.
            if(boletoBuscado!=null)throw new FachadaException("El boleto ya existe");
        }catch(PersistenciaException pe){

       }
        try{
            listaBoletos.agrega(boleto);
        }catch(PersistenciaException pe){
       // Aquí se envuelve la excepción PersistenciaException
      // en la excepción FachadaException y se relanza
            throw new FachadaException("No se puede agregar el boleto",pe);
    }
    }


    public void actualiza(Boleto boleto) throws FachadaException {
       try {
listaBoletos.actualiza(boleto);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede actualizar el boleto", pe);
    }
    }


    public void elimina(Boleto boleto) throws FachadaException {
        try {
listaBoletos.elimina(boleto);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede eliminar el boleto", pe);
  }
  }


    public Vector consultaBoletoCodigo(String codigoBoleto) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return  listaBoletos.listaBoletoCodigo(codigoBoleto);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista del codigo del boleto",pe);
    }
    }

    public Vector consultaBoletoNombreCliente(String nombreCliente) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoNombreCliente(nombreCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto del cliente",pe);
    }
    }

        public Vector consultaBoletoApellidoCliente(String apellidoCliente) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoApellidoCliente(apellidoCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto del cliente",pe);
    }
    }
    public Vector consultaBoletoUnidad(String unidad) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoUnidad(unidad);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la unidad",pe);
    }
    }

    public Vector consultaBoletoRuta(String ruta) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoRuta(ruta);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la ruta",pe);
    }
    }

    public Vector consultaBoletoFecha(String fecha) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoFecha(fecha);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la fecha",pe);
    }
    }

    public Vector consultaBoleto() throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaBoletos.listaBoletos();
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de boletos",pe);
        }
}

    public Vector consultaBoletoCedulaCliente(String cedulaCliente) throws FachadaException {
        // Regresa el vector con la lista de canciones
try {
return listaBoletos.listaBoletoCedulaCliente(cedulaCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la unidad",pe);
    }
    }

    public Vector consultaBoletoCodigoUnidad(String codigoUnidad) throws FachadaException {
        try {
return listaBoletos.listaBoletoCodigoUnidad(codigoUnidad);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la unidad",pe);
    }
    }

    public Vector consultaBoletoHora(float hora) throws FachadaException {
        try {
return listaBoletos.listaBoletoHora(hora);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la hora",pe);
    }
    }

    public Vector consultaBoletoCodRuta(String codRuta) throws FachadaException {
        try {
return listaBoletos.listaBoletoCodRuta(codRuta);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de boleto de la hora",pe);
    }
    }
    }

