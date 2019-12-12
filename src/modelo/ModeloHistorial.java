package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloHistorial {

    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "admin";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloHistorial(String baseDatos){
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

    public List<Integer> carreras(Cliente cliente)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        String usuario = cliente.getUsername();
        String consultaSQL ="select * from scautodromo.historial_apuestas('"+usuario+"');";
        List<Integer> lista = new ArrayList<>();

        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            //ps.setString(1,p.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                    Integer carrera = rs.getInt("carr");
                    lista.add(carrera);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en carreras "+e);
            closeConexion();
        }
        return lista;
    }

    public List<String> apodos(Cliente cliente)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        String resltado = null;
        String usuario = cliente.getUsername();
        String consultaSQL ="select * from scautodromo.historial_apuestas('"+usuario+"');";
        //select * from historial_apuestas('Xicoten');
        List<String> lista = new ArrayList<>();

        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            //ps.setString(1,p.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                resltado = rs.getString("ap_piloto");
                lista.add(resltado);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en la busqueda de posiciones en las que quedado un piloto "+e);
            closeConexion();
        }
        return lista;
    }

    public List<Integer> cantidad(Cliente cliente)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        Integer resltado = null;
        String usuario = cliente.getUsername();
        String consultaSQL ="select * from scautodromo.historial_apuestas('"+usuario+"');";
        List<Integer> lista = new ArrayList<>();

        try {
            //Preparar la llamada
            ps  = getConexion().prepareStatement(consultaSQL);
            //ps.setString(1,p.getnum_licencia());
            //Ejecutarla y recoger el resultado
            rs  = ps.executeQuery();

            //Recorrer el resultado
            while(rs.next())
            {
                resltado = rs.getInt("cantidad");
                lista.add(resltado);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en la busqueda de posiciones en las que quedado un piloto "+e);
            closeConexion();
        }
        return lista;
    }

    public String resultados(String usuario, String piloto, int carrera)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        String resltado = null;
        String consulta ="select * from scautodromo.ganador('"+usuario+"','"+piloto+"',"+carrera+");";
        try
        {
            ps = getConexion().prepareStatement(consulta);
            rs = ps.executeQuery();
            if(rs.next())
            {
                resltado = rs.getString(1);
            }
        }catch (SQLException ex)
        {
            System.err.println("Error en la consulta"+ ex.getStackTrace());
        }
        return resltado;
    }
}
