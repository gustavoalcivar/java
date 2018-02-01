/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencias;
import java.io.*;
import java.util.Vector;
import objetoProyecto.Ubicacion;
import excepciones.PersistenciaException;

/**
 *
 * @author ALEXIS
 */
public class Ubicaciones extends AccesoAleatorio{
// Tamaño de un registro (datos del cliente)
// codigoUbicacion       7 caracteres       14 bytes
// nombreUbicacion      20 caracteres       40 bytes
// Total 54 bytes

    public Ubicaciones(String nomArchivo){
        super(nomArchivo,54);
    }
  private Ubicacion leeUbicacion() throws IOException {
Ubicacion ubicacion = new Ubicacion();
// Lee de el archivo cada unos de los atributos de la ubicacion
ubicacion.setCodigoUbicacon(leeString(7));
ubicacion.setNombreUbicacion(leeString(20));

return ubicacion;
}

    /**
* Escribe una ubicacion a un archivo
* @param ubicacion Ubicacion a escribir
* @throws IOException Si hay un error de entrada / salida.
*/
private void escribeUbicacion(Ubicacion ubicacion) throws IOException {
escribeString(ubicacion.getCodigoUbicacon(), 7);
escribeString(ubicacion.getNombreUbicacion(), 20);


}

public Ubicacion obten(Ubicacion ubicacion) throws PersistenciaException {
Ubicacion ubicacionLeida;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
ubicacionLeida = leeUbicacion();
// Si es la ubicacion buscada, regrésala
if(ubicacion.getCodigoUbicacon().equals(ubicacionLeida.getCodigoUbicacon())) {
return ubicacionLeida;
}
}
}
// Si se llegó al final del archivo sin encontrar la ubicacion
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
public void agrega(Ubicacion ubicacion) throws PersistenciaException {
Ubicacion ubicacionLeida;
// Abre el archivo de escritura/lectura
try {
archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Se posiciona al final del archivo
archivo.seek(archivo.length());
// Escribe la ubicacion
escribeUbicacion(ubicacion);
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
public void actualiza(Ubicacion ubicacion) throws PersistenciaException {
Ubicacion ubicacionLeida;
// Abre el archivo de escritura/lectura
try {
archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente");
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
ubicacionLeida = leeUbicacion();
// Si es la ubicacion buscada
if(ubicacion. getCodigoUbicacon().equals(ubicacionLeida.getCodigoUbicacon())) {
    // Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Escribe la ubicacion modificada
escribeUbicacion(ubicacion);
// Cierra el archivo
archivo.close();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
throw new PersistenciaException("La ubicacion no existe");
}
// Si ocurrió un error de entrada salida
catch (IOException eofe) {
throw new PersistenciaException("Error al acceder al archivo");
}
finally {
try {
// Cierra el archivo
archivo.close();
}
// Si ocurrió un error de entrada salida
catch (IOException eofe) {
throw new PersistenciaException("Error al cerrar el archivo");
}
}
}
public void elimina(Ubicacion ubicacion) throws PersistenciaException {
Ubicacion ubicaionLeida;
// Abre el archivo de escritura/lectura
try {
    archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
ubicaionLeida = leeUbicacion();
// Si es la ubicacion buscada
if(ubicacion.getCodigoUbicacon().equals(ubicaionLeida.getCodigoUbicacon())) {
// Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra la ubicacion
borraRegistro();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo sin encontrar la ubicacion
catch (EOFException eofe) {
throw new PersistenciaException("La ubicacion no existe", eofe);
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

 
public Vector lista() throws PersistenciaException {
Vector listaUbicacion = new Vector();
Ubicacion ubicacion;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
 ubicacion = leeUbicacion();
// Agrega la ubicacion al vector de ubicaciones
listaUbicacion.add(ubicacion);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de ubicaciones
return listaUbicacion;
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


public Vector listaNombreUbicacion(String nombreUbicacion) throws PersistenciaException {
Vector listaNombreUbicacion = new Vector();
Ubicacion ubicacion;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
ubicacion = leeUbicacion();
// Si es la ubicacion buscada
if(nombreUbicacion.equals(ubicacion.getNombreUbicacion()))
// Agrega la ubicacion al vector de ubicaciones
listaNombreUbicacion.add(ubicacion);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de ubicaciones
return listaNombreUbicacion;
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
public Vector listaCodigoUbicacon(String codigoUbicacion) throws PersistenciaException {
Vector listaNombreUbicacion = new Vector();
Ubicacion ubicacion;
// Abre el archivo de sólo lectura
try {
archivo = new RandomAccessFile(nomArchivo, "r");
}
catch(FileNotFoundException fnfe) {
    throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya ubicaciones en el archivo
while(true) {
// Lee una ubicacion
ubicacion = leeUbicacion();
// Si es la ubicacion buscada
if(codigoUbicacion.equals(ubicacion.getCodigoUbicacon()))
// Agrega la ubicacion al vector de ubicaciones
listaNombreUbicacion.add(ubicacion);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de ubicaciones
return listaNombreUbicacion;
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
