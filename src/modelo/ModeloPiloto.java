/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author mfarf
 */
public class ModeloPiloto {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "0987654321";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;
    
    public ModeloPiloto(String baseDatos){
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
    
    public Piloto selectPiloto(Piloto p){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        Piloto pilotoEncontrado = null;

        String consulta ="select nombre, apellidoP, apellidoM, apodo from scautodromo.piloto where noLicencia = ?;";
        try
        {
            ps = getConexion().prepareStatement(consulta);
            ps.setString(1,p.getnum_licencia());
            rs = ps.executeQuery();
            if(rs.next())
            {
                pilotoEncontrado = new Piloto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
        }catch (SQLException ex)
        {
            System.err.println("Error en la consulta"+ ex.getStackTrace());
        }
        return pilotoEncontrado;
    }
    

    public List<Piloto> listarPilotos(){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View

        //Cargar datos de todos los estudiantes
        String consultaSQL = "select noLicencia, nombre, apellidoP, apellidoM, apodo from scautodromo.piloto;";
        List<Piloto> pilotos = new ArrayList<Piloto>();
        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);

            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                Piloto p = new Piloto();
                p.setnum_licencia(rs.getString("noLicencia"));
                p.setnombre(rs.getString("nombre"));
                p.setapellidoP(rs.getString("apellidoP"));
                p.setapellidoM(rs.getString("apellidoM"));
                p.setapodo(rs.getString("apodo"));
                pilotos.add(p);
            }
        }catch (SQLException e)
        {
            System.err.println("Error mostrando todas las carreras");
        }
        return pilotos;
    }

    public List<Piloto> listaPilotosPorCarrera(Piloto c){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View
        List<Piloto> pilotos = new ArrayList<Piloto>();
        String consultaSQL ="select nombre, apellidoP, apellidoM, apodo from scautodromo.piloto where noLicencia in (select noLicencia from resultados where id_carrera = ?;";
        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            ps.setString(1,c.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                Piloto piloto = new Piloto();
                piloto.setnum_licencia(rs.getString("noLicencia"));
                piloto.setnombre(rs.getString("nombre"));
                piloto.setapellidoP(rs.getString("apellidoP"));
                piloto.setapellidoM(rs.getString("apellidoM"));
                piloto.setapodo(rs.getString("apodo"));
                pilotos.add(piloto);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en la busqueda de ploto desde la carrera "+e.getStackTrace());
        }
        return pilotos;
    }

    public void insertarPiloto(Piloto piloto)
    {
        PreparedStatement ps;
        String numLicencia = piloto.getnum_licencia();
        String nombre = piloto.getnombre();
        String apellido1 = piloto.getapellidoP();
        String apellido2 = piloto.getapellidoM();
        String apodo = piloto.getapodo();
        String sqlInsertApuesta = "insert into scautodromo.piloto values("+numLicencia+",'"+nombre+"','"
                +apellido1+"','"+apellido2+"','"+apodo+"');";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertApuesta);
            //Ejecutar el comando insert
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error en la insersion de un piloto "+e);
        }
    }
}
