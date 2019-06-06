/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mfarf
 */
public class ModeloRegistro {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "0987654321";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;
 
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
	
    public ModeloRegistro(String baseDatos){
	this.baseDatos = baseDatos;
        ConexionBd();
    }
    protected void ConexionBd(){
        this.servidor="jdbc:postgresql://"+host+":"+ puerto+"/"+baseDatos;
 
        //Registrar el driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        }
 
        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                        this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
 
    //Devuelve el objeto Connection que se usará en la clase Controller
    private Connection getConexion() {
        return conexion;
    }
    
    public void closeConexion(){
	if ( getConexion() != null){
            try {
		getConexion().close();
            } catch(SQLException e){
		System.err.println("Error al cerrar la bd "+ e);
            }
	}
    }
}
