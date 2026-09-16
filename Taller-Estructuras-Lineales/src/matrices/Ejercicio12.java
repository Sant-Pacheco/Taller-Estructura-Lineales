package matrices;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrizNxN(scanner);
        scanner.close();
    }

    public static void matrizNxN(Scanner scanner){
        System.out.println("Ingrese el tamaño de la matriz cuadrada (n):");
        int n = scanner.nextInt();

        int[][] matriz = generarMatrizAleatoria(n, -50, 50);
        imprimirMatriz(matriz);
        int sumaDiagonalSecundaria = calcularSumaDiagonalOpuesta(matriz);
        System.out.println("\nLa sumatoria de la matriz diagonal opuesta es: "+ sumaDiagonalSecundaria);
    }
    //Recordar n = tamaño de la matriz
    private static int[][] generarMatrizAleatoria(int n, int min, int max){
        Random rand = new Random();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(max - min + 1)+ min;
            }
        }
        return matriz;
    }
//Recorrido eficiente al usar la diagonal de los indices
    private static int calcularSumaDiagonalOpuesta(int[][] matriz){
        int suma=0;
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            int columnaOpuesta = (n-1) - i;
            suma += matriz[i][columnaOpuesta];
        }
        return suma;
    }

    private static void imprimirMatriz (int[][] matriz){
        System.out.println("\n--- MATRIZ " + matriz.length + "x" + matriz.length + " ---");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }
}
