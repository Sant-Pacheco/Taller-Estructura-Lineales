package matrices;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrizSimetricaEsquinas(scanner);
        scanner.close();
    }

    public static void matrizSimetricaEsquinas(Scanner scanner) {
        System.out.print("Ingrese el tamaño de la matriz cuadrada (n): ");
        int n = scanner.nextInt();

        int[][] matriz = generarMatrizAleatoria(n, 1, 9); // Números pequeños para visualizar mejor
        imprimirMatriz(matriz);

        imprimirEsquinas(matriz);

        boolean simetrica = esSimetrica(matriz);
        System.out.println("\n¿La matriz es simétrica?: " + (simetrica ? "SÍ" : "NO"));
    }

    private static int[][] generarMatrizAleatoria(int n, int min, int max) {
        Random rand = new Random();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    // Valida si A[i][j] == A[j][i]
    private static boolean esSimetrica(int[][] matriz) {
        int n = matriz.length;

        // Solo es necesario comparar la mitad superior triangular (j > i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false; // Si encuentra un par distinto, cancela de inmediato
                }
            }
        }
        return true;
    }

    private static void imprimirEsquinas(int[][] matriz) {
        int n = matriz.length;
        System.out.println("\n--- VALORES DE LAS ESQUINAS ---");
        System.out.println("Esquina Sup. Izquierda [0][0]: " + matriz[0][0]);
        System.out.println("Esquina Sup. Derecha   [0][" + (n - 1) + "]: " + matriz[0][n - 1]);
        System.out.println("Esquina Inf. Izquierda [" + (n - 1) + "][0]: " + matriz[n - 1][0]);
        System.out.println("Esquina Inf. Derecha   [" + (n - 1) + "][" + (n - 1) + "]: " + matriz[n - 1][n - 1]);
    }

    private static void imprimirMatriz(int[][] matriz) {
        System.out.println("\n--- MATRIZ GENERADA ---");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }
}