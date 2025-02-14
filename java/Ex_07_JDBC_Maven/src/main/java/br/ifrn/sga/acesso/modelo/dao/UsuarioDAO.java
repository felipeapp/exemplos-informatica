package br.ifrn.sga.acesso.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class UsuarioDAO extends AbstratoDAO {

	public boolean adicionar(Usuario u) {
		boolean sucesso;
		String sql = "insert into usuario (nome, cpf, tag) values (?, ?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
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

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			var rs = stmt.executeQuery();

			if (rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setTag(rs.getInt("tag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

}
