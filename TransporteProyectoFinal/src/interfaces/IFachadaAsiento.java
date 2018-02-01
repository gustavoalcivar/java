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
public interface IFachadaAsiento {

    public Asiento obten(Asiento asiento) throws FachadaException;

    public void agrega(Asiento Asiento) throws FachadaException;

    public void actualiza(Asiento asiento) throws FachadaException;

    public void elimina(Asiento asiento) throws FachadaException;

    public Vector consultaAsientos() throws FachadaException;

    public Vector consultaCodigoAsiento(String codigo)throws FachadaException;

    public Vector consultaNumeroAsiento(int numeroAsiento)throws FachadaException;

    public Vector consultaAsientoUnidad(String unidad)throws FachadaException;

    public Vector consultaTipoAsiento(String tipoAsiento)throws FachadaException;

    public Vector consultaAsientoCodBoleto(String codBoleto)throws FachadaException;

    
}
