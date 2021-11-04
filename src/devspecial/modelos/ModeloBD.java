
package devspecial.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModeloBD {
    
    //Ruta del la BD
    private String servidorBD="jdbc:mysql://localhost/parqueadero_devspecial";
    private String usuarioBD="root";
    private String passwordBD="";
    
    public ModeloBD(){
        
    }
    public Connection conectar(){
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidorBD, usuarioBD, passwordBD);
            System.out.println("Coneccion realizada");
            return conexion;
            
        }catch(Exception error){
            System.out.println("Fallo en coneccion"+error);
            return null;
            
        }
    }
    
    
}
