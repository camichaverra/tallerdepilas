import java.util.Scanner;
import java.util.Stack; // Importamos la clase Stack para manejar la pila

public class AnalisisPila {
    private Stack<Integer> pila; // Pila para almacenar los números

    // Constructor que inicializa la pila
    public AnalisisPila() {
        this.pila = new Stack<>();
    }

    // Método para llenar la pila con números ingresados por el usuario
    public void llenarPila(int[] numeros) {
        for (int num : numeros) {
            pila.push(num); // Agregamos cada número a la pila
        }
    }

    // Método que analiza la pila según las condiciones dadas
    public void analizarPila() {
        Stack<Integer> pilaAux = new Stack<>(); // Pila auxiliar para restaurar valores originales

        int cantidad20_80 = 0; // Contador de números entre 20 y 80
        int cantidadPositivos = 0; // Contador de números positivos
        int suma80_200 = 0; // Suma de los números entre 80 y 200

        while (!pila.isEmpty()) { // Mientras la pila no esté vacía
            int num = pila.pop(); // Extraemos un número de la pila

            // Si el número es negativo, lo elevamos al cubo
            if (num < 0) {
                System.out.println("El número negativo " + num + " elevado al cubo es: " + (num * num * num));
            }

            // Contamos los números que están entre 20 y 80
            if (num >= 20 && num <= 80) {
                cantidad20_80++;
            }

            // Contamos los números positivos
            if (num > 0) {
                cantidadPositivos++;
            }

            // Sumamos los números entre 80 y 200
            if (num >= 80 && num <= 200) {
                suma80_200 += num;
            }

            pilaAux.push(num); // Guardamos el número original en la pila auxiliar
        }

        // Restauramos la pila original con los elementos de la pila auxiliar
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }

        // Mostramos los resultados del análisis
        System.out.println("Cantidad de números entre 20 y 80: " + cantidad20_80);
        System.out.println("Cantidad de números positivos: " + cantidadPositivos);
        System.out.println("Suma de los números entre 80 y 200: " + suma80_200);
    }

    // Método principal para probar el programa
    public static void main(String[] args) {
        AnalisisPila analisisPila = new AnalisisPila(); // Creamos una instancia de la clase
        Scanner scanner = new Scanner(System.in); // Scanner para leer entrada del usuario

        System.out.println("Ingrese la cantidad de números a procesar:");
        int n = scanner.nextInt(); // Leemos cuántos números quiere ingresar
        int[] numeros = new int[n]; // Creamos un array para almacenar los números

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt(); // Leemos cada número y lo almacenamos en el array
        }

        analisisPila.llenarPila(numeros); // Llenamos la pila con los números ingresados
        analisisPila.analizarPila(); // Analizamos la pila y mostramos los resultados
    }
}

