import java.util.Scanner;
import java.util.Stack; // Importamos la clase Stack para manejar la pila

public class FactorialPila {
    private Stack<Integer> pila; // Declaramos una pila para almacenar los números

    // Constructor que inicializa la pila
    public FactorialPila() {
        this.pila = new Stack<>();
    }

    // Método para llenar la pila con números ingresados por el usuario
    public void llenarPila(int[] numeros) {
        for (int num : numeros) {
            pila.push(num); // Agregamos cada número a la pila
        }
    }

    // Método que calcula el factorial de un número
    private int calcularFactorial(int num) {
        int factorial = 1; // Inicializamos el factorial en 1
        for (int i = 1; i <= num; i++) {
            factorial *= i; // Multiplicamos cada número desde 1 hasta num
        }
        return factorial; // Retornamos el resultado
    }

    // Método para calcular el factorial de cada número en la pila
    public void calcularFactoriales() {
        Stack<Integer> pilaAux = new Stack<>(); // Pila auxiliar para restaurar los valores originales

        while (!pila.isEmpty()) { // Mientras la pila no esté vacía
            int num = pila.pop(); // Extraemos un número de la pila
            int factorial = calcularFactorial(num); // Calculamos su factorial
            System.out.println("Factorial de " + num + " es: " + factorial); // Mostramos el resultado
            pilaAux.push(num); // Guardamos el número original en la pila auxiliar
        }

        // Restauramos la pila original con los elementos de la pila auxiliar
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    // Método principal para probar el programa
    public static void main(String[] args) {
        FactorialPila factorialPila = new FactorialPila(); // Creamos una instancia de la clase
        Scanner scanner = new Scanner(System.in); // Scanner para leer entrada del usuario

        System.out.println("Ingrese la cantidad de números a procesar:");
        int n = scanner.nextInt(); // Leemos cuántos números quiere ingresar
        int[] numeros = new int[n]; // Creamos un array para almacenar los números

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt(); // Leemos cada número y lo almacenamos en el array
        }

        factorialPila.llenarPila(numeros); // Llenamos la pila con los números ingresados
        factorialPila.calcularFactoriales(); // Calculamos y mostramos el factorial de cada número
    }
}
