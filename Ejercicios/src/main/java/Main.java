import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        // Configuración de la ventana
        setTitle("Suma de los primeros n números naturales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta y campo de texto para ingresar el valor de n
        JLabel label = new JLabel("Ingrese el valor de n:");
        JTextField textField = new JTextField(10);

        // Botón para calcular la suma
        JButton calcularButton = new JButton("Calcular Suma");

        // Acción del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el valor de n del campo de texto
                    int n = Integer.parseInt(textField.getText());
                    // Calcular la suma de los primeros n números naturales
                    int suma = SumaNaturales.calcularSumaNaturales(n);
                    // Mostrar el resultado en un cuadro de diálogo
                    JOptionPane.showMessageDialog(Main.this,
                            "La suma de los primeros " + n + " números naturales es: " + suma,
                            "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Main.this,
                            "Por favor, ingrese un número válido para n.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar componentes al panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(calcularButton, BorderLayout.SOUTH);

        // Agregar panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase Main (Interfaz Gráfica)
        new Main();
    }
}
