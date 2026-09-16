# README ESPECIFICAMENTE DE REPASO DE CONCEPTOS CLAVE DEL TALLER

Este documento es una guía de repaso teórico-práctica para el parcial. Cubre arreglos unidimensionales, listas dinámicas (`ArrayList`) y matrices, explicando no solo el código sino **por qué** se aplican estas soluciones[cite: 1].

---

## ¿Por qué es importante todo esto? (Teoría y Fundamentos)

1. **Gestión de Memoria y Eficiencia:**
   - **Arreglos fijos (`int[]`, `int[][]`):** Reservan un bloque contiguo de memoria en el *Heap*. Son ultrapápidos para acceder por índice $\mathcal{O}(1)$, pero no pueden cambiar de tamaño[cite: 1].
   - **Estructuras Dinámicas (`ArrayList`):** Permiten cambiar de tamaño dinámicamente[cite: 1]. Por dentro manejan un arreglo que se duplica automáticamente cuando se llena.
2. **Buenas Prácticas (Clean Code & SOLID):**
   - **DRY (Don't Repeat Yourself):** Crear métodos reutilizables para lectura, procesamiento e impresión evita código duplicado[cite: 1].
   - **KISS (Keep It Simple, Stupid):** Escribir la solución más directa y legible posible sin sobrecomplicar la lógica[cite: 1].
   - **SRP (Principio de Responsabilidad Única):** Cada método debe hacer una sola cosa bien (ej. `obtenerFactorial()` solo calcula el factorial, no imprime)[cite: 1].

---

## 1. Arreglos Unidimensionales (`int[]`)

| Concepto | Sintaxis / Lógica | ¿Por qué se hace así? |
| :--- | :--- | :--- |
| **Inicialización Directa** | `int[] primos = {2, 3, 5, 7};` | Para valores conocidos de antemano (Ej. Ejercicio 1)[cite: 1]. |
| **Por Programa** | `int[] pares = new int[100];` | Reserva espacio cuando los datos se calculan dinámicamente (Ej. Ejercicio 2)[cite: 1]. |
| **Operador Ternario** | `(i < n - 1 ? ", " : "")` | Evita la coma sobrante al final de las impresiones en consola. |

### Puntos Críticos para el Parcial:
* **Factoriales e Inicialización:** El neutro multiplicativo es `1`. En bucles acumuladores de producto, arrancar en `0` arruina el resultado (`0 * n = 0`). Además, por definición matemática $0! = 1$.
* **Búsqueda de Menor/Mayor:** Inicializar siempre con `menor = arreglo[0]` y `mayor = arreglo[0]`. Inicializar en `0` fallará si todos los datos del arreglo son negativos.
* **Fórmula de Aleatorios en Rango $[min, max]$:**
  `rand.nextInt(max - min + 1) + min`  
  *(Ejemplo: para el rango $-50$ a $50$[cite: 1], `max - min + 1` = $101$ valores posibles).*

---

## 2. Listas Dinámicas (`ArrayList<T>`)

| Operación | Método | Detalle de Examen |
| :--- | :--- | :--- |
| **Acceso y Tamaño** | `.get(i)` / `.size()` | No usar `[i]` ni `.length` (son exclusivos de arreglos fijos). |
| **Inserción Ordenada** | `.add(posicion, elemento)` | Corre los elementos a la derecha automáticamente[cite: 1]. |
| **Ordenamiento** | `Collections.sort(lista)` | Ordena de menor a mayor ($\mathcal{O}(n \log n)$)[cite: 1]. |
| **Orden Inverso** | `Collections.sort(l, Collections.reverseOrder())` | Ordena de mayor a menor[cite: 1]. |
| **Eliminación por Valor** | `lista.remove(Integer.valueOf(val))` | Pasar un `int` primitivo eliminará por **índice**, no por valor[cite: 1]. |

### Especificamente de Arraylist

1. **Borrado por Valor vs. Borrado por Índice (`.remove()`):**
   - Si la lista es de enteros (`ArrayList<Integer>`):
     - `lista.remove(3)` $\to$ Elimina el elemento en el **índice 3**.
     - `lista.remove(Integer.valueOf(3))` $\to$ Elimina el **número 3** de la lista (por valor)[cite: 1].
2. **Eliminación Segura dentro de Bucles:**
   - **No uses `for-each` para eliminar** elementos de un `ArrayList` mientras lo recorres (provoca `ConcurrentModificationException`).
   - **Solución A:** Usar `Iterator` con `it.remove()` (Como el ejemplo de la clase con `PartidoFutbol`).
   - **Solución B:** Usar `lista.removeIf(p -> condición)`[cite: 1].

### Eliminación Segura en Bucles
* **Jamás uses un `for-each` para eliminar** elementos de un `ArrayList` mientras lo recorres (causa `ConcurrentModificationException`).
* **Soluciones Correctas:**
  1. Usar `Iterator` con `it.remove()` (Método visto en clase con `PartidoFutbol`)[cite: 2].
  2. Usar `lista.removeIf(p -> condición)`[cite: 1].

---

## 3. Matrices (`int[][]`)

Una matriz es un "arreglo de arreglos". En Java, `matriz.length` da el número de filas ($m$) y `matriz[0].length` da el número de columnas ($n$)[cite: 1].

### Algoritmos Clave en Matrices

1. **Búsqueda con Interrupción Temprana (Ejercicio 11):**
   - Usa un `return` o `break` etiquetado apenas encuentras el elemento para imprimir **solo la primera ocurrencia** y no malgastar ciclos de CPU[cite: 1].
2. **Diagonal Principal vs. Secundaria / Opuesta (Ejercicio 12):**
   - **Principal:** Celdas donde `i == j`.
   - **Secundaria (Opuesta):** Celdas donde `j = (n - 1) - i`[cite: 1].  
     *Optimizacion:* Se recorre con un solo ciclo `for` en tiempo $\mathcal{O}(n)$ en lugar de un doble `for` $\mathcal{O}(n^2)$.
3. **Validación de Simetría (Ejercicio 13):**
   - Una matriz es simétrica si $A[i][j] == A[j][i]$[cite: 1]. Se recorre únicamente la mitad triangular superior (`j = i + 1`) para evitar comparaciones duplicadas.
4. **Matriz Transpuesta (Ejercicio 14):**
   - Se invierten las dimensiones: si la matriz original es de $m \times n$, la transpuesta será de $n \times m$[cite: 1].
   - La asignación es: `transpuesta[j][i] = original[i][j]`[cite: 1].
5. **Intercambio de Filas (Ejercicio 15):**
   - En Java, intercambiar dos filas completas es tan simple como intercambiar sus punteros de memoria en $\mathcal{O}(1)$:  
     `int[] aux = matriz[0]; matriz[0] = matriz[1]; matriz[1] = aux;`[cite: 1]

---

## 4. Lectura de Archivos Planos (`Scanner` + `.split()`)

Para cargar datos desde archivos externos (ej. `PartidoLiga.txt`)[cite: 2]:

```java
File fichero = new File("PartidoLiga.txt");
Scanner leer = new Scanner(fichero);

while (leer.hasNext()) {
    String linea = leer.nextLine();
    String[] datos = linea.split("::"); // Divide la cadena usando el separador del archivo[cite: 2]
    
    // Mapeo a objeto (POO):
    PartidoFutbol p = new PartidoFutbol();
    p.setEquipoLocal(datos[0]);
    p.setEquipoVisitante(datos[1]);
    p.setGolLocal(Integer.parseInt(datos[2]));     // Parse de String a int[cite: 2]
    p.setGolVisitante(Integer.parseInt(datos[3])); // Parse de String a int[cite: 2]
}