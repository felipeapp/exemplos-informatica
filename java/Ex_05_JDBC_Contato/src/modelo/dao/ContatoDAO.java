package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.Contato;

public class ContatoDAO extends AbstratoDAO {

	private Contato criar_contato(ResultSet rs) throws SQLException {
		Contato c = new Contato();

		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setEmail(rs.getString("email"));
		c.setCelular(rs.getInt("celular"));
		c.setNascimento(rs.getObject("nascimento", LocalDate.class));
		c.setCadastro(rs.getObject("cadastro", LocalDateTime.class));

		return c;
	}

	public boolean adicionar(Contato c) {
		boolean sucesso;
		String sql = "insert into contato (nome, email, celular, nascimento) values (?, ?, ?, ?)";

		try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setInt(3, c.getCelular());
			stmt.setObject(4, c.getNascimento());

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
			// e.printStackTrace();
		}

		return sucesso;
	}

	public boolean atualizar(String email, String novo_nome, int novo_celular) {
		boolean sucesso;
		String sql = "update contato set nome = ?, celular = ? where email = ?";

		try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
			stmt.setString(1, novo_nome);
			stmt.setInt(2, novo_celular);
			stmt.setString(3, email);

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
			// e.printStackTrace();
		}

		return sucesso;
	}

	public boolean removerPorEmail(String email) {
		boolean sucesso;
		String sql = "delete from contato where email = ?";

		try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
			stmt.setString(1, email);
			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
			// e.printStackTrace();
		}

		return sucesso;
	}

	public List<Contato> listar() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from contato";

		try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				contatos.add(criar_contato(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contatos;
	}

	public Contato buscarPorEmail(String email) {
		Contato contato = null;
		String sql = "select * from contato where email = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				contato = criar_contato(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contato;
	}

	public List<Contato> buscarPorNome(String nome) {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from contato where nome like ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contatos.add(criar_contato(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contatos;
	}

}
