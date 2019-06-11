package vista;

import controlador.Carrito;
import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.Random;
//Clase para la visualizacion de la carrera
public class Pista extends JFrame {
    private JLabel carrito;
    private JPanel panel;
    private Carrito hilo;
    private JLabel carrito2;
    private List<Piloto> pilotos;


    public Pista() {
        String path = "/imagenes/runner3.png";
        String path2 = "/imagenes/sanic2.png";
        URL url = this.getClass().getResource(path2);
        //Image image = new ImageIcon(url).getImage();
        URL url1 = this.getClass().getResource(path);
        Image image2 = new ImageIcon(url1).getImage();
        //ImageIcon icon = new ImageIcon(image.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        carrito = new JLabel();
        carrito.setIcon(icon2);
        carrito2 = new JLabel();
        carrito2.setIcon(icon2);
        panel = new JPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(500, 300));
        panel.setLayout(null);
        panel.add(carrito);
        panel.add(carrito2);
        carrito.setBounds(50, 50, 50, 50);
        carrito2.setBounds(75,25,50,50);
        getContentPane().add(panel);
        setPreferredSize(new Dimension(1000, 300));
        pack();
        setVisible(true);
    }

    public JLabel getCarrito() {
        return carrito;
    }

    public void correr() {
        Random random1 = new Random();
        Random random2 = new Random();
        hilo = new Carrito(this.carrito,random1);
        Carrito carro2 = new Carrito(this.carrito2,random2);
        hilo.start();
        carro2.start();
        while (hilo.isAlive()&&carro2.isAlive())
        {

        }
        if(hilo.isAlive())
        {
            System.out.println("Carrito 2 Ganó");
        }
        else
            {
                System.out.println("hilo 1 Ganó");
            }
    }

    public static void main(String[] args) {
        Pista pista = new Pista();
        pista.correr();

    }
}
