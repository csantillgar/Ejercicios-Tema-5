import javax.swing.*;

public class Ejercicio2 {
    // Función recursiva para generar la lista de números naturales entre a y d
    public static String generarLista(int a, int d) {
        if (a <= d) {
            return a + " " + generarLista(a + 1, d);
        } else {
            return "";
        }
    }
}
