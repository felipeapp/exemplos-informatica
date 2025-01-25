package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstratoDAO {

	protected Connection conexao;

	public AbstratoDAO() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://10.225.0.4:3306/1812384_agenda", "1812384",
					"felipe@123");
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
