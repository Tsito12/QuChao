package vista;

import controlador.Carrito;
import modelo.Carrera;
import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VistaCarrera extends JFrame{
    private Carrera carrera;
    private Piloto pilotoApostado;
    List<Piloto> pilotos;
    private JPanel contenedor;
    private JPanel pista;
    List<Carrito> hilos;

    public VistaCarrera(Carrera carrera, Piloto piloto)
    {
        this.carrera=carrera;
        hilos = new ArrayList<Carrito>();
        pilotoApostado = piloto;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        contenedor.setLayout(new FlowLayout());
        getContentPane().add(contenedor);
        pista = new JPanel();
        pista.setPreferredSize(new Dimension(500, 300));
        pista.setLayout(null);
        contenedor.add(pista);
        setPreferredSize(new Dimension(1000, 300));
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
            Coches coche = new Coches(i,pilotos.get(i));
            //System.out.println(coche.piloto.getapodo());
            pista.add(coche);
            lugarX+=25;
            lugarY-=25;
            coche.setBounds(lugarX,lugarY,50,50);
            Carrito hilo = new Carrito(coche,new Random(),carrera.getNoVueltas());
            hilos.add(hilo);
        }
    }

    public void gottaGoFast()
    {
        List<Integer> tiempos;
        for(int i =0;i<hilos.size();i++)
        {
            hilos.get(i).start();
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
