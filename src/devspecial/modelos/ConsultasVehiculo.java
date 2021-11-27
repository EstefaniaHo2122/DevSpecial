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
public class ConsultasVehiculo extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo(Vehiculo vehiculo){
        
        Connection conexion=conectar();
        String query="INSERT INTO vehiculo(placa,status)"
                + "VALUES (?,?)";
        
        try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,vehiculo.getPlaca());
            consultaSQL.setString(2,"1");
            
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
    
//    public Vehiculo buscarPiloto(int id){
//       
//        Connection conexion=conectar();
//        String query="SELECT * from vehiculo where id=?";
//        
//        try{
//            
//            //Peparate que voy con toa
//            consultaSQL=conexion.prepareStatement(query);
//            
//            //Ajusto la consulta
//            consultaSQL.setInt(1, id);
//            
//            //Ejecuto la consulta
//            resultadoSQL=consultaSQL.executeQuery();
//            
//            //Orgaizo el resultado
//            Piloto piloto= new Piloto();
//            if(resultadoSQL.next()){
//                
//                piloto.setId(resultadoSQL.getInt("id"));
//                piloto.setNombres(resultadoSQL.getString("nombres"));
//                piloto.setApellidos(resultadoSQL.getString("apellidos"));
//                piloto.setSalario(resultadoSQL.getInt("salario"));
//                piloto.setFechaIn(resultadoSQL.getString("fecha_inicio"));
//                piloto.setFechaOut(resultadoSQL.getString("fecha_salida"));
//                piloto.setIdEscuderia(resultadoSQL.getString("id_escuderia"));
//                
//                return piloto;
//                
//                
//            }else{
//                return null;
//            }
//            
//         
//            
//        }catch(Exception error){
//            System.out.println("upsss... "+error);
//            return null;
//        }      
//   } 
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
