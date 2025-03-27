import java.util.Scanner;
import java.util.Stack;

public class PilaNumeros {
    private Stack<Integer> pila; // Creamos una pila de números enteros

    // Constructor: inicializa la pila vacía
    public PilaNumeros() {
        this.pila = new Stack<>();
    }

    // Método para llenar la pila con números aleatorios entre 1 y 10
    public void llenarPila(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = (int) (Math.random() * 10) + 1; // Generamos un número aleatorio entre 1 y 10
            pila.push(numeroAleatorio); // Agregamos el número a la pila
        }
    }

    // Método para calcular el factorial de un número
    public int factorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) { // Multiplicamos desde 2 hasta n
            resultado *= i;
        }
        return resultado;
    }

    // Método para reemplazar cada número de la pila con su factorial
    public void calcularFactorial() {
        Stack<Integer> pilaAux = new Stack<>(); // Creamos una pila auxiliar

        // Sacamos cada número, calculamos su factorial y lo guardamos en la pila auxiliar
        while (!pila.isEmpty()) {
            int num = pila.pop();
            pilaAux.push(factorial(num)); // Calculamos el factorial y lo almacenamos
        }

        // Restauramos la pila original con los factoriales calculados
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    // Método para ordenar la pila en orden ascendente
    public void ordenarAscendente() {
        Stack<Integer> pilaAux = new Stack<>(); // Creamos una pila auxiliar

        while (!pila.isEmpty()) {
            int temp = pila.pop(); // Extraemos un elemento de la pila

            // Movemos elementos de la pila auxiliar a la original hasta encontrar su lugar
            while (!pilaAux.isEmpty() && pilaAux.peek() > temp) {
                pila.push(pilaAux.pop());
            }
            pilaAux.push(temp);
        }

        // Restauramos la pila con los elementos ordenados
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    // Método para ordenar la pila en orden descendente
    public void ordenarDescendente() {
        Stack<Integer> pilaAux = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop(); // Extraemos un elemento

            // Reubicamos los elementos en la pila auxiliar para ordenar de mayor a menor
            while (!pilaAux.isEmpty() && pilaAux.peek() < temp) {
                pila.push(pilaAux.pop());
            }
            pilaAux.push(temp);
        }

        // Restauramos la pila original con los elementos ordenados
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    // Método para eliminar un número específico de la pila
    public void eliminarElemento(int valor) {
        Stack<Integer> pilaAux = new Stack<>();
        boolean encontrado = false; // Para verificar si el número estaba en la pila

        while (!pila.isEmpty()) {
            int num = pila.pop();
            if (num == valor && !encontrado) {
                encontrado = true; // Eliminamos solo la primera vez que encontramos el número
            } else {
                pilaAux.push(num);
            }
        }

        // Restauramos la pila sin el número eliminado
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }

        if (encontrado) {
            System.out.println("Número " + valor + " eliminado correctamente.");
        } else {
            System.out.println("El número " + valor + " no se encontró en la pila.");
        }
    }

    // Método para mostrar la pila en pantalla
    public void mostrarPila() {
        System.out.println("Pila actual: " + pila);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilaNumeros pilaNumeros = new PilaNumeros();

        // Solicitamos la cantidad de números a generar
        System.out.print("Ingrese la cantidad de números aleatorios a generar: ");
        int cantidad = scanner.nextInt();

        // Llenamos la pila con números aleatorios
        pilaNumeros.llenarPila(cantidad);
        System.out.println("Pila con números aleatorios:");
        pilaNumeros.mostrarPila();

        // Calculamos la factorial de cada número en la pila
        pilaNumeros.calcularFactorial();
        System.out.println("Pila después de reemplazar cada número con su factorial:");
        pilaNumeros.mostrarPila();

        // Ordenamos la pila en orden ascendente
        pilaNumeros.ordenarAscendente();
        System.out.println("Pila ordenada de manera ascendente:");
        pilaNumeros.mostrarPila();

        // Ordenamos la pila en orden descendente
        pilaNumeros.ordenarDescendente();
        System.out.println("Pila ordenada de manera descendente:");
        pilaNumeros.mostrarPila();

        // Pedimos un número al usuario para eliminar
        System.out.print("Ingrese un número de la pila para eliminar: ");
        int numeroEliminar = scanner.nextInt();

        // Eliminamos el número de la pila y mostramos el resultado final
        pilaNumeros.eliminarElemento(numeroEliminar);
        System.out.println("Pila después de eliminar el número:");
        pilaNumeros.mostrarPila();
    }
}
