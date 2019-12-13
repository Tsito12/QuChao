package controlador;

import modelo.Carrera;
import modelo.ModeloAgregarPilotos;
import vista.VistaAgregarPilotos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorAgregarPilotos implements ActionListener, MouseListener {
    private VistaAgregarPilotos view;
    private ModeloAgregarPilotos modelo;

    public ControladorAgregarPilotos (VistaAgregarPilotos view, ModeloAgregarPilotos modelo){
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
                modelo.insertPiloto(view.piloto());
                this.modelo.closeConexion();
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
