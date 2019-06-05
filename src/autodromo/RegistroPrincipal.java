/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autodromo;

import controlador.ControladorRegistro;
import modelo.ModeloRegistro;
import vista.VistaRegistro;

/**
 *
 * @author mfarf
 */
public class RegistroPrincipal {
    public static void main(String[] args) {
        //Invocar al constructor de la clase Bd
        ModeloRegistro modelo = new ModeloRegistro("dbautodromo");
        //Crear un objeto de la clase View
        VistaRegistro vista  = new VistaRegistro();
        //Crear un objeto de la clase Controller
        ControladorRegistro controlador  = new ControladorRegistro(vista, modelo);
        //Vincular la vista y el controlador
        vista.conectaControlador(controlador);
    } 
}
