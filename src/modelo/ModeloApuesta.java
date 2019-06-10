package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ModeloApuesta {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "0987654321";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloApuesta(String baseDatos){
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

    public void insertarApuesta(Cliente cliente, Carrera carrera, Piloto piloto, int monto, int importe)
    {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        Calendar c = Calendar.getInstance();
        int fechaDia = c.get(Calendar.DATE);
        int fechaMes = c.get(Calendar.MONTH);
        int fechaAnio = c.get(Calendar.YEAR);
        String fechaActual = fechaAnio+"-"+fechaMes+"-"+fechaDia;
        String nombreUsuario = cliente.getUsername();
        int idCarrera = carrera.getIdcarrera();
        String noLicencia = piloto.getnum_licencia();
        String sqlInsertApuesta = "insert into scautodromo.apuesta values('"+nombreUsuario+"',"+idCarrera+","
                +noLicencia+","+monto+",'"+fechaActual+"',"+importe+");";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertApuesta);
            //Ejecutar el comando insert
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error en la insersion de la apuesta "+e);
        }
    }
}
