package arraylist;
import java.util.ArrayList;
import java.util.Random;

public class Ejercicio6 {
    public static void main(String[] args) {
        arraylistTope10();
    }

    public static void arraylistTope10(){
        ArrayList<Integer> numeros = generarHastaDiez();

        int suma = calcularSuma(numeros);
        double media = (double) suma / numeros.size();
        imprimirResultados(numeros, suma, media);
    }
    private static ArrayList<Integer> generarHastaDiez(){
        ArrayList<Integer> lista = new ArrayList<>();
        Random rand = new Random();

        while (true) { 
            int num = rand.nextInt(21) - 10; //Generamos el rando de -10 a 10
            lista.add(num);
            if (num ==  10){
                break; //Detenemos el ciclo al llegar a 10
            }
        }
        return lista;
    }
    private  static int calcularSuma(ArrayList<Integer> lista){
        int suma = 0;
        for (int num : lista) {
            suma += num;
        }
        return suma;
    }
    private static void imprimirResultados(ArrayList<Integer> lista, int suma, double media){
        System.out.println("--- Números leídos en el ArrayList ---");
        System.out.println(lista);
        System.out.println("Total de elementos: "+ lista.size());
        System.out.println("Suma total: "+ suma);
        System.out.printf("Promedio (media) total: %.2f\n\n", media);
    }

}
