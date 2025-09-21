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
