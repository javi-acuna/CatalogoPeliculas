package ar.com.peliculas.negocio;

import ar.com.peliculas.datos.*;
import ar.com.peliculas.domain.Pelicula;
import ar.com.peliculas.excepciones.*;

/**
 *
 * @author Javier Emiliano
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        var pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error acceso a datos");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error lectura de datos");
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error lectura de datos");
        }
        System.out.println(resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            } else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al iniciar el catalogo de peliculas");
        }
    }

}
