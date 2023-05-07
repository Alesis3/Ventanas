import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class VentanaSG extends JFrame {
    private JPanel panel1;
    private JButton boton1;
    private JLabel etiqueta1;
    //------------------------------
    private JPanel panel2;
    private JLabel etiqueta2;

    //-------------------------------
    private JPanel panel3;
    private JComboBox<String> comboBox;
    //--------------------------------
    private JPanel panel4;
    //---------------------------------
    private GridLayout layout;

    public VentanaSG(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel();
        panel1.setBackground(new Color(0x9E30BB));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        boton1=new JButton("ha Click");
        panel1.add(boton1);
        etiqueta1 = new JLabel("etiqueta 1");
        panel1.add(etiqueta1);

        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiqueta1.setText("presionaste el boton del panel 1 ");
            }
        });


        this.getContentPane().add(panel1,0);

        //panel2
        String enlace = "https://th.bing.com/th/id/OIP.eILOypr4bQuvRioKnyji1gAAAA?w=168&h=180&c=7&r=0&o=5&pid=1.7";

        panel2 = new JPanel();
        panel2.setBackground(new Color(0x34B08D));
        panel2.setLayout(new FlowLayout());
        //--------------------------------
        try {
            URL url = new URL(enlace);
            Image imagen = ImageIO.read(url);
            ImageIcon imagenicon = new ImageIcon(imagen);
            etiqueta2 = new JLabel(imagenicon);
            panel2.add(etiqueta2);

            this.getContentPane().add(panel2,1);

        }catch(MalformedURLException me){
            System.out.println("Url no valida");
        }catch (Exception e){
            System.out.println("Error al cargar l aimagen");
        }


        //panel3
        panel3 = new JPanel();
        panel3.setBackground(new Color(0x50D34A));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"opcion1", "opcion2", "opcion3", "opcion4"};
        comboBox = new JComboBox<>(elementos);
        panel3.add(comboBox);

        this.getContentPane().add(panel3,2);

        //panel4
        panel4 = new JPanel();
        panel4.setBackground(new Color(0xEC4DEC));

        this.getContentPane().add(panel4,3);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }
}
