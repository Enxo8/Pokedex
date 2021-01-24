package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;


public class LoginDAO extends AbstractDao {
	
	/**
	 * Metodo para comprobar que el usuario y la contrasena esten en la BD
	 * @param usuario
	 * @param contrasena
	 * @return
	 */
	public boolean comprobarLogin(String usuario,String contrasena) {
		try {
			ResultSet rs = stmt.executeQuery("Select * from pokemon.login where username like '"+usuario+"' and password like '"+ contrasena+"'");
			
				return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Metodo para anadir a la BD un usuario y su contrasena
	 * @param u
	 */
	public void registrarUsuario(Usuario u) {
		String sql = "INSERT INTO login VALUES (?,?);";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, u.getUsuario());
			preparedStatement.setString(2, u.getContrasena());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}       
		
	}
	
	/**
	 * Metodo para comprobar que el nombre existe 
	 * @param usuario
	 * @return
	 */
	public boolean comprobarUsuario(String usuario) {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM login where username = '" + usuario + "';");
			
			// rs.next() devuelve true si hay un usuario con ese username y false en caso
			// contrario.
			return rs.next();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// En caso error.
			return false;
		}
	}
	
	
	
	
}
