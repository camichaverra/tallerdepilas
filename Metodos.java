package tallerdepilas; 
import java.util.*;


    // Métodos aquí


// Clase que contiene los métodos de cada operación
 public class Metodos {
    
    // Método para calcular la suma de las filas de una matriz usando una pila
    public void sumaFilasPila() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la dimensión n de la matriz (n x n): ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];
        Stack<Integer> pila = new Stack<>();
        
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
                sumaFila += matriz[i][j];
            }
            pila.push(sumaFila);
        }
        
        System.out.println("Suma de cada fila (de arriba hacia abajo en la pila):");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
    
    // Método para calcular la suma de las columnas de una matriz usando una pila
    public void sumaColumnasPila() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la dimensión n de la matriz (n x n): ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];
        Stack<Integer> pila = new Stack<>();
        
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                sumaColumna += matriz[i][j];
            }
            pila.push(sumaColumna);
        }
        
        System.out.println("Suma de cada columna (de izquierda a derecha en la pila):");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
    
    // Método para calcular el factorial de la dimensión de la matriz
    public void factorialDimension() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la dimensión n de la matriz (n x n): ");
        int n = sc.nextInt();
        
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        System.out.println("El factorial de " + n + " es: " + factorial);
    }
    
    // Método para invertir una cadena de caracteres usando una pila
    public void invertirCadena() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una cadena de caracteres: ");
        String cadena = sc.nextLine();
        Stack<Character> pila = new Stack<>();
        
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }
        
        System.out.print("Cadena invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
        System.out.println("\nNúmero de caracteres: " + cadena.length());
    }
    
    // Método para calcular la serie de Fibonacci y ordenarla en una pila
    public void fibonacciPila() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de términos de Fibonacci: ");
        int n = sc.nextInt();
        Stack<Integer> pila = new Stack<>();
        
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            pila.push(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        System.out.println("Serie Fibonacci en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
    
    // Método para calcular el factorial de números de una pila y ordenarla
    public void factorialPila() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();
        
        System.out.print("Ingrese la cantidad de números: ");
        int n = sc.nextInt();
        
        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pila.push(calcularFactorial(num));
        }
        
        List<Integer> lista = new ArrayList<>(pila);
        Collections.sort(lista);
        System.out.println("Factoriales ordenados: " + lista);
    }
    
    private int calcularFactorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
