package controlador;

import modelo.Carrera;
import modelo.ModeloAgregarPilotos;
import modelo.Piloto;
import vista.VistaAgregarPilotos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ControladorAgregarPilotos implements ActionListener, MouseListener {
    private VistaAgregarPilotos view;
    private ModeloAgregarPilotos modelo;

    public ControladorAgregarPilotos (VistaAgregarPilotos view, ModeloAgregarPilotos modelo){
        this.view = view;
        this.modelo = modelo;
        llenarCombo();
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
                modelo.insertPiloto(view.piloto(),this.view.carrera.getIdcarrera());
                this.modelo.closeConexion();

                break;


            default:
                System.err.println("Comando no definido");
                break;
        }
    }

    public void llenarCombo()
    {
        List<Piloto> pilotos = modelo.listarPilotos();
        for (int i = 0; i<pilotos.size();i++)
        {
            this.view.getPilotos().addItem(pilotos.get(i).getapodo());
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
