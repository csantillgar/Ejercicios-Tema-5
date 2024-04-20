public class Ejercicio6 {
    // Función recursiva para convertir una cadena de dígitos hexadecimales en su valor decimal
    public static int hexToDecimal(String cadena, int longitud) {
        // Caso base: si la longitud es 0, el valor decimal es 0
        if (longitud == 0) {
            return 0;
        }
        // Obtener el último dígito hexadecimal de la cadena
        char ultimoDigito = cadena.charAt(longitud - 1);
        // Convertir el dígito hexadecimal a su valor decimal correspondiente
        int valorDecimal = Character.isDigit(ultimoDigito) ? ultimoDigito - '0' : ultimoDigito - 'A' + 10;
        // Multiplicar el valor decimal por 16^(longitud-1)
        return valorDecimal * (int) Math.pow(16, cadena.length() - longitud) + hexToDecimal(cadena, longitud - 1);
    }
}
