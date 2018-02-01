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
 * @author Gustavo
 */
public interface IFachadaCliente {

    public Cliente obten(Cliente cliente) throws FachadaException;

    public void agrega(Cliente cliente) throws FachadaException;

    public void elimina(Cliente cliente) throws FachadaException;

    public void actualiza(Cliente cliente) throws FachadaException;

    public Vector consultaCliente()throws FachadaException;

    public Vector consultaClienteCodigo(String codigoCliente)throws FachadaException;

    public Vector consultaClienteNombres(String nombres)throws FachadaException;

    public Vector consultaClienteApellidos(String apellidos)throws FachadaException;

    public Vector consultaClienteDireccion(String direccion)throws FachadaException;

    public Vector consultaClienteEmail(String email)throws FachadaException;

    public Vector consultaClienteTelefono(String telefono)throws FachadaException;

    public Vector consultaClienteCedula(String cedula)throws FachadaException;
    
}
