package arreglos;

public class Ejercicio1 {
    public static void main(String[] args) {
        arregloPrimos();
    }

    public static void arregloPrimos(){
        //Le damos exactamente los 10 primeros números primos
        int[] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        //Metodo de lectura
        imprimirArreglo("Los primeros 10 números primos son: ", primos);
    }
    //Metodo para imprimir
    private static void imprimirArreglo(String mensaje, int arreglo[]){
        System.out.println(mensaje);
        for (int i = 0; i < arreglo.length; i++) {
            //(condición) ? valor_si_verdadero : valor_si_falso
            System.out.print(arreglo[i] + (i<arreglo.length - 1 ? ", " : ""));
        }
        System.out.println("\n");
    }
}
//Condición i < arreglo.length - 1: Comprueba si el elemento actual NO es el último elemento del arreglo (arreglo.length - 1 es el último índice válido).