package arraylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio9 {
    public static void main(String[] args) {
        ordenamientoySeparacion();
    }

    public static void ordenamientoySeparacion(){
        ArrayList<Integer> original = generarAleatorios(20, 1, 100);
        System.out.println("Lista original: "+ original);

        //Orden de menor a mayor
        ArrayList<Integer> ascendente = new ArrayList<>(original);
        Collections.sort(ascendente);
        System.out.println("Menor a mayor: "+ ascendente);
        //biceversa
        ArrayList<Integer> descendente = new ArrayList<>(original);
        Collections.sort(descendente, Collections.reverseOrder());
        System.out.println("Mayor a menos: "+ descendente);

        //Pares e impares separados
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();
        separarParesImpares(original, pares, impares);

        System.out.println("Lista impares: "+ impares);
        System.out.println("Lista pares: "+ pares);
    }

    private static ArrayList<Integer> generarAleatorios(int cantidad, int min, int max){
        Random rand = new Random();
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(rand.nextInt(max - min + 1)+min);
        }
        return lista;
    }

    private static void separarParesImpares(ArrayList<Integer> orig, ArrayList<Integer> pares, ArrayList<Integer> impares){
        for (int num : orig) {
            if(num % 2 == 0){
                pares.add(num);
            }else{
                impares.add(num);
            }
        }
    }
}
