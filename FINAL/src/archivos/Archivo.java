/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Peliculas;
import entidades.Sala;
import java.io.IOException;
import java.util.ArrayList;
import utilidades.Validacion;

/**
 * @category ESPOL
 * @version 8.0
 * @author Villacis, Marmolejo, Espinosa.
 */

public class Archivo{
    private static final String RUTA_ARCHIVO = "salas.txt";
    private static final String RUTA_ARCHIVO2 = "peliculas.txt";
    
    public static boolean crear(){
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static boolean borrar_contenido(){
        try{
            EscribirArchivo archivo = new EscribirArchivo();
            archivo.borrar_contenido(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static ArrayList<Sala> obtener_registros()throws Exception{
        ArrayList<Sala> salas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO);
            salas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return salas;        
    }
    
    public static boolean insertar_registro(Sala s){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RUTA_ARCHIVO);
            archivo.insertar_objeto(s);
            archivo.cerrar(); 
        }catch(Exception e){
            return false;
        }                          
        return true;
    }
    
    public static boolean actualizar_registro(Sala s){
         ArrayList<Sala> salas = null;
         try{
            salas = Archivo.obtener_registros();
            int indice = Validacion.existeSala(salas,s);
            salas.set(indice, s);
         }catch(Exception e){
             return false;
         }
         return Archivo.actualizar_registros(salas);         
    }
    
    public static boolean actualizar_registros(ArrayList salas){
        borrar_contenido();
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            for(int i=0;i<salas.size();i++)
                archivo.insertar_objeto(salas.get(i));
            archivo.cerrar();
        }catch(Exception e){
            return false;
        }                 
        return true;
    }
    
    public static boolean actualizarDatosSala(Sala s){        
        ArrayList<Sala> registros = null;
        
        try{
            registros = Archivo.obtener_registros();
            for(int i=0;i<registros.size();i++){
                Sala tmp = registros.get(i); 
                if(tmp.getCodigo().equals(s.getCodigo())){                
                    s.setCodigo(tmp.getCodigo());
                    s.setNombre(tmp.getNombre());
                    s.setTipo(tmp.getTipo());
                    s.setCapacidad(tmp.getCapacidad());
                    return true;
                }
            }
        }catch(Exception e){
            return false;
        }    
        return false;
    }
    
    
    
    
    
    
    
    
    public static boolean crear2(){
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO2);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static boolean borrar_contenido2(){
        try{
            EscribirArchivo archivo = new EscribirArchivo();
            archivo.borrar_contenido(RUTA_ARCHIVO2);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static ArrayList<Peliculas> obtener_registros2()throws Exception{
        ArrayList<Peliculas> peliculas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO2);
            peliculas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return peliculas;        
    }
    
    public static boolean insertar_registro2(Peliculas p){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RUTA_ARCHIVO2);
            archivo.insertar_objeto(p);
            archivo.cerrar(); 
        }catch(Exception e){
            return false;
        }                          
        return true;
    }
    
    public static boolean actualizar_registro2(Peliculas p){
         ArrayList<Peliculas> peliculas = null;
         try{
            peliculas = Archivo.obtener_registros2();
            int indice = Validacion.existePelicula(peliculas,p);
            peliculas.set(indice, p);
         }catch(Exception e){
             return false;
         }
         return Archivo.actualizar_registros2(peliculas);         
    }
    
    public static boolean actualizar_registros2(ArrayList peliculas){
        borrar_contenido2();
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO2);
            for(int i=0;i<peliculas.size();i++)
                archivo.insertar_objeto(peliculas.get(i));
            archivo.cerrar();
        }catch(Exception e){
            return false;
        }                 
        return true;
    }
    
    public static boolean actualizarDatosPelicula(Peliculas p){        
        ArrayList<Peliculas> registros = null;
        
        try{
            registros = Archivo.obtener_registros2();
            for(int i=0;i<registros.size();i++){
                Peliculas tmp = registros.get(i); 
                if(tmp.getId().equals(p.getId())){                
                    p.setTitulo(tmp.getTitulo());
                    p.setClasificacion(tmp.getClasificacion());
                    p.setGenero(tmp.getGenero());
                    p.setIdioma(tmp.getIdioma());
                    p.setActor(tmp.getActor());
                    p.setDirector(tmp.getDirector());
                    p.setSinopsis(tmp.getSinopsis());
                    p.setAño(tmp.getAño());
                    p.setDuracion(tmp.getDuracion());                                               
                    return true;
                }
            }
        }catch(Exception e){
            return false;
        }    
        return false;
    }
}
