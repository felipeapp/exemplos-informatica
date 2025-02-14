package br.ifrn.sga.acesso.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.sga.acesso.modelo.entidade.Sala;

public class SalaDAO extends AbstratoDAO {

	public boolean adicionar(Sala s) {
		boolean sucesso;
		String sql = "insert into sala (numero, nome) values (?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, s.getNumero());
			stmt.setString(2, s.getNome());

			sucesso = stmt.executeUpdate() == 1;
		} catch (SQLException e) {
			sucesso = false;
		}

		return sucesso;
	}

	public Sala buscarPorNumero(int numero) {
		Sala s = null;
		String sql = "select * from sala where numero = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, numero);
			var rs = stmt.executeQuery();

			if (rs.next()) {
				s = new Sala();
				s.setId(rs.getInt("id"));
				s.setNumero(rs.getInt("numero"));
				s.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}

	public List<Sala> buscarPorUsuario(String cpf) {
		List<Sala> salas = new ArrayList<>();

		String sql = "select s.* from sala s inner join permissao p on s.id = p.id_sala "
				+ "inner join usuario u on u.id = p.id_usuario where u.cpf = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				Sala s = new Sala();

				s.setId(rs.getInt("id"));
				s.setNumero(rs.getInt("numero"));
				s.setNome(rs.getString("nome"));

				salas.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salas;
	}

}
