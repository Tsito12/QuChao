package vista;

import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Coches extends JLabel {
    private JLabel carrito;
    private int numeroDesalida;
    Piloto piloto;


    public Coches(int numeroDesalida, Piloto piloto)
    {
        this.piloto=piloto;
        this.numeroDesalida=numeroDesalida;
        String path = "/imagenes/sanic2.png";
        URL url1 = this.getClass().getResource(path);
        Image image2 = new ImageIcon(url1).getImage();
        ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        carrito = new JLabel();
        carrito.setIcon(icon2);
        setPreferredSize(new Dimension(50, 50));
        setText(piloto.getapodo());
        //setLayout(null);
        //add(carrito);
        //carrito.setBounds(50+numeroDesalida*5, 50+numeroDesalida*5, 50, 50);
    }

    public Piloto getPiloto() {
        return piloto;
    }
}
