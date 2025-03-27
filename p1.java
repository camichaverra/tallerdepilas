import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class p1 {

    // 1️⃣ Suma de filas usando una pila
    public void sumaFilasConPila(int[][] matriz) {
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < matriz.length; i++) { 
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) { 
                suma += matriz[i][j]; 
            }
            pila.push(suma);
        }

        int fila = 1;
        while (!pila.isEmpty()) { 
            System.out.println("Suma de la fila " + fila + ": " + pila.pop());
            fila++;
        }
    }

    // 2️⃣ Suma de columnas usando una cola
    public void sumaColumnasConCola(int[][] matriz) {
        Queue<Integer> cola = new LinkedList<>();

        for (int j = 0; j < matriz[0].length; j++) { 
            int suma = 0;
            for (int i = 0; i < matriz.length; i++) { 
                suma += matriz[i][j]; 
            }
            cola.offer(suma); 
        }

        int columna = 1;
        while (!cola.isEmpty()) { 
            System.out.println("Suma de la columna " + columna + ": " + cola.poll());
            columna++;
        }
    }

    // 3️⃣ Factorial de la dimensión de la matriz
    public int factorialDimension(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialDimension(n - 1);
    }

    // 4️⃣ Ordenar números de una cola de mayor a menor
    public void ordenarColaDescendente(Queue<Integer> cola) {
        int[] arreglo = new int[cola.size()];
        int index = 0;

        while (!cola.isEmpty()) { 
            arreglo[index++] = cola.poll(); 
        }

        Arrays.sort(arreglo);

        for (int i = arreglo.length - 1; i >= 0; i--) { 
            cola.offer(arreglo[i]);
        }

        System.out.println("Cola ordenada de mayor a menor: " + cola);
    }
}
