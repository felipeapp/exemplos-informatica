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

}
