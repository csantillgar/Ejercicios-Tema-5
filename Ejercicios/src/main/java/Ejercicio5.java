public class Ejercicio5 {
    // Función recursiva para calcular el valor máximo de un vector
    public static int encontrarMaximo(int[] vector, int inicio) {
        // Caso base: si el vector está vacío, devolver un valor negativo infinito
        if (inicio >= vector.length) {
            return Integer.MIN_VALUE;
        }
        // Caso base: si el vector tiene un solo elemento, devolver ese elemento
        if (inicio == vector.length - 1) {
            return vector[inicio];
        }
        // Caso recursivo: encontrar el máximo entre el primer elemento y el valor máximo del resto del vector
        int maxResto = encontrarMaximo(vector, inicio + 1);
        return Math.max(vector[inicio], maxResto);
    }
}
