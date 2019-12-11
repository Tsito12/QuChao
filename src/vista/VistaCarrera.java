package vista;

import controlador.Carrito;
import modelo.Carrera;
import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VistaCarrera extends JFrame{
    private Carrera carrera;
    private Piloto pilotoApostado;
    List<Piloto> pilotos;
    private JPanel contenedor;
    private JPanel pista;
    List<Carrito> hilos;
    private ExecutorService ejecutor;
    //List<Coches> carritos;

    public VistaCarrera(Carrera carrera, Piloto piloto)
    {
        this.carrera=carrera;
        hilos = new ArrayList<Carrito>();
        //carritos = new ArrayList<Coches>();
        ejecutor = Executors.newFixedThreadPool(carrera.getNoParticpantes());
        pilotoApostado = piloto;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        contenedor.setLayout(new FlowLayout());
        getContentPane().add(contenedor);
        pista = new JPanel();
        pista.setPreferredSize(new Dimension(600, 400));
        pista.setLayout(null);
        contenedor.add(pista);
        //setPreferredSize(new Dimension(1000, 300));
        pack();
        setVisible(true);


    }

    public void acomodarCarritos()
    {

        int lugarX = 50;
        int lugarY = 200;
        for(int i=0;i<pilotos.size();i++)
        {
            //System.out.println(pilotos.get(i).getapodo());
            String path = "/imagenes/QuChao1.png";
            URL url1 = this.getClass().getResource(path);
            Coches coche = new Coches(i,pilotos.get(i),url1);
            //carritos.add(coche);
            //System.out.println(coche.piloto.getapodo());
            pista.add(coche);
            lugarX+=25;
            lugarY-=25;
            coche.setBounds(lugarX,lugarY,50,50);
            //Thread hilo = new Thread(new Carrito(coche,new Random(),carrera.getNoVueltas()));
            Carrito carrito = new Carrito(coche,new Random(),carrera.getNoVueltas());
            hilos.add(carrito);
            //hilo.start();

        }
    }

    public void gottaGoFast()
    {
        for (int j =0;j<carrera.getNoVueltas();j++) {
            for(int i =0;i<hilos.size();i++)
            {
                //hilos.get(i).start();
                ejecutor.execute(hilos.get(i));
            }
        }

        if (ejecutor.isTerminated()) {
            for (Carrito c:
                 hilos) {
                System.out.println(c.getCarro().getTimepo());
            }
        }
    }

    public void verTiempos()
    {
        for(int i =0;i<hilos.size();i++)
        {
            System.out.println(hilos.get(i).getTiempo());
        }
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public Carrera getCarrera() {
        return carrera;
    }
}
