package controlador;

import modelo.ModeloDetalleCarrera;
import modelo.ModeloHistorial;
import modelo.ModeloProximasCarreras;
import vista.DetalleCarrera;
import vista.VistaHistorial;
import vista.VistaProximasCarreras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ControladorHIstorial implements ActionListener {

    private VistaHistorial vista;
    private ModeloHistorial modelo;
    public ControladorHIstorial(VistaHistorial vistaHistorial, ModeloHistorial modelo)
    {
        this.vista=vistaHistorial;
        this.modelo=modelo;
        cagarTablas();
    }

    public void cagarTablas()
    {
        Vector<Object> fila;

        //Limpiar los datos de la tabla
        for(int i=this.vista.dtm.getRowCount(); i>0; i--){
            this.vista.dtm.removeRow(i-1);
        }

        List<Integer> carreras = modelo.carreras(vista.getCliente());
        List<String> apodos = modelo.apodos(vista.getCliente());
        List<Integer> cantidad = modelo.cantidad(vista.getCliente());
        List<String> resultados = new ArrayList<>();
        String res="";
        for(int i =0; i<carreras.size();i++)
        {
            res = modelo.resultados(vista.getCliente().getUsername(),apodos.get(i),carreras.get(i));
            resultados.add(res);
        }
        for (int i = 0; i<carreras.size();i++) {
            fila=new Vector<Object>();
            fila.add(carreras.get(i));
            fila.add(apodos.get(i));
            fila.add(cantidad.get(i));
            fila.add(resultados.get(i));
            this.vista.dtm.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando)
        {
            case "Regresar":
                modelo.closeConexion();
                this.vista.dispose();
                VistaProximasCarreras vistaProximasCarreras = new VistaProximasCarreras(this.vista.getCliente());
                ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
                ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(vistaProximasCarreras,modeloProximasCarreras);
                vistaProximasCarreras.conectaControlador(controladorProximasCarreras);
                break;
        }

    }
}
