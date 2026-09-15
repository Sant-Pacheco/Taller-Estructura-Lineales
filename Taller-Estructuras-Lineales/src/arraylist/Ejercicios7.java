package arraylist;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arraylist20numAscendente(scanner);
        scanner.close();
    }

    public static void arraylist20numAscendente(Scanner scanner){
        ArrayList<Integer> pares = generarPares(20); //Inicializamos los primero 20 pares
        System.out.println("Arraylist inicial:");
        System.out.println(pares + "\n");

        System.out.println("Ingrese un número:"); //Recibir y ordenar numero automaticamente
        int numeroInsertar = scanner.nextInt();
        insertarenOrden(pares, numeroInsertar);
        System.out.println("Arraylist ordenado:");
        System.out.println(pares + "\n");

        System.out.println("Ingrese un número para borrar de la lista:"); //Borrar numero que indica usuario
        int numeroEliminar = scanner.nextInt();
        boolean eliminado = pares.remove(Integer.valueOf(numeroEliminar));
        if(eliminado){
            System.out.println("El valor "+ numeroEliminar +" eliminado correctamente");
        }else{
            System.out.println("El valor "+ numeroEliminar +" no se encuentra en la lista");
        }
        System.out.println("Arraylist (lista) final es:");
        System.out.println(pares);
    }

    private static ArrayList<Integer> generarPares(int cantidad){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= cantidad; i++) {
            lista.add(i*2);
        }
        return lista;
    }

    private static void insertarenOrden(ArrayList<Integer> lista, int numero){
        int posicion=0; //Buscador de la posicion donde el numero debe ser insertado para conservar el orden
        while (posicion<lista.size() && lista.get(posicion)<numero) {
            posicion++;
        }
        lista.add(posicion, numero);
    }
}
