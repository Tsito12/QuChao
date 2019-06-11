/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ModeloInicioSesion;
import modelo.ModeloProximasCarreras;
import modelo.ModeloRegistro;
import vista.VistaInicioSesion;
import vista.VistaProximasCarreras;
import vista.VistaRegistro;

/**
 *
 * @author mfarf
 */
public class ControladorInicioSesion implements ActionListener, MouseListener{
    private VistaInicioSesion view;
    private ModeloInicioSesion modelo;
    
    public ControladorInicioSesion(VistaInicioSesion view, ModeloInicioSesion modelo){
        this.view = view;
        this.modelo = modelo;
    }
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
  
	Cliente e;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
        ArrayList<Cliente> list;
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "INICIAR":
                String pss = view.getpass();
                String us = view.getusername();
                list = modelo.login(us, pss);
                if (list.size()>0){
                    view.dispose();
                    Cliente cliente = list.get(0);
                    this.modelo.closeConexion();
                    VistaProximasCarreras v= new VistaProximasCarreras(cliente);
                    ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
                    ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(v,modeloProximasCarreras);
                    v.conectaControlador(controladorProximasCarreras);
                }else {
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña invalidos","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            break;
 
            case "REGISTRAR":
                view.dispose();
                this.modelo.closeConexion();
                VistaRegistro vr = new VistaRegistro();
                ModeloRegistro modeloRegistro = new ModeloRegistro("dbautodromo");
                ControladorRegistro controladorRegistro = new ControladorRegistro(vr,modeloRegistro);
                vr.conectaControlador(controladorRegistro);
                vr.setVisible(true);
            break;
			
            default:
                System.err.println("Comando no definido");
            break;
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
}
