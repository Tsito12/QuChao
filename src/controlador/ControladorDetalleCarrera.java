package controlador;

import modelo.*;
import vista.DetalleCarrera;
import vista.VistaApuesta;
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
                VistaProximasCarreras vistaProximasCarreras = new VistaProximasCarreras(this.vista.cliente);
                ModeloProximasCarreras modeloProximasCarreras = new ModeloProximasCarreras("dbautodromo");
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
                    VistaHistorialPiloto vistaHistorialPiloto = new VistaHistorialPiloto(p2,this.vista.carrera,this.vista.cliente);
                    ModeloHistorialPiloto modeloHistorialPiloto = new ModeloHistorialPiloto("dbautodromo");
                    ControladorHistorialPiloto controladorHistorialPiloto = new ControladorHistorialPiloto(vistaHistorialPiloto, modeloHistorialPiloto);
                    vistaHistorialPiloto.conectarControlador(controladorHistorialPiloto);
                }
                break;
            case "Apostar":
                filaPulsada = this.vista.tabla.getSelectedRow();
                if(filaPulsada>=0)
                {
                    Piloto p = new Piloto();
                    String apodo = (String)this.vista.dtm.getValueAt(filaPulsada,3);
                    p.setapodo(apodo);
                    Piloto p2 = modelo.selectPiloto(p);
                    //modelo.closeConexion();
                    //this.vista.dispose();
                    VistaApuesta vistaApuesta = new VistaApuesta(p2,this.vista.carrera,this.vista.cliente);
                    ModeloApuesta modeloApuesta = new ModeloApuesta("dbautodromo");
                    ControladorApuesta controladorApuesta = new ControladorApuesta(vistaApuesta,modeloApuesta);
                    vistaApuesta.conectarControlador(controladorApuesta);
                }
                break;
        }
    }
}
