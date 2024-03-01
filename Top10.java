import java.util.Scanner;
public class Top10 {
    public static void main(String[] args) {

        // Crear un array bidimensional para almacenar los datos de los jugadores
        String[][] jugadores = {
                {"1", "Erling Haaland", "Noruega", "Manchester City", "208"},
                {"3", "Lionel Messi", "Argentina", "Inter Miami", "85"},
                {"4", "Rodri", "España", "Manchester City", "55"},
                {"5", "Jude Bellingham", "Inglaterra", "Borussia Dortmund / Real Madrid", "34"},


        };

        // Menú de inicio
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Editar jugador");
            System.out.println("4. Imprimir jugadores");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarJugadores(jugadores);
                    break;
                case "2":
                    eliminarJugadores(jugadores);
                    break;
                case "3":
                    editarJugador(jugadores);
                    break;
                case "4":
                    imprimirJugadores(jugadores);
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (!opcion.equals("5"));
    }

    /**
     * Permite al usuario ingresar datos de nuevos jugadores y los agrega al array de jugadores.
     * @param jugadores El array de jugadores existente.
     */
    public static void agregarJugadores(String[][] jugadores) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            // Pedir al usuario que ingrese los datos del jugador
            System.out.println("Ingrese los datos del jugador:");
            System.out.print("Posición: ");
            String posicion = scanner.nextLine();
            System.out.print("Nombre del jugador: ");
            String nombre = scanner.nextLine();
            System.out.print("Nacionalidad: ");
            String nacionalidad = scanner.nextLine();
            System.out.print("Equipo: ");
            String equipo = scanner.nextLine();
            System.out.print("Puntos: ");
            String puntos = scanner.nextLine();

            // Agregar los datos del jugador al array
            String[] nuevoJugador = {posicion, nombre, nacionalidad, equipo, puntos};
            jugadores = agregarJugador(jugadores, nuevoJugador);

            // Preguntar al usuario si desea agregar más jugadores
            System.out.print("¿Desea agregar otro jugador? (s/n): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
    }

    /**
     * Agrega un jugador al array de jugadores.
     * @param jugadores El array de jugadores existente.
     * @param nuevoJugador Los datos del nuevo jugador a agregar.
     * @return El nuevo array de jugadores que incluye al nuevo jugador.
     */
    public static String[][] agregarJugador(String[][] jugadores, String[] nuevoJugador) {
        // Crear un nuevo array con capacidad para un jugador adicional
        String[][] nuevoArray = new String[jugadores.length + 1][5];

        // Copiar los datos de los jugadores existentes al nuevo array
        for (int i = 0; i < jugadores.length; i++) {
            nuevoArray[i] = jugadores[i];
        }

        // Agregar el nuevo jugador al final del nuevo array
        nuevoArray[jugadores.length] = nuevoJugador;

        return nuevoArray;
    }

    /**
     * Permite al usuario eliminar jugadores del array de jugadores.
     * @param jugadores El array de jugadores existente.
     */
    public static void eliminarJugadores(String[][] jugadores) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            // Pedir al usuario que ingrese la posición del jugador a eliminar
            System.out.print("Ingrese la posición del jugador que desea eliminar: ");
            String posicionEliminar = scanner.nextLine();

            // Encontrar el índice del jugador a eliminar
            int indiceEliminar = -1;
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i][0].equals(posicionEliminar)) {
                    indiceEliminar = i;
                    break;
                }
            }

            // Eliminar al jugador si se encontró
            if (indiceEliminar != -1) {
                jugadores = eliminarJugador(jugadores, indiceEliminar);
                System.out.println("Jugador eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún jugador con la posición especificada.");
            }

            // Preguntar al usuario si desea eliminar otro jugador
            System.out.print("¿Desea eliminar otro jugador? (s/n): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
    }

    /**
     * Elimina un jugador del array de jugadores.
     * @param jugadores El array de jugadores existente.
     * @param indiceEliminar El índice del jugador a eliminar.
     * @return El nuevo array de jugadores que no incluye al jugador eliminado.
     */
    public static String[][] eliminarJugador(String[][] jugadores, int indiceEliminar) {
        // Crear un nuevo array con capacidad para un jugador menos
        String[][] nuevoArray = new String[jugadores.length - 1][5];

        // Copiar los datos de los jugadores existentes al nuevo array, excepto el jugador a eliminar
        int nuevoIndice = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (i != indiceEliminar) {
                nuevoArray[nuevoIndice] = jugadores[i];
                nuevoIndice++;
            }
        }

        return nuevoArray;
    }

    /**
     * Permite al usuario editar los datos de un jugador.
     * @param jugadores El array de jugadores existente.
     */
    public static void editarJugador(String[][] jugadores) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            // Pedir al usuario que ingrese la posición del jugador a editar
            System.out.print("Ingrese la posición del jugador que desea editar: ");
            String posicionEditar = scanner.nextLine();

            // Encontrar el índice del jugador a editar
            int indiceEditar = -1;
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i][0].equals(posicionEditar)) {
                    indiceEditar = i;
                    break;
                }
            }

            // Editar al jugador si se encontró
            if (indiceEditar != -1) {
                // Pedir al usuario que ingrese los nuevos datos del jugador
                System.out.println("Ingrese los nuevos datos del jugador:");
                System.out.print("Nombre del jugador: ");
                jugadores[indiceEditar][1] = scanner.nextLine();
                System.out.print("Nacionalidad: ");
                jugadores[indiceEditar][2] = scanner.nextLine();
                System.out.print("Equipo: ");
                jugadores[indiceEditar][3] = scanner.nextLine();
                System.out.print("Puntos: ");
                jugadores[indiceEditar][4] = scanner.nextLine();

                System.out.println("Jugador editado correctamente.");
            } else {
                System.out.println("No se encontró ningún jugador con la posición especificada.");
            }

            // Preguntar al usuario si desea editar otro jugador
            System.out.print("¿Desea editar otro jugador? (s/n): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
    }

    /**
     * Imprime los datos de los jugadores en formato de tabla.
     * @param jugadores El array de jugadores a imprimir.
     */
    public static void imprimirJugadores(String[][] jugadores) {
        System.out.println("Posición\tJugador\t\tNacionalidad\tEquipo\t\tPuntos");
        for (String[] jugador : jugadores) {
            for (String dato : jugador) {
                System.out.print(dato + "\t\t");
            }
            System.out.println();
        }
    }
}