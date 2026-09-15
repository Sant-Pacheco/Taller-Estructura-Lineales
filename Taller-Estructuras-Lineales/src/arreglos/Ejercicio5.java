package arreglos;
import java.util.Random;

public class Ejercicio5 {
    public static void main(String[] args) {
        invertidNumerosArreglo();
    }

    public static void invertidNumerosArreglo(){
        int[] originales= generarAleatorios(20, 10, 999);
        int[] invertidos= invertirArreglo(originales);

        imprimirResultado(originales, invertidos);
    }

    private static int[] generarAleatorios(int cantidad, int min, int max){
        Random rand= new Random();
        int[] arreglo = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arreglo[i] = rand.nextInt(max - min + 1) + min;
        }
        return arreglo;
    }

    private static int[] invertirArreglo(int[] arreglo){
        int[] invertidos = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            invertidos[i]= invertirNumero(arreglo[i]);
        }

        return invertidos;
    }
    //Metodo para invertir los numeros
    private static int invertirNumero(int num){
        int numeroInvertido = 0;
        int auxiliar = Math.abs(num); //Para poder trabajar con valores absolutos

        while (auxiliar>0) {
            int ultimoDigito = auxiliar % 10;
            numeroInvertido = (numeroInvertido * 10)+ ultimoDigito;
            auxiliar /= 10; //Quitamos ese ultimo digito del número
        }
        //Verificamos si el número original era negativo o positivo
        return numeroInvertido < 0 ? -numeroInvertido : numeroInvertido;
    }

    private static void imprimirResultado(int[] orig, int[] inver){
        System.out.println("--- RESULTADOS ---");
        System.out.printf("%-15s | %-15s\n", "Original", "Invertido");
        System.out.println("-----------------------");
        for (int i = 0; i < orig.length; i++) {
            System.out.printf("%-15d | %-15d\n", orig[i], inver[i]);
        }
    }
}
