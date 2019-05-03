
package Controlador.Login;

import Modelo.Beans.Usuarios.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OperacionesBD {
    
    public Object Login(String u, String p ){
        try {
            GestionConexion gs = new GestionConexion();
            Connection c= gs.conectar();
            Statement stm = c.createStatement();
            String query = "SELECT * FROM USUARIOS WHERE Documento='"+u+"'AND Password='"+p+"';";
            System.out.println(query);
            ResultSet rs = stm.executeQuery(query);
            if (rs.first()){
                Usuarios user = new Usuarios();
                user.setDocumento(u);
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("Password"));
                user.setRol(rs.getString("rol"));
                return user;                   
            }else{
                return null;
            }            
            
        } catch (SQLException ex) {
            
        }
        return null;
        
    }
    
    
   
}
/**
 * CREATE TABLE USUARIOS(
    Documento VARCHAR(25)NOT NULL PRIMARY KEY,
    Nombre VARCHAR(45),
    Password VARCHAR(20),
    Rol VARCHAR(20),
    Habilitado boolean default true
);

 */