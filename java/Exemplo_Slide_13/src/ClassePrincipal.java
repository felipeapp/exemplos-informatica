import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassePrincipal {

	public static void main(String[] args) throws SQLException {

		Connection conexao = DriverManager.getConnection("jdbc:mysql://10.225.0.4/1812384_agenda", "1812384",
				"felipe3");

		PreparedStatement stmt = conexao.prepareStatement("select * from contato");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			int idade = rs.getInt("idade");

			System.out.println("--------------------");
			System.out.println("ID: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("E-Mail: " + email);
			System.out.println("Idade: " + idade);
		}

		rs.close();
		stmt.close();
		conexao.close();

	}

}
