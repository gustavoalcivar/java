
package persistencias;

import java.util.Vector;
import objetoProyecto.Unidad;
import excepciones.PersistenciaException;
import java.io.*;



public class Unidades extends AccesoAleatorio {
    // Tamaño de un registro (datos de una unidad)
    // codigoUnidad         2 caracteres             4 bytes
    // matricula            7 caracteres            14 bytes
    // capacidaUnidad       1 int                    4 bytes
    // disponibles          1 int                    4 bytes
    //chofer               20 caracteres            40 bytes
    //ayudante             20 caracteres            40 bytes
    
     // Total                                      106  bytes

/**
 * Establece el nombre del archivo en el que se almacenan los datos
 * @param nomArchivo Nombre del archivo en el que se almacenan los datos
 */
    public Unidades(String nomArchivo) {
        // Establece el nombre del archivo en el que se almacenan los datos y
        // el tamaño de un registro del archivo. Cada registro contiene los
        // datos de una unidad.
        super(nomArchivo, 106);
    }

    /**
     * Lee una unidad de un archivo
     * @return La unidad leída
     * @throws IOException Si hay un error de entrada / salida.
     */
    private Unidad leeUnidad() throws IOException {
        Unidad unidad = new Unidad();
        // Lee de el archivo cada unos de los atributos de la unidad
        unidad.setCodigoUnidad(leeString(2));
        unidad.setMatricula(leeString(7));
        unidad.setCapacidadUnidad(archivo.readInt());
        unidad.setDisponibles(archivo.readInt());
        unidad.setChofer(leeString(20));
        unidad.setAyudante(leeString(20));

        return unidad;
    }

    /**
     * Escribe una unidad a un archivo
     * @param unidad Unidad a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
    private void escribeUnidad(Unidad unidad) throws IOException {

        escribeString(unidad.getCodigoUnidad(),2);
        escribeString(unidad.getMatricula(), 7);
        archivo.writeInt(unidad.getCapacidadUnidad());
        archivo.writeInt(unidad.getDisponibles());
        escribeString(unidad.getChofer(), 20);
        escribeString(unidad.getAyudante(), 20);

    }
    /**
     * Este método obtiene una unidad de un archivo cuya clave es igual a la
     * clave de la unidad dada por el parámetro.
     * @param unidad Objeto de tipo Unidad con la clave de la unidad a
     * buscar
     * @return La Unidad si la encuentra. null en caso contrario.
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public Unidad obten(Unidad unidad) throws PersistenciaException {
       Unidad unidadLeida;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe); }
        try {
            // Mientras haya unidades en el archivo
            while(true) {
                // Lee una unidad
                unidadLeida = leeUnidad();
                // Si es la unidad buscada, regrésala
                if(unidad.getCodigoUnidad().equals(unidadLeida.getCodigoUnidad())) {
                    return unidadLeida;
                    }
                }
            }
        // Si se llegó al final del archivo sin encontrar la unidad
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
     * Este método permite agregar una unidad en un archivo.
     * @param unidad Unidad a insertar en la tabla unidades
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public void agrega(Unidad unidad) throws PersistenciaException {
        Unidad unidadLeida;
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
              // Escribe la unidad         //el puntero de archivo en el lugar para leer y escribir.
                  escribeUnidad(unidad);  //Esto se hace usando el seek() método.La posición actual del puntero de archivo se pueden obtener llamando a la getFilePointer() método.
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
     * de los objetos de la clase Unidad.
     * @param unidad La unidad a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede actualizar la unidad.
     */
    public void actualiza(Unidad unidad) throws PersistenciaException {
       Unidad unidaLeida;
        // Abre el archivo de escritura/lectura
    try {
         archivo = new RandomAccessFile(nomArchivo, "rw");
    }
    catch(FileNotFoundException fnfe) {
        throw new PersistenciaException("Archivo inexistente", fnfe);
    }
    try {
        // Mientras haya unidades en el archivo
        while(true) {
            // Lee una unidad
            unidaLeida = leeUnidad();
            // Si es la unidad buscada
            if(unidad.getCodigoUnidad().equals(unidaLeida.getCodigoUnidad())) {
                // Se posiciona al principio del registro
                archivo.seek(archivo.getFilePointer() - tamRegistro);
                // Escribe la unidad modificada
                escribeUnidad(unidad);
                // Termina la búsqueda
                break;
                }
            }
        }
    // Si se llegó al final del archivo sin encontrar la unidad
    catch (EOFException eofe) {
        throw new PersistenciaException("La unidad no existe", eofe);
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
* los objetos de la clase Unidad.
* @param unidad Unidad a borrar
* @throws PersistenciaException Si hay un error de entrada / salida,
* el archivo no existe o no se puede eliminar la unidad.
*/
public void elimina(Unidad unidad) throws PersistenciaException {
Unidad unidaLeida;
// Abre el archivo de escritura/lectura
try {
   archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidaLeida = leeUnidad();
// Si es la unidad buscada
if(unidad.getCodigoUnidad().equals(unidaLeida.getCodigoUnidad())) {
// Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra la unidad
borraRegistro();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo sin encontrar la unidad
catch (EOFException eofe) {
throw new PersistenciaException("La unidad no existe", eofe);
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

public Vector listaUnidades() throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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
* de la clase Unidad y que tienen el mismo título.
* @param titulo Título de la unidad a buscar
* @return Un vector con la lista de los objetos del tipo Unidad de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaMatricula(String matricula) throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(matricula.equals(unidad.getMatricula()))
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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
* de la clase Unidad y que tienen el mismo título.
* @param titulo Título de la unidad a buscar
* @return Un vector con la lista de los objetos del tipo Unidad de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaCapacidadUnidad(int capacidadUnidad) throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(capacidadUnidad==unidad.getCapacidadUnidad())
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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
* de la clase Unidad y que tienen el mismo título.
* @param titulo Título de la unidad a buscar
* @return Un vector con la lista de los objetos del tipo Unidad de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaDisponibles(int disponibles) throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {

    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(disponibles==unidad.getDisponibles())
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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
public Vector listaCodigoUnidad(String codigoUnidad)
throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(codigoUnidad.equals(unidad.getCodigoUnidad()))
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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

public Vector listaAyudante(String ayudante)
throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(ayudante.equals(unidad.getAyudante()));
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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

public Vector listaChofer(String chofer)
throws PersistenciaException {
Vector lista = new Vector();
Unidad unidad;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya unidades en el archivo
while(true) {
// Lee una unidad
unidad = leeUnidad();
// Si es la unidad buscada
if(chofer.equals(unidad.getChofer()));
// Agrega la unidad al vector de unidades
lista.add(unidad);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de unidades
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