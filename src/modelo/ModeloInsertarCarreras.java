package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ModeloInsertarCarreras {

        private String  host     = "localhost";
        private String  usuario     = "";
        private String  clave       = "";
        private int     puerto      = 5432;
        private String  servidor    = "";
        private String  baseDatos;
        private static Connection conexion  = null;

        //CONSTRUCTOR
        //Recibe el nombre de la base de datos

        public ModeloInsertarCarreras(String baseDatos){
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

    public boolean insertCarrera(Carrera e){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlInsertLibro = "insert into scautodromo.carrera values (?,?,?,?,?);";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlInsertLibro);
            //Indicar qué información se pasa al Statement
            ps.setInt(1, e.getIdcarrera());
            ps.setInt(2, e.getNoParticpantes());
            ps.setString(3,e.getFecha());
            ps.setInt(4,e.getNoVueltas());
            ps.setString(5, e.getHora());

            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException exception) {
            System.err.println("Error en la INSERCIÓN " + exception );
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
