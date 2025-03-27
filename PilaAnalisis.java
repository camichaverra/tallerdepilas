import java.util.Stack;

public class PilaAnalisis {
    private Stack<Integer> pila;

    public PilaAnalisis() {
        this.pila = new Stack<>();
    }

    public void llenarPila(int[] numeros) {
        for (int num : numeros) {
            pila.push(num);
        }
    }

    public void analizarPila() {
        Stack<Integer> pilaAux = new Stack<>();
        while (!pila.isEmpty()) {
            int num = pila.pop();
            if (num < 0) {
                num = 0;
            } else if (num >= 8 && num <= 20) {
                num = 50;
            } else if (num > 60 && num < 62) {
                num = 100;
            }
            pilaAux.push((int) Math.sqrt(num));
        }
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
        }
    }

    public void mostrarPila() {
        System.out.println("Contenido de la pila:");
        for (int num : pila) {
            System.out.println(num);
        }
    }
}
