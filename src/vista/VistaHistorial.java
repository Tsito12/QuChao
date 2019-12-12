package vista;

import controlador.ControladorHIstorial;
import controlador.ControladorHistorialPiloto;
import modelo.Carrera;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaHistorial extends JFrame {

    private Cliente cliente;
    private Carrera carrera;

    private JPanel panel;

    private JButton regresar;

    public JTable tabla;
    public DefaultTableModel dtm;
    private JScrollPane scroll;
    protected String [] cabecera;
    protected Object [][] datos;

    public VistaHistorial(Cliente c)
    {
//        this.carrera=carrera;
       cliente=c;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Historial de apuestas");
        panel = new JPanel();
        getContentPane().add(panel);
        SpringLayout sp = new SpringLayout();
        panel.setLayout(sp);

        regresar = new JButton("Regresar");
        panel.add(regresar);
        sp.putConstraint(SpringLayout.NORTH,regresar,10,SpringLayout.NORTH,panel);
        sp.putConstraint(SpringLayout.WEST,regresar,350,SpringLayout.WEST,panel);
        sp.putConstraint(SpringLayout.EAST,regresar,-10,SpringLayout.EAST,panel);

        scroll      = new JScrollPane();
        cabecera    = new String[] {"Carrera","Piloto","Cantidad","Resultado"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);

        panel.add(scroll);
        sp.putConstraint(SpringLayout.NORTH,scroll,30,SpringLayout.NORTH,regresar);
        sp.putConstraint(SpringLayout.WEST,scroll,10,SpringLayout.WEST,panel);
        sp.putConstraint(SpringLayout.EAST,scroll,-10,SpringLayout.EAST,panel);


        setBounds(100, 100,650,650);
        setVisible(true);

    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void conectarControlador(ControladorHIstorial c)
    {
        regresar.setActionCommand("Regresar");
        regresar.addActionListener(c);
    }

//    public static void main(String[] args)
//    {
//        //VistaHistorial vistaHistorial = new VistaHistorial();
//    }

}
