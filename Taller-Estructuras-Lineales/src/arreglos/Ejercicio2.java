package arreglos;

public class Ejercicio2 {

    public static void main(String[] args) {
        arreglonumPares();
    }

    public static void arreglonumPares(){
        int[] pares = generarPares(100);

        System.out.println("-- Imprimir todos 100 números pares en una sola linea --");
        imprimirEnUnaLinea(pares);
        System.out.println("-- Imprimir los números pares en 10 lineas --");
        imprimirCada10Lineas(pares);
    }
    //Metodo para los pares
    private static int[] generarPares(int cantidad){
        int[] arregloPares = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloPares[i]= (i+1)*2;
        }
        return arregloPares;
    }

    private static void imprimirEnUnaLinea(int[] arreglo){
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void imprimirCada10Lineas(int[] arreglo){
        int numeroLinea = 1;
        for (int i = 0; i < arreglo.length; i++) {
            //imprimir numero al inicio de cada salto de 10
            if(i % 10 == 0){
                System.out.printf("Linea %2d: ", numeroLinea++);
            }
            System.out.printf("%4d", arreglo[i]);
            //Salto cada 10 numeros
            if((i+1)%10 == 0){
                System.out.println();
            }

        }
    }
}
