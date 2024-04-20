public class Ejercicio4 {
    // Función recursiva para calcular x * y mediante multiplicaciones sucesivas
    public static int multiplicar(int x, int y) {
        // Caso base: si y es 0, el resultado es 0
        if (y == 0) {
            return 0;
        }
        // Caso recursivo: x * y = x + x * (y-1)
        return x + multiplicar(x, y - 1);
    }
}
