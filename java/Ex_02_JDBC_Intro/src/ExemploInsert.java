import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExemploInsert {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "root";
		String senha = "123456";

		String sql = "insert into aluno (nome, matricula, ira, sexo, nascimento) values (?, ?, ?, ?, ?)";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o nome: ");
			var nome = leitor.nextLine();

			System.out.print("Digite a matrícula: ");
			var matricula = leitor.nextInt();

			System.out.print("Digite o IRA: ");
			var ira = leitor.nextDouble();

			System.out.print("Digite o sexo: ");
			var sexo = leitor.next();

			System.out.print("Digite a data de nascimento (aaaa-mm-dd): ");
			var nascimento = leitor.next();

			stmt.setString(1, nome);
			stmt.setInt(2, matricula);
			stmt.setDouble(3, ira);
			stmt.setString(4, sexo);
			stmt.setString(5, nascimento);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

		} catch (SQLException e) {
			System.out.println("Erro ao realizar inserção!");
			// e.printStackTrace();
		}

	}

}
