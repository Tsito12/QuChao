package controlador;

import modelo.Carrera;
import modelo.ModeloProximasCarreras;
import vista.VistaProximasCarreras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

public class ControladorProximasCarreras implements ActionListener, MouseListener {
    private VistaProximasCarreras vista;
    private ModeloProximasCarreras modelo;

    public ControladorProximasCarreras(VistaProximasCarreras vista, ModeloProximasCarreras modelo)
    {
        this.modelo=modelo;
        this.vista=vista;
        cargarTabla();
        cargarListaCarreras();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando)
        {
            case "Salir":
                modelo.closeConexion();
                this.vista.dispose();
            break;
            case "Modificar":
                int filaPulsada = this.vista.tabla.getSelectedRow();
                if(filaPulsada>=0)
                {
                    Carrera carrera = new Carrera();
                    String fecha = (String)this.vista.dtm.getValueAt(filaPulsada,2);
                    String hora = (String)this.vista.dtm.getValueAt(filaPulsada,3);
                    carrera.setFecha(fecha);
                    carrera.setFecha(fecha);
                }
        }

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
    public void cargarListaCarreras()
    {
        List<Carrera> carreras = modelo.listarCarreras();
        for(int i =0; i<carreras.size();i++)
        {
            vista.getComboCarrera().addItem(carreras.get(i).getIdcarrera());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Recoger que fila se ha pulsadao en la tabla
        int filaPulsada = this.vista.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0)
        {
            Carrera carrera = new Carrera();
            String noParticipantes = (String)this.vista.dtm.getValueAt(filaPulsada,0);
        }
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
