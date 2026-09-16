package matrices;

public class Ejercicio14 {

    public static void main(String[] args) {
        matrizTraspuesta();
    }

    public static void matrizTraspuesta() {
        // Inicialización con valores predeterminados (Matriz 3 filas x 4 columnas)
        int[][] original = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[][] transpuesta = obtenerTranspuesta(original);

        System.out.println("--- MATRIZ ORIGINAL (3x4) ---");
        imprimirMatriz(original);

        System.out.println("\n--- MATRIZ TRANSPUESTA (4x3) ---");
        imprimirMatriz(transpuesta);
    }

    private static int[][] obtenerTranspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // La transpuesta invierte las dimensiones: columnas x filas
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j]; // Se intercambian los índices
            }
        }
        return transpuesta;
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