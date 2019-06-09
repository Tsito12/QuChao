package controlador;

import modelo.Carrera;
import modelo.ModeloDetalleCarrera;
import modelo.ModeloHistorialPiloto;
import vista.DetalleCarrera;
import vista.VistaHistorialPiloto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

public class ControladorHistorialPiloto implements ActionListener, MouseListener {
    private VistaHistorialPiloto vista;
    private ModeloHistorialPiloto modelo;

    public ControladorHistorialPiloto(VistaHistorialPiloto vista, ModeloHistorialPiloto modelo) {
        this.vista = vista;
        this.modelo = modelo;
        cargarTablaCarreras();
    }

    public void cargarTablaCarreras()
    {
        Vector<Object> fila;

        //Limpiar los datos de la tabla
        for(int i=this.vista.dtmCarrea.getRowCount(); i>0; i--){
            this.vista.dtmCarrea.removeRow(i-1);
        }

        List<Carrera> carreras = modelo.listCarreras(vista.getPiloto());
        List<Integer> posiciones = modelo.posiciones(this.vista.getPiloto());
        for (int i = 0; i<carreras.size();i++) {
            fila=new Vector<Object>();
            fila.add(carreras.get(i).getFecha());
            fila.add(carreras.get(i).getHora());
            fila.add(carreras.get(i).getNoVueltas());
            fila.add(carreras.get(i).getNoParticpantes());
            fila.add(posiciones.get(i));
            this.vista.dtmCarrea.addRow(fila);
        }
    }

    public void cargarTablaApodos()
    {
        int filaPulsada = this.vista.tablaCarrera.getSelectedRow();
        if (filaPulsada>=0) {
            Carrera carrera = new Carrera();
            String fecha = (String)this.vista.dtmCarrea.getValueAt(filaPulsada,0);
            String hora = (String)this.vista.dtmCarrea.getValueAt(filaPulsada,1);
            carrera.setFecha(fecha);
            carrera.setHora(hora);
            Carrera carrera2 = this.modelo.selectCarrera(carrera);
            Vector<Object> fila;

            //Limpiar los datos de la tabla
            for(int i=this.vista.dtmParticipantes.getRowCount(); i>0; i--){
                this.vista.dtmParticipantes.removeRow(i-1);
            }

            List<String> apodos = modelo.listaDeApodos(carrera2);
            for (int i = 0; i<apodos.size();i++) {
                fila=new Vector<Object>();
                fila.add(apodos.get(i));
                this.vista.dtmParticipantes.addRow(fila);
            }
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
                DetalleCarrera detalleCarrera = new DetalleCarrera(this.vista.getCarrera());
                ModeloDetalleCarrera modeloDetalleCarrera = new ModeloDetalleCarrera("autodoromo");
                ControladorDetalleCarrera controladorDetalleCarrera = new ControladorDetalleCarrera(detalleCarrera,modeloDetalleCarrera);
                detalleCarrera.conectaControlador(controladorDetalleCarrera);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cargarTablaApodos();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
