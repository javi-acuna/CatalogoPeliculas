package main;

import ar.com.peliculas.negocio.*;
import java.util.Scanner;

/**
 *
 * @author Javier Emiliano
 */
public class Main {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1) Iniciar catalogo de peliculas \n"
                    + "2) Agregar pelicula \n"
                    + "3) Listar peliculas \n"
                    + "4) Buscar pelicula \n"
                    + "0) Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Nombre de la pelicula para agregar: ");
                    var nombre = scanner.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Nombre de la pelicula a buscar: ");
                    var nombreBuscar = scanner.nextLine();
                    catalogo.buscarPelicula(nombreBuscar);
                    break;
                case 0:
                    System.out.println("Saludos");
                    break;
                default:
                    System.out.println("Se ingreso una opcion incorrecta");
                    break;
            }
        }
    }
}
