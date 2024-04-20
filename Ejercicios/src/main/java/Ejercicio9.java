import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio9 {
    // Función para ordenar las líneas de un archivo alfabéticamente y escribir el resultado en un nuevo archivo
    public static void ordenarArchivo(String nombreArchivo) {
        // Lista para almacenar las líneas del archivo
        List<String> lineas = new ArrayList<>();

        // Leer el contenido del archivo y almacenarlo en la lista
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Ordenar las líneas alfabéticamente
        Collections.sort(lineas);

        // Escribir las líneas ordenadas en un nuevo archivo
        String nuevoNombreArchivo = "archivo_ordenado.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoNombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine(); // Agregar nueva línea después de cada línea escrita
            }
            System.out.println("Archivo ordenado generado con éxito: " + nuevoNombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
