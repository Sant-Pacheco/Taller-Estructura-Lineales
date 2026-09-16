package matrices;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrizIntercambioFila(scanner);
        scanner.close();
    }

    public static void matrizIntercambioFila(Scanner scanner) {
        System.out.print("Ingrese número de filas (m, mínimo 2): ");
        int m = scanner.nextInt();

        System.out.print("Ingrese número de columnas (n): ");
        int n = scanner.nextInt();

        if (m < 2) {
            System.out.println("Error: Se necesitan al menos 2 filas para realizar el intercambio.");
            return;
        }

        int[][] matriz = generarMatrizAleatoria(m, n, 10, 99);

        System.out.println("\n--- MATRIZ ORIGINAL ---");
        imprimirMatriz(matriz);

        // Intercambio de la primera fila (índice 0) con la segunda fila (índice 1)
        intercambiarFilas(matriz, 0, 1);

        System.out.println("\n--- MATRIZ CON FILA 1 Y FILA 2 INTERCAMBIADAS ---");
        imprimirMatriz(matriz);
    }

    private static int[][] generarMatrizAleatoria(int filas, int columnas, int min, int max) {
        Random rand = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    // Intercambia la referencia completa del arreglo de la fila
    private static void intercambiarFilas(int[][] matriz, int fila1, int fila2) {
        int[] aux = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = aux;
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }
}