
package Controlador.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GestionConexion {
    
//variables miembro
    private String usuario;
    private String clave;
    private String url;
    private String host;
    private String db;
    private String driverClassName;
    private Connection conn = null;
    
//CONSTRUCTORES
    //Constructor que toma los datos de conexion por medio de parametros
    public GestionConexion(String usuario, String clave, String url, String driverClassName) {
        this.usuario = usuario;
        this.clave = clave;
        this.url = url;
        this.driverClassName = driverClassName;
    }

    //Constructor que crea la conexion sin parametros con unos definidos en la clase
    //(asignar los datos correspondientes)
    public GestionConexion() {
        //asignar las credenciales apropiadas
        this.db = "AplicacionPOS";
        this.host = "jdbc:mysql://localhost:3306/";
        this.usuario = "root";
        this.clave = "4N1m3l0m3j0R";
        this.url = host + db + "?user=" + usuario + "&password=" + clave;
        this.driverClassName = "com.mysql.jdbc.Driver";
    }


    //metodos para recuperar los datos de conexion
    public String getClave() {
        return clave;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public Connection getConn() {
        return conn;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    //metodos para establecer los valores de conexion
    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) throws SQLException {
        this.usuario = usuario;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

//la conexion propiamente dicha
    public Connection conectar() {
        try {
            Class.forName(this.driverClassName); //toma el driver
            
            //usa el driver para establecer una conexión (puente) con mysql, y
            //almacena dicha conexión en la variable conn
            this.conn = DriverManager.getConnection(this.url, this.usuario, this.clave);
            

        } catch (Exception err) {
            System.out.println("Error " + err.getMessage());
        }
        return conn;

    }
    //Cerrar la conexion
    
    public void cierraConexion() throws SQLException {
        this.conn.close();
    }
}


/**
  CREATE TABLE  IF NOT EXISTS Usuarios (
    Id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    Email VARCHAR (50),
    Password VARCHAR (50),
    Rol VARCHAR (20),
    Habilitado BIT,
    PRIMARY KEY (id)
    );

 */