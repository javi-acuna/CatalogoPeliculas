package ar.com.peliculas.negocio;

/**
 *
 * @author Javier Emiliano
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "peliculas.txt";
    
    public void agregarPelicula(String nombrePelicula);

    public void listarPeliculas();

    public void buscarPelicula(String buscar);

    public void iniciarArchivo();
}
