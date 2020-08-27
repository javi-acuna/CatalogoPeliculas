package ar.com.peliculas.datos;

import ar.com.peliculas.domain.Pelicula;
import ar.com.peliculas.excepciones.*;
import java.util.List;

/**
 *
 * @author Javier Emiliano
 */
public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
