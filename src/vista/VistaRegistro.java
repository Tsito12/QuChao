/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorRegistro;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author mfarf
 */
public class VistaRegistro extends JFrame{
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
    //Etiquetas
    private JLabel lblusername;
    private JLabel lblpass;
    private JLabel lblconfirmpass;
    private JLabel lblcuenta;
    private JLabel titulo;
    private JLabel lbldir_calle;
    private JLabel lbldir_colonia;
    private JLabel lbldir_num;
    private JLabel lbldir_cp;
    private JLabel lblnombre;
    private JLabel lblapellido1;
    private JLabel lblapellido2;
    private JLabel lblcorreo;
    
    //Cuadros de texto
    private JTextField txtusername;
    private JPasswordField txtpass;
    private JPasswordField txtconfirmpass;
    private JTextField cuenta;
    private JTextField txtdir_calle;
    private JTextField txtdir_colonia;
    private JTextField txtdir_numero;
    private JTextField txtcp;
    private JTextField txtnombre;
    private JTextField txtapellido1;
    private JTextField txtapellido2;
    private JTextField txtcorreo;
    
    //Botones
    private JButton bntregistrar;
    private JButton btnExit;
    
    
    public VistaRegistro(){
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
        titulo = new JLabel("REGISTRO DE USUARIO");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo,  5,
                        SpringLayout.WEST, contenedor);
        
        //ETIQUETA nombre de usuario
        lblusername = new JLabel("Elija un nombre de usuario: ");  //Crear el objeto
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
        
