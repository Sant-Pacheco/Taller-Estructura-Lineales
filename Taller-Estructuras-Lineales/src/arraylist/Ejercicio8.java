package arraylist;
import java.util.ArrayList;
import java.util.Random;

public class Ejercicio8 {
    public static void main(String[] args) {
        tabladeFrecuencias();
    }

    public static void tabladeFrecuencias(){
        ArrayList<Integer> numeros = generarAleatorios(100, 1, 20);
        int[] frecuencias = calcularFrecuencias(numeros);

        imprimirTablaMasFrecuente(frecuencias);
    }

    private static ArrayList<Integer> generarAleatorios(int cantidad, int min, int max){
        Random rand = new Random();
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(rand.nextInt(max - min + 1) + min);
        }
        return lista;
    }

    private static int[] calcularFrecuencias(ArrayList<Integer> lista){
        int[] frecuencias = new int[21]; // Para tener el indice de 1 a 20
        for (int num : lista) {
            frecuencias[num]++;
        }
        return frecuencias;
    }

    private static void imprimirTablaMasFrecuente(int[] frecuencias){
        System.out.printf("%-10s | %-10s\n", "Número", "Frecuencia");
        System.out.println("-----------------------");

        int masFrecuente = 1;
        int maxFrecuencia = frecuencias[1];

        for (int i = 0; i <= 20; i++) {
            System.out.printf("%-10d | %-10d\n", i, frecuencias[i]);
            if(frecuencias[i] > maxFrecuencia){
                maxFrecuencia = frecuencias[i];
                masFrecuente = i;
            }
        }
        System.out.println("\nEl número más frecuente es el: "+ masFrecuente +" con "+ maxFrecuencia +" apariciones.");
    }
}
