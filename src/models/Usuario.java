package models;

/**
 * Objeto usuario que contiene los parametros con los que construiremos los usuarios mas adelante 
 * @author eNZO
 *
 */
public class Usuario {
	
	private String usuario;
	private String contrasena;
	
	
	public Usuario(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	@Override
	public String toString() {
		return "Ususario [usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
	
	
}
