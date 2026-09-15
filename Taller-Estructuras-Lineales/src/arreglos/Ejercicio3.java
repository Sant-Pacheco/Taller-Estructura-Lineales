package arreglos;

import java.util.Random;
import java.util.Scanner;


public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nnumerosAleatorios(scanner);

        scanner.close();
    }

    public static void nnumerosAleatorios(Scanner scanner){
        System.out.println("Ingrese la cantidad de números (n): ");
        int n = scanner.nextInt();
        //Generamos los aleatorios
        int[] originales = generarAleatorios(n, 0, 15); //limito el rango de 0 a 15 para evitar errores
        long[] factoriales= calcularFactorialesArreglo(originales);
        imprimirResultados(originales, factoriales);
    }

    //Hacemos el metodo para los aleatorios
    private static int[] generarAleatorios(int n, int min, int max){
        Random rand= new Random();
        int[] arreglo= new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i]=rand.nextInt(max - min + 1) + min; //Formula de numeros aleatorios
        }
        return arreglo;
    }

    private static long[] calcularFactorialesArreglo(int[] arreglo){
        long[] factoriales = new long[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            factoriales[i]=obtenerFactorial(arreglo[i]);
        }
        return factoriales;
    }

    private static long  obtenerFactorial(int num){
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial*=i;
        }
        return factorial;
    }

    private static void imprimirResultados(int[] origi, long[] fact){
        System.out.println("\n -- Resultados --");
        System.out.printf("%-10s | %-20s\n", "Número", "Factorial");
        System.out.println();
        for (int i = 0; i < origi.length; i++) {
        System.out.printf("%-10s | %-20d\n", origi[i], fact[i]);    
        }
    }
}
