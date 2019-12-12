package vista;

import controlador.ControladorProximasCarreras;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProximasCarreras extends JFrame {
    public Cliente cliente;
    //Contenedor principal
    private JPanel contenedor;
    //ETIQUETAS
    private JLabel titulo;
    //BOTONES
    private JLabel lblUsuario;
    private JButton btnUsuarioSalir;
    private JButton btnDetalle;
    private JButton btnHistorial;
    //TABLA
    public JTable tabla;
    public DefaultTableModel dtm;
    private JScrollPane scroll;
    protected String [] cabecera;
    protected Object [][] datos;
    //COMBO BOX
    private JComboBox comboCarrera;

    public VistaProximasCarreras(Cliente cliente)
    {
        this.cliente=cliente;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proximas Carreras");
        setBounds(100, 100,650,400);
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        SpringLayout sp = new SpringLayout();
        getContentPane().add(contenedor);
        contenedor.setLayout(sp);

        //Botones del usuario


        btnUsuarioSalir = new JButton("Salir");
        contenedor.add(btnUsuarioSalir);
        sp.putConstraint(SpringLayout.NORTH, btnUsuarioSalir,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnUsuarioSalir,-10,SpringLayout.EAST,contenedor);

        btnHistorial = new JButton("Historial");
        contenedor.add(btnHistorial);
        sp.putConstraint(SpringLayout.NORTH, btnHistorial,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST, btnHistorial,-100,SpringLayout.EAST,btnUsuarioSalir);

        lblUsuario = new JLabel("Bienvenido, "+cliente.getUsername());
        contenedor.add(lblUsuario);
        sp.putConstraint(SpringLayout.NORTH, lblUsuario,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST, lblUsuario,-100,SpringLayout.EAST,btnHistorial);

        //Titulo de la tabla
        titulo = new JLabel("Proximas carreras");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 50,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo, 10 , SpringLayout.WEST, contenedor);


        scroll      = new JScrollPane();
        cabecera    = new String[] {"Número de paricipantes","Numero de vueltas","Fecha","Hora"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        tabla.setBackground(Color.PINK);
        scroll.setViewportView(tabla);
        // scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 70,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,
                SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,
                SpringLayout.SOUTH, contenedor);


        //Boton Detalle
        btnDetalle = new JButton("Detalle");
        contenedor.add(btnDetalle);
        sp.putConstraint(SpringLayout.SOUTH, btnDetalle,-10, SpringLayout.SOUTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,btnDetalle,300,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnDetalle,-250,SpringLayout.EAST,contenedor);
        setVisible(true);

    }

    public VistaProximasCarreras()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proximas Carreras");
        setBounds(100, 100,650,400);
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        SpringLayout sp = new SpringLayout();
        getContentPane().add(contenedor);
        contenedor.setLayout(sp);

        //Botones del usuario


        btnUsuarioSalir = new JButton("Salir");
        contenedor.add(btnUsuarioSalir);
        sp.putConstraint(SpringLayout.NORTH, btnUsuarioSalir,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnUsuarioSalir,-10,SpringLayout.EAST,contenedor);

        btnHistorial = new JButton("Historial");
        contenedor.add(btnHistorial);
        sp.putConstraint(SpringLayout.NORTH, btnHistorial,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST, btnHistorial,-100,SpringLayout.EAST,btnUsuarioSalir);

        lblUsuario = new JLabel("Bienvenido, ");
        contenedor.add(lblUsuario);
        sp.putConstraint(SpringLayout.NORTH, lblUsuario,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST, lblUsuario,-100,SpringLayout.EAST,btnHistorial);

        //Titulo de la tabla
        titulo = new JLabel("Proximas carreras");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 50,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo, 10 , SpringLayout.WEST, contenedor);


        scroll      = new JScrollPane();
        cabecera    = new String[] {"Número de paricipantes","Numero de vueltas","Fecha","Hora"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        tabla.setBackground(Color.PINK);
        scroll.setViewportView(tabla);
        // scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 70,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,
                SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,
                SpringLayout.SOUTH, contenedor);


        //Boton Detalle
        btnDetalle = new JButton("Detalle");
        contenedor.add(btnDetalle);
        sp.putConstraint(SpringLayout.SOUTH, btnDetalle,-10, SpringLayout.SOUTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,btnDetalle,300,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnDetalle,-250,SpringLayout.EAST,contenedor);
        setVisible(true);

    }

    public String getCarreraSeleccionada() {
        return (String) comboCarrera.getSelectedItem();
    }
    public JComboBox getComboCarrera()
    {
        return comboCarrera;
    }

    public void conectaControlador(  ControladorProximasCarreras c  ){
        btnUsuarioSalir.setActionCommand("Salir");
        btnUsuarioSalir.addActionListener(c);
        btnDetalle.setActionCommand("Detalle");
        btnDetalle.addActionListener(c);
        btnHistorial.setActionCommand("Historial");
        btnHistorial.addActionListener(c);
    }
/*
    public static void main(String[] args)
    {
        ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
        VistaProximasCarreras v = new VistaProximasCarreras();
        ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(v, modeloProximasCarreras);
        v.conectaControlador(controladorProximasCarreras);

    }*/
}
