import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/agenda";
		String usuario = "root";
		String senha = "123456";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o e-mail do contato a ser removido: ");
			var email = leitor.nextLine();

			/*
			 * Este é um exemplo de SQL Injection, NÃO use desta forma! Digitar ' or '1'='1
			 * produzirá o SQL: delete from contato where email = '' or '1'='1' e apagará
			 * todos os dados da tabela contato.
			 */
			var sql = "delete from contato where email = '" + email + "'";
			System.out.println("SQL: " + sql);
			var stmt = conexao.prepareStatement(sql);

			// Esta é a forma correta!
			// var sql = "delete from contato where email = ?";
			// var stmt = conexao.prepareStatement(sql);
			// stmt.setString(1, email);

			var linha = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linha);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
