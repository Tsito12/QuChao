package vista;

import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Coches extends JLabel implements Runnable {
    private JLabel carrito;
    private int numeroDesalida;
    Piloto piloto;
    long tiempo;


    public Coches(int numeroDesalida, Piloto piloto, URL url)
    {
        this.piloto=piloto;
        this.numeroDesalida=numeroDesalida;
        tiempo=0;
        String path = "/imagenes/QuChao1.png";
        URL url1 = this.getClass().getResource(path);
        Image image2 = new ImageIcon(url).getImage();
        ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        carrito = new JLabel();
        carrito.setIcon(icon2);
        setPreferredSize(new Dimension(100, 50));
        setText(piloto.getapodo());
        //setLayout(null);
        //add(carrito);
        //carrito.setBounds(50+numeroDesalida*5, 50+numeroDesalida*5, 50, 50);
    }

    public void sumarTiempo(Long t)
    {
        tiempo+=t;
    }

    public long getTimepo()
    {
        return tiempo;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    @Override
    public void run() {
        getTimepo();
    }
}
