import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExSelect {

	public static void main(String[] args) {

		String url = "jdbc:mysql://127.0.0.1/agenda";
		String usuario = "root";
		String senha = "123456";

		String sql = "select * from contato";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				var id = rs.getInt("id");
				var nome = rs.getString("nome");
				var email = rs.getString("email");
				var celular = rs.getInt("celular");
				var nascimento = rs.getObject("nascimento", LocalDate.class);
				var cadastro = rs.getObject("cadastro", LocalDateTime.class);

				System.out.println("ID: " + id);
				System.out.println("Nome: " + nome);
				System.out.println("E-Mail: " + email);
				System.out.println("Celular: " + celular);
				System.out.println("Data de Nascimento: " + DateUtil.dateToString(nascimento));
				System.out.println("Data de Cadastro: " + DateUtil.dateToString(cadastro));
				System.out.println("------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
