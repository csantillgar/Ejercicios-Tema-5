import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ejercicio12 {

    public static void ordenarFechas() {
        Scanner scanner = new Scanner(System.in);

        // Lista para almacenar las fechas
        List<Date> fechas = new ArrayList<>();

        System.out.println("Introduce las fechas en formato dd/MM/yyyy (por ejemplo, 01/01/2023).");
        System.out.println("Escribe 'fin' cuando hayas terminado.");

        // Ciclo para ingresar fechas
        while (true) {
            System.out.print("Introduce una fecha: ");
            String input = scanner.nextLine();

            // Salir del ciclo si el usuario escribe 'fin'
            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            // Convertir la cadena a una fecha
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = dateFormat.parse(input);
                fechas.add(fecha);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
            }
        }

        // Ordenar las fechas cronológicamente
        Collections.sort(fechas);

        // Imprimir las fechas ordenadas
        System.out.println("\nFechas ordenadas cronológicamente:");
        for (Date fecha : fechas) {
            System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        }
    }
}
