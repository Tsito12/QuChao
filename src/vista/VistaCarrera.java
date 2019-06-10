package vista;

import modelo.Carrera;
import modelo.Piloto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCarrera extends JFrame{
    private Carrera carrera;
    private Piloto pilotoApostado;
    List<Piloto> pilotos;
    private JPanel contenedor;
    private JPanel pista;

    public VistaCarrera(Carrera carrera, Piloto piloto)
    {
        this.carrera=carrera;
        pilotoApostado = piloto;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contenedor = new JPanel();
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
        for(int i=0;i<pilotos.size();i++)
        {
            Coches coche = new Coches(i,pilotos.get(i));
            pista.add(coche);
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
