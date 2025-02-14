package br.ifrn.sga.acesso.visao.terminal;

import java.util.Scanner;

import br.ifrn.sga.acesso.modelo.dao.SalaDAO;
import br.ifrn.sga.acesso.modelo.dao.UsuarioDAO;
import br.ifrn.sga.acesso.modelo.entidade.Sala;
import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class SalaUtil {

	public static void lerDadosAdicionar(Scanner leitor) {
		Sala s = new Sala();

		System.out.print("Digite o nome da sala: ");
		s.setNome(leitor.nextLine());

		System.out.print("Digite o número da sala: ");
		s.setNumero(leitor.nextInt());

		try (SalaDAO dao = new SalaDAO()) {
			if (dao.adicionar(s)) {
				System.out.println("Sala adicionada com sucesso!");
			} else {
				System.out.println("Erro ao adicionar sala!");
			}
		}
	}

	public static void lerDadosBuscarPorNumero(Scanner leitor) {
		System.out.print("Digite o número da sala: ");
		int numero = leitor.nextInt();

		try (SalaDAO dao = new SalaDAO()) {
			Sala s = dao.buscarPorNumero(numero);

			if (s == null) {
				System.out.println("Sala não encontrada!");
			} else {
				System.out.println(s);
			}
		}
	}

	public static void lerDadosBuscarPorUsuario(Scanner leitor) {
		System.out.print("Digite o CPF do usuário para buscar suas salas: ");
		String cpf = leitor.nextLine();

		try (UsuarioDAO dao_usuario = new UsuarioDAO()) {
			Usuario u = dao_usuario.buscarPorCpf(cpf);

			if (u == null) {
				System.out.println("Usuário não encontrado!");
			} else {
				System.out.println("Salas do usuário " + u + ":");

				try (SalaDAO dao_sala = new SalaDAO()) {
					var salas = dao_sala.buscarPorUsuario(cpf);

					if (salas.isEmpty()) {
						System.out.println("Nenhuma sala encontrada!");
					} else {
						salas.forEach(System.out::println);
					}
				}
			}
		}
	}

}
