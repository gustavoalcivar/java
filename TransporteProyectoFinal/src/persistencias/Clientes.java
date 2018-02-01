/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencias;
import java.io.*;
import java.util.Vector;
import objetoProyecto.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author Gustavo
 */
public class Clientes extends AccesoAleatorio{
    // Tamaño de un registro (datos del cliente)
// codigaCliente         7 caracteres 14 bytes
// Nombres              20 caracteres 40 bytes
// Apellidos            20 caracteres 40 bytes
// Direccion            75 caracteres 150 bytes
// Email                30 caracteres 60 bytes
// Telefono             10 caracteres 20 bytes
// cedula               10 caracteres 20 bytes

// Total 344 bytes
    public Clientes(String nomArchivo){
        super(nomArchivo,344);
    }

    private Cliente leeCliente() throws IOException {
Cliente cliente = new Cliente();
// Lee de el archivo cada unos de los atributos de la canción
cliente.setCodigoCliente(leeString(7));
cliente.setNombres(leeString(20));
cliente.setApellidos(leeString(20));
cliente.setDireccion(leeString(75));
cliente.setEmail(leeString(30));
cliente.setTelefono(leeString(10));
cliente.setCedula(leeString(10));

return cliente;
}

    /**
* Escribe una canción a un archivo
* @param cancion Canción a escribir
* @throws IOException Si hay un error de entrada / salida.
*/
private void escribeCliente(Cliente cliente) throws IOException {
escribeString(cliente.getCodigoCliente(), 7);
escribeString(cliente.getNombres(), 20);
escribeString(cliente.getApellidos(), 20);
escribeString(cliente.getDireccion(), 75);
escribeString(cliente.getEmail(), 30);
escribeString(cliente.getTelefono(), 10);
escribeString(cliente.getCedula(), 10);
}

public Cliente obten(Cliente cliente) throws PersistenciaException {
Cliente clienteLeido;
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
clienteLeido = leeCliente();
// Si es la canción buscada, regrésala
if(cliente.getCodigoCliente().equals(clienteLeido.getCodigoCliente())) {
return clienteLeido;
}
}
}
// Si se llegó al final del archivo sin encontrar la canción
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
public void agrega(Cliente cliente) throws PersistenciaException {
Cliente clienteLeido;
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
// Escribe la canción
escribeCliente(cliente);
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
public void elimina(Cliente cliente) throws PersistenciaException {
Cliente clienteLeido;
// Abre el archivo de escritura/lectura
try {
    archivo = new RandomAccessFile(nomArchivo, "rw");
}
catch(FileNotFoundException fnfe) {
throw new PersistenciaException("Archivo inexistente", fnfe);
}
try {
// Mientras haya canciones en el archivo
while(true) {
// Lee una canción
clienteLeido = leeCliente();
// Si es la canción buscada
if(cliente.getCodigoCliente().equals(clienteLeido.getCodigoCliente())) {
// Se posiciona al principio del registro
archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra la canción
borraRegistro();
// Termina la búsqueda
break;
}
}
}
// Si se llegó al final del archivo sin encontrar la canción
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
     * Este método permite modificar un renglón de la tabla con los atributos
     * de los objetos de la clase Cancion.
     * @param cancion La canción a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede actualizar la canción.
     */
    public void actualiza(Cliente cliente) throws PersistenciaException {
       Cliente clienteLeido;
        // Abre el archivo de escritura/lectura
    try {
         archivo = new RandomAccessFile(nomArchivo, "rw");
    }
    catch(FileNotFoundException fnfe) {
        throw new PersistenciaException("Archivo inexistente", fnfe);
    }
    try {
        // Mientras haya canciones en el archivo
        while(true) {
            // Lee una canción
            clienteLeido = leeCliente();
            // Si es la canción buscada
            if(cliente.getCodigoCliente().equals(clienteLeido.getCodigoCliente())) {
                // Se posiciona al principio del registro
                archivo.seek(archivo.getFilePointer() - tamRegistro);
                // Escribe la canción modificada
                escribeCliente(cliente);
                // Termina la búsqueda
                break;
                }
            }
        }
    // Si se llegó al final del archivo sin encontrar la canción
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
public Vector listaCliente() throws PersistenciaException {
Vector listaCliente = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Agrega la canción al vector de canciones
listaCliente.add(cliente);
}
}
// Si se llegó al final del archivo
catch (EOFException eofe) {
// Regresa la lista de canciones
return listaCliente;
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
public Vector listaClienteCodigo(String codigoCliente)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(codigoCliente.equals(cliente.getCodigoCliente()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteNombres(String nombres)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(nombres.equals(cliente.getNombres()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteApellidos(String apellidos)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(apellidos.equals(cliente.getApellidos()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteDireccion(String direccion)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(direccion.equals(cliente.getDireccion()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteEmail(String email)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(email.equals(cliente.getEmail()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteTelefono(String telefono)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(telefono.equals(cliente.getTelefono()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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
public Vector listaClienteCedula(String cedula)throws PersistenciaException {
Vector lista = new Vector();
Cliente cliente;
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
cliente = leeCliente();
// Si es la canción buscada
if(cedula.equals(cliente.getCedula()))
// Agrega la canción al vector de canciones
lista.add(cliente);
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

