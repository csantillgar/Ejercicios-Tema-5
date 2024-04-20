public class Ejercicio8 {
    // Función recursiva para contar la cantidad de genes en una cadena de ADN
    public static int contarGenes(String cadenaADN) {
        int contadorGenes = 0;
        for (int i = 0; i < cadenaADN.length() - 2; i++) {
            if (cadenaADN.substring(i, i + 3).equals("ATG")) {
                contadorGenes++;
                // Buscar la secuencia de final de gen más cercana
                int indiceFinGen = encontrarFinGen(cadenaADN, i);
                if (indiceFinGen != -1) {
                    // Mover el índice al final del gen actual
                    i = indiceFinGen;
                } else {
                    // Si no se encuentra el final del gen, salir del bucle
                    break;
                }
            }
        }
        return contadorGenes;
    }

    // Función para encontrar la secuencia de final de gen más cercana a partir de un índice dado
    private static int encontrarFinGen(String cadenaADN, int indiceInicio) {
        for (int i = indiceInicio + 3; i < cadenaADN.length() - 2; i += 3) {
            String codon = cadenaADN.substring(i, i + 3);
            if (codon.equals("TAG") || codon.equals("TAA") || codon.equals("TGA")) {
                return i + 3; // Devuelve el índice del último carácter del codón
            }
        }
        return -1; // Si no se encuentra ninguna secuencia de final de gen
    }
}
