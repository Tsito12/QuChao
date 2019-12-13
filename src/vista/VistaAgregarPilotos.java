package vista;

import controlador.ControladorAgregarPilotos;

import javax.swing.*;

public class VistaAgregarPilotos extends JFrame {
    private JLabel titulo;
    private JLabel lblpilotos;
    private JComboBox cpilotos;
    private JButton btnagregar;
    private JPanel contenedor;
    private String user;
    private String pass;

    public VistaAgregarPilotos(){
        //Métodos de la JFrame
        setBounds(300, 300, 550, 550);//Definir las dimensiones de la ventana
        setTitle("AUTÓDROMO QU CHAO");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
        //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);

        //USAR EL LAYOUTMANAGER SpringLayout
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);

        /**************** ETIQUETAS  vvvvvvvvvvvvvvvv **/
        titulo = new JLabel("REGISTRO DE CARRERAS");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 10,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo,  5,
                SpringLayout.WEST, contenedor);

        lblpilotos = new JLabel("Usuario: ");  //Crear el objeto
        contenedor.add(lblpilotos);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblpilotos, 40,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblpilotos,  5,
                SpringLayout.WEST, contenedor);

        cpilotos       = new JComboBox();
        contenedor.add(cpilotos);
        sp.putConstraint(SpringLayout.NORTH, cpilotos, 60,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, cpilotos, 5,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, cpilotos, 200,
                SpringLayout.WEST, contenedor);

        btnagregar       = new JButton("Agregar piloto");
        btnagregar.setToolTipText("Ingrese Contraseña");
        contenedor.add(btnagregar);
        sp.putConstraint(SpringLayout.NORTH, btnagregar, 60,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnagregar, 230,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, btnagregar, 200,
                SpringLayout.EAST, contenedor);

        setBounds(300,300,500,400);
        setVisible(true);
    }

    public JComboBox getPilotos(){
        return cpilotos;
    }
    public String piloto(){
        return cpilotos.getSelectedItem().toString();
    }

    public void conectaControlador(  ControladorAgregarPilotos c  ){
        btnagregar.addActionListener(c);
        btnagregar.setActionCommand("INSERTAR");
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getuser(){
        return user;
    }
    public String getpass(){
        return pass;
    }


}
