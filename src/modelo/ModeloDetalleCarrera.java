package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloDetalleCarrera {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "admin";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloDetalleCarrera(String baseDatos){
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

    public Integer carrerasGanadas(Piloto piloto)
    {
        Integer totalCarreras =0;
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        String consultaTodoBien = "select count (posicion) as carreras_ganadas from scautodromo.resultados " +
                "where noLicencia =? and posicion = 1;";
        //String consultaTodoMal = "";
        try
        {
            ps=getConexion().prepareStatement(consultaTodoBien);
            ps.setString(1,piloto.getnum_licencia());
            rs=ps.executeQuery();
            if(rs.next())
            {
                totalCarreras = rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error al sacar el numero de carreras ganadas "+e.getStackTrace());
        }
        return totalCarreras;
    }

    public List<Integer> listaCarrerasGanadas()
    {
        List<Integer> listaDeCarrerasGanadas = new ArrayList<Integer>();
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        String consulta = "select noLicencia,count (posicion) as carreras_ganadas from scautodromo.resultados " +
                "where noLicencia in(select noLicencia from scautodromo.piloto) and posicion = 1 group by noLicencia " +
                "union " +
                "select noLicencia,'0'as carreras_ganadas from scautodromo.resultados " +
                "where noLicencia in(select noLicencia from scautodromo.piloto) and posicion != 1 group by noLicencia order by noLicencia;";
        try
        {
            ps=getConexion().prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Integer carreras=rs.getInt(2);
                listaDeCarrerasGanadas.add(carreras);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error obteniendo la lista de carreras ganadas "+e);
        }
        return listaDeCarrerasGanadas;
    }

    public Piloto selectPiloto(Piloto p)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        Piloto pilotoEncontrado = null;
        String consulta ="select noLicencia, nombre,apellidoP,apellidoM,apodo from scautodromo.piloto where apodo=?;";
        try
        {
            ps=getConexion().prepareStatement(consulta);
            ps.setString(1,p.getapodo());
            rs=ps.executeQuery();
            if(rs.next())
            {
                pilotoEncontrado = new Piloto();
                pilotoEncontrado.setnum_licencia(rs.getString("noLicencia"));
                pilotoEncontrado.setnombre(rs.getString("nombre"));
                pilotoEncontrado.setapellidoP(rs.getString("apellidoP"));
                pilotoEncontrado.setapellidoM(rs.getString("apellidoM"));
                pilotoEncontrado.setapodo(rs.getString("apodo"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error al buscar un piloto por su apodo "+e);
        }
        return pilotoEncontrado;
    }
}
