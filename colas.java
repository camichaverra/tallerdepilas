import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class colas {
    
    // 1. Simulación de un sistema de atención de emergencias
    static class Emergencia {
        String tipo;
        int prioridad; // A menor número, mayor prioridad

        public Emergencia(String tipo, int prioridad) {
            this.tipo = tipo;
            this.prioridad = prioridad;
        }
    }

    public static void atenderEmergencias() {
        Queue<Emergencia> cola = new LinkedList<>();
        cola.add(new Emergencia("Incendio", 1));
        cola.add(new Emergencia("Accidente de tráfico", 2));
        cola.add(new Emergencia("Corte de electricidad", 3));
        
        while (!cola.isEmpty()) {
            Emergencia e = cola.poll(); // Atiende la emergencia en orden FIFO
            System.out.println("Atendiendo: " + e.tipo + " con prioridad " + e.prioridad);
        }
    }

    // 2. Ordenamiento manual de una cola (Bubble Sort adaptado para colas)
    public static Queue<Integer> ordenarCola(Queue<Integer> cola) {
        int n = cola.size();
        Integer[] arr = cola.toArray(new Integer[0]);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        cola.clear();
        for (int num : arr) {
            cola.add(num);
        }
        return cola;
    }

    // 3. Buscar y eliminar un elemento de una cola sin perder el orden
    public static Queue<Integer> eliminarElemento(Queue<Integer> cola, int valor) {
        Queue<Integer> nuevaCola = new LinkedList<>();
        boolean eliminado = false;
        while (!cola.isEmpty()) {
            int num = cola.poll();
            if (num == valor && !eliminado) {
                eliminado = true; // Solo elimina la primera aparición
                continue;
            }
            nuevaCola.add(num);
        }
        return nuevaCola;
    }

    // 4. Implementación de BFS usando una cola
    static class Grafo {
        private LinkedList<Integer>[] adj;
        
        public Grafo(int vertices) {
            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        
        public void agregarArista(int origen, int destino) {
            adj[origen].add(destino);
            adj[destino].add(origen);
        }
        
        public void BFS(int inicio) {
            boolean[] visitado = new boolean[adj.length];
            Queue<Integer> cola = new LinkedList<>();
            cola.add(inicio);
            visitado[inicio] = true;
            
            while (!cola.isEmpty()) {
                int nodo = cola.poll();
                System.out.print(nodo + " ");
                for (int vecino : adj[nodo]) {
                    if (!visitado[vecino]) {
                        visitado[vecino] = true;
                        cola.add(vecino);
                    }
                }
            }
        }
    }
    
    // 5. Manejo avanzado de pilas (invertir, filtrar y operar datos)
    public static Stack<Integer> procesarPila(Stack<Integer> pila) {
        Stack<Integer> nuevaPila = new Stack<>();
        while (!pila.isEmpty()) {
            int num = pila.pop();
            if (num < 0) {
                nuevaPila.push(num * num * num); // Si es negativo, calcular el cubo
            } else {
                nuevaPila.push(num);
            }
        }
        return nuevaPila;
    }
    
    public static void main(String[] args) {
        // Prueba de cada método
        System.out.println("\nAtendiendo Emergencias:");
        atenderEmergencias();

        Queue<Integer> colaNumeros = new LinkedList<>();
        colaNumeros.add(5);
        colaNumeros.add(2);
        colaNumeros.add(9);
        colaNumeros.add(1);
        colaNumeros.add(8);
        System.out.println("\nCola Ordenada: " + ordenarCola(colaNumeros));

        System.out.println("\nCola después de eliminar el 2: " + eliminarElemento(colaNumeros, 2));
        
        Grafo g = new Grafo(6);
        g.agregarArista(0, 1);
        g.agregarArista(0, 2);
        g.agregarArista(1, 3);
        g.agregarArista(1, 4);
        g.agregarArista(2, 5);
        System.out.println("\nBFS desde nodo 0:");
        g.BFS(0);
        
        Stack<Integer> pilaNumeros = new Stack<>();
        pilaNumeros.push(3);
        pilaNumeros.push(-4);
        pilaNumeros.push(7);
        pilaNumeros.push(-2);
        System.out.println("\nPila Procesada: " + procesarPila(pilaNumeros));
    }
}
 {
    
}
