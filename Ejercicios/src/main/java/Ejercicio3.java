public class Ejercicio3 {
    // Función recursiva para contar la cantidad de dígitos de un número entero
    public static int contarDigitos(int numero) {
        // Caso base: número tiene un solo dígito
        if (numero < 10 && numero > -10) {
            return 1;
        }
        // Caso recursivo: contar dígitos del número sin el último dígito
        return 1 + contarDigitos(numero / 10);
    }
}
