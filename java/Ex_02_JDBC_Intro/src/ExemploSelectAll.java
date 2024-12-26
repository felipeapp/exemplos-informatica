import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploSelectAll {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "root";
		String senha = "123456";

		String sql = "select * from aluno";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					var id = rs.getInt("id");
					var nome = rs.getString("nome");
					var matricula = rs.getInt("matricula");
					var ira = rs.getDouble("ira");
					var curso = rs.getString("curso");
					var sexo = rs.getString("sexo");
					var nascimento = rs.getString("nascimento");
					var cadastro = rs.getString("cadastro");

					System.out.println("ID: " + id);
					System.out.println("Nome: " + nome);
					System.out.println("Matrícula: " + matricula);
					System.out.println("IRA: " + ira);
					System.out.println("Curso: " + curso);
					System.out.println("Sexo: " + sexo);
					System.out.println("Data de Nascimento: " + nascimento);
					System.out.println("Data de Cadastro: " + cadastro);
					System.out.println("------------------------");
				}
			} else {
				System.out.println("Nenhum aluno cadastrado!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
