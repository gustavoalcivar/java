
package fachadas;
import java.util.Vector;
import objetoProyecto.*;
import objetoServicio.Fecha;
import persistencias.*;
import interfaces.*;
import excepciones.*;


public class ListadoRutas implements IFachadaRuta {



     private Rutas listaRutas;

  /**
   * Constructor predeterminado
   */
  public  ListadoRutas() {
    // Crea un objeto del tipo catalogoRutas para accesar a la tabla
    // rutas
    listaRutas = new Rutas("rutas.dat");

  }

  /**
   * Obtiene una ruta del catálogo de rutas
   * @param ruta Ruta a obtener
   * @return La ruta si existe, null en caso contrario
   * @throws FachadaException Si no se puede obtener la ruta.
   */
  public Ruta obten(Ruta ruta) throws FachadaException {
    // Obten la ruta
    try {
      return listaRutas.obten(ruta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la ruta", pe);
    }
  }

  /**
   * Agrega una ruta al catálogo de rutas. No se permiten rutas
   * con claves repetidas
   * @param ruta Ruta a agregar
   * @throws FachadaException Si la ruta está repetida o no se puede
   * agregar la ruta al catálogo de rutas.
   */
  public void agrega(Ruta ruta) throws FachadaException {
    Ruta rutaBuscada;

    // Busca la ruta en el arreglo con la misma clave.
    try {
      rutaBuscada = listaRutas.obten(ruta);

      // Si lo hay, no se agrega al arreglo
      if(rutaBuscada != null)
        throw new FachadaException("Ruta repetida");
    }
    catch (PersistenciaException pe) {
      // Si el archivo no existe no se hace nada
    }

    // Agrega la nueva ruta al catálogo
    try {
      listaRutas.agrega(ruta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede agregar la ruta", pe);
    }
  }

  /**
   * Actualiza una ruta del catálogo de rutas
   * @param ruta Ruta a actualizar
   * @throws FachadaException Si no se puede actualizar la ruta del
   * catálogo de rutas.
   */
  public void actualiza(Ruta ruta) throws FachadaException {
    // Actualiza la  ruta del catálogo
    try {
      listaRutas.actualiza(ruta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede actualizar la ruta", pe);
    }
  }

  /**
   * Elimina una ruta del catálogo de rutas
270  Entrada / Salida
ITSON    Manuel Domitsu Kono
   * @param ruta Ruta a eliminar
   * @throws FachadaException Si no se puede eliminar la ruta del
   * catálogo de rutas.
   */
  public void elimina(Ruta ruta) throws FachadaException {
    // Elimina la  ruta del catálogo
    try {
      listaRutas.elimina(ruta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede eliminar la ruta", pe);
    }
  }

    public Vector consultaRutas() throws FachadaException {
            try {
      return listaRutas.listaRutas();
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de rutas",
                                 pe);
    }

    }

    public Vector consultaLugarSalida(String lugarSalida) throws FachadaException {
       try {
      return listaRutas.listaLugarSalida(lugarSalida);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de lugares de salida",
                                 pe);
    }
  }



    public Vector consultaLugarLlegada(String lugarLlegada) throws FachadaException {
           try {
      return listaRutas.listaLugarLlegada(lugarLlegada);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de lugares de llegada",
                                 pe);
    }
    }

   

    public Vector consultaCostoRuta(float costoRuta) throws FachadaException {
           try {
      return listaRutas.listaCostoRuta(costoRuta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista costos de ruta",
                                 pe);
    }
  }



    public Vector consultaHora(float hora) throws FachadaException {
           try {
      return listaRutas.listaHora(hora);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista horas de rutas",
                                 pe);
    }
  }



    public Vector consultaDistancia(float distancia) throws FachadaException {
            try {
      return listaRutas.listaDistancia(distancia);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de distancias de ",
                                 pe);
    }

    }

    public Vector consultaTiampoAproximado(float tiempoAproximado) throws FachadaException {
            try {
      return listaRutas.listaTiampoAproximado(tiempoAproximado);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de capacidad de tiempos Aproximados",
                                 pe);
    }

    }




    public Vector consultaCodigoRuta(String codigoRuta) throws FachadaException {
        try {
      return listaRutas.listaCodigoRuta(codigoRuta);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de capacidad de tiempos Aproximados",
                                 pe);
    }

    }
public Vector consultaUnidadRuta(String unidad) throws FachadaException{
    try {
      return listaRutas.listaUnidadRuta(unidad);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de unidades de la ruta",
                                 pe);
}

    }

   
    public Vector consultaFechaRuta(Fecha fecha) throws FachadaException {
        try {
      return listaRutas.listaFechaRuta(fecha);
    }
    catch (PersistenciaException pe) {
      throw new FachadaException("No se puede obtener la lista de fecha de la ruta",
                                 pe);
}
    }
}



