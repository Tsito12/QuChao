/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author mfarf
 */
public class VistaPiloto extends JFrame{
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
    //Etiquetas
    private JLabel titulo;
    private JLabel lblnum_licencia;
    private JLabel lblnombre;
    private JLabel lblapellido1;
    private JLabel lblapellido2;
    private JLabel lblapodo;
    private JLabel lblnum_seguro;
    
    //Cuadros de texto
    private JTextField txtnum_licencia;
    private JTextField txtnombre;
    private JTextField txtapellido1;
    private JTextField txtapellido2;
    private JTextField txtapodo;
    private JTextField txtnum_seguro;
    
    //Botones
    private JButton bntregistrar;
    private JButton btnExit;
    public VistaPiloto(){
        //Métodos de la JFrame
        setBounds(300, 300, 550, 350);//Definir las dimensiones de la ventana
        setTitle("AUTÓDROMO QU CHAO");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
         //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //USAR EL LAYOUTMANAGER SpringLayout
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        /**************** ETIQUETAS  vvvvvvvvvvvvvvvv **/
        titulo = new JLabel("REGISTRO DE PILOTOS");
        contenedor.add(titulo);
        sp.putConstraint(SpringLayout.NORTH, titulo, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, titulo,  5,
                        SpringLayout.WEST, contenedor);
        
        //ETIQUETA nombre de usuario
        lblnum_licencia = new JLabel("Numero de licencia: ");  //Crear el objeto
        contenedor.add(lblnum_licencia);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblnum_licencia, 40,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnum_licencia,  5,
                        SpringLayout.WEST, contenedor);
        //txt nombre de usaurio
        txtnum_licencia       = new JTextField();
        contenedor.add(txtnum_licencia);
        sp.putConstraint(SpringLayout.NORTH, txtnum_licencia, 60,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnum_licencia, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnum_licencia, 200,
                        SpringLayout.WEST, contenedor);
        
       
        
        //NOMBRE
        lblnombre = new JLabel("Nombre: ");  //Crear el objeto
        contenedor.add(lblnombre);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblnombre, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnombre,  5,
                        SpringLayout.WEST, contenedor);
        
        txtnombre       = new JTextField();
        contenedor.add(txtnombre);
        sp.putConstraint(SpringLayout.NORTH, txtnombre, 110,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnombre, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnombre, 200,
                        SpringLayout.WEST, contenedor);
        
        //Apellido paterno
        lblapellido1 = new JLabel("Apellido paterno: ");  //Crear el objeto
        contenedor.add(lblapellido1);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblapellido1, 140,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblapellido1,  5,
                        SpringLayout.WEST, contenedor);
        
        txtapellido1       = new JTextField();
        contenedor.add(txtapellido1);
        sp.putConstraint(SpringLayout.NORTH, txtapellido1, 160,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellido1, 5,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtapellido1, 200,
                        SpringLayout.WEST, contenedor);
        
        //Apellido materno
        lblapellido2 = new JLabel("Apellido materno: ");  //Crear el objeto
        contenedor.add(lblapellido2);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblapellido2, 140,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblapellido2,  230,
                        SpringLayout.WEST, contenedor);
        
        txtapellido2       = new JTextField();
        contenedor.add(txtapellido2);
        sp.putConstraint(SpringLayout.NORTH, txtapellido2, 160,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellido2, 320,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellido2, 200,
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
    
    public String getnum_licencia(){
        return txtnum_licencia.getText();
    }
    public String getnombre(){
        return txtnombre.getText();
    }
    public String getApellido1(){
        return txtapellido1.getText();
    }
    public String getApellido2(){
        return txtapellido2.getText();
    }
    
    public String getapodo(){
        return txtapodo.getText();
    }
    
    public String getnumseguro(){
        return txtnum_seguro.getText();
    }
    
    public static void main (String [] args){
        VistaPiloto vp = new VistaPiloto();
    } 
}
