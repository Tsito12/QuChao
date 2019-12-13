package controlador;

import modelo.*;
import vista.VistaAgregarPilotos;
import vista.VistaInsertarCarreras;
import vista.VistaProximasCarreras;
import vista.VistaRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControladorInsertarCarrera implements ActionListener, MouseListener {
    private VistaInsertarCarreras view;
    private ModeloInsertarCarreras modelo;

    public ControladorInsertarCarrera(VistaInsertarCarreras view, ModeloInsertarCarreras modelo){
        this.view = view;
        this.modelo = modelo;
    }

    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos

        Carrera e;

        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();

        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "INSERTAR":
                modelo.login(view.getuser(),view.getpass());
                e = new Carrera(view.getid(),view.getNoparticipantes(), view.getFecha(),view.getnoVueltas(),view.getHora());
                modelo.insertCarrera(e);
                VistaAgregarPilotos vista = new VistaAgregarPilotos(e);
                vista.setPass(view.getpass());
                vista.setUser(view.getuser());
                ModeloAgregarPilotos ma = new ModeloAgregarPilotos("dbautodromo");
                ma.login(view.getuser(),view.getpass());
                ControladorAgregarPilotos ca = new ControladorAgregarPilotos(vista, ma);
                vista.conectaControlador(ca);
                //ma.llenarpilotos(vista.getPilotos());
                this.modelo.closeConexion();
                this.view.dispose();
                break;

            case "CARRERAS":
                modelo.closeConexion();
                this.view.dispose();
                VistaProximasCarreras vistaProximasCarreras = new VistaProximasCarreras();
                ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
                ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(vistaProximasCarreras,modeloProximasCarreras);
                vistaProximasCarreras.conectaControlador(controladorProximasCarreras);
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