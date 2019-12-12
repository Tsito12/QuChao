package modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
public class ModeloProximasCarreras {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "admin";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloProximasCarreras(String baseDatos){
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

    public Carrera selectCarrera(Carrera c)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        Carrera carreraEncontrada = null;
        String fechac = c.getFecha();
        String horac = c.getHora();
        String consulta ="select id_carrera, noParticipantes, fecha, noVueltas, hora from scautodromo.carrera where fecha ='"+fechac+"' and hora='"+horac+"';";
        try
        {
            ps = getConexion().prepareStatement(consulta);
            rs = ps.executeQuery();
            if(rs.next())
            {
                carreraEncontrada = new Carrera(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
            }
        }catch (SQLException ex)
        {
            System.err.println("Error en la consulta"+ ex.getStackTrace());
        }
        return carreraEncontrada;
    }

    public List<Carrera> listarCarreras()
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View


        //Cargar datos de todos las carreras
        String consultaSQL = "select id_carrera,noParticipantes,fecha,noVueltas,hora from scautodromo.carrera where id_carrera in (select id_carrera from scautodromo.resultados where posicion is null);";
        List<Carrera> carreras = new ArrayList<Carrera>();
        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);

            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                Carrera carrera = new Carrera();
                carrera.setIdcarrera(rs.getInt("id_carrera"));
                carrera.setNoParticpantes(rs.getInt("noParticipantes"));
                carrera.setFecha(rs.getString("fecha"));
                carrera.setNoVueltas(rs.getInt("noVueltas"));
                carrera.setHora(rs.getString("hora"));
                carreras.add(carrera);
            }
        }catch (SQLException e)
        {
            System.err.println("Error mostrando todas las carreras"+e);
        }
        return carreras;
    }

    public List<Piloto> listaPilotosPorCarrera(Carrera c)
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View
        List<Piloto> pilotos = new ArrayList<Piloto>();
        String consultaSQL ="select nombre, apellidop, apellidom, apodo from scautodromo.piloto where noLicencia in (select noLicencia from resultados where id_carrera = ?;";
        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            ps.setInt(1,c.getIdcarrera());
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
}
