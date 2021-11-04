
package devspecial;

import devspecial.controladores.Controlador;
import devspecial.modelos.ModeloBD;
import devspecial.vistas.Vista;



public class DevSpecial {

    
    public static void main(String[] args) {
        ModeloBD modelo = new ModeloBD();
        Vista vista = new Vista();
        vista.setVisible(true);
        Controlador controlador = new Controlador(modelo, vista);
        
        
      
    }
    
}
