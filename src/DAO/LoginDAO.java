package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends AbstractDao {
	
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

}
