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
public class Cliente {
        private String username;
        private String pass;
        private String cuenta;
        private String telefono;
        private String correo;
        private String dir_colonia;
        private String dir_calle;
        private String dir_num;
        private String dir_cp;
        private String nombre_nombre;
        private String nombre_apellidoP;
        private String nombre_apellidoM;
        
        public Cliente(String username, String pass, String cuenta, String correo, String dir_colonia, 
                String dir_calle, String dir_num, String dir_cp, String nombre_nombre, String nombre_apellidoP, String nombre_apellidoM){
            this.username = username;
            this.pass = pass;
            this.cuenta = cuenta;
            this.correo = correo;
            this.dir_colonia = dir_colonia;
            this.dir_calle = dir_calle;
            this.dir_num = dir_num;
            this.dir_cp = dir_cp;
            this.nombre_nombre = nombre_nombre;
            this.nombre_apellidoP = nombre_apellidoP;
            this.nombre_apellidoM = nombre_apellidoM;
        }
        
        public Cliente(){}
        
        public void setUsername(String username){
            this.username = username ;
        }
        public String getUsername(){
            return username;
        }
        
        public void setPass(String pass){
            this.pass = pass;
        }
        public String getPass(){
            return pass;
        }
        
        public void setCuenta(String cuenta){
            this.cuenta = cuenta;
        }
        public String getCuenta(){
            return cuenta;
        }
        
        public void setTelefono(String telefono){
            this.telefono = telefono;
        }
        public String getTelefono(){
            return telefono;
        }
        
        public void setCorreo(String correo){
            this.correo = correo;
        }
        public String getCorreo(){
            return correo;
        }
        
        public void setDir_colonia(String dir_colonia){
            this.dir_colonia = dir_colonia;
        }
        public String getDir_colonia(){
            return dir_colonia;
        }
        
        public void setDir_calle(String dir_calle){
            this.dir_calle = dir_calle;
        }
        public String getDir_calle(){
            return dir_calle;
        }
        
        public void setDir_num(String dir_num){
            this.dir_num = dir_num;
        }
        public String getDir_num(){
            return dir_num;
        }
        
        public void setDir_cp(String dir_cp){
            this.dir_cp = dir_cp;
        }
        public String getDir_cp(){
            return dir_cp;
        }
        
        public void setNombre_nombre(String nombre_nombre){
            this.nombre_nombre = nombre_nombre;
        }
        public String getNombre_nombre(){
            return nombre_nombre;
        }
        
        public void setNombre_apellidoP(String nombre_apellidoP){
            this.nombre_apellidoP = nombre_apellidoP;
        }
        public String getNombre_apellidoP(){
            return nombre_apellidoP;
        }
        
        public void setNombre_apellidoM(String nombre_apellidoM){
            this.nombre_apellidoM = nombre_apellidoM;
        }
        public String getNombre_apellidoM(){
            return nombre_apellidoM;
        }
        
}
