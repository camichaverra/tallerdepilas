 import java.util.Stack;

public class invertircadena {
    // Método que invierte una cadena usando una pila
    public static String invertir(String cadena) {
        Stack<Character> pila = new Stack<>(); // Se crea una pila para almacenar los caracteres
        
        // Se apilan los caracteres de la cadena
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }
        
        StringBuilder cadenaInvertida = new StringBuilder();
        
        // Se desapilan los caracteres y se agregan a la nueva cadena
        while (!pila.isEmpty()) {
            cadenaInvertida.append(pila.pop());
        }
        
        return cadenaInvertida.toString(); // Se devuelve la cadena invertida
    }
}
 
