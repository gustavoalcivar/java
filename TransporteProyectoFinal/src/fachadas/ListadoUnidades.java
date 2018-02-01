
package fachadas;

import java.util.Vector;
import objetoProyecto.*;
import persistencias.*;
import interfaces.*;
import excepciones.*;


public class ListadoUnidades implements IFachadaUnidad  {



     private Unidades listaUnidades;

  /**
   * Constructor predeterminado
   */
  public  ListadoUnidades() {
    // Crea un objeto del tipo catalogoUnidades para accesar a la tabla
    // unidades
    listaUnidades = new Unidades("unidades.dat");

  }

  /**
   * Obtiene una unidad del catálogo de unidades
   * @param unidad Unidad a obtener
   * @return La unidad si existe, null en caso contrario
   * @throws FachadaException Si no se puede obtener la unidad.
   */
  public Unidad obten(Unidad unidad) throws FachadaException {
    // Obten la unidad
    try {
      return listaUnidades.obten(unidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la unidad", pe);
    }
  }

  /**
   * Agrega una unidad al catálogo de unidades. No se permiten unidades
   * con claves repetidas
   * @param unidad Unidad a agregar
   * @throws FachadaException Si la unidad está repetida o no se puede
   * agregar la unidad al catálogo de unidades.
   */
  public void agrega(Unidad unidad) throws FachadaException {
    Unidad unidadBuscada;

    // Busca la unidad en el arreglo con la misma clave.
    try {
      unidadBuscada = listaUnidades.obten(unidad);

      // Si lo hay, no se agrega al arreglo
      if(unidadBuscada != null)
        throw new FachadaException("Unidad repetida");
    }
    catch (PersistenciaException pe) {
      // Si el archivo no existe no se hace nada
    }

    // Agrega la nueva unidad al catálogo
    try {
      listaUnidades.agrega(unidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede agregar la unidad", pe);
    }
  }

  /**
   * Actualiza una unidad del catálogo de unidades
   * @param unidad Unidad a actualizar
   * @throws FachadaException Si no se puede actualizar la unidad del
   * catálogo de unidades.
   */
  public void actualiza(Unidad unidad) throws FachadaException {
    // Actualiza la  unidad del catálogo
    try {
      listaUnidades.actualiza(unidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede actualizar la unidad", pe);
    }
  }

  /**
   * Elimina una unidad del catálogo de unidades
270  Entrada / Salida
ITSON    Manuel Domitsu Kono
   * @param unidad Unidad a eliminar
   * @throws FachadaException Si no se puede eliminar la unidad del
   * catálogo de unidades.
   */
  public void elimina(Unidad unidad) throws FachadaException {
    // Elimina la  unidad del catálogo
    try {
      listaUnidades.elimina(unidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede eliminar la unidad", pe);
    }
  }


  /**
   * Obtiene una lista todas las unidades
   * @return Vector con la lista de todas las unidades
   * @throws FachadaException Si no se puede obtener la lista de unidades
   */


    public Vector consultaMatricula(String matricula) throws FachadaException {

      try {
      return listaUnidades.listaMatricula(matricula);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de numero de matriculas ",
                                 pe);
    }
  }



    public Vector consultaCapacidadUnidad(int capacidadUnidad) throws FachadaException {
        try {
      return listaUnidades.listaCapacidadUnidad(capacidadUnidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de capacidad unidad",
                                 pe);
    }
  }
 public Vector consultaDisponibles(int disponibles) throws FachadaException {
        try {
      return listaUnidades.listaDisponibles(disponibles);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de capacidad unidad",
                                 pe);
    }
  }
    public Vector consultaCodigoUnidad(String codigoUnidad) throws FachadaException {
        try {
      return listaUnidades.listaCodigoUnidad(codigoUnidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista del codigo de unidad",
                                 pe);
    }
    }

    public Vector consultaUnidades() throws FachadaException {
          try {
            // Regresa el vector con la lista de empleados
            return listaUnidades.listaUnidades();
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede consultar la lista de unidades",
                    pe);
        }
    }

   
    public Vector consultaChofer(String chofer) throws FachadaException {
        try {
      return listaUnidades.listaChofer(chofer);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista del chofer de la unidad",
                                 pe);
    }
    }

    public Vector consultaAyudante(String ayudante) throws FachadaException {
        try {
      return listaUnidades.listaAyudante(ayudante);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista del ayudante de la unidad",
                                 pe);
    }
    
}
}


