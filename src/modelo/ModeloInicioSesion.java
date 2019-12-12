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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author mfarf
 */
public class ModeloInicioSesion {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "admin";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;
 
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
	
    public ModeloInicioSesion(String baseDatos){
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
    
    public ArrayList<Cliente> login(String usuario, String pass){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View

        //Cargar datos de todos los estudiantes
        String consultaSQL = "select * from scautodromo.cliente where nombre_usuario=? and contrasenia=?;";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                Cliente p = new Cliente();
                p.setUsername(rs.getString("nombre_usuario"));
                p.setPass(rs.getString("contrasenia"));
                p.setCuenta(rs.getString("cuenta_bancaria"));
                p.setCorreo(rs.getString("correo_elec"));
                p.setDir_colonia(rs.getString("dir_colonia"));
                p.setDir_calle(rs.getString("dir_calle"));
                p.setDir_num(rs.getString("dir_numero"));
                p.setDir_cp(rs.getString("dir_cp"));
                p.setNombre_nombre(rs.getString("nombre"));
                p.setNombre_apellidoP(rs.getString("apellidop"));
                p.setNombre_apellidoM(rs.getString("apellidom"));
                clientes.add(p);
            }
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Usuario o Contraseña invalidos"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
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
