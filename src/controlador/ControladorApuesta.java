package controlador;

import modelo.Cliente;
import modelo.ModeloApuesta;
import modelo.ModeloCarrera;
import vista.VistaApuesta;
import vista.VistaCarrera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorApuesta implements ActionListener {
    private VistaApuesta vista;
    private ModeloApuesta modelo;

    public ControladorApuesta(VistaApuesta vistaApuesta, ModeloApuesta modelo)
    {
        vista = vistaApuesta;
        this.modelo=modelo;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando)
        {
            case "Cancelar" :
                this.vista.dispose();
                break;
            case "OK":
                Integer monto = vista.getTxtCantidad();
                System.out.println(monto);
                int importe = monto*10;
                Cliente cliente = new Cliente(); //Este es para prueba, se tiene que sustituir por el usuario
                cliente.setUsername("Tsito");    //con el que se haya iniciado sesion, que se tendra en todas las vistas
                                                 //inlcudia la VistaApuesta. Asi como se ha hecho con la carrera y el piloto
                modelo.insertarApuesta(cliente,this.vista.getCarrera(),this.vista.getPiloto(),monto,importe);
                this.vista.dispose();
                VistaCarrera vistaCarrera= new VistaCarrera(this.vista.getCarrera(),this.vista.getPiloto());
                ModeloCarrera modeloCarrera = new ModeloCarrera("dbautodromo");
                ControladorCarrera controladorCarrera = new ControladorCarrera(vistaCarrera,modeloCarrera);
                vistaCarrera.acomodarCarritos();
                break;
        }
    }
}
