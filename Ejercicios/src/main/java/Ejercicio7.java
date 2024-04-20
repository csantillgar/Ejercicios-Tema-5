public class Ejercicio7 {
    // Función recursiva para calcular C(n, k)
    public static int calcularCombinacion(int n, int k) {
        // Caso base: n y k son iguales, o k es 0
        if (n == k || k == 0) {
            return 1;
        }
        // Caso recursivo
        return calcularCombinacion(n - 1, k) + calcularCombinacion(n - 1, k - 1);
    }
}
