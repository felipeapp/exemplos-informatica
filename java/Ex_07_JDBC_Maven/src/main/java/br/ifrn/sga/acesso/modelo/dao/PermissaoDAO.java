package br.ifrn.sga.acesso.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifrn.sga.acesso.modelo.entidade.Sala;
import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class PermissaoDAO extends AbstratoDAO {

	public boolean adicionar(String cpf, int numero) {
		boolean sucesso;
		String sql = "insert into permissao (id_usuario, id_sala) values"
				+ "((select id from usuario where cpf = ?), (select id from sala where numero = ?))";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			stmt.setInt(2, numero);

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
		}

		return sucesso;
	}

	public boolean adicionar(Usuario u, Sala s) {
		boolean sucesso;
		String sql = "insert into permissao (id_usuario, id_sala) values (?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, u.getId());
			stmt.setInt(2, s.getId());

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
		}

		return sucesso;
	}

}
