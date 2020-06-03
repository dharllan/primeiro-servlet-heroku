package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10345222","sql10345222","P3MRBkpIKT");
		return conexao;
		} catch (Exception e ) {
			System.out.println("Falha no banco de dados");
			return null;
		}
		
	}
}