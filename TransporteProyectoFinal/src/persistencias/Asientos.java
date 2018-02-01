/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencias;

import java.io.*;
import java.util.Vector;
import objetoProyecto.*;
import excepciones.PersistenciaException;

/**
 * @author Gustavo
 */
public class Asientos extends AccesoAleatorio{
 // Tamaño de un registro (datos de los asientos)
// codigoAsiento         20 caracteres     40 bytes
// numeroAsiento         1 int            4 bytes
//numero unidad          2 caracteres     4 bytes
//tipoAsiento            10 caracteres   20 bytes
//cod boleto              7 caracteres   14 bytes

// Total 82 bytes
    public Asientos(String nomArchivo){
        super(nomArchivo,82);
    }
  
    private Asiento leeAsiento() throws IOException {
Asiento asiento = new Asiento();
// Lee de el archivo cada unos de los atributos de los asientos
asiento.setCodigoAsiento(leeString(20));
asiento.setNumeroAsiento(archivo.readInt());
asiento.setNumeroUnidad(leeString(2));
asiento.setTipoAsiento(leeString(10));
asiento.setCodBoleto(leeString(7));

/**
     * Escribe un asiento en un archivo
     * @param asiento Asiento a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
return asiento;
}
      private void escribeAsiento(Asiento asiento) throws IOException {
        escribeString(asiento.getCodigoAsiento(),20);
        archivo.writeInt(asiento.getNumeroAsiento());
        escribeString(asiento.getNumeroUnidad(),2);
        escribeString(asiento.getTipoAsiento(), 10);
        escribeString(asiento.getCodBoleto(), 7);
    }

    /**
     * Este método obtiene un asiento de un archivo cuya clave es igual a la
     * clave del asiento dado por el parámetro.
     * @param asiento Objeto de tipo Asiento con la clave del asiento a
     * buscar
     * @return el asiento si lo encuentra. null en caso contrario.
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public Asiento obten(Asiento asiento) throws PersistenciaException {
       Asiento asientoLeido;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe); }
        try {
            // Mientras haya asientos en el archivo
            while(true) {
                // Lee un asiento
                asientoLeido = leeAsiento();
                // Si es el asiento buscado, regrésalo
                if(asiento.getCodigoAsiento().equals(asientoLeido.getCodigoAsiento())) {
                    return asientoLeido;
                    }
                }
            }
        // Si se llegó al final del archivo sin encontrar el asiento
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
     * Este método permite agregar un asiento en un archivo.
     * @param asiento Asiento a insertar en la tabla asientos
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public void agrega(Asiento Asiento) throws PersistenciaException {
        Asiento asientoLeido;
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
              // Escribe el asiento         //el puntero de archivo en el lugar para leer y escribir.
                  escribeAsiento(Asiento);  //Esto se hace usando el seek() método.La posición actual del puntero de archivo se pueden obtener llamando a la getFilePointer() método.
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
     * de los objetos de la clase Asiento.
     * @param asiento El asiento a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede actualizar el asiento.
     */
    public void actualiza(Asiento asiento) throws PersistenciaException {
       Asiento asientoLeido;
        // Abre el archivo de escritura/lectura
    try {
         archivo = new RandomAccessFile(nomArchivo, "rw");
    }
    catch(FileNotFoundException fnfe) {
        throw new PersistenciaException("Archivo inexistente", fnfe);
    }
    try {
        // Mientras haya asientos en el archivo
        while(true) {
            // Lee un asiento
            asientoLeido = leeAsiento();
            // Si es el asiento buscada
            if(asiento.getCodigoAsiento().equals(asientoLeido.getCodigoAsiento())) {
                // Se posiciona al principio del registro
                archivo.seek(archivo.getFilePointer() - tamRegistro);
                // Escribe el asiento modificado
                escribeAsiento(asiento);
                // Termina la búsqueda
                break;
                }
            }
        }
    // Si se llegó al final del archivo sin encontrar el asiento
    catch (EOFException eofe) {
        throw new PersistenciaException("La canción no existe", eofe);
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
* los objetos de la clase Asiento.
* @param asiento Asiento a borrar
* @throws PersistenciaException Si hay un error de entrada / salida,
* el archivo no existe o no se puede eliminar el asiento.
*/
public void elimina(Asiento asiento) throws PersistenciaException {
Asiento asientoLeido;
// Abre el archivo de escritura/lectura
try {
   archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya asientos en el archivo
while(true) {
// Lee un asiento
asientoLeido = leeAsiento();
// Si es el asiento buscado
if(asiento.getCodigoAsiento().equals(asientoLeido.getCodigoAsiento())) {
// Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra el asiento
borraRegistro();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo sin encontrar el asiento
catch (EOFException eofe) {
throw new PersistenciaException("La canción no existe", eofe);
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

public Vector listaAsientos() throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
* de la clase Cancion y que tienen el mismo interprete.
* @param interprete Interprete de la canción a buscar
* @return Un vector con la lista de los objetos del tipo Cancion de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaCodigoAsiento(String codigo)throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Si es la canción buscada
if(codigo.equals(asiento.getCodigoAsiento()))
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
* de la clase Cancion y que tienen el mismo interprete.
* @param interprete Interprete de la canción a buscar
* @return Un vector con la lista de los objetos del tipo Cancion de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaNumeroAsiento(int numeroAsiento)throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Si es la canción buscada
if(numeroAsiento==asiento.getNumeroAsiento())
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
* de la clase Cancion y que tienen el mismo interprete.
* @param interprete Interprete de la canción a buscar
* @return Un vector con la lista de los objetos del tipo Cancion de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaAsientoUnidad(String unidad)throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Si es la canción buscada
if(unidad.equals(asiento.getNumeroUnidad()))
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
* de la clase Cancion y que tienen el mismo interprete.
* @param interprete Interprete de la canción a buscar
* @return Un vector con la lista de los objetos del tipo Cancion de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaTipoAsiento(String tipoAsiento)throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Si es la canción buscada
if(tipoAsiento.equals(asiento.getTipoAsiento()))
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
* de la clase Cancion y que tienen el mismo interprete.
* @param interprete Interprete de la canción a buscar
* @return Un vector con la lista de los objetos del tipo Cancion de la
* tabla
* @throws PersistenciaException Si hay un error de entrada / salida o
* el archivo no existe.
*/
public Vector listaAsientoCodBoleto(String codBoleto)throws PersistenciaException {
Vector lista = new Vector();
Asiento asiento;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
asiento = leeAsiento();
// Si es la canción buscada
if(codBoleto.equals(asiento.getCodBoleto()))
// Agrega la canción al vector de canciones
lista.add(asiento);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
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
