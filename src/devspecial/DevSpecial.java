
package devspecial;

import devspecial.controladores.*;
import devspecial.modelos.ModeloBD;
import devspecial.modelos.Parqueadero;
import devspecial.modelos.Usuario;
import devspecial.modelos.Vehiculo;
import devspecial.vistas.*;



public class DevSpecial {

    
    public static void main(String[] args) {
        ModeloBD modelo = new ModeloBD();
        //VistaIngreso vista = new VistaIngreso();
        VistaHome vista = new VistaHome();
        vista.setVisible(true);
        Parqueadero parqueadero  = new Parqueadero();
        Vehiculo vehiculo = new Vehiculo();
        Usuario usuario = new Usuario();
        ControladorHome controlador = new ControladorHome(modelo,vista , parqueadero, usuario,vehiculo);
        //ControladorIngreso ingreso = new ControladorIngreso(vista, parqueadero, vehiculo, usuario);
        
        
      
    }
    
}
