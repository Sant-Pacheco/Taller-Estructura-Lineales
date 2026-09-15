package arreglos;
import java.util.Random;

public class Ejercicio4 {
    public static void main(String[] args) {
        Arreglominamax();
    }

    public static void Arreglominamax(){
        int[] numeros = generarAleatorios(25, -50, 50);

        imprimirArreglo(numeros);
        encontrarMayoryMenor(numeros);
    }

    private  static int[] generarAleatorios(int cantidad, int min, int max){
        Random rand = new Random();
        int[] arreglo = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arreglo[i]=rand.nextInt(max - min + 1) + min;
        }
        return arreglo;
    }

    private static void encontrarMayoryMenor(int[] arreglo){
        int menor = arreglo[0];
        int mayor = arreglo[0];
        
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] < menor){
                menor=arreglo[i];
            }
            if(arreglo[i] > mayor){
                mayor=arreglo[i];
            }
        }
        System.out.println("El número mayor del arreglo es: "+ mayor);
        System.out.println("El número menor del arreglo es: "+ menor);
    }

    private static void imprimirArreglo(int[] arreglo){
        System.out.println("\n--- Arreglo de 25 números al azar ---");
        for (Object num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
}
