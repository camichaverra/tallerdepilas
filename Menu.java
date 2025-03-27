// Clase principal con el menú
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Suma de filas de la matriz");
            System.out.println("2. Suma de columnas de la matriz");
            System.out.println("3. Factorial de la dimensión de la matriz");
            System.out.println("4. Invertir cadena");
            System.out.println("5. Serie Fibonacci con pila");
            System.out.println("6. Factorial de números en una pila");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1: 
                metodos.sumaFilasPila(); break;
                case 2:
                 metodos.sumaColumnasPila(); break;
                case 3:
                 metodos.factorialDimension(); break;
                case 4: 
                metodos.invertirCadena(); break;
                case 5: 
                metodos.fibonacciPila(); break;
                case 6: 
                metodos.factorialPila(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}

