package general;

import javax.swing.JOptionPane;
import archivos.Archivo;
import formularios.FrmPrincipal;
/**
 *
 * @author CAEM
 */
public class Principal {
    
     public static void main(String args[]){
        if(!Archivo.crear()){
            JOptionPane.showMessageDialog(null, "Error al crear el archivo",                                            
                                            "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }        
        
        Ventana1 login = new Ventana1();
        login.setVisible(true);
        
        
    }    
}
