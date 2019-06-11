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
import modelo.Cliente;
import modelo.ModeloProximasCarreras;
import modelo.ModeloRegistro;
import vista.VistaProximasCarreras;
import vista.VistaRegistro;

/**
 *
 * @author mfarf
 */
public class ControladorRegistro implements ActionListener, MouseListener{
    private VistaRegistro view;
    private ModeloRegistro modelo;
    
    public ControladorRegistro( VistaRegistro view , ModeloRegistro modelo){
        this.view   = view;
	this.modelo = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
  
	Cliente e;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "INSERTAR":
                e = new Cliente(view.getTxtusername(), view.getTxtpass(),view.getTxtcuenta(),view.getTxtcorreo(),view.getTxtcolonia(),view.getTxtcalle(),
                view.getTxtnumero(),view.getTxtcp(), view.getTxtnombre(), view.getTxtapellidoP(), view.getTxtapellidoM());
                modelo.insertCliente(e);
                view.registroCompleto();
                this.modelo.closeConexion();
                this.view.dispose();
                VistaProximasCarreras vistaProximasCarreras = new VistaProximasCarreras(e);
                ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
                ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(vistaProximasCarreras,modeloProximasCarreras);
                vistaProximasCarreras.conectaControlador(controladorProximasCarreras);
                
            break;
 
            case "SALIR":
                modelo.closeConexion();
                this.view.dispose();
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
