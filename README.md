# Taller de Estructuras de Datos Lineales 

**Estudiante:** David Santiago Pacheco Ortega
**Asignatura:** Estructura de Datos Lineales  
**Plataforma de desarrollo:** Java (JDK 17+) | Visual Studio Code 

---

## Descripción del Taller
Este repositorio contiene la solución completa al taller práctico de repaso para la evaluación parcial de **Estructuras de Datos Lineales** 

El proyecto abarca el uso, manipulación y optimización de:
1. **Arreglos Unidimensionales (`int[]`):** Inicialización estática/dinámica, generación de números primos, pares y cálculos acumulativos (factoriales)
2. **Estructuras Dinámicas (`ArrayList<T>`):** Control de capacidad dinámica, ordenamiento (`Collections.sort`), filtros, operaciones CRUD y lectura de persistencia en archivos planos (`PartidoLiga.txt`)
3. **Matrices Bidimensionales (`int[][]`):** Algoritmos de búsqueda con detención temprana, cálculo de diagonales opuestas, validación de simetría, matrices transpuestas e intercambio de filas

---

## Principios de Diseño y Buenas Prácticas
El desarrollo del código se realizó aplicando los criterios de calidad exigidos:
* **Clean Code:** Métodos cortos con nombres descriptivos y responsabilidad única (SRP)
* **Principios SOLID, DRY y KISS:** Eliminación de código duplicado mediante la separación de la generación de datos, el procesamiento lógico y la impresión formateada de resultados
* **Paradigma Orientado a Objetos (POO):** Modelado modular de entidades (como `PartidoFutbol`)

---

## Estructura del Repositorio
Siguiendo la arquitectura requerida para el taller:

```text
Taller-Estructuras-Lineales/
│
├── src/
│   ├── arreglos/         # Ejercicios 1 al 5 (Arreglos unidimensionales)
│   ├── arraylist/        # Ejercicios 6 al 10 (Listas dinámicas y POO)
│   └── matrices/         # Ejercicios 11 al 15 (Matrices bidimensionales)
│   └──README.md          #Anotaciones del taller
├
└── README.md             # Documentación del proyecto
