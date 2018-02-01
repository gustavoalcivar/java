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
 *
 * @author Gustavo
 */
public class Boletos extends AccesoAleatorio {
    // Tamaño de un registro (datos del cliente)
// codigoBoleto          7 caracteres 14 bytes
//nombres cliente       20 caracteres 40 bytes
//apellidos cliente     20 caracteres 40 bytes
//cedula cliente        10 caracteres 20 bytes
//numero unidad          2 caracteres  4 bytes
//ruta                  20 caracteres 40 bytes
//cod ruta               7 caracteres  14 bytes
//fecha                  10 caracteres  20 bytes
//hora                   1 float       4 bytes
//asientos normales      1 int         4 bytes
//asientos especiales    1 int         4 bytes
//detalleAsientosNormales 20 caracteres 40 bytes
//detalleAsientosEspeciales 20 caracteres 40 bytes
//costo total            1 float       4 bytes

// Total 284 bytes
    public Boletos(String nomArchivo) {
        super(nomArchivo, 288);
    }

    private Boleto leeBoleto() throws IOException {
        Boleto boleto = new Boleto();
// Lee de el archivo cada unos de los atributos de la canción
        boleto.setCodigoBoleto(leeString(7));

        boleto.setNombreCliente(leeString(20));
        boleto.setApellidoCliente(leeString(20));
        boleto.setCedulaCliente(leeString(10));

        boleto.setUnidad(leeString(2));

        boleto.setRuta(leeString(20));
        boleto.setCodRuta(leeString(7));

        boleto.setFecha(leeString(10));

        boleto.setHora(archivo.readFloat());

        boleto.setNumAsientosNormales(archivo.readInt());
        boleto.setNumAsientosEspeciales(archivo.readInt());

        boleto.setDetalleAsientosNormales(leeString(20));
        boleto.setDetalleAsientosEspeciales(leeString(20));

        boleto.setCostoTotal(archivo.readFloat());

        /**
         * Escribe una canción a un archivo
         *
         * @param cancion Canción a escribir
         * @throws IOException Si hay un error de entrada / salida.
         */
        return boleto;
    }

    private void escribeBoleto(Boleto boleto) throws IOException {

        escribeString(boleto.getCodigoBoleto(), 7);
        escribeString(boleto.getNombreCliente(), 20);
        escribeString(boleto.getApellidoCliente(), 20);
        escribeString(boleto.getCedulaCliente(), 10);
        escribeString(boleto.getUnidad(), 2);
        escribeString(boleto.getRuta(), 20);
        escribeString(boleto.getCodRuta(), 7);
        escribeString(boleto.getFecha(), 10);
        archivo.writeFloat(boleto.getHora());
        archivo.writeInt(boleto.getNumAsientosNormales());
        archivo.writeInt(boleto.getNumAsientosEspeciales());
        escribeString(boleto.getDetalleAsientosNormales(), 20);
        escribeString(boleto.getDetalleAsientosEspeciales(), 20);
        archivo.writeFloat(boleto.getCostoTotal());
    }

    /**
     * Este método obtiene una canción de un archivo cuya clave es igual a la
     * clave de la canción dada por el parámetro.
     *
     * @param cancion Objeto de tipo Cancion con la clave de la canción a buscar
     * @return La Cancion si la encuentra. null en caso contrario.
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Boleto obten(Boleto boleto) throws PersistenciaException {
        Boleto boletoLeido;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
            // Mientras haya canciones en el archivo
            while (true) {
                // Lee una canción
                boletoLeido = leeBoleto();
                // Si es la canción buscada, regrésala
                if (boleto.getCodigoBoleto().equals(boletoLeido.getCodigoBoleto())) {
                    return boletoLeido;
                }
            }
        } // Si se llegó al final del archivo sin encontrar la canción
        catch (EOFException eofe) {
            return null;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
                // Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite agregar una canción en un archivo.
     *
     * @param cancion Cancion a insertar en la tabla cancioness
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public void agrega(Boleto boleto) throws PersistenciaException {
        Boleto boletoLeido;
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {  //Indica que un intento de abrir el fichero denotado por una ruta especificada ha fallado.
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
            // Se posiciona al final del archivo
            archivo.seek(archivo.length()); // Para leer o escribir en una ubicación específica en un RandomAccessFile primero debe colocar
            // Escribe la canción         //el puntero de archivo en el lugar para leer y escribir.
            escribeBoleto(boleto);  //Esto se hace usando el seek() método.La posición actual del puntero de archivo se pueden obtener llamando a la getFilePointer() método.
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
                // Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion La canción a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida, el
     * archivo no existe o no se puede actualizar la canción.
     */
    public void actualiza(Boleto boleto) throws PersistenciaException {
        Boleto boletoLeido;
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
            // Mientras haya canciones en el archivo
            while (true) {
                // Lee una canción
                boletoLeido = leeBoleto();
                // Si es la canción buscada
                if (boleto.getCodigoBoleto().equals(boletoLeido.getCodigoBoleto())) {
                    // Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    // Escribe la canción modificada
                    escribeBoleto(boleto);
                    // Termina la búsqueda
                    break;
                }
            }
        } // Si se llegó al final del archivo sin encontrar la canción
        catch (EOFException eofe) {
            throw new PersistenciaException("La canción no existe", eofe);
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
                // Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion Cancion a borrar
     * @throws PersistenciaException Si hay un error de entrada / salida, el
     * archivo no existe o no se puede eliminar la canción.
     */
    public void elimina(Boleto boleto) throws PersistenciaException {
        Boleto boletoLeido;
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boletoLeido = leeBoleto();
// Si es la canción buscada
                if (boleto.getCodigoBoleto().equals(boletoLeido.getCodigoBoleto())) {
// Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
// Borra la canción
                    borraRegistro();
// Termina la búsqueda
                    break;
                }
            }
        } // Si se llegó al final del archivo sin encontrar la canción
        catch (EOFException eofe) {
            throw new PersistenciaException("El boleto no existe", eofe);
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    public Vector listaBoletos() throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Agrega la canción al vector de canciones
                lista.add(boleto);
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoUnidad(String unidad) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (unidad.equals(boleto.getUnidad())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoCodigo(String codigoBoleto) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (codigoBoleto.equals(boleto.getCodigoBoleto())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoCedulaCliente(String cedulaCliente) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (cedulaCliente.equals(boleto.getCedulaCliente())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoNombreCliente(String nombreCliente) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (nombreCliente.equals(boleto.getNombreCliente())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoApellidoCliente(String apellidoCliente) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (apellidoCliente.equals(boleto.getApellidoCliente())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoCodigoUnidad(String codigoUnidad) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (codigoUnidad.equals(boleto.getUnidad())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoRuta(String ruta) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (ruta.equals(boleto.getRuta())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoFecha(String fecha) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (fecha.equals(boleto.getFecha())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoHora(Float hora) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (hora == boleto.getHora()) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Cancion y que tienen el mismo interprete.
     *
     * @param interprete Interprete de la canción a buscar
     * @return Un vector con la lista de los objetos del tipo Cancion de la
     * tabla
     * @throws PersistenciaException Si hay un error de entrada / salida o el
     * archivo no existe.
     */
    public Vector listaBoletoCodRuta(String codRuta) throws PersistenciaException {
        Vector lista = new Vector();
        Boleto boleto;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente", fnfe);
        }
        try {
// Mientras haya canciones en el archivo
            while (true) {
// Lee una canción
                boleto = leeBoleto();
// Si es la canción buscada
                if (codRuta.equals(boleto.getCodRuta())) // Agrega la canción al vector de canciones
                {
                    lista.add(boleto);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de canciones
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo", ioe);
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo", ioe);
            }
        }
    }
}
