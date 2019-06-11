/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.ControladorInicioSesion;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author mfarf
 */
public class VistaInicioSesion extends JFrame{
     //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
    //Etiquetas
    private JLabel lblusername;
    private JLabel lblpass;
   private JLabel titulo;
    
    //Cuadros de texto
    private JTextField txtusername;
    private JPasswordField txtpass;
   
    
    //Botones
    private JButton btniniciar;
    private JButton btnregistrar;
    
    public VistaInicioSesion(){
        //Métodos de la JFrame
        setBounds(300, 300, 320, 250);//Definir las dimensiones de la ventana
        setTitle("AUTÓDROMO QU CHAO");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
         //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        contenedor.setBackground(Color.PINK);
        getContentPane().add(contenedor);
 
        //USAR EL LAYOUTMANAGER SpringLayout
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        /**************** ETIQUETAS  vvvvvvvvvvvvvvvv **/
        titulo = new JLabel("Iniciar sesión");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo,  5,
                        SpringLayout.WEST, contenedor);
        
        //ETIQUETA nombre de usuario
        lblusername = new JLabel("Nombre de usuario: ");  //Crear el objeto
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
        //Boton registrar
        btniniciar          = new JButton("Acceder");
        contenedor.add(btniniciar);
        sp.putConstraint(SpringLayout.SOUTH, btniniciar, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btniniciar,   35,
                        SpringLayout.WEST, contenedor);
        
        //BOTÓN SALIR
	btnregistrar			= new JButton("Registrarme");
	contenedor.add(btnregistrar);
	sp.putConstraint(SpringLayout.SOUTH, btnregistrar, -10,
	SpringLayout.SOUTH, contenedor);
	sp.putConstraint(SpringLayout.WEST, btnregistrar, 155,
	SpringLayout.WEST,contenedor);//
        setVisible(true);
    }
    
    public String getusername(){
        return txtusername.getText();
    }
    public String getpass(){
        return txtpass.getText();
    }
    
    public void conectaControlador(  ControladorInicioSesion c  ){
 
        btniniciar.addActionListener(c);
        btniniciar.setActionCommand("INICIAR");
        
        btnregistrar.addActionListener(c);
        btnregistrar.setActionCommand("REGISTRAR");
    }
    
    public static void main (String [] args){
        VistaInicioSesion v = new VistaInicioSesion();
    }
}
