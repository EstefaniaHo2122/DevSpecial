/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devspecial.controladores;

import devspecial.modelos.ConsultasParqueadero;
import devspecial.modelos.ConsultasUsuario;
import devspecial.modelos.ModeloBD;
import devspecial.modelos.Parqueadero;
import devspecial.modelos.Usuario;
import devspecial.modelos.Vehiculo;
import devspecial.vistas.VistaHome;
import devspecial.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author Stefania
 */
public class ControladorHome implements ActionListener {

    //ATRIBUTOS
    VistaHome vistaHome = new VistaHome();
    Parqueadero parqueadero = new Parqueadero();
    Usuario usuario = new Usuario();
    Vehiculo vehiculo = new Vehiculo();
    
    public ControladorHome(ModeloBD modelo, VistaHome vistaHome,
            Parqueadero parqueadero, Usuario usuario, Vehiculo vehiculo) {
        
        this.parqueadero = parqueadero;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.vistaHome = vistaHome;
        vistaHome.btnEnviar.addActionListener(this);
        //ControladorIngreso ingreso = new ControladorIngreso(vista, parqueadero, vehiculo, usuario);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasParqueadero consultasParqueadero = new ConsultasParqueadero();
        ConsultasUsuario consultasUsuario = new ConsultasUsuario();
        
        if (consultasParqueadero.buscarParqueadero(vistaHome.txtPlaca.getText()) != null) {
           
            Parqueadero parqueaderoConsulta=consultasParqueadero.buscarParqueadero(vistaHome.txtPlaca.getText());
            Usuario usuarioConsulta = new Usuario();
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistaIngreso.txtBandera.setVisible(false);
            vistaIngreso.txtBandera.setText("1");
            
            vistaHome.setVisible(false);
            vistaIngreso.setVisible(true);
            
            ModeloBD modelo = new ModeloBD();
            vehiculo.setPlaca(vistaHome.txtPlaca.getText());
            
            vistaIngreso.txtDocumento.setText(parqueaderoConsulta.getId_usuario());
            String[] fecha= parqueaderoConsulta.getFecha_ingreso().split(" ");
            vistaIngreso.txtFechaIngreso.setText(fecha[0]);
            vistaIngreso.txtEntrada.setText(parqueaderoConsulta.getHora_ingreso());
            vistaIngreso.txtNumeroCelda.setText(parqueaderoConsulta.getCelda()+"");
            
            vistaIngreso.txtDocumento.setEditable(false);
            vistaIngreso.txtFechaIngreso.setEditable(false);
            vistaIngreso.txtEntrada.setEditable(false);
            vistaIngreso.txtNumeroCelda.setEditable(false);
            
            if(consultasUsuario.buscarUsuario(parqueaderoConsulta.getId_usuario())!=null){
                usuarioConsulta=consultasUsuario.buscarUsuario(parqueaderoConsulta.getId_usuario());
                vistaIngreso.txtNombre.setText(usuarioConsulta.getNombres());
                vistaIngreso.txtTelefonoFijo.setText(usuarioConsulta.getTel_fijo());
                vistaIngreso.txtTelefonoCelular.setText(usuarioConsulta.getTel_movil());
                vistaIngreso.txtNombre.setEditable(false);
                vistaIngreso.txtTelefonoFijo.setEditable(false);
                vistaIngreso.txtTelefonoCelular.setEditable(false);
            }                        
            
            vistaIngreso.txtDocumento.setEditable(false);
            vistaIngreso.txtPlaca.setText(vehiculo.getPlaca());
            vistaIngreso.txtPlaca.setEditable(false);
            
            Date salida = new Date();
            SimpleDateFormat formato2 = new SimpleDateFormat("HH:mm:ss");
            String hora = formato2.format(salida);
            parqueadero.setHora_ingreso(hora);
            
            vistaIngreso.txtSalida.setText(hora);
            vistaIngreso.txtSalida.setEditable(false);

            LocalTime hora_1 = LocalTime.parse(vistaIngreso.txtEntrada.getText());
            LocalTime hora_2 = LocalTime.parse(hora);

            long diff = ChronoUnit.MINUTES.between(hora_1, hora_2);
            
            vistaIngreso.txtEstadia.setText(diff+"");
            vistaIngreso.txtTotalPagar.setText((diff*150)+"");
            vistaIngreso.slcEstado.setToolTipText("Retirado");
            ControladorIngreso controladorIngreso
                    = new ControladorIngreso(modelo, vistaIngreso, parqueaderoConsulta, vehiculo, usuarioConsulta);
            vistaIngreso.txtPlaca.setText(vehiculo.getPlaca());
            
            
            
            
            
        } else {
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistaHome.setVisible(false);
            vistaIngreso.txtBandera.setVisible(false);
            vistaIngreso.txtSalida.setEnabled(false);
            vistaIngreso.txtEntrada.setEnabled(false);
            vistaIngreso.txtFechaIngreso.setEnabled(false);
            vistaIngreso.slcEstado.setEnabled(false);
            vistaIngreso.txtEstadia.setEnabled(false);
            vistaIngreso.txtTotalPagar.setEnabled(false);
            vistaIngreso.txtBandera.setText("0");
            
            vistaIngreso.setVisible(true);
            ModeloBD modelo = new ModeloBD();
             Date entrada = new Date();
             
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaEntrada = formato.format(entrada);
            parqueadero.setFecha_ingreso(fechaEntrada);
            SimpleDateFormat formato2 = new SimpleDateFormat("HH:mm:ss");
            String hora = formato2.format(entrada);
            parqueadero.setHora_ingreso(hora);
            vehiculo.setPlaca(vistaHome.txtPlaca.getText());
            
            vistaIngreso.txtFechaIngreso.setText(parqueadero.getFecha_ingreso());
            vistaIngreso.txtEntrada.setText(parqueadero.getHora_ingreso());
            vistaIngreso.txtPlaca.setText(vehiculo.getPlaca());
            
            ControladorIngreso controladorIngreso
                    = new ControladorIngreso(modelo, vistaIngreso, parqueadero, vehiculo, usuario);
        }
        
    }
    
}
