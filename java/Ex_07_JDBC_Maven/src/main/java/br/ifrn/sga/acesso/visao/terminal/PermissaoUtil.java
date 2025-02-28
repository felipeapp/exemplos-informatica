package br.ifrn.sga.acesso.visao.terminal;

import java.util.Scanner;

import br.ifrn.sga.acesso.modelo.dao.PermissaoDAO;
import br.ifrn.sga.acesso.modelo.dao.SalaDAO;
import br.ifrn.sga.acesso.modelo.dao.UsuarioDAO;
import br.ifrn.sga.acesso.modelo.entidade.Sala;
import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class PermissaoUtil {

	public static void lerDadosAdicionarSemVerificacao(Scanner leitor) {
		System.out.print("Digite o CPF do usuário: ");
		String cpf = leitor.nextLine();

		System.out.print("Digite o número da sala: ");
		int numero = leitor.nextInt();

		try (PermissaoDAO dao = new PermissaoDAO()) {
			if (dao.adicionar(cpf, numero)) {
				System.out.println("Permissão adicionada com sucesso!");
			} else {
				System.out.println("Erro ao adicionar permissão!");
			}
		}
	}

	public static void lerDadosAdicionarComVerificacao(Scanner leitor) {
		System.out.print("Digite o CPF do usuário: ");
		String cpf = leitor.nextLine();

		try (UsuarioDAO dao_usuario = new UsuarioDAO()) {
			Usuario u = dao_usuario.buscarPorCpf(cpf);

			if (u == null) {
				System.out.println("Usuário não encontrado!");
			} else {
				System.out.print("Digite o número da sala: ");
				int numero = leitor.nextInt();

				try (SalaDAO dao_sala = new SalaDAO()) {
					Sala s = dao_sala.buscarPorNumero(numero);

					if (s == null) {
						System.out.println("Sala não encontrada!");
					} else {
						try (PermissaoDAO dao_permissao = new PermissaoDAO()) {
							if (dao_permissao.adicionar(u, s)) {
								System.out.println("Permissão adicionada com sucesso!");
							} else {
								System.out.println("Erro ao adicionar permissão!");
							}
						}
					}
				}
			}
		}
	}

	public static void lerDadosRemoverSemVerificacao(Scanner leitor) {
		System.out.print("Digite o CPF do usuário: ");
		String cpf = leitor.nextLine();

		System.out.print("Digite o número da sala: ");
		int numero = leitor.nextInt();

		try (PermissaoDAO dao = new PermissaoDAO()) {
			if (dao.remover(cpf, numero)) {
				System.out.println("Permissão removida com sucesso!");
			} else {
				System.out.println("Erro ao remover permissão!");
			}
		}
	}

	public static void lerDadosRemoverComVerificacao(Scanner leitor) {
		System.out.print("Digite o CPF do usuário: ");
		var cpf = leitor.nextLine();

		try (var dao_usuario = new UsuarioDAO()) {
			var u = dao_usuario.buscarPorCpf(cpf);

			if (u == null) {
				System.out.println("Usuário não encontrado!");
			} else {
				System.out.println("Usuário encontrado: " + u);

				System.out.print("Digite o número da sala: ");
				var numero = leitor.nextInt();

				try (var dao_sala = new SalaDAO()) {
					Sala s = dao_sala.buscarPorNumero(numero);

					if (s == null) {
						System.out.println("Sala não encontrada!");
					} else {
						System.out.println("Sala encontrada: " + s);

						try (var dao_permissao = new PermissaoDAO()) {
							if (dao_permissao.remover(u, s)) {
								System.out.println("Permissão removida com sucesso!");
							} else {
								System.out.println("Não existe permissão entre o usuário e a sala!");
							}
						}
					}
				}
			}
		}
	}

	public static void gerarRelatorio() {
		try (PermissaoDAO dao = new PermissaoDAO()) {
			var permissoes = dao.buscarTodos();

			if (permissoes.isEmpty()) {
				System.out.println("Nenhuma permissão encontrada!");
			} else {
				permissoes.forEach(System.out::println);
			}
		}
	}

}
