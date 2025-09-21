import java.util.Scanner;
//  Actividad 2 Pilas ( Stack )
class Pila {
    private String[] elementos;  // Arreglo para guardar los elementos
    private int tope;           // Índice del último elemento
    private int tamaño;         // Tamaño máximo de la pila

    // Se crea una pila vacia
    public Pila(int tamaño) {
        this.tamaño = tamaño;
        this.elementos = new String[tamaño];
        this.tope = -1;  // el -1 significa que está vacía
    }
    
    // push(): agrega el elemento arriba de la pila
    public void push(String elemento) {
        if (tope < tamaño - 1) {  // Si hay espacio
            tope++;
            elementos[tope] = elemento;
        } else {
            System.out.println("La pila está llena!");// imprime el mensaje la pila esta llena
        }
    }

    // pop(): quitar y devolver el elemento de arriba
    public String pop() {
        if (!isEmpty()) {  // Si no está vacía
            String elemento = elementos[tope];
            elementos[tope] = null;  // Limpiar la posición
            tope--;
            
            return elemento;
        } else {
            return null;
        }
    }
    // peek(): ver el elemento de arriba sin quitarlo
    public String peek() {
        if (!isEmpty()) {
            return elementos[tope];
        } else {
            return null;
        }
    }

    // isEmpty: revisa si la pila está vacia
    public boolean isEmpty() {
        return tope == -1;
    }

    // Clase principal
public class EditorConPilas {
    private Pila pilaPrincipal;    // Pila que almacena la información que ingresa el usuario
    private Pila pilaDeshechos;    // Pila que almacena los datos que el usuario deshace

    // Constructor
    public EditorConPilas() {
        this.pilaPrincipal = new Pila(50);   // Tamaño maximo de la pila de 50 elementos
        this.pilaDeshechos = new Pila(50);   // Tamaño maximo de la pila de 50 elementos
    }
