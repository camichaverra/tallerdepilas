import java.util.Scanner;
import java.util.Stack; // Importamos la clase Stack para manejar la pila

public class PilaBusqueda {
    private Stack<Character> pila; // Declaramos una pila de caracteres

    // Constructor que inicializa la pila
    public PilaBusqueda() {
        this.pila = new Stack<>();
    }

    // Método para llenar la pila con caracteres de un array
    public void llenarPila(char[] caracteres) {
        for (char c : caracteres) {
            pila.push(c); // Agregamos cada carácter a la pila
        }
    }

    // Método para buscar un elemento dentro de la pila
    public void buscarElemento(char elemento) {
        Scanner scanner = new Scanner(System.in); // Scanner para leer entrada del usuario
        boolean encontrado = false; // Variable para verificar si se encontró el elemento

        while (!encontrado) { // Mientras no se haya encontrado el elemento
            if (pila.isEmpty()) { // Si la pila está vacía, se vuelve a llenar
                System.out.println("La pila está vacía. Ingrese nuevos elementos:");
                String entrada = scanner.nextLine(); // Se lee una nueva entrada de caracteres
                llenarPila(entrada.toCharArray()); // Se convierte en array y se llena la pila
                continue; // Vuelve al inicio del ciclo para intentar la búsqueda de nuevo
            }

            Stack<Character> pilaAux = new Stack<>(); // Pila auxiliar para restaurar los elementos después de la búsqueda
            int posicion = pila.size(); // Guardamos el tamaño de la pila para conocer la posición del elemento

            while (!pila.isEmpty()) { // Mientras la pila no esté vacía
                char actual = pila.pop(); // Extraemos el elemento superior de la pila
                if (actual == elemento) { // Si encontramos el elemento buscado
                    System.out.println("Elemento encontrado en la posición: " + posicion);
                    encontrado = true; // Marcamos que el elemento fue encontrado
                    break; // Salimos del bucle
                }
                pilaAux.push(actual); // Si no es el elemento buscado, lo pasamos a la pila auxiliar
                posicion--; // Reducimos la posición
            }

            // Restauramos la pila original volviendo a pasar los elementos de la pila auxiliar
            while (!pilaAux.isEmpty()) {
                pila.push(pilaAux.pop());
            }

            // Si al terminar el recorrido el elemento no se encontró, se muestra un mensaje
            if (!encontrado) {
                System.out.println("Elemento no encontrado, intente de nuevo.");
            }
        }
    }

    // Método principal para probar el programa
    public static void main(String[] args) {
        PilaBusqueda pilaBusqueda = new PilaBusqueda(); // Creamos una instancia de la clase
        Scanner Scanner = new Scanner(System.in); // Scanner para leer entrada del usuario

        System.out.println("Ingrese caracteres para llenar la pila:");
        String entrada = Scanner.nextLine(); // Leemos la entrada del usuario
        pilaBusqueda.llenarPila(entrada.toCharArray()); // Convertimos la entrada en array de caracteres y llenamos la pila

        System.out.println("Ingrese el carácter que desea buscar:");
        char caracterBuscado = Scanner.next().charAt(0); // Leemos el carácter a buscar
        pilaBusqueda.buscarElemento(caracterBuscado); // Llamamos al método para buscar el elemento
    }
}

