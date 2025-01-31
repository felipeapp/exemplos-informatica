package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstratoDAO {

	protected Connection conexao;

	public AbstratoDAO() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda", "root", "123456");
		} catch (SQLException e) {
			System.out.println("Erro conectando ao banco de dados!");
		}
	}

	public void fechar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
