import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaSwing extends JFrame {
    private JLabel etiqueta1;
    private JTextField txtGrados;
    private JButton boton;
    private JLabel resultado;
    private FlowLayout layout;
    private double Farenheid;

    public VentanaSwing(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 600);

        layout = new FlowLayout();
        this.getContentPane().setLayout(layout);
        etiqueta1 = new JLabel("Grados °C");
        this.getContentPane().add(etiqueta1);
        txtGrados = new JTextField(10);
        this.getContentPane().add(txtGrados);
        boton = new JButton("Convertir");
        this.getContentPane().add(boton);
        resultado = new JLabel("0.0°F");
        this.getContentPane().add(resultado);


        this.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                double centigrados = Double.parseDouble(txtGrados.getText());
                double farenheid = (centigrados + 9.0/5.0)+32.0;
                resultado.setText(farenheid + " °F");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "bai...");
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

}
