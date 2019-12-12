package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloCarrera {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "admin";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloCarrera(String baseDatos){
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

    public List<Piloto> listaPilotosPorCarrera(Carrera c)
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View
        List<Piloto> pilotos = new ArrayList<Piloto>();
        String consultaSQL ="select noLicencia, nombre, apellidoP, apellidoM, apodo from scautodromo.piloto where noLicencia in (select noLicencia from scautodromo.resultados where id_carrera = ?);";
        String nuevac ="select nombre, apellidop, apellidom, apodo from piloto where noLicencia in (select noLicencia from resultados where id_carrera =65432124);";
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
            System.err.println("Error en la busqueda de ploto desde la carrera "+e);
            closeConexion();
        }
        return pilotos;
    }
}
