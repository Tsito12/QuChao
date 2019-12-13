package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorInsertarCarrera;

import javax.swing.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class VistaInsertarCarreras extends JFrame {
    //Contenedor principal
    private JPanel contenedor;
    //ETIQUETAS
    private JLabel titulo;
    private JLabel lblusername;
    private JLabel lblpass;
    private JLabel lblidcarrera;
    private JLabel lblnopaticipantes;
    private JLabel lblfecha;
    private JLabel lblnovueltas;
    private JLabel lblhora;

    private JTextField txtusername;
    private JPasswordField txtpass;
    private JTextField txtidcarrera;
    private JTextField txtnoparticipantes;
    private JDateChooser chdate;
    private JTextField txtnovueltas;
    private JTextField txthora;

    private JButton bntregistrar;
    private JButton btnCarrerasProximas;

    public  VistaInsertarCarreras(){
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

        lblusername = new JLabel("Usuario: ");  //Crear el objeto
        contenedor.add(lblusername);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblusername, 40,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblusername,  5,
                SpringLayout.WEST, contenedor);
        //txt nombre de usaurio
        txtusername       = new JTextField();
        contenedor.add(txtusername);
        sp.putConstraint(SpringLayout.NORTH, txtusername, 60,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtusername, 5,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtusername, 200,
                SpringLayout.WEST, contenedor);

        lblpass = new JLabel("Contraseña: ");  //Crear el objeto
        contenedor.add(lblpass);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblpass, 40,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblpass,  230,
                SpringLayout.WEST, contenedor);
        //txt Contraseña
        txtpass       = new JPasswordField();
        txtpass.setToolTipText("Ingrese Contraseña");
        contenedor.add(txtpass);
        sp.putConstraint(SpringLayout.NORTH, txtpass, 60,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtpass, 230,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtpass, 200,
                SpringLayout.EAST, contenedor);

        lblidcarrera = new JLabel("Id de la carrera: ");
        contenedor.add(lblidcarrera);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblidcarrera, 90,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblidcarrera,  230,
                SpringLayout.WEST, contenedor);

        txtidcarrera = new JTextField();
        contenedor.add(txtidcarrera);
        sp.putConstraint(SpringLayout.NORTH, txtidcarrera, 110,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtidcarrera, 230,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtidcarrera, 200,
                SpringLayout.EAST, contenedor);

        lblnopaticipantes = new JLabel("Numero de corredores");
        contenedor.add(lblnopaticipantes);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblnopaticipantes, 140,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnopaticipantes,  5,
                SpringLayout.WEST, contenedor);

        txtnoparticipantes = new JTextField();
        contenedor.add(txtnoparticipantes);
        sp.putConstraint(SpringLayout.NORTH, txtnoparticipantes, 160,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnoparticipantes, 5,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnoparticipantes, 200,
                SpringLayout.WEST, contenedor);

        lblfecha = new JLabel("Fecha: ");
        contenedor.add(lblfecha);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblfecha, 190,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblfecha,  5,
                SpringLayout.WEST, contenedor);

        chdate = new JDateChooser();
        chdate.setDateFormatString("yyyy-MM-dd");
        contenedor.add(chdate);
        sp.putConstraint(SpringLayout.NORTH, chdate, 210,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, chdate, 5,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, chdate, 200,
                SpringLayout.WEST, contenedor);

        lblnovueltas= new JLabel("Numero de vueltas: ");
        contenedor.add(lblnovueltas);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblnovueltas, 190,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnovueltas,  230,
                SpringLayout.WEST, contenedor);

        txtnovueltas = new JTextField();
        contenedor.add(txtnovueltas);
        sp.putConstraint(SpringLayout.NORTH, txtnovueltas, 210,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnovueltas, 230,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnovueltas, 50,
                SpringLayout.EAST, contenedor);

        lblhora = new JLabel("Hora: ");
        contenedor.add(lblhora);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblhora, 240,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblhora,  5,
                SpringLayout.WEST, contenedor);

        txthora = new JTextField();
        contenedor.add(txthora);
        sp.putConstraint(SpringLayout.NORTH, txthora, 260,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txthora, 5,
                SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txthora, 200,
                SpringLayout.WEST, contenedor);

        bntregistrar          = new JButton("Registrar Carrera");
        contenedor.add(bntregistrar);
        sp.putConstraint(SpringLayout.SOUTH, bntregistrar, -10,
                SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, bntregistrar,   35,
                SpringLayout.WEST, contenedor);

        btnCarrerasProximas = new JButton("Carreras proximas");
        contenedor.add(btnCarrerasProximas);
        sp.putConstraint(SpringLayout.SOUTH, btnCarrerasProximas, -10,
                SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.EAST, btnCarrerasProximas,   35,
                SpringLayout.EAST, contenedor);

        setBounds(300,300,500,400);
        setVisible(true);
    }


    public String getuser(){return txtusername.getText();}
    public String getpass(){return  txtpass.getText();}
    public int getid(){return Integer.parseInt(txtidcarrera.getText());}
    public int getNoparticipantes(){return Integer.parseInt(txtnoparticipantes.getText());}
    public String getFecha(){
        java.util.Date  fecha=chdate.getDate();
        DateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        String fecha2=f.format(fecha);
        return fecha2;}

    public int getnoVueltas(){return Integer.parseInt(txtnovueltas.getText());}
    public String getHora(){return txthora.getText();}

    public void conectaControlador(  ControladorInsertarCarrera c  ){

        bntregistrar.addActionListener(c);
        bntregistrar.setActionCommand("INSERTAR");

        btnCarrerasProximas.addActionListener(c);
        btnCarrerasProximas.setActionCommand("CARRERAS");
    }
}
