import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExemploUpdate {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "root";
		String senha = "123456";

		String sql = "update aluno set curso = ? where matricula = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o novo curso: ");
			var novo_curso = leitor.nextLine();

			System.out.print("Digite a matrícula da busca: ");
			var matricula = leitor.nextInt();

			stmt.setString(1, novo_curso);
			stmt.setInt(2, matricula);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

			if (linhas > 0) {
				System.out.println("Atualização realizada com sucesso!");
			} else {
				System.out.println("Matrícula não encontrada!");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar atualização!");
			// e.printStackTrace();
		}

	}

}
