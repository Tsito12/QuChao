/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import modelo.ModeloPiloto;
import modelo.Piloto;
import vista.VistaPiloto;
/**
 *
 * @author mfarf
 */
public class ControladorPiloto implements ActionListener, MouseListener{
    private VistaPiloto view;
    private ModeloPiloto modelo;
    
    public ControladorPiloto(VistaPiloto view, ModeloPiloto modelo){
        this.view = view;
        this.modelo = modelo;
        cargarTabla();
    }

    public void cargarTabla()
    {
        Vector<Object> fila;

        //Limpiar los datos de la tabla
        for(int i=this.view.dtm.getRowCount(); i>0; i--){
            this.view.dtm.removeRow(i-1);
        }
        List<Piloto> piltos = this.modelo.listarPilotos();
        for(int i = 0; i<piltos.size();i++)
        {
            fila=new Vector<Object>();
            fila.add(piltos.get(i).getnum_licencia());
            fila.add(piltos.get(i).getnombre());
            fila.add(piltos.get(i).getapellidoP());
            fila.add(piltos.get(i).getapellidoM());
            fila.add(piltos.get(i).getapodo());
            this.view.dtm.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
  
	Piloto e;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "REGISTRAR":
                String numLicencia = this.view.getnum_licencia();
                String nombre = this.view.getnombre();
                String apellido1 = this.view.getApellido1();
                String apellido2 = this.view.getApellido2();
                String aapodo = this.view.getapodo();
                e = new Piloto();
                e.setnum_licencia(numLicencia);
                e.setnombre(nombre);
                e.setapellidoP(apellido1);
                e.setapellidoM(apellido2);
                e.setapodo(aapodo);
                modelo.insertarPiloto(e);
                cargarTabla();
            break;
 
            case "SALIR":
                modelo.closeConexion();
                this.view.dispose();
            break;

            case "EDITAR":
                int filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0)
                {
                     numLicencia = this.view.getnum_licencia();
                     nombre = this.view.getnombre();
                     apellido1 = this.view.getApellido1();
                     apellido2 = this.view.getApellido2();
                     aapodo = this.view.getapodo();
                    e = new Piloto();
                    e.setnum_licencia(numLicencia);
                    e.setnombre(nombre);
                    e.setapellidoP(apellido1);
                    e.setapellidoM(apellido2);
                    e.setapodo(aapodo);
                    modelo.updatePiloto(e);
                    cargarTabla();
                }
			break;
            case "ELIMINAR":
                filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    //int identificador   = (int)this.view.dtm.getValueAt(filaPulsada, 0);
                    e = new Piloto();
                    String num_Licencia = (String) this.view.dtm.getValueAt(filaPulsada,0);
                    e.setnum_licencia(num_Licencia);
                    modelo.deletePiloto(e);
                }
                break;
            default:
                System.err.println("Comando no definido");
            break;
        }
        //limpiar el formulario
        limpiar();

        //refrescar la tabla
        cargarTabla();
    }

    public void limpiar()
    {
        this.view.setTxtapodo("");
        this.view.setTxtnum_licencia("");
        this.view.setTxtnombre("");
        this.view.setTxtapellido1("");
        this.view.setTxtapellido2("");
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

        //Recoger qué fila se ha pulsadao en la tabla
        int filaPulsada = this.view.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0) {
            //Se recoge el id de la fila marcada
            Piloto p = new Piloto();
            String numLicencia = (String) this.view.dtm.getValueAt(filaPulsada, 0);

            p.setnum_licencia(numLicencia);
            Piloto p2 = modelo.selectPiloto(p);
            if (p2 != null) {

                this.view.setTxtnum_licencia(p2.getnum_licencia());
                this.view.setTxtnombre(p2.getnombre());
                this.view.setTxtapellido1(p2.getapellidoP());
                this.view.setTxtapellido2(p2.getapellidoM());
                this.view.setTxtapodo(p2.getapodo());
            }
        }
    }
}
