
package persistencias;

import java.util.Vector;
import objetoProyecto.Ruta;
import java.io.*;
import excepciones.PersistenciaException;
import objetoServicio.Fecha;



public class Rutas extends AccesoAleatorio {

      // Tamaño de un registro (datos de una ruta)
    // codioRuta             7 caracteres            14 bytes
    // lugarSalida          40 caracteres            80 bytes
    // lugarLlegada         40 caracteres            80 bytes
    // tiempoAproximado     1 float                   4 bytes
    // costoRuta            1 float                   4 bytes
    // hora                 1 float                   4 bytes
    // distancia            1 float                   4 bytes
    //unidad                2 caracteres              4 bytes
    //fecha                 3 int                    12 bytes

     // Total                                      206  bytes

/**
 * Establece el nombre del archivo en el que se almacenan los datos
 * @param nomArchivo Nombre del archivo en el que se almacenan los datos
 */
    public Rutas(String nomArchivo) {
        // Establece el nombre del archivo en el que se almacenan los datos y
        // el tamaño de un registro del archivo. Cada registro contiene los
        // datos de una ruta.
        super(nomArchivo, 206);
    }

    /**
     * Lee una ruta de un archivo
     * @return La ruta leída
     * @throws IOException Si hay un error de entrada / salida.
     */
    private Ruta leeRuta() throws IOException {
        Ruta ruta = new Ruta();
        // Lee de el archivo cada unos de los atributos de la ruta
        ruta.setCodigoRuta(leeString(7));
        ruta.setTiempoAproximado(archivo.readFloat());
        ruta.setCostoRuta(archivo.readFloat());
        ruta.setDistancia(archivo.readFloat());

        ruta.setLugarSalida(leeString(40));
        ruta.setLugarLlegada(leeString(40));

        ruta.setHora(archivo.readFloat());

        ruta.setFecha(leeFecha());

        ruta.setUnidad(leeString(2));


        return ruta;
    }

    /**
     * Escribe una ruta a un archivo
     * @param ruta Ruta a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
    private void escribeRuta(Ruta ruta) throws IOException {

        escribeString(ruta.getCodigoRuta(),7);
        archivo.writeFloat(ruta.getTiempoAproximado());
        archivo.writeFloat(ruta.getCostoRuta());
        archivo.writeFloat(ruta.getDistancia());

        escribeString(ruta.getLugarSalida(), 40);
        escribeString(ruta.getLugarLlegada(), 40);

        archivo.writeFloat(ruta.getHora());

        escribeFecha(ruta.getFecha());

        escribeString(ruta.getUnidad(),2);

    }
    /**
     * Este método obtiene una ruta de un archivo cuya clave es igual a la
     * clave de la ruta dada por el parámetro.
     * @param ruta Objeto de tipo Ruta con la clave de la ruta a
     * buscar
     * @return La Ruta si la encuentra. null en caso contrario.
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public Ruta obten(Ruta ruta) throws PersistenciaException {
       Ruta rutaLeida;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe); }
        try {
            // Mientras haya ruta es en el archivo
            while(true) {
                // Lee una ruta
                rutaLeida = leeRuta();
                // Si es la ruta buscada, regrésala
                if(ruta.getCodigoRuta().equals(rutaLeida.getCodigoRuta())) {
                    return rutaLeida;
                    }
                }
            }
        // Si se llegó al final del archivo sin encontrar la ruta
        catch (EOFException eofe) {
            return null;
            }
        // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
            }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
                }
            // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
                }
            }
        }
    /**
     * Este método permite agregar una ruta en un archivo.
     * @param ruta Ruta a insertar en la tabla rutas
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public void agrega(Ruta ruta) throws PersistenciaException {
        Ruta rutaLeida;
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
            }
        catch(FileNotFoundException fnfe) {  //Indica que un intento de abrir el fichero denotado por una ruta especificada ha fallado.
            throw new PersistenciaException("Archivo inexistente", fnfe);
            }
        try {
            // Se posiciona al final del archivo
            archivo.seek(archivo.length()); // Para leer o escribir en una ubicación específica en un RandomAccessFile primero debe colocar
              // Escribe la ruta         //el puntero de archivo en el lugar para leer y escribir.
                  escribeRuta(ruta);  //Esto se hace usando el seek() método.La posición actual del puntero de archivo se pueden obtener llamando a la getFilePointer() método.
          }


        // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
            }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
                }
            // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
                }
            }
        }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos
     * de los objetos de la clase Ruta.
     * @param ruta La ruta a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede actualizar la ruta.
     */
    public void actualiza(Ruta ruta) throws PersistenciaException {
       Ruta rutaLeida;
        // Abre el archivo de escritura/lectura
    try {
         archivo = new RandomAccessFile(nomArchivo, "rw");
    }
    catch(FileNotFoundException fnfe) {
        throw new PersistenciaException("Archivo inexistente", fnfe);
    }
    try {
        // Mientras haya rutaes en el archivo
        while(true) {
            // Lee una ruta
            rutaLeida = leeRuta();
            // Si es la ruta buscada
            if(ruta.getCodigoRuta().equals(rutaLeida.getCodigoRuta())) {
                // Se posiciona al principio del registro
                archivo.seek(archivo.getFilePointer() - tamRegistro);
                // Escribe la ruta modificada
                escribeRuta(ruta);
                // Termina la búsqueda
                break;
                }
            }
        }
    // Si se llegó al final del archivo sin encontrar la ruta
    catch (EOFException eofe) {
        throw new PersistenciaException("La ruta no existe", eofe);
        }
        // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
            }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
                }
            // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
                }
            }
        }

