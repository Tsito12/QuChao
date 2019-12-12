package autodromo;

import controlador.ControladorInsertarCarrera;
import modelo.ModeloInsertarCarreras;
import vista.VistaInsertarCarreras;

public class InsertarCarreraPrincipal {
    public static void main(String[] args) {
        //Invocar al constructor de la clase Bd
        //Crear un objeto de la clase View
        VistaInsertarCarreras vista  = new VistaInsertarCarreras();
        ModeloInsertarCarreras modelo = new ModeloInsertarCarreras("dbautodromo");
        //Crear un objeto de la clase Controller
        ControladorInsertarCarrera controlador  = new ControladorInsertarCarrera(vista, modelo);
        //Vincular la vista y el controlador
        vista.conectaControlador(controlador);
    }
}
