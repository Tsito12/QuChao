package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloHistorialPiloto {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "0987654321";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloHistorialPiloto(String baseDatos){
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
    public List<Carrera> listCarreras(Piloto p)
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View

        String noLicencia = p.getnum_licencia();
        //Cargar datos de todos las carreras
        String consultaSQL = "select id_carrera, noVueltas, noParticipantes, fecha, hora from scautodromo.carrera natural join scautodromo.resultados" +
                             " where  noLicencia ='"+noLicencia+"' and posicion is not null order by id_carrera;";
        List<Carrera> listaDeCarreras= new ArrayList<>();

        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            //ps.setString(1,p.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                Carrera carrera = new Carrera();
                carrera.setIdcarrera(rs.getInt("id_carrera"));
                carrera.setNoVueltas(rs.getInt("noVueltas"));
                carrera.setNoParticpantes(rs.getInt("noParticipantes"));
                carrera.setFecha(rs.getString("fecha"));
                carrera.setHora(rs.getString("hora"));
                listaDeCarreras.add(carrera);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en la busqueda de Carreras en las que ha participado un piloto "+e);
            closeConexion();
        }
        return listaDeCarreras;
    }

    public List<Integer> posiciones(Piloto p)
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View

        String noLicencia = p.getnum_licencia();
        //Cargar datos de todos las carreras
        String consultaSQL = "select id_carrera, posicion from scautodromo.resultados where noLicencia = '"+noLicencia+"' order by id_carrera;";
        List<Integer> listaPosiciones= new ArrayList<>();

        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            //ps.setString(1,p.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                if (rs.getInt("posicion")!=0) {
                    Integer posicion = rs.getInt("posicion");
                    listaPosiciones.add(posicion);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en la busqueda de posiciones en las que quedado un piloto "+e);
            closeConexion();
        }
        return listaPosiciones;
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

    public List<String> listaDeApodos(Carrera c)
    {
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View


        //Cargar datos de todos las carreras
        String consultaSQL = "select apodo from scautodromo.piloto natural join scautodromo.resultados where id_carrera=?;";
        List<String> apodos = new ArrayList<>();
        try
        {
            ps=getConexion().prepareStatement(consultaSQL);
            ps.setInt(1,c.getIdcarrera());
            rs = ps.executeQuery();
            while (rs.next())
            {
                String apodo = rs.getString("apodo");
                apodos.add(apodo);
            }
        }
        catch (SQLException e )
        {
            System.err.println("Error en la busqueda de apodos "+e);
        }
        return apodos;

    }
}
