package br.ifrn.sga.acesso.visao.terminal;

import java.util.Scanner;

import br.ifrn.sga.acesso.modelo.dao.UsuarioDAO;
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

}
