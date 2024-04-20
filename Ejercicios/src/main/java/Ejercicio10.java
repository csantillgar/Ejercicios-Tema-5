import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio10 {

    public static String buscarPalabra(String nombreArchivo, String palabra) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int lineaActual = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                lineaActual++;
                System.out.println("Línea " + lineaActual + ": " + linea); // Mensaje de depuración
                if (linea.contains(palabra)) {
                    return "La palabra '" + palabra + "' se encontró en la línea " + lineaActual + ": " + linea;
                }
            }
            return "La palabra '" + palabra + "' no se encontró en el archivo.";
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }
}
