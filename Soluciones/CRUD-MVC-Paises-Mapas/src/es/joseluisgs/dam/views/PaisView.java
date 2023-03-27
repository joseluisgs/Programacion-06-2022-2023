package es.joseluisgs.dam.views;

import es.joseluisgs.dam.comparators.PaisNombreComparator;
import es.joseluisgs.dam.controllers.PaisController;
import es.joseluisgs.dam.models.Pais;
import es.joseluisgs.dam.utils.Console;

import java.util.List;

/**
 * Sería la vista de un país., pronto será un formulario...
 */
public class PaisView {
    private static PaisView instance;
    private final PaisController controller = PaisController.getInstance();

    private PaisView() {
    }

    public static PaisView getInstance() {
        if (instance == null) {
            instance = new PaisView();
        }
        return instance;
    }

    /**
     * Salir del programa
     */
    private static void salir() {
        System.out.println("¡Hasta pronto!");
        System.exit(0);
    }

    /**
     * Muestra los paises ordenados por nombre
     */
    private void mostrarPaises() {
        System.out.println("Mostrar países");
        // Obtengo los países
        List<Pais> paises = controller.getAllPaises();
        // Puedes probar otro comparador
        paises.sort(new PaisNombreComparator());
        System.out.println("Hay " + paises.size() + " países");
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    /**
     * Actualiza un pais
     */
    private void actualizarPais() {
        System.out.println("Actualizar país");
        String nombre = Console.getString("Nombre del país: ");
        System.out.println("Introduce los nuevos datos o deje en blanco para mantener los actuales");

        try {
            // Comprobamos si existe el pais antes de pedirle los datos
            var existe = controller.getPaisByNombre(nombre);

            // Tomamos los nuevos datos o nos quedamos con los antiguos si son blancos.
            String nuevoNombre = Console.getString("Nuevo nombre del país (anterior: " + existe.getNombre() + "): ");
            nuevoNombre = (nuevoNombre.isEmpty()) ? existe.getNombre() : nuevoNombre;
            String nuevoCodigo = Console.getString("Nuevo código del país (anterior: " + existe.getCodigo() + "): ");
            nuevoCodigo = (nuevoCodigo.isEmpty()) ? existe.getCodigo() : nuevoCodigo;
            String nuevoIdioma = Console.getString("Nuevo idioma del país (anterior: " + existe.getIdioma() + "): ");
            nuevoIdioma = (nuevoIdioma.isEmpty()) ? existe.getIdioma() : nuevoIdioma;
            String nuevoCapital = Console.getString("Nueva capital del país (anterior: " + existe.getCapital() + "): ");
            nuevoCapital = (nuevoCapital.isEmpty()) ? existe.getCapital() : nuevoCapital;
            String nuevoMoneda = Console.getString("Nueva moneda del país (anterior: " + existe.getMoneda() + "): ");
            nuevoMoneda = (nuevoMoneda.isEmpty()) ? existe.getMoneda() : nuevoMoneda;

            // Es importante crear un objeto nuevo, porque si no al ser referencias tocamos el del repositorio
            // Esto no pasará con ficheros o bases de datos
            var update = existe.clone()
                    .nombre(nuevoNombre)
                    .codigo(nuevoCodigo)
                    .idioma(nuevoIdioma)
                    .capital(nuevoCapital)
                    .moneda(nuevoMoneda);

            // Actualizamos el pais
            var res = controller.updatePais(existe.getId(), update);
            System.out.println("País actualizado");
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error al actualizar un pais. " + e.getMessage());
        }
    }

    /**
     * Elimina un pais
     */
    private void eliminarPais() {
        System.out.println("Eliminar país");
        String nombre = Console.getString("Nombre del país: ");
        try {
            var res = controller.deletePais(nombre);
            System.out.println("País eliminado correctamente");
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Crea un pais
     */
    private void crearPais() {
        System.out.println("Crear país");
        System.out.println("Los datos no pueden estar vacíos");
        String nombre = Console.getString("Nombre del país: ");
        String codigo = Console.getString("Código del país: ");
        String idioma = Console.getString("Idioma principal: ");
        String moneda = Console.getString("Nombre de la moneda: ");
        String capital = Console.getString("Nombre de la capital: ");

        // Deberíamos comprobar que los datos son correctos tanto en la vista como en el backend!!
        // No hay que fiarse nunca. Imagina que es un mívil y los datos van a un servidor remoto.

        // Pais pais = new Pais(nombre, codigo, idioma, moneda, capital);
        // uso interfaz fluída, hasta que sepa hacer builder :)
        Pais pais = new Pais()
                .nombre(nombre)
                .codigo(codigo)
                .idioma(idioma)
                .moneda(moneda)
                .capital(capital);

        // insertamos el pais
        try {
            var res = controller.crearPais(pais);
            System.out.println("País creado correctamente");
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    public void menu() {
        System.out.println("Gestion de Paises");
        System.out.println("=================");
        // Bucle infinito a la espera de una opción o salir
        do {
            System.out.println();
            System.out.println("1. Crear país");
            System.out.println("2. Eliminar país");
            System.out.println("3. Actualizar país");
            System.out.println("4. Mostrar países");
            System.out.println("5. Consultar país");
            System.out.println("6. Salir");
            System.out.println();
            String opcion = Console.getString("Elige una opción [1-5]: ");
            // Expresion regular para validar la opción
            var regex = "[1-6]";
            if (opcion.matches(regex)) {
                switch (opcion) {
                    case "1":
                        crearPais();
                        break;
                    case "2":
                        eliminarPais();
                        break;
                    case "3":
                        actualizarPais();
                        break;
                    case "4":
                        mostrarPaises();
                        break;
                    case "5":
                        getPaisByNombre();
                        break;
                    case "6":
                        salir();
                        break;
                }
            }
        } while (true);
    }

    /**
     * Obtiene un pais por su nombre
     */
    private void getPaisByNombre() {
        System.out.println("Mostrar país");
        String nombre = Console.getString("Nombre del país: ");
        try {
            var res = controller.getPaisByNombre(nombre);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }
}
