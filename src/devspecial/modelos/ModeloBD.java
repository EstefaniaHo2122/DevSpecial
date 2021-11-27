/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devspecial.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 505
 */
public class ModeloBD {
    
    private String servidor="jdbc:mysql://localhost/parqueadero_devspecial";
    private String usuario="root";
    private String password="";

    public ModeloBD() {
    }
    
    public Connection conectar(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,usuario,password);
            System.out.println("Exito conectandonos");
            return conexion;
            
        }catch(Exception error){
            
            System.out.println("UPSS.. "+error);
            return null;
            
        }
    }
    
}
