public class Ejercicio1 {
    // Función recursiva para calcular la suma de los n primeros números naturales
    public static int calcularSumaNaturales(int n) {
        // Caso base: cuando n es igual a 0, la suma es 0
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: suma de los primeros n números naturales
        return n + calcularSumaNaturales(n - 1);
    }
}
