import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {

    public Main() {
        // Configuración de la ventana
        setTitle("Menú de Ejercicios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1)); // Grid de 7 filas y 1 columna

        // Botones para acceder a cada ejercicio
        JButton ejercicio1Button = new JButton("Ejercicio 1: Suma de los primeros n números naturales");
        JButton ejercicio2Button = new JButton("Ejercicio 2: Imprimir lista de números naturales entre a y b");
        JButton ejercicio3Button = new JButton("Ejercicio 3: Contar cantidad de dígitos de un número entero");
        JButton ejercicio4Button = new JButton("Ejercicio 4: Calcular xy mediante multiplicaciones sucesivas");
        JButton ejercicio5Button = new JButton("Ejercicio 5: Encontrar el valor máximo de un vector");
        JButton ejercicio6Button = new JButton("Ejercicio 6: Convertir cadena hexadecimal a decimal");


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




        // Agregar botones al panel
        panel.add(ejercicio1Button);
        panel.add(ejercicio2Button);
        panel.add(ejercicio3Button);
        panel.add(ejercicio4Button);
        panel.add(ejercicio5Button);
        panel.add(ejercicio6Button);

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


    public static void main(String[] args) {
        // Crear una instancia de la clase Main (Interfaz Gráfica)
        new Main();
    }
}