/**
* Este método permite borrar un renglón de la tabla con los atributos de
* los objetos de la clase Ruta.
* @param ruta Ruta a borrar
* @throws PersistenciaException Si hay un error de entrada / salida,
* el archivo no existe o no se puede eliminar la ruta.
*/
public void elimina(Ruta ruta) throws PersistenciaException {
Ruta rutaLeida;
// Abre el archivo de escritura/lectura
try {
   archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
rutaLeida = leeRuta();
// Si es la ruta buscada
if(ruta.getCodigoRuta().equals(rutaLeida.getCodigoRuta())) {
// Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra la ruta
borraRegistro();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo sin encontrar la ruta
catch (EOFException eofe) {
throw new PersistenciaException("La ruta no existe", eofe);
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
/**
* Este método permite consultar la tabla con los atributos de los objetos
* de la clase Ruta.
* @return Un vector con la lista de los objetos del tipo Ruta de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaRutas() throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
/**
* Este método permite consultar la tabla con los atributos de los objetos
* de la clase Ruta y que tienen el mismo título.
* @param titulo Título de la ruta a buscar
* @return Un vector con la lista de los objetos del tipo Ruta de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaLugarSalida(String lugarSalida) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(lugarSalida.equals(ruta.getLugarSalida()))
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
public Vector listaLugarLlegada(String lugarLlegada) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(lugarLlegada.equals(ruta.getLugarLlegada()))
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
public Vector listaTiampoAproximado(float tiempoAproximado) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(tiempoAproximado==ruta.getTiempoAproximado())
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
public Vector listaCostoRuta(float costoRuta) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(costoRuta==ruta.getCostoRuta())
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
public Vector listaHora(float hora) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(hora==ruta.getHora())
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}
public Vector listaDistancia(float distancia) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(distancia==ruta.getDistancia())
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}

public Vector listaCodigoRuta(String codigoRuta) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(codigoRuta.equals(ruta.getCodigoRuta()))
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}

public Vector listaUnidadRuta(String unidad) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(unidad.equals(ruta.getUnidad()))
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}

public Vector listaFechaRuta(Fecha fecha) throws PersistenciaException {
Vector lista = new Vector();
Ruta ruta;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya rutaes en el archivo
while(true) {
// Lee una ruta
ruta = leeRuta();
// Si es la ruta buscada
if(fecha.equals(ruta.getFecha()))
// Agrega la ruta al vector de rutaes
lista.add(ruta);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de rutaes
return lista;
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al acceder al archivo", ioe);
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException ioe) {
throw new PersistenciaException("Error al cerrar el archivo", ioe);
}
}
}


}
