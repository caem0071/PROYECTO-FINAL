/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import entidades.Peliculas;
import entidades.Sala;

import java.util.ArrayList;

/**
 * @category ESPOL
 * @version 8.0
 * @author Villacis, Marmolejo, Espinosa.
 */
public class Validacion {
	
	public static boolean verificarDuplicidadCodigo(ArrayList<Sala> salas,String codigo){
        
        for(int i=0;i<salas.size();i++){                        
            if(salas.get(i).getCodigo().equalsIgnoreCase(codigo))
                return true;        
        }
        return false;
    }
    
    public static int existeSala(ArrayList<Sala> salas, Sala s){
    	
    	for(int i=0;i<salas.size();i++){
            Sala s2 = salas.get(i);
            if(s.getCodigo().equals(s2.getCodigo())){                
                return i;
            }        
        }
        return -1;    
    }
    
    
    
    public static boolean verificarDuplicidadId(ArrayList<Peliculas> peliculas,String Id){
        
        for(int i=0;i<peliculas.size();i++){                        
            if(peliculas.get(i).getId().equalsIgnoreCase(Id))
                return true;        
        }
        return false;
    }
    
    
    public static int existePelicula(ArrayList<Peliculas> peliculas, Peliculas p){
    	
    	for(int i=0;i<peliculas.size();i++){
            Peliculas p2 = peliculas.get(i);
            if(p.getId().equals(p2.getId())){                
                return i;
            }        
        }
        return -1;    
    }
}
