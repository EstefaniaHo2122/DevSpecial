/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devspecial.controladores;

import devspecial.modelos.*;
import devspecial.vistas.VistaHome;
import devspecial.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefania
 */
public class ControladorIngreso implements ActionListener {

    //ATRIBUTOS
    VistaIngreso vistaingreso = new VistaIngreso();
    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();
    Usuario usuario = new Usuario();
    ModeloBD modelo = new ModeloBD();

    public ControladorIngreso(ModeloBD modelo, VistaIngreso vistaingreso,
            Parqueadero parqueadero, Vehiculo vehiculo, Usuario usuario) {

        this.parqueadero = parqueadero;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.vistaingreso = vistaingreso;
        vistaingreso.btnEnviar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsultasUsuario consultasUsuario
                = new ConsultasUsuario();

        ConsultasVehiculo consultasVehiculo
                = new ConsultasVehiculo();

        ConsultasParqueadero consultasParqueadero
                = new ConsultasParqueadero();

        //registro Vehiculo}
        vehiculo.setPlaca(vistaingreso.txtPlaca.getText());

        //registro Usuario
        usuario.setCedula(vistaingreso.txtDocumento.getText());
        usuario.setNombres(vistaingreso.txtNombre.getText());
        usuario.setTel_fijo(vistaingreso.txtTelefonoFijo.getText());
        usuario.setTel_movil(vistaingreso.txtTelefonoCelular.getText());

        parqueadero.setFecha_ingreso(vistaingreso.txtFechaIngreso.getText());
        parqueadero.setId_usuario(usuario.getCedula());
        parqueadero.setId_vehiculo(vehiculo.getPlaca());

        
        parqueadero.setHora_ingreso(vistaingreso.txtEntrada.getText());

        parqueadero.setCelda(Integer.parseInt(vistaingreso.txtNumeroCelda.getText()));
        parqueadero.setEstado(vistaingreso.slcEstado.getToolTipText());
        VistaHome home = new VistaHome();
        int cont=0;
        if (vistaingreso.txtBandera.getText().equals("0")) {
            consultasVehiculo.registrarVehiculo(vehiculo);
            if(consultasUsuario.registrarUsuario(usuario)){
                cont++;
            }else{
                if(consultasUsuario.actualizarUsuario(usuario)){
                    cont++;
                }
            }
            if(consultasParqueadero.registrarParquadero(parqueadero)){
                cont++;
            }else{
                if(consultasParqueadero.actualizarParqueadero(parqueadero.getId())){
                    cont++;
                }
            }
            if(cont==2){
                JOptionPane.showMessageDialog(null, "Exito ingresando");
            }
        }else{
            if (consultasParqueadero.actualizarParqueadero(parqueadero.getId())) {
                JOptionPane.showMessageDialog(null, "Exito ingresando");
            } else {
                JOptionPane.showMessageDialog(null, "Error ingresando");
            }
        }
        vistaingreso.setVisible(false);
        home.setVisible(true);
        ControladorHome controlador = new ControladorHome(modelo,home, parqueadero, usuario, vehiculo);
    }

}
