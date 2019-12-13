/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPiloto;
import modelo.ModeloPiloto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    private JLabel lblnum_seguro;//xd ya no se ocupo ese pedo
    
    //Cuadros de texto
    private JTextField txtnum_licencia;
    private JTextField txtnombre;
    private JTextField txtapellido1;
    private JTextField txtapellido2;
    private JTextField txtapodo;
    private JTextField txtnum_seguro;
    
    //Botones
    private JButton bntregistrar;
    private JButton btnEditar;
    private JButton btnExit;
    private JButton btnEliminar;

    //Tabla
    public JTable tabla;
    public DefaultTableModel dtm;
    private JScrollPane scroll;
    protected String [] cabecera;
    protected Object [][] datos;
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
        sp.putConstraint(SpringLayout.WEST, txtapellido2, 225,
                        SpringLayout.WEST, txtapellido1);
        sp.putConstraint(SpringLayout.EAST, txtapellido2, -100,
                        SpringLayout.EAST, contenedor);

        lblapodo = new JLabel("Apodo");
        contenedor.add(lblapodo);
        sp.putConstraint(SpringLayout.NORTH, lblapodo, 25,
                SpringLayout.NORTH, txtapellido1);
        sp.putConstraint(SpringLayout.WEST, lblapodo,  5,
                SpringLayout.WEST, contenedor);

        txtapodo = new JTextField();
        contenedor.add(txtapodo);
        sp.putConstraint(SpringLayout.NORTH,txtapodo,25,SpringLayout.NORTH,lblapodo);
        sp.putConstraint(SpringLayout.WEST,txtapodo,5,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST, txtapodo, 200,
                SpringLayout.WEST, contenedor);

        scroll      = new JScrollPane();
        cabecera    = new String[] {"Numero de Licencia","Nombre","Apellido Paterno","Apellido Materno","Apodo"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);

        contenedor.add(scroll);
        sp.putConstraint(SpringLayout.NORTH,scroll,30,SpringLayout.NORTH,txtapodo);
        sp.putConstraint(SpringLayout.WEST,scroll,10,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,scroll,-10,SpringLayout.EAST,contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -40,
                SpringLayout.SOUTH, contenedor);//colocarlo
        
        //Boton registrar
        bntregistrar          = new JButton("Registrar");
        contenedor.add(bntregistrar);
        sp.putConstraint(SpringLayout.SOUTH, bntregistrar, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, bntregistrar,   35,
                        SpringLayout.WEST, contenedor);

        //boton editar
        btnEditar = new JButton("Editar");
        contenedor.add(btnEditar);
        sp.putConstraint(SpringLayout.SOUTH, btnEditar, -10,
                SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnEditar,   200,
                SpringLayout.WEST, contenedor);

        //boton eliminar
        btnEliminar = new JButton("Eliminar");
        contenedor.add(btnEliminar);
        sp.putConstraint(SpringLayout.SOUTH, btnEliminar, -10,
                SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnEliminar,   300,
                SpringLayout.WEST, contenedor);
        
        //BOTÓN SALIR
	btnExit			= new JButton("Salir");
	contenedor.add(btnExit);
	sp.putConstraint(SpringLayout.SOUTH, btnExit, -10,
	SpringLayout.SOUTH, contenedor);
	sp.putConstraint(SpringLayout.WEST, btnExit, 500,
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


    public void setTxtnum_licencia(String txtnum_licencia) {
        this.txtnum_licencia.setText(txtnum_licencia);
    }

    public void setTxtnombre(String txtnombre) {
        this.txtnombre.setText(txtnombre);
    }

    public void setTxtapellido1(String txtapellido1) {
        this.txtapellido1.setText(txtapellido1);
    }

    public void setTxtapellido2(String txtapellido2) {
        this.txtapellido2.setText(txtapellido2);
    }

    public void setTxtapodo(String txtapodo) {
        this.txtapodo.setText(txtapodo);
    }

    public void conectarControlador(ControladorPiloto c)
    {
        bntregistrar.setActionCommand("REGISTRAR");
        bntregistrar.addActionListener(c);
        btnExit.setActionCommand("SALIR");
        btnExit.addActionListener(c);
        btnEditar.setActionCommand("EDITAR");
        btnEditar.addActionListener(c);
        tabla.addMouseListener(c);
        btnEliminar.setActionCommand("ELIMINAR");
        btnEliminar.addActionListener(c);
    }
    
    public static void main (String [] args){
        VistaPiloto vp = new VistaPiloto();
        ModeloPiloto modelo = new ModeloPiloto("dbautodromo");
        ControladorPiloto controlador = new ControladorPiloto(vp,modelo);
        vp.conectarControlador(controlador);
    } 
}
