import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Main extends JFrame {

    public Main() {
        // Configuración de la ventana
        setTitle("Menú de Ejercicios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2)); // Grid de10filas y 1 columna

        // Botones para acceder a cada ejercicio
        JButton ejercicio1Button = new JButton("Ejercicio 1: Suma de los primeros n números naturales");
        JButton ejercicio2Button = new JButton("Ejercicio 2: Imprimir lista de números naturales entre a y b");
        JButton ejercicio3Button = new JButton("Ejercicio 3: Contar cantidad de dígitos de un número entero");
        JButton ejercicio4Button = new JButton("Ejercicio 4: Calcular xy mediante multiplicaciones sucesivas");
        JButton ejercicio5Button = new JButton("Ejercicio 5: Encontrar el valor máximo de un vector");
        JButton ejercicio6Button = new JButton("Ejercicio 6: Convertir cadena hexadecimal a decimal");
        JButton ejercicio7Button = new JButton("Ejercicio 7: Calcular C(n, k)");
        JButton ejercicio8Button = new JButton("Ejercicio 8: Contar genes en una cadena de ADN");
        JButton ejercicio9Button = new JButton("Ejercicio 9: Ordenar archivo de texto alfabéticamente");
        JButton ejercicio10Button = new JButton("Ejercicio 10: Buscar palabra en archivo de texto");
        JButton ejercicio12Button = new JButton("Ejercicio 12: Ordenar fechas cronológicamente");





        // Acción del botón para el Ejercicio 1
        ejercicio1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de n:"));
                int suma = Ejercicio1.calcularSumaNaturales(n);
                JOptionPane.showMessageDialog(Main.this,
                        "La suma de los primeros " + n + " números naturales es: " + suma,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Implementación del Ejercicio 2
        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de a:"));
                int d = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de d:"));
                String lista = Ejercicio2.generarLista(a, d);
                mostrarLista(lista);
            }
        });

        // Acción del botón para el Ejercicio 3
        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese un número entero:"));
                int cantidadDigitos = Ejercicio3.contarDigitos(Math.abs(numero)); // Usamos Math.abs para obtener el valor absoluto del número
                JOptionPane.showMessageDialog(Main.this,
                        "El número " + numero + " tiene " + cantidadDigitos + " dígitos.",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 4
        ejercicio4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de x:"));
                int y = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de y:"));
                int resultado = Ejercicio4.multiplicar(x, y);
                JOptionPane.showMessageDialog(Main.this,
                        x + " * " + y + " = " + resultado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 5
        ejercicio5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pide al usuario que ingrese los elementos del vector
                String input = JOptionPane.showInputDialog(Main.this, "Ingrese los elementos del vector separados por comas:");
                String[] elementos = input.split(",");
                int[] vector = new int[elementos.length];
                for (int i = 0; i < elementos.length; i++) {
                    vector[i] = Integer.parseInt(elementos[i]);
                }
                // Calcula el valor máximo del vector
                int maximo = Ejercicio5.encontrarMaximo(vector, 0);
                JOptionPane.showMessageDialog(Main.this,
                        "El valor máximo del vector es: " + maximo,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 6
        ejercicio6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadenaHexadecimal = JOptionPane.showInputDialog(Main.this, "Ingrese la cadena hexadecimal:");
                int valorDecimal = Ejercicio6.hexToDecimal(cadenaHexadecimal, cadenaHexadecimal.length());
                JOptionPane.showMessageDialog(Main.this,
                        "El valor decimal de la cadena hexadecimal " + cadenaHexadecimal + " es: " + valorDecimal,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });


        // Acción del botón para el Ejercicio 7
        ejercicio7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de n:"));
                int k = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Ingrese el valor de k:"));
                int resultado = Ejercicio7.calcularCombinacion(n, k);
                JOptionPane.showMessageDialog(Main.this,
                        "C(" + n + ", " + k + ") = " + resultado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 8
        ejercicio8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadenaADN = generarCadenaADNAleatoria(1000); // Genera una cadena de ADN aleatoria de longitud 1000
                int genes = Ejercicio8.contarGenes(cadenaADN);
                JOptionPane.showMessageDialog(Main.this,
                        "Cadena de ADN generada:\n\n" + cadenaADN + "\n\nNúmero de genes encontrados: " + genes,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 9
        ejercicio9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreArchivo = "archivo.txt"; // Nombre del archivo de texto a ordenar
                Ejercicio9.ordenarArchivo("C:\\Users\\cinti\\IdeaProjects\\Ejercicios-Tema-5\\Ejercicios\\src\\main\\java\\Ejemplo.txt");

            }
        });

        // Acción del botón para el Ejercicio 10
        ejercicio10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreArchivo = "C:\\Users\\cinti\\IdeaProjects\\Ejercicios-Tema-5\\Ejercicios\\src\\main\\java\\Ejemplo.txt";
                String palabra = JOptionPane.showInputDialog(Main.this, "Ingrese la palabra a buscar:");

                // Buscar la palabra en el archivo y obtener el resultado
                String resultado = Ejercicio10.buscarPalabra(nombreArchivo, palabra);

                // Mostrar el resultado en un cuadro de diálogo
                JOptionPane.showMessageDialog(Main.this, resultado, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción del botón para el Ejercicio 12
        ejercicio12Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarFechas();
            }
        });


        // Agregar botones al panel
        panel.add(ejercicio1Button);
        panel.add(ejercicio2Button);
        panel.add(ejercicio3Button);
        panel.add(ejercicio4Button);
        panel.add(ejercicio5Button);
        panel.add(ejercicio6Button);
        panel.add(ejercicio7Button);
        panel.add(ejercicio8Button);
        panel.add(ejercicio9Button);
        panel.add(ejercicio10Button);
        panel.add(ejercicio12Button);
        // Agregar panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Función para mostrar la lista en una ventana
    public static void mostrarLista(String lista) {
        JTextArea textArea = new JTextArea(lista);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Lista de Números Naturales", JOptionPane.PLAIN_MESSAGE);
    }

    // Función para generar una cadena de ADN aleatoria
    public static String generarCadenaADNAleatoria(int longitud) {
        StringBuilder sb = new StringBuilder();
        String bases = "ACGT";
        for (int i = 0; i < longitud; i++) {
            int randomIndex = (int) (Math.random() * bases.length());
            sb.append(bases.charAt(randomIndex));
        }
        return sb.toString();
    }

    // Método para buscar una palabra en el archivo de texto
    public String buscarPalabra(String palabra) {
        try {
            // Ruta del archivo de texto
            String nombreArchivo = "ruta/del/archivo.txt";

            // Leer el archivo y almacenar cada línea en una lista
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();

            // Ordenar la lista alfabéticamente
            Collections.sort(lineas);

            // Realizar búsqueda binaria
            int indice = Collections.binarySearch(lineas, palabra);

            // Construir el mensaje de resultado
            if (indice >= 0) {
                return "La palabra '" + palabra + "' se encontró en la línea " + (indice + 1) + ": " + lineas.get(indice);
            } else {
                return "La palabra '" + palabra + "' no se encontró en el archivo.";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error al leer el archivo.";
        }
    }

    // Función para ordenar fechas cronológicamente
    private static void ordenarFechas() {
        List<Date> fechas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Ciclo para ingresar fechas
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Introduce una fecha en formato dd/MM/yyyy (o escribe 'fin' para terminar):");
            if (input.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                Date fecha = dateFormat.parse(input);
                fechas.add(fecha);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Ordenar las fechas cronológicamente
        Collections.sort(fechas);

        // Mostrar las fechas ordenadas
        StringBuilder result = new StringBuilder("Fechas ordenadas cronológicamente:\n");
        for (Date fecha : fechas) {
            result.append(dateFormat.format(fecha)).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Fechas Ordenadas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase Main (Interfaz Gráfica)
        new Main();
    }
}
