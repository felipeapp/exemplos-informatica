import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class ExInsert {

	public static void main(String[] args) {

		String url = "jdbc:mysql://127.0.0.1/agenda";
		String usuario = "root";
		String senha = "123456";

		String sql = "insert into contato (nome, email, celular, nascimento) values (?, ?, ?, ?)";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o nome: ");
			var nome = leitor.nextLine();

			System.out.print("Digite o e-mail: ");
			var email = leitor.nextLine();

			System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
			var nascimento = DateUtil.stringToDate(leitor.nextLine(), LocalDate.class);

			System.out.print("Digite o número do celular: ");
			var celular = leitor.nextInt();

			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setInt(3, celular);
			stmt.setObject(4, nascimento);

			var linha = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linha);
		} catch (SQLException e) {
			System.out.println("Erro ao realizar inserção!");
			e.printStackTrace();
		}

	}

}
