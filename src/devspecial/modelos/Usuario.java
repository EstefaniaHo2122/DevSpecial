/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devspecial.modelos;

/**
 *
 * @author Stefania
 */
public class Usuario {
    
    private String cedula;
    private String nombres;
  //  private String apellidos;
    private String tel_fijo;
    private String tel_movil;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }

    public String getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(String tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public String getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }
    
    
    
}