        //Contraseña
        lblpass = new JLabel("Elija una contraseña: ");  //Crear el objeto
        contenedor.add(lblpass);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblpass, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblpass,  5,
                        SpringLayout.WEST, contenedor);
        //txt Contraseña
        txtpass       = new JPasswordField();
        txtpass.setToolTipText("Ingrese Contraseña");
        contenedor.add(txtpass);
        sp.putConstraint(SpringLayout.NORTH, txtpass, 110,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtpass, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtpass, 200,
                        SpringLayout.WEST, contenedor);
        
        //Confirmar contraseña
        lblconfirmpass = new JLabel("Confirme su contraseña: ");  //Crear el objeto
        contenedor.add(lblconfirmpass);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblconfirmpass, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblconfirmpass,  230,
                        SpringLayout.WEST, contenedor);
        //txt Confirmar contraseña
        txtconfirmpass       = new JPasswordField();
        txtconfirmpass.setToolTipText("Confirme su Contraseña");
        contenedor.add(txtconfirmpass);
        sp.putConstraint(SpringLayout.NORTH, txtconfirmpass, 110,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtconfirmpass, 230,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtconfirmpass, 200,
                        SpringLayout.EAST, contenedor);
        
        //Cuenta Bancaria
        lblcuenta = new JLabel("Introduzca el numero de su tarjeta: ");  //Crear el objeto
        contenedor.add(lblcuenta);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblcuenta, 140,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblcuenta,  5,
                        SpringLayout.WEST, contenedor);
        //txt Confirmar contraseña
        cuenta       = new JTextField();
        contenedor.add(cuenta);
        sp.putConstraint(SpringLayout.NORTH, cuenta, 160,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, cuenta, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, cuenta, 200,
                        SpringLayout.WEST, contenedor);
        
        //Direccion calle
        lbldir_calle = new JLabel("Calle: ");  //Crear el objeto
        contenedor.add(lbldir_calle);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lbldir_calle, 190,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldir_calle,  5,
                        SpringLayout.WEST, contenedor);
       
        txtdir_calle       = new JTextField();
        contenedor.add(txtdir_calle);
        sp.putConstraint(SpringLayout.NORTH, txtdir_calle, 210,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtdir_calle, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtdir_calle, 200,
                        SpringLayout.WEST, contenedor);
        
        //direccion
        lbldir_num = new JLabel("Número: ");  //Crear el objeto
        contenedor.add(lbldir_num);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lbldir_num, 190,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldir_num,  230,
                        SpringLayout.WEST, contenedor);
        //txt numero
        txtdir_numero       = new JTextField();
        contenedor.add(txtdir_numero);
        sp.putConstraint(SpringLayout.NORTH, txtdir_numero, 210,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtdir_numero, 230,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtdir_numero, 50,
                        SpringLayout.EAST, contenedor);
        
        //Direccion colonia y cp
        lbldir_colonia = new JLabel("Colonia: ");  //Crear el objeto
        contenedor.add(lbldir_colonia);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lbldir_colonia, 240,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldir_colonia,  5,
                        SpringLayout.WEST, contenedor);
        //txt numero
        txtdir_colonia       = new JTextField();
        contenedor.add(txtdir_colonia);
        sp.putConstraint(SpringLayout.NORTH, txtdir_colonia, 260,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtdir_colonia, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtdir_colonia, 200,
                        SpringLayout.WEST, contenedor);
        
        lbldir_cp = new JLabel("Código postal: ");  //Crear el objeto
        contenedor.add(lbldir_cp);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lbldir_cp, 240,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldir_cp,  230,
                        SpringLayout.WEST, contenedor);
        //txt numero
        txtcp       = new JTextField();
        contenedor.add(txtcp);
        sp.putConstraint(SpringLayout.NORTH, txtcp, 260,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtcp, 230,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtcp, 50,
                        SpringLayout.EAST, contenedor);
        
        //NOMBRE
        lblnombre = new JLabel("Nombre: ");  //Crear el objeto
        contenedor.add(lblnombre);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblnombre, 290,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnombre,  5,
                        SpringLayout.WEST, contenedor);
        
        txtnombre       = new JTextField();
        contenedor.add(txtnombre);
        sp.putConstraint(SpringLayout.NORTH, txtnombre, 310,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnombre, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnombre, 200,
                        SpringLayout.WEST, contenedor);
        
        //Apellido paterno
        lblapellido1 = new JLabel("Apellido paterno: ");  //Crear el objeto
        contenedor.add(lblapellido1);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblapellido1, 340,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblapellido1,  5,
                        SpringLayout.WEST, contenedor);
        
        txtapellido1       = new JTextField();
        contenedor.add(txtapellido1);
        sp.putConstraint(SpringLayout.NORTH, txtapellido1, 360,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellido1, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtapellido1, 200,
                        SpringLayout.WEST, contenedor);
        
        //Apellido materno
        lblapellido2 = new JLabel("Apellido materno: ");  //Crear el objeto
        contenedor.add(lblapellido2);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblapellido2, 340,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblapellido2,  230,
                        SpringLayout.WEST, contenedor);
        
        txtapellido2       = new JTextField();
        contenedor.add(txtapellido2);
        sp.putConstraint(SpringLayout.NORTH, txtapellido2, 360,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellido2, 230,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtapellido2, 200,
                        SpringLayout.EAST, contenedor);
        
        //CORREO ELECTRONICO
        lblcorreo = new JLabel("Correo electronico: ");  //Crear el objeto
        contenedor.add(lblcorreo);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblcorreo, 390,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblcorreo,  5,
                        SpringLayout.WEST, contenedor);
        
        txtcorreo       = new JTextField();
        contenedor.add(txtcorreo);
        sp.putConstraint(SpringLayout.NORTH, txtcorreo, 410,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtcorreo, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtcorreo, 200,
                        SpringLayout.WEST, contenedor);
        
        
        //Boton registrar
        bntregistrar          = new JButton("Registrar");
        contenedor.add(bntregistrar);
        sp.putConstraint(SpringLayout.SOUTH, bntregistrar, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, bntregistrar,   35,
                        SpringLayout.WEST, contenedor);
        
        //BOTÓN SALIR
	btnExit			= new JButton("Salir");
	contenedor.add(btnExit);
	sp.putConstraint(SpringLayout.SOUTH, btnExit, -10,
	SpringLayout.SOUTH, contenedor);
	sp.putConstraint(SpringLayout.WEST, btnExit, 355,
	SpringLayout.WEST,contenedor);//
        
        setVisible(true);
    }
    
    // Métodos para obtener contenido de los cuadros de texto
    public String  getTxtusername(){
        return txtusername.getText();
    }
    
    public String getTxtpass(){
        return txtpass.getText();
    }
    
    public String getTxtconfirmpass(){
        return txtconfirmpass.getText();
    }
    public String getTxtcuenta(){
        return cuenta.getText();
    }
    public String getTxtcalle(){
        return txtdir_calle.getText();
    }
    public String getTxtnumero(){
        return txtdir_numero.getText();
    }
    public String getTxtcolonia(){
        return txtdir_colonia.getText();
    }
    public String getTxtcp(){
        return txtcp.getText();
    }
    public String getTxtnombre(){
        return txtnombre.getText();
    }
    public String getTxtapellidoP(){
        return txtapellido1.getText();
    }
    public String getTxtapellidoM(){
        return txtapellido2.getText();
    }
    public String getTxtcorreo(){
        return txtcorreo.getText();
    }
    
    public void conectaControlador(  ControladorRegistro c  ){
 
        bntregistrar.addActionListener(c);
        bntregistrar.setActionCommand("INSERTAR");
        
        btnExit.addActionListener(c);
        btnExit.setActionCommand("SALIR");
    }

    public void registroCompleto()
    {
        JOptionPane.showMessageDialog(this, "Registro Completado");
    }
    
    public static void main (String [] args){
        VistaRegistro v = new VistaRegistro();
    }
    
}
