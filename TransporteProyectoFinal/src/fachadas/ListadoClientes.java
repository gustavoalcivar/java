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
public class ListadoClientes implements IFachadaCliente {
    private Clientes listaClientes;

    public ListadoClientes(){
        listaClientes = new Clientes("clientes.dat");

    }

    public Cliente obten(Cliente cliente) throws FachadaException{

         try{
             return listaClientes.obten(cliente);
             }
    catch (PersistenciaException pe) {
    throw new FachadaException("No se puede obtener el cliente", pe);
}
}


    public void agrega(Cliente cliente) throws FachadaException {
       Cliente clienteBuscado=null;
         // Agrega el nuevo candidato
        try{
            clienteBuscado=listaClientes.obten(cliente);
             // Agrega el nuevo candidato a la lista.
            if(clienteBuscado!=null)throw new FachadaException("El cliente ya existe");
        }catch(PersistenciaException pe){

       }
        try{
            listaClientes.agrega(cliente);
        }catch(PersistenciaException pe){
       // Aquí se envuelve la excepción PersistenciaException
      // en la excepción FachadaException y se relanza
            throw new FachadaException("No se puede agregar el cliente",pe);
    }
    }


    public void actualiza(Cliente cliente) throws FachadaException {
       try {
listaClientes.actualiza(cliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede actualizar el cliente", pe);
    }
    }


    public void elimina(Cliente cliente) throws FachadaException {
        try {
listaClientes.elimina(cliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede eliminar el cliente", pe);
  }
  }


    public Vector consultaClienteCodigo(String codigoCliente) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return  listaClientes.listaClienteCodigo(codigoCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista del codigo del cliente",pe);
    }
    }

    public Vector consultaClienteNombres(String nombresCliente) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteNombres(nombresCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con ese nombre",pe);
    }
    }

    public Vector consultaClienteApellidos(String apellidosCliente) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteApellidos(apellidosCliente);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con ese apellido",pe);
    }
    }

    public Vector consultaClienteDireccion(String direccion) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteDireccion(direccion);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con esa direccion",pe);
    }
    }

    public Vector consultaClienteEmail(String email) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteEmail(email);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con ese email",pe);
    }
    }

    public Vector consultaClienteTelefono(String telefono) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteTelefono(telefono);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con ese telefono",pe);
    }
    }

    public Vector consultaClienteCedula(String cedula) throws FachadaException {

// Regresa el vector con la lista de canciones
try {
return listaClientes.listaClienteCedula(cedula);
}
catch (PersistenciaException pe) {
throw new FachadaException("No se puede obtener la lista de clientes con esa cedula",pe);
    }
    }

    public Vector consultaCliente() throws FachadaException {
        try {
            // Regresa el vector con la lista de empleados
            return listaClientes.listaCliente();
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de clientes",pe);
        }
    }
}