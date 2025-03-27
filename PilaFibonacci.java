import java.util.Scanner;
import java.util.Stack;

public class PilaFibonacci {
    private Stack<Integer> pila; // Pila para almacenar los números

    // Constructor que inicializa la pila
    public PilaFibonacci() {
        this.pila = new Stack<>();
    }

    // Método para llenar la pila con números aleatorios entre 1 y 10
    public void llenarPila(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = (int) (Math.random() * 10) + 1; // Número entre 1 y 10
            pila.push(numeroAleatorio); // Agregamos el número a la pila
        }
    }

    // Método para calcular la serie de Fibonacci de un número dado
    public int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Método que reemplaza cada número por su valor en la serie de Fibonacci
    public void calcularFibonacci() {
        Stack<Integer> pilaAux = new Stack<>();

        while (!pila.isEmpty()) {
            int num = pila.pop();
            pilaAux.push(fibonacci(num)); // Reemplazamos por su Fibonacci
        }

        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop()); // Restauramos la pila original
        }
    }

    // Método para ordenar la pila en orden ascendente SIN usar Collections.sort()
    public void ordenarPila() {
        Stack<Integer> pilaAux = new Stack<>(); // Pila auxiliar para ordenar

        while (!pila.isEmpty()) {
            int temp = pila.pop(); // Sacamos un elemento de la pila

            // Reubicamos los elementos en la pila auxiliar en orden ascendente
            while (!pilaAux.isEmpty() && pilaAux.peek() > temp) {
                pila.push(pilaAux.pop());
            }
            pilaAux.push(temp); // Insertamos el elemento en su posición correcta
        }

        // Restauramos la pila original con los elementos ordenados
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    // Método para eliminar un número de la pila
    public void eliminarElemento(int valor) {
        Stack<Integer> pilaAux = new Stack<>();
        boolean encontrado = false;

        while (!pila.isEmpty()) {
            int num = pila.pop();
            if (num == valor && !encontrado) {
                encontrado = true; // Eliminamos solo la primera ocurrencia
            } else {
                pilaAux.push(num); // Guardamos los demás elementos
            }
        }

        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop()); // Restauramos la pila sin el número eliminado
        }

        if (encontrado) {
            System.out.println("Número " + valor + " eliminado correctamente.");
        } else {
            System.out.println("El número " + valor + " no se encontró en la pila.");
        }
    }

    // Método para mostrar los elementos de la pila
    public void mostrarPila() {
        System.out.println("Pila actual: " + pila);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilaFibonacci pilaFibonacci = new PilaFibonacci();

        System.out.print("Ingrese la cantidad de números aleatorios a generar: ");
        int cantidad = scanner.nextInt();

        // Llenamos la pila con números aleatorios
        pilaFibonacci.llenarPila(cantidad);
        System.out.println("Pila con números aleatorios:");
        pilaFibonacci.mostrarPila();

        // Calculamos la serie de Fibonacci para cada número
        pilaFibonacci.calcularFibonacci();
        System.out.println("Pila después de reemplazar cada número con su Fibonacci:");
        pilaFibonacci.mostrarPila();

        // Ordenamos la pila en orden ascendente sin usar Collections
        pilaFibonacci.ordenarPila();
        System.out.println("Pila ordenada de manera ascendente:");
        pilaFibonacci.mostrarPila();

        // Solicitamos un número para eliminar
        System.out.print("Ingrese un número de la pila para eliminar: ");
        int numeroEliminar = scanner.nextInt();

        // Eliminamos el número y mostramos la pila final
        pilaFibonacci.eliminarElemento(numeroEliminar);
        System.out.println("Pila después de eliminar el número:");
        pilaFibonacci.mostrarPila();
    }
}

