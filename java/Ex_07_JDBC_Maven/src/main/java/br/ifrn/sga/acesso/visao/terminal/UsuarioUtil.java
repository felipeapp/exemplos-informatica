package br.ifrn.sga.acesso.visao.terminal;

import java.util.Scanner;

import br.ifrn.sga.acesso.modelo.dao.SalaDAO;
import br.ifrn.sga.acesso.modelo.dao.UsuarioDAO;
import br.ifrn.sga.acesso.modelo.entidade.Sala;
import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class UsuarioUtil {

	public static void lerDadosAdicionar(Scanner leitor) {
		Usuario u = new Usuario();

		System.out.print("Digite o nome do usuário: ");
		u.setNome(leitor.nextLine());

		System.out.print("Digite o CPF do usuário: ");
		u.setCpf(leitor.nextLine());

		System.out.print("Digite a tag do usuário: ");
		u.setTag(leitor.nextInt());

		try (UsuarioDAO dao = new UsuarioDAO()) {
			if (dao.adicionar(u)) {
				System.out.println("Usuário adicionado com sucesso!");
			} else {
				System.out.println("Erro ao adicionar usuário!");
			}
		}
	}

	public static void lerDadosBuscarPorCpf(Scanner leitor) {
		System.out.print("Digite o CPF do usuário: ");
		String cpf = leitor.nextLine();

		try (UsuarioDAO dao = new UsuarioDAO()) {
			Usuario u = dao.buscarPorCpf(cpf);

			if (u == null) {
				System.out.println("Usuário não encontrado!");
			} else {
				System.out.println(u);
			}
		}
	}

	public static void lerDadosBuscarPorSala(Scanner leitor) {
		System.out.print("Digite o número da sala para buscar seus usuários: ");
		var numero = leitor.nextInt();

		try (SalaDAO dao_sala = new SalaDAO()) {
			Sala s = dao_sala.buscarPorNumero(numero);

			if (s == null) {
				System.out.println("Sala não encontrada!");
			} else {
				System.out.println("Usuários da sala " + s + ":");

				try (UsuarioDAO dao_usuario = new UsuarioDAO()) {
					var usuarios = dao_usuario.buscarPorSala(numero);

					if (usuarios.isEmpty()) {
						System.out.println("Nenhum usuário encontrado!");
					} else {
						usuarios.forEach(System.out::println);
					}
				}
			}
		}
	}

	public static void gerarRelatorio() {
		try (UsuarioDAO dao = new UsuarioDAO()) {
			var usuarios = dao.buscarTodos();

			if (usuarios.isEmpty()) {
				System.out.println("Não há usuários cadastrados!");
			} else {
				usuarios.forEach(System.out::println);
			}
		}
	}

}
