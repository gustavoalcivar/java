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
public interface IFachadaBoleto {

    public Boleto obten(Boleto boleto) throws FachadaException;

    public void agrega(Boleto boleto) throws FachadaException;

    public void actualiza(Boleto boleto) throws FachadaException;

    public void elimina(Boleto boleto) throws FachadaException;

    public Vector consultaBoleto()throws FachadaException;

    public Vector consultaBoletoCodigo(String codigoBoleto)throws FachadaException;

    public Vector consultaBoletoNombreCliente(String nombreCliente)throws FachadaException;

    public Vector consultaBoletoApellidoCliente(String apellidoCliente)throws FachadaException;

    public Vector consultaBoletoCedulaCliente(String cedulaCliente)throws FachadaException;

    public Vector consultaBoletoUnidad(String unidad)throws FachadaException;

    public Vector consultaBoletoRuta(String ruta)throws FachadaException;

    public Vector consultaBoletoFecha(String fecha)throws FachadaException;

    public Vector consultaBoletoCodigoUnidad(String codigoUnidad)throws FachadaException;

    public Vector consultaBoletoHora(float hora)throws FachadaException;

    public Vector consultaBoletoCodRuta(String codRuta)throws FachadaException;
    
}
