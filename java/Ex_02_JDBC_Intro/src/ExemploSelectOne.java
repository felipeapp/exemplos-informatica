import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExemploSelectOne {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "root";
		String senha = "123456";

		String sql = "select * from aluno where matricula = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite a matrícula da busca: ");
			var matricula_entrada = leitor.nextInt();

			stmt.setInt(1, matricula_entrada);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
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
				} else {
					System.out.println("Matrícula não encontrada!");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
