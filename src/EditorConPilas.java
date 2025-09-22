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
     //Creación del metodo principal que controla el programa.
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" EDITOR DE TEXTO CON PILAS ");
        System.out.println("Ingresa tu información (presiona 5 para finalizar):");

        while (true) {
            // Pedir información al usuario
            System.out.print("\nEscribir texto: ");
            String informacion = scanner.nextLine();

            // Si escribe 5 termina el programa
            if (informacion.equalsIgnoreCase("5")) {
                System.out.println("Programa Finalizado");
                break;
            }

            // Este campo agrega la informacion a la pila principal
            pilaPrincipal.push(informacion);
            System.out.println("Informacion guardada: '" + informacion + "'");

            // Mostrar el menú despues de ingresar información
            mostrarMenu(scanner);
        }

        scanner.close();
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
     //Creación del metodo principal que controla el programa.
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" EDITOR DE TEXTO CON PILAS ");
        System.out.println("Ingresa tu información (presiona 5 para finalizar):");

        while (true) {
            // Pedir información al usuario
            System.out.print("\nEscribir texto: ");
            String informacion = scanner.nextLine();

            // Si escribe 5 termina el programa
            if (informacion.equalsIgnoreCase("5")) {
                System.out.println("Programa Finalizado");
                break;
            }

            // Este campo agrega la informacion a la pila principal
            pilaPrincipal.push(informacion);
            System.out.println("Informacion guardada: '" + informacion + "'");

            // Mostrar el menú despues de ingresar información
            mostrarMenu(scanner);
        }

        scanner.close();
    }
     // Mostrar menú con las opciones
    private void mostrarMenu(Scanner scanner) {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            System.out.println("\n Opciones: ");
            System.out.println("1: Deshacer");
            System.out.println("2: Rehacer");
            System.out.println("3: ver información ingresada");
            System.out.println("4: Continuar ingresando su información ");
            System.out.println("5: Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa informacion valida.");
                entradaValida = false;
            }

            if (entradaValida) {
                switch (opcion) {
                    case 1:
                        deshacer();
                        break;

                    case 2:
                        rehacer();
                        break;

                    case 3:
                        verInformacion();
                        break;

                    case 4:
                        System.out.println("Continuando...");
                        break;

                    /// al precionar la tecla 5 finaliza la ejecucion del programa.
                    case 5:
                        System.out.println("El programa se cerrará");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        entradaValida = false;
                }
            }

        } while (!entradaValida || opcion != 4);
    }

    // Deshacer: quita el último elemento de la pila principal y lo pone en la pila de deshechos
    private void deshacer() {
        if (!pilaPrincipal.isEmpty()) {
            String datoDeshacer = pilaPrincipal.pop();
            pilaDeshechos.push(datoDeshacer);
            System.out.println("Se deshizo: '" + datoDeshacer + "'");
            System.out.println("El dato se movió a la pila de deshechos.");
        } else {
            System.out.println("No hay información que deshacer.");
        }
    }
