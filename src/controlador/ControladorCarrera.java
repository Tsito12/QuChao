package controlador;

import modelo.ModeloCarrera;
import vista.VistaCarrera;

public class ControladorCarrera {
    private VistaCarrera vista;
    private ModeloCarrera modelo;

    public ControladorCarrera(VistaCarrera vista, ModeloCarrera modelo)
    {
        this.modelo=modelo;
        this.vista=vista;
        vista.setPilotos(modelo.listaPilotosPorCarrera(vista.getCarrera()));
    }

}
