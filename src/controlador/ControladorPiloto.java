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
import modelo.ModeloPiloto;
import modelo.Piloto;
import vista.VistaPiloto;
/**
 *
 * @author mfarf
 */
public class ControladorPiloto implements ActionListener, MouseListener{
    private VistaPiloto view;
    private ModeloPiloto modelo;
    
    public ControladorPiloto(VistaPiloto view, ModeloPiloto modelo){
        this.view = view;
        this.modelo = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
  
	Piloto e;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "INSERTAR":
                
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
