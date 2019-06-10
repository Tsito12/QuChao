package vista;

import controlador.ControladorApuesta;
import modelo.Carrera;
import modelo.Piloto;

import javax.swing.*;
import java.awt.*;

public class VistaApuesta extends JDialog {
    private Piloto piloto;
    private Carrera carrera;
    private JPanel contenedor;
    private JPanel botones;
    private JLabel nombrePiloto;
    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JButton btnCancelar;
    private JButton btnOK;

    public VistaApuesta(Piloto piloto, Carrera carrera)
    {
        this.piloto=piloto;
        this.carrera=carrera;
        //Panel principal
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        contenedor = new JPanel();
        getContentPane().add(contenedor);
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);

        //Nombre del piloto
        nombrePiloto = new JLabel("Usted esta apostando a "+piloto.getapodo());
        contenedor.add(nombrePiloto);
        sp.putConstraint(SpringLayout.NORTH,nombrePiloto,10,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,nombrePiloto,10,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,nombrePiloto,-10,SpringLayout.EAST,contenedor);

        //Cantidad a apostar
        lblCantidad = new JLabel("Ingrese la cantidad a apostar");
        contenedor.add(lblCantidad);
        sp.putConstraint(SpringLayout.NORTH,lblCantidad,30,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,lblCantidad,10,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,lblCantidad,-10,SpringLayout.EAST,contenedor);

        txtCantidad = new JTextField();
        contenedor.add(txtCantidad);
        sp.putConstraint(SpringLayout.NORTH,txtCantidad,50,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,txtCantidad,10,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.EAST,txtCantidad,-10,SpringLayout.EAST,contenedor);

        btnCancelar = new JButton("Cancelar");
        contenedor.add(btnCancelar);
        sp.putConstraint(SpringLayout.NORTH,btnCancelar,90,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.WEST,btnCancelar,10,SpringLayout.WEST,contenedor);
        sp.putConstraint(SpringLayout.SOUTH,btnCancelar,-10,SpringLayout.SOUTH,contenedor);

        btnOK = new JButton("OK");
        contenedor.add(btnOK);
        sp.putConstraint(SpringLayout.NORTH,btnOK,90,SpringLayout.NORTH,contenedor);
        sp.putConstraint(SpringLayout.SOUTH,btnOK,-10,SpringLayout.SOUTH,contenedor);
        sp.putConstraint(SpringLayout.EAST,btnOK,-10,SpringLayout.EAST,contenedor);

        setBounds(100,100,300,175);
        setVisible(true);
    }

    public void conectarControlador(ControladorApuesta c)
    {
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.addActionListener(c);
        btnOK.setActionCommand("OK");
        btnOK.addActionListener(c);
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getTxtCantidad() {
        return Integer.parseInt(txtCantidad.getText());
    }
/*public static void main(String[]args)
    {
        VistaApuesta v = new VistaApuesta();
    }**/
}
