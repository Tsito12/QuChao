package modelo;

import vista.VistaAgregarPilotos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloAgregarPilotos {
    private String  host     = "localhost";
    private String  usuario     = "";
    private String  clave       = "";
    private int     puerto      = 5432;
    private String  servidor    = "";
    private String  baseDatos;
    private static Connection conexion  = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos

    public ModeloAgregarPilotos(String baseDatos){
        this.baseDatos = baseDatos;
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

    public void login(String usuario, String clave){
        this.usuario=usuario;
        this.clave=clave;
        ConexionBd();
    }

    public void llenarpilotos(JComboBox pilotos){
        PreparedStatement ps;
        ResultSet rs;
        String consulta = "Select apodo from scautodromo.piloto;";
        try{
            ps  = getConexion().prepareStatement(consulta);
            rs = ps.executeQuery();
            pilotos.addItem("Escoja un piloto");
            while (rs.next()){
                pilotos.addItem(rs.getString("apodo"));
            }
        }catch (SQLException exception) {
            System.err.println("Error al agregar piloto " + exception );
        }

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



    public boolean insertPiloto(String v, int id_carrera){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String licencia;
        ResultSet resultado;
        String sqlInsertCarrera = "insert into scautodromo.resultados (id_carrera,nolicencia) values ("+id_carrera+",(select noLicencia from scautodromo.piloto where apodo = '"+v+"'));";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertCarrera);
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException exception) {
            System.err.println("Error al agregar piloto " + exception );
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
