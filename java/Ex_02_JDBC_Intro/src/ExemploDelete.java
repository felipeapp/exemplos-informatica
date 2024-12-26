import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExemploDelete {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "root";
		String senha = "123456";

		String sql = "delete from aluno where matricula = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite a matrícula do aluno a ser removido: ");
			var matricula_entrada = leitor.nextInt();

			stmt.setInt(1, matricula_entrada);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

			if (linhas > 0) {
				System.out.println("Remoção realizada com sucesso!");
			} else {
				System.out.println("Matrícula não encontrada!");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar remoção!");
			// e.printStackTrace();
		}

	}

}
