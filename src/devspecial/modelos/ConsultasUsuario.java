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
public class ConsultasUsuario extends ModeloBD {

    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;

    public boolean registrarUsuario(Usuario usuario) {

        Connection conexion = conectar();
        String query = "INSERT INTO usuario(cedula,nombres,tel_fijo,tel_movil)"
                + "VALUES (?,?,?,?)";

        try {
            //Peparate que voy con toa
            consultaSQL = conexion.prepareStatement(query);

            //Ajusto la consulta
            consultaSQL.setString(1, usuario.getCedula());
            consultaSQL.setString(2, usuario.getNombres());
            consultaSQL.setString(3, usuario.getTel_fijo());
            consultaSQL.setString(4, usuario.getTel_movil());

            System.out.println(consultaSQL);

            //Ejecuto la consulta
            int resultado = consultaSQL.executeUpdate();

            //validando el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception error) {
            System.out.println("upsss... " + error);
            return false;
        }

    }

    public Usuario buscarUsuario(String id) {

        Connection conexion = conectar();
        String query = "SELECT * FROM usuario WHERE cedula = ?";

        try {

            //Peparate que voy con toa
            consultaSQL = conexion.prepareStatement(query);
            
            

            //Ajusto la consulta
            consultaSQL.setString(1, id);
            System.out.println(consultaSQL);
            //Ejecuto la consulta
            resultadoSQL = consultaSQL.executeQuery();

            //Orgaizo el resultado
            Usuario usuario = new Usuario();
            if (resultadoSQL.next()) {

                usuario.setNombres(resultadoSQL.getString("nombres"));
                usuario.setTel_fijo(resultadoSQL.getString("tel_fijo"));
                usuario.setTel_movil(resultadoSQL.getString("tel_movil"));
                return usuario;

            } else {
                return null;
            }

        } catch (Exception error) {
            System.out.println("upsss... " + error);
            return null;
        }

    }
    
    public boolean actualizarUsuario(Usuario usuario){
        Connection conexion=conectar();
        String query="UPDATE usuario SET tel_movil=?,tel_fijo=? WHERE cedula=?";
        try{
            //Ajusto la consulta
           
            consultaSQL=conexion.prepareStatement(query);
            
             consultaSQL.setString(1,usuario.getTel_movil());
             consultaSQL.setString(2, usuario.getTel_fijo());
             consultaSQL.setString(3, usuario.getCedula());
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

}
