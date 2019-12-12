/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autodromo;

import controlador.ControladorInicioSesion;
import modelo.ModeloInicioSesion;
import vista.VistaInicioSesion;



/**
 *
 * @author mfarf
 */
public class IniciarSesionPrincipal {
    public static void main(String[] args) {
        //Invocar al constructor de la clase Bd
        VistaInicioSesion vista  = new VistaInicioSesion();
        ModeloInicioSesion modelo = new ModeloInicioSesion("dbautodromo");
        //Crear un objeto de la clase View

        //Crear un objeto de la clase Controller
        ControladorInicioSesion controlador  = new ControladorInicioSesion(vista, modelo);
        //Vincular la vista y el controlador
        vista.conectaControlador(controlador);
    } 
}
