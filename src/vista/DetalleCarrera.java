package vista;

import controlador.ControladorDetalleCarrera;
import modelo.Carrera;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DetalleCarrera extends JFrame {
    //Clase que nos dirá que datos mostrar
    public Carrera carrera;
    public Cliente cliente;

    //Panel Principal
    private JPanel contenedor;

    //Etiquetas
    private JLabel lbltitulo;
    private JLabel lblnombreTabla;

    //Botones
    private JButton btnHistorial;
    private JButton btnApostar;
    private JButton btnRegresar;

    //Tabla
    public DefaultTableModel dtm;
    protected JScrollPane scroll;
    public JTable tabla;
    private String [] cabecera;
    private Object [][] datos;

    public DetalleCarrera(Carrera c, Cliente cliente)
    {
        carrera = c;
        this.cliente = cliente;

        //Metodos de JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Detalle carrera");
        setBounds(100, 100,650,650);
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().add(contenedor);
        contenedor.setLayout(gb);
        setVisible(true);

        //titulo
        lbltitulo = new JLabel("Carrera el día "+carrera.getFecha()+" a las: "+carrera.getHora());
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;
        constraints.weighty=1.0;
        constraints.insets = new Insets(10,0,10,0);
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(lbltitulo,constraints);

        //Titulo de la tabla
        lblnombreTabla = new JLabel("Pilotos");
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.weighty=0.0;
        constraints.weightx=1.0;
        constraints.insets = new Insets(0,0,0,0);
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(lblnombreTabla,constraints);

        //Panel de la tabla y tabla
        scroll      = new JScrollPane();
        cabecera    = new String[] {"Nombre","Apellido Paterno","Apellido Materno","Apodo"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        tabla.setBackground(Color.PINK);
        scroll.setViewportView(tabla);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=4;
        constraints.gridheight=1;
        constraints.weightx=0.0;
        constraints.weighty=0.0;
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill=GridBagConstraints.BOTH;
        contenedor.add(scroll,constraints);

        //Botones
        btnHistorial = new JButton("Historial");
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridheight=1;
        constraints.gridwidth=1;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.insets = new Insets(0,0,0,0);
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(btnHistorial,constraints);

        btnApostar=new JButton("Apostar");
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridheight=1;
        constraints.gridwidth=1;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(btnApostar,constraints);

        btnRegresar = new JButton("Regresar");
        constraints.gridx=0;
        constraints.gridy=3;
        contenedor.add(btnRegresar,constraints);
        pack();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void conectaControlador(ControladorDetalleCarrera c)
    {
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(c);
        btnHistorial.setActionCommand("Historial");
        btnHistorial.addActionListener(c);
        btnApostar.setActionCommand("Apostar");
        btnApostar.addActionListener(c);
    }

}
