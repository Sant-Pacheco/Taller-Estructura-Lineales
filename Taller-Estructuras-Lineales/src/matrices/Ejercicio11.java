package matrices;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matricesMFilasNColumnas(scanner);
        scanner.close();
    }

    public static void matricesMFilasNColumnas(Scanner scanner){
        System.out.println("Ingrese número de filas (m):");
        int m = scanner.nextInt();
        System.out.println("Ingrese número de columnas (n):");
        int n = scanner.nextInt();

        //Crear e iniciar la matriz
        int[][] matriz = generarMatrizAleatoria (m, n, 1, 50); //limitado de 1 a 50
        imprimirMatriz(matriz);

        System.out.println("\nIngrese el número entero que desea buscar: ");
        int numeroBuscado = scanner.nextInt();
        buscarPrimeraOcurrencia(matriz, numeroBuscado);
    }
    //Metodo para rellenar la matriz de números al azar
    private static int[][] generarMatrizAleatoria (int filas, int columnas, int min, int max){
        Random rand = new Random();
        int[][] matriz = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(max - min + 1)+min;
            }
        }
        return matriz;
    }

    private static void buscarPrimeraOcurrencia(int[][] matriz, int objetivo){
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == objetivo){
                    System.out.printf("El número %d se encuentra en la posición: Fila %d, Columna %d\n", objetivo, i+1, j+1);
                    encontrado = true;
                    return; //Retornamos de inmediato para ignorarotras ocurrencias
                }
            }
        }
        if(!encontrado){
            System.out.println("El número "+ objetivo +" NO se encuentra en la matriz.");

        }    
    }
    //Metodo para imprimir la matriz en formato de cuadricula
    private static void imprimirMatriz(int[][] matriz) {
        System.out.println("\n--- Matriz Generada ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                 System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println(); // Salto de línea al terminar cada fila
        }
    }
}
