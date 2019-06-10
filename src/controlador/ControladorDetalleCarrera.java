package controlador;

import modelo.ModeloDetalleCarrera;
import modelo.ModeloHistorialPiloto;
import modelo.ModeloProximasCarreras;
import modelo.Piloto;
import vista.DetalleCarrera;
import vista.VistaHistorialPiloto;
import vista.VistaProximasCarreras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ControladorDetalleCarrera implements ActionListener {
    private DetalleCarrera vista;
    private ModeloDetalleCarrera modelo;

    public ControladorDetalleCarrera(DetalleCarrera vista, ModeloDetalleCarrera modelo) {
        this.vista = vista;
        this.modelo = modelo;
        cargarTabla();
    }

    public void cargarTabla()
    {
        Vector<Object> fila;

        //Limpiar los datos de la tabla
        for(int i=this.vista.dtm.getRowCount(); i>0; i--){
            this.vista.dtm.removeRow(i-1);
        }
        List<Piloto> piltos = this.modelo.listaPilotosPorCarrera(this.vista.carrera);
        List<Integer> listaCarrerasGandas = this.modelo.listaCarrerasGanadas();
        for(int i = 0; i<piltos.size();i++)
        {
            fila=new Vector<Object>();
            fila.add(piltos.get(i).getnombre());
            fila.add(piltos.get(i).getapellidoP());
            fila.add(piltos.get(i).getapellidoM());
            fila.add(piltos.get(i).getapodo());
            fila.add(listaCarrerasGandas.get(i));
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
                VistaProximasCarreras vistaProximasCarreras = new VistaProximasCarreras();
                ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("autodoromo");
                ControladorProximasCarreras controladorProximasCarreras = new ControladorProximasCarreras(vistaProximasCarreras, modeloProximasCarreras);
                vistaProximasCarreras.conectaControlador(controladorProximasCarreras);
                break;
            case "Historial":
                int filaPulsada = this.vista.tabla.getSelectedRow();
                if(filaPulsada>=0)
                {
                    Piloto p = new Piloto();
                    String apodo = (String)this.vista.dtm.getValueAt(filaPulsada,3);
                    p.setapodo(apodo);
                    Piloto p2 = modelo.selectPiloto(p);
                    modelo.closeConexion();
                    this.vista.dispose();
                    VistaHistorialPiloto vistaHistorialPiloto = new VistaHistorialPiloto(p2,this.vista.carrera);
                    ModeloHistorialPiloto modeloHistorialPiloto = new ModeloHistorialPiloto("autodoromo");
                    ControladorHistorialPiloto controladorHistorialPiloto = new ControladorHistorialPiloto(vistaHistorialPiloto, modeloHistorialPiloto);
                    vistaHistorialPiloto.conectarControlador(controladorHistorialPiloto);
                }
                break;
        }
    }
}