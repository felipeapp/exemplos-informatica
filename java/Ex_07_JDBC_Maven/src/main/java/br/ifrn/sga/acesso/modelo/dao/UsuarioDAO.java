package br.ifrn.sga.acesso.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class UsuarioDAO extends AbstratoDAO {

	public static Usuario criarUsuario(ResultSet rs) throws SQLException {
		return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getInt("tag"));
	}

	public boolean adicionar(Usuario u) {
		boolean sucesso;
		String sql = "insert into usuario (nome, cpf, tag) values (?, ?, ?)";

		try (var stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getCpf());
			stmt.setInt(3, u.getTag());

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
		}

		return sucesso;
	}

	public Usuario buscarPorCpf(String cpf) {
		Usuario u = null;
		String sql = "select * from usuario where cpf = ?";

		try (var stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			var rs = stmt.executeQuery();

			if (rs.next()) {
				u = criarUsuario(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	public List<Usuario> buscarPorSala(int numero) {
		List<Usuario> usuarios = new ArrayList<>();

		String sql = "select u.* from sala s inner join permissao p on s.id = p.id_sala "
				+ "inner join usuario u on u.id = p.id_usuario where s.numero = ?";

		try (var stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, numero);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				usuarios.add(criarUsuario(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = new ArrayList<>();

		String sql = "select * from usuario";

		try (var stmt = conexao.prepareStatement(sql); var rs = stmt.executeQuery()) {
			while (rs.next()) {
				usuarios.add(criarUsuario(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

}
