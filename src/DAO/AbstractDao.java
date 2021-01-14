package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

	protected Connection conn = conexion();
	protected Statement stmt = sentencia();
	
	private Connection conexion() {
		Connection conn = null;
		try {
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Pepito","Narutito777");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	private Statement sentencia() {
		Statement stmt = null;
		try {
			stmt = ((java.sql.Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}