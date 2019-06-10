/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author mfarf
 */
public class ModeloRegistro {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "Mario12";
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
    
    public boolean insertCliente(Cliente e){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
	    String sqlInsertLibro = "insert into scautodromo.cliente values (?,?,?,?,?,?,?,?,?,?,?);";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertLibro);
            //Indicar qué información se pasa al Statement
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getCuenta());
            ps.setString(3,e.getPass());
            ps.setString(4,e.getNombre_nombre());
            ps.setString(5, e.getNombre_apellidoP());
            ps.setString(6, e.getNombre_apellidoM());
            ps.setString(7, e.getDir_cp());
            ps.setString(8, e.getDir_calle());
            ps.setString(9, e.getDir_num());
            ps.setString(10, e.getDir_colonia());
            ps.setString(11, e.getCorreo());
            
            //Ejecutar el comando insert
            ps.executeUpdate();
	return true;
        }catch (SQLException exception) {
            System.err.println("Error en la INSERCIÓN " + exception );
			return false;
        }
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
