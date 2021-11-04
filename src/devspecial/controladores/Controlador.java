
package devspecial.controladores;

import devspecial.modelos.ModeloBD;
import devspecial.vistas.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
    
    ModeloBD modelo = new ModeloBD();
    Vista vista = new Vista();
    
    public Controlador (ModeloBD modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnIngreso.addActionListener(this);
        vista.btnAdministrar.addActionListener(this);
        vista.btnRetirar.addActionListener(this);
        vista.btnCerrar.addActionListener(this);
           
    }
    public void actionPerformed(ActionEvent ae){
        modelo.conectar();
    }
    
    
    
}
