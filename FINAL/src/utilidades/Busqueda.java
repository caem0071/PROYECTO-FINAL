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
public class Busqueda {
    
    public static int buscarSalaPorCodigo(ArrayList<Sala> salas,String codigo){
        for(int i=0;i<salas.size();i++){                        
            if(salas.get(i).getCodigo().equalsIgnoreCase(codigo))
                return i;        
        }
        return -1;    
    }
    
    public static int buscarPeliculaPorId(ArrayList<Peliculas> peliculas,String codigo){
        for(int i=0;i<peliculas.size();i++){                        
            if(peliculas.get(i).getId().equalsIgnoreCase(codigo))
                return i;        
        }
        return -1;    
    }
    
    
}