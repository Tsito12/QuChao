package modelo;

import vista.VistaAgregarPilotos;

import javax.swing.*;
import java.sql.*;

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
            rs = ps.executeQuery()
            pilotos.addItem("Escoja un piloto");
            while (rs.next()){
                pilotos.addItem(rs.getString("apodo"));
            }
        }catch (SQLException exception) {
            System.err.println("Error al agregar piloto " + exception );
        }

    }
    public boolean insertPiloto(String v){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String licencia;

        String sqlInsertCarrera = "select nolicencia piloto where apodo = '"+v+"';";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertCarrera);
            //Ejecutar el comando insert
            ResultSet resultado = ps.executeQuery();
            String r = resultado.getString("nolicencia");
            ps  = getConexion().prepareStatement("insert into scautodromo.resultados(id_carrera, nolicencia) values (,"+r+");");
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
