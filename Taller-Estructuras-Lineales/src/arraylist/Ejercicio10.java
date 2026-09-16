package arraylist;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio10 {

    // Ruta del archivo (se puede usar la ruta relativa "PartidoLiga.txt" si está en la raíz)
    private static final String NOMBRE_FICHERO = "C:\\Users\\David Pacheco\\OneDrive\\Escritorio\\Carpeta uni\\Todo Programacion I a III semestre\\Carpeta Visual 4to semestre\\Taller-Estructuras-Lineales\\PartidoLiga.txt";

    public static void main(String[] args) {
        ArrayList<PartidoFutbol> partidos = new ArrayList<>();
        File fichero = new File(NOMBRE_FICHERO);
        Scanner leer;

        // --- CÓDIGO DEL PROFESOR: LECTURA DEL ARCHIVO TXT ---
        try {
            System.out.println("Leyendo el documento...");
            leer = new Scanner(fichero);
            while (leer.hasNext()) {
                String linea = leer.nextLine();
                String[] cortarString = linea.split("::");

                PartidoFutbol partido = new PartidoFutbol();
                partido.setEquipoLocal(cortarString[0]);
                partido.setEquipoVisitante(cortarString[1]);
                partido.setGolLocal(Integer.parseInt(cortarString[2]));
                partido.setGolVisitante(Integer.parseInt(cortarString[3]));

                partidos.add(partido);
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("El fichero no se pudo leer: " + e.getMessage());
            return;
        }

        System.out.println("Total de partidos cargados: " + partidos.size() + "\n");

        // Requerimiento 1: Mostrar los partidos donde el visitante fue el ganador
        System.out.println("=== PARTIDOS DONDE GANÓ EL VISITANTE ===");
        for (PartidoFutbol p : partidos) {
            if (p.ganoVisitante()) {
                System.out.println(p);
            }
        }

        // Requerimiento 2: Contar cuántas veces ganó el Barcelona
        int victoriasBarcelona = 0;
        for (PartidoFutbol p : partidos) {
            if (p.getEquipoLocal().equalsIgnoreCase("Barcelona") && p.ganoLocal()) {
                victoriasBarcelona++;
            } else if (p.getEquipoVisitante().equalsIgnoreCase("Barcelona") && p.ganoVisitante()) {
                victoriasBarcelona++;
            }
        }
        System.out.println("\nBarcelona ganó en total: " + victoriasBarcelona + " partidos.");

        // Requerimiento 4: Contar cuántos partidos ganó el equipo local
        int victoriasLocal = 0;
        for (PartidoFutbol p : partidos) {
            if (p.ganoLocal()) {
                victoriasLocal++;
            }
        }
        System.out.println("Partidos ganados por el equipo local: " + victoriasLocal);

        // Requerimiento 3: Eliminar los partidos cuyo resultado NO sea un empate e imprimir los restantes
        // Usamos un Iterator tradicional (ya que el profe importó java.util.Iterator en su código)
        Iterator<PartidoFutbol> it = partidos.iterator();
        while (it.hasNext()) {
            PartidoFutbol p = it.next();
            if (!p.esEmpate()) {
                it.remove(); // Elimina de forma segura mientras se recorre
            }
        }

        System.out.println("\n=== PARTIDOS RESTANTES TRAS ELIMINAR NO-EMPATES (SOLO EMPATES) ===");
        for (PartidoFutbol p : partidos) {
            System.out.println(p);
        }
        System.out.println("Total de empates registrados: " + partidos.size());
    }
}