package vista;

import controlador.ControladorProximasCarreras;
import modelo.ModeloProximasCarreras;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaProximasCarreras extends JFrame {
    //Contenedor principal
    private JPanel contenedor;
    //ETIQUETAS
    private JLabel titulo;
    //BOTONES
    private JButton btnUsuario;
    private JButton btnUsuarioSalir;
    private JButton btnDetalle;
    //TABLA
    public JTable tabla;
    public DefaultTableModel dtm;
    private JScrollPane scroll;
    protected String [] cabecera;
    protected Object [][] datos;
    //COMBO BOX
    private JComboBox comboCarrera;

    public VistaProximasCarreras()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proximas Carreras");
        setBounds(100, 100,650,400);
        contenedor = new JPanel();
        SpringLayout sp = new SpringLayout();
        getContentPane().add(contenedor);
        contenedor.setLayout(sp);

        //Botones del usuario
        btnUsuario = new JButton("Usuario");
        contenedor.add(btnUsuario);
        sp.putConstraint(SpringLayout.NORTH, btnUsuario,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnUsuario,-100,SpringLayout.EAST,contenedor);

        btnUsuarioSalir = new JButton("Salir");
        contenedor.add(btnUsuarioSalir);
        sp.putConstraint(SpringLayout.NORTH, btnUsuarioSalir,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnUsuarioSalir,-10,SpringLayout.EAST,contenedor);

        //Titulo de la tabla
        titulo = new JLabel("Proximas carreras");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 50,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo, 10 , SpringLayout.WEST, contenedor);

        //Tabla
        /*
        scroll = new JScrollPane();
        cabecera = new String[]{"Número de paricipantes","Numero de vueltas","Fecha","Hora"};
        //datos = new Object[][]{{"Popo","Popo","Popo","Popo"}};
        dtm = new DefaultTableModel(datos,cabecera);
        tabla = new JTable(dtm);
        scroll.setViewportView(tabla);
        contenedor.add(scroll);
        sp.putConstraint(SpringLayout.NORTH, scroll, 70, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll, -10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50, SpringLayout.SOUTH, contenedor);
        */

        scroll      = new JScrollPane();
        cabecera    = new String[] {"Número de paricipantes","Numero de vueltas","Fecha","Hora"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
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
        //Combo
        comboCarrera = new JComboBox();
        contenedor.add(comboCarrera);
        sp.putConstraint(SpringLayout.SOUTH,comboCarrera,-10,SpringLayout.SOUTH,contenedor);
        sp.putConstraint(SpringLayout.WEST, comboCarrera, 125, SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,comboCarrera,-400,SpringLayout.EAST,contenedor);
        //pack();
    }

    public String getComboCarrera() {
        return (String) comboCarrera.getSelectedItem();
    }

    public void conectaControlador(  ControladorProximasCarreras c  ){

    }

    public static void main(String[] args)
    {
        ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
        VistaProximasCarreras v = new VistaProximasCarreras();
        ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(v, modeloProximasCarreras);
        v.conectaControlador(controladorProximasCarreras);

    }
}
