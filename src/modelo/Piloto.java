/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mfarf
 */
public class Piloto {
    private String num_licencia;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String apodo;
    private String num_seguro;
    
    public Piloto(){}
    
    public Piloto(String num_licencia, String nombre, String apellidoP, String apellidoM, String apodo, String num_seguro){
        this.num_licencia = num_licencia;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.apodo = apodo;
        this.num_seguro = num_seguro;
    }
    
    public void setnum_licencia (String num_licencia){
        this.num_licencia = num_licencia;
    }
    public String getnum_licencia(){
        return num_licencia;
    }
    
    public void setnombre (String nombre){
        this.nombre = nombre;
    }
    public String getnombre(){
        return nombre;
    }
    
    public void setapellidoP (String apellidoP){
        this.apellidoP= apellidoP;
    }
    public String getapellidoP(){
        return apellidoP;
    }
    public void setapellidoM (String apellidoM){
        this.apellidoM = apellidoM;
    }
    public String getapellidoM(){
        return apellidoM;
    }
    
    public void setapodo (String apodo){
        this.apodo = apodo;
    }
    public String getapodo(){
        return apodo;
    }
    
    public void setnum_seguro (String num_seguro){
        this.num_seguro = num_seguro;
    }
    public String getnum_seguro(){
        return num_seguro;
    }
}
