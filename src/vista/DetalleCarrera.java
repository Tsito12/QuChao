package vista;

import modelo.Carrera;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DetalleCarrera extends JFrame {
    //Clase que nos dirá que datos mostrar
    //public Carrera carrera;

    //Panel Principal
    private JPanel contenedor;
    //Panel para la tabla
    private JPanel panelTabla;

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

    public DetalleCarrera(/*Carrera c*/)
    {
        //carrera = c;

        //Metodos de JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Detalle carrera");
        setBounds(100, 100,650,650);
        contenedor = new JPanel();
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().add(contenedor);
        contenedor.setLayout(gb);
        setVisible(true);

        //titulo
        lbltitulo = new JLabel(/*carrera.getFecha()+" "+carrera.getHora()*/);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;
        constraints.weighty=1.0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        contenedor.add(lbltitulo,constraints);

        //Titulo de la tabla
        lblnombreTabla = new JLabel("Pilotos");
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.weighty=0.0;
        constraints.weightx=1.0;
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(lblnombreTabla,constraints);

        //Panel de la tabla y tabla
        scroll      = new JScrollPane();
        cabecera    = new String[] {"Nombre","Apellido Paterno","Apellido Materno","Apodo","Carreras Ganadas"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        panelTabla = new JPanel();
        //panelTabla.add(scroll);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=4;
        constraints.gridheight=1;
        constraints.weightx=0.0;
        constraints.weighty=0.0;
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill=GridBagConstraints.BOTH;
        //constraints.anchor=GridBagConstraints.CENTER;
        contenedor.add(scroll,constraints);

        //Botones
        btnHistorial = new JButton("Historial");
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridheight=1;
        constraints.gridwidth=2;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.insets = new Insets(0,0,0,0);
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(btnHistorial,constraints);

        btnApostar=new JButton("Apostar");
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridheight=1;
        constraints.gridwidth=2;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.fill=GridBagConstraints.NONE;
        contenedor.add(btnApostar,constraints);
        pack();
    }

    public static void main(String[] args)
    {
        DetalleCarrera d = new DetalleCarrera();
    }
}
