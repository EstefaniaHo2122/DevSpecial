/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devspecial.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 505
 */
public class ConsultasParqueadero extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean actualizarParqueadero(int id){
        System.out.println(id+"--->");
        Connection conexion=conectar();
        String query="UPDATE parqueadero SET estado='Retirado'  WHERE id=?";
        try{
            //Ajusto la consulta
           
            consultaSQL=conexion.prepareStatement(query);
            
             consultaSQL.setString(1,id+"");
            //Ejecuto la consulta
            int resultado=consultaSQL.executeUpdate();
            
            //validando el resultado
            if(resultado>0){
              return true;  
            }else{
               return false; 
            }
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;
        }
    }
    
    public boolean registrarParquadero(Parqueadero parqueadero){
        
        Connection conexion=conectar();
        String query="INSERT INTO parqueadero( id_vehiculo, id_usuario, fecha_ingreso, hora_ingreso, celda, estado)"
                + "VALUES (?,?,?,?,?,?)";
        
        try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,parqueadero.getId_vehiculo());
            consultaSQL.setString(2,parqueadero.getId_usuario());
            consultaSQL.setString(3,parqueadero.getFecha_ingreso());
            consultaSQL.setString(4,parqueadero.getHora_ingreso());
            consultaSQL.setInt(5,parqueadero.getCelda());
            consultaSQL.setString(6,"Ingresado");
                 
            
            //Ejecuto la consulta
            int resultado=consultaSQL.executeUpdate();
            
            //validando el resultado
            if(resultado>0){
              return true;  
            }else{
               return false; 
            }
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;
        }
        
    }
    
    public Parqueadero buscarParqueadero(String id){
       
        Connection conexion=conectar();
        String query="SELECT * from parqueadero where id_vehiculo =? and estado='Ingresado' ";
        
        try{
            
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1, id);
            
            //Ejecuto la consulta
            resultadoSQL=consultaSQL.executeQuery();
            
            //Orgaizo el resultado
            Parqueadero parqueadero= new Parqueadero();
            if(resultadoSQL.next()){
                parqueadero.setId(resultadoSQL.getInt("id"));
                parqueadero.setId_vehiculo(resultadoSQL.getString("id_vehiculo"));
                parqueadero.setId_usuario(resultadoSQL.getString("id_usuario"));
                parqueadero.setFecha_ingreso(resultadoSQL.getString("fecha_ingreso"));
                parqueadero.setHora_ingreso(resultadoSQL.getString("hora_ingreso"));
                parqueadero.setEstado(resultadoSQL.getString("estado"));
                
                return parqueadero;
                
                
            }else{
                return null;
            }
            
         
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }      
   } 
//    
//   public boolean actualizarPiloto(Piloto piloto){
//       Connection conexion=conectarBD();
//       String query="UPDATE pilotos SET fecha_salida=? WHERE id=?";
//       
//       try{
//            //Peparate que voy con toa
//            consultaSQL=conexion.prepareStatement(query);
//            
//            //Ajusto la consulta
//            consultaSQL.setString(1,piloto.getFechaOut());
//            consultaSQL.setInt(2,piloto.getId());           
//            
//            //Ejecuto la consulta
//            int resultado=consultaSQL.executeUpdate();
//            
//            //validando el resultado
//            if(resultado>0){
//              return true;  
//            }else{
//               return false; 
//            }
//            
//        }catch(Exception error){
//            System.out.println("upsss... "+error);
//            return false;
//        }
//   }
//    
}
