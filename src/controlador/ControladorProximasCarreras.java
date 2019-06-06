package controlador;

import modelo.Carrera;
import modelo.ModeloProximasCarreras;
import vista.VistaProximasCarreras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ControladorProximasCarreras implements ActionListener {
    private VistaProximasCarreras vista;
    private ModeloProximasCarreras modelo;

    public ControladorProximasCarreras(VistaProximasCarreras vista, ModeloProximasCarreras modelo)
    {
        this.modelo=modelo;
        this.vista=vista;
        cargarTabla();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void cargarTabla()
    {
        Vector<Object> fila;

        //Limpiar los datos de la tabla
        for(int i=this.vista.dtm.getRowCount(); i>0; i--){
            this.vista.dtm.removeRow(i-1);
        }

        List<Carrera> carreras = modelo.listarCarreras();
        for (Carrera c:
             carreras) {
            fila=new Vector<Object>();
            fila.add(c.getNoParticpantes());
            fila.add(c.getNoVueltas());
            fila.add(c.getFecha());
            fila.add(c.getHora());
            this.vista.dtm.addRow(fila);
        }
    }
}
