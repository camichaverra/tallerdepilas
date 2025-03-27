import java.util.Stack;

public class pilas {

    // 1. Método para verificar si una expresión tiene paréntesis balanceados
    public static boolean balanceoParentesis(String expresion) {
        Stack<Character> pila = new Stack<>();
        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;
                char apertura = pila.pop();
                if ((c == ')' && apertura != '(') || (c == ']' && apertura != '[') || (c == '}' && apertura != '{')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    // 2. Método para convertir un número decimal a binario usando una pila
    public static String decimalABinario(int numero) {
        Stack<Integer> pila = new Stack<>();
        while (numero > 0) {
            pila.push(numero % 2);
            numero /= 2;
        }
        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        return binario.toString();
    }

    // 3. Método para evaluar una expresión matemática en notación postfija
    public static int evaluarPostfija(String expresion) {
        Stack<Integer> pila = new Stack<>();
        for (String token : expresion.split(" ")) {
            if (token.matches("\\d+")) { // Si es un número
                pila.push(Integer.parseInt(token));
            } else { // Es un operador
                int b = pila.pop();
                int a = pila.pop();
                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                }
            }
        }
        return pila.pop();
    }

    // 4. Método para invertir una cadena usando una pila
    public static String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }
        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    // 5. Método para eliminar duplicados en una pila
    public static Stack<Integer> eliminarDuplicados(Stack<Integer> pila) {
        Stack<Integer> auxiliar = new Stack<>();
        while (!pila.isEmpty()) {
            int valor = pila.pop();
            if (!auxiliar.contains(valor)) {
                auxiliar.push(valor);
            }
        }
        return auxiliar;
    }

    public static void main(String[] args) {
        // Pruebas
        System.out.println("Balanceo de paréntesis en '(5+3)*(8/(2-1))': " + balanceoParentesis("(5+3)*(8/(2-1))"));
        System.out.println("Decimal 25 a Binario: " + decimalABinario(25));
        System.out.println("Evaluar Postfija '3 4 + 2 *': " + evaluarPostfija("3 4 + 2 *"));
        System.out.println("Invertir 'Hola Mundo': " + invertirCadena("Hola Mundo"));
        
        // Prueba de eliminar duplicados
        Stack<Integer> pilaNumeros = new Stack<>();
        pilaNumeros.push(4);
        pilaNumeros.push(8);
        pilaNumeros.push(4);
        pilaNumeros.push(3);
        pilaNumeros.push(8);
        System.out.println("Pila sin duplicados: " + eliminarDuplicados(pilaNumeros));
    }
}

