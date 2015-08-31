/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 * @category ESPOL
 * @version 8.0
 * @author Villacis, Marmolejo, Espinosa.
 */

public class Sala implements java.io.Serializable{
    
	private String codigo;
    private String nombre;
    private String tipo;
    private int capacidad;
    
    public Sala(){}
	
	public Sala(String codigo, String nombre, String tipo, int capacidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.capacidad = capacidad;
	}

	public Sala(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
			
}	