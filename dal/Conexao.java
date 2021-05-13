package dal;

import java.sql.*;

public class Conexao {
	// Método para conectar com o banco
	public static Connection conector() {
		java.sql.Connection conexao = null;
		String url = "jdbc:mysql://localhost:3306/hospital";
		String user = "root";
		String senha = "123456";
		
		try {
			conexao = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}
	
}
