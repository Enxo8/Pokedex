package models;

import java.util.ArrayList;

public class Pokemon {
	
	private int numero;
	private String nombre;
	private String Descripcion;
	private float altura;
	private float peso;
	private String categoria;
	private String habilidad;
	private String tipos;
	
	
	//Constructor
	public Pokemon(int numero, String nombre, String descripcion, float altura, float peso, String categoria,
			String habilidad, String tipos) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		Descripcion = descripcion;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
		this.tipos=tipos;
	}
	//Fin Constructor
	
	//Getters y setters

	@Override
	public String toString() {
		return "Pokemon [numero=" + numero + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", altura="
				+ altura + ", peso=" + peso + ", categoria=" + categoria + ", habilidad=" + habilidad + ", tipos="
				+ tipos + "]";
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	
	//Fin getters y setters
}
