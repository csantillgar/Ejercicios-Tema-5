import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio10 {
    // Método para buscar una palabra en un archivo de texto y devolver el resultado
    public static String buscarPalabra(String nombreArchivo, String palabra) {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numeroLinea = 0;
            StringBuilder resultado = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.contains(palabra)) {
                    resultado.append("La palabra '").append(palabra).append("' se encontró en la línea ").append(numeroLinea).append(": ").append(linea).append("\n");
                }
            }
            br.close();
            fr.close();
            if (resultado.length() == 0) {
                return "La palabra '" + palabra + "' no se encontró en el archivo.";
            } else {
                return resultado.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer el archivo.";
        }
    }
}

