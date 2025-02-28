package br.ifrn.sga.acesso.visao.terminal;

import java.util.Scanner;

public class Terminal {

	public static void mostrarMenu() {
		System.out.println("-----------------------");
		System.out.println("00. Sair do programa");
		System.out.println("01. Adicionar usuário");
		System.out.println("02. Adicionar sala");
		System.out.println("03. Adicionar permissão (sem verificação)");
		System.out.println("04. Adicionar permissão (com verificação)");
		System.out.println("05. Buscar usuário por CPF");
		System.out.println("06. Buscar sala por número");
		System.out.println("07. Buscar salas do usuário");
		System.out.println("08. Buscar usuários da sala");
		System.out.println("09. Remover permissão (sem verificação)");
		System.out.println("10. Remover permissão (com verificação)");
		System.out.println("11. Gerar relatório de usuários");
		System.out.println("12. Gerar relatório de salas");
		System.out.println("13. Gerar relatório de permissões");
		System.out.print("Escolha sua opção: ");
	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		while (true) {
			mostrarMenu();
			int opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao == 0) {
				System.out.println("Saindo do programa...");
				break;
			} else if (opcao == 1) {
				UsuarioUtil.lerDadosAdicionar(leitor);
			} else if (opcao == 2) {
				SalaUtil.lerDadosAdicionar(leitor);
			} else if (opcao == 3) {
				PermissaoUtil.lerDadosAdicionarSemVerificacao(leitor);
			} else if (opcao == 4) {
				PermissaoUtil.lerDadosAdicionarComVerificacao(leitor);
			} else if (opcao == 5) {
				UsuarioUtil.lerDadosBuscarPorCpf(leitor);
			} else if (opcao == 6) {
				SalaUtil.lerDadosBuscarPorNumero(leitor);
			} else if (opcao == 7) {
				SalaUtil.lerDadosBuscarPorUsuario(leitor);
			} else if (opcao == 8) {
				UsuarioUtil.lerDadosBuscarPorSala(leitor);
			} else if (opcao == 9) {
				PermissaoUtil.lerDadosRemoverSemVerificacao(leitor);
			} else if (opcao == 10) {
				PermissaoUtil.lerDadosRemoverComVerificacao(leitor);
			} else if (opcao == 11) {
				UsuarioUtil.gerarRelatorio();
			} else if (opcao == 12) {
				SalaUtil.gerarRelatorio();
			} else if (opcao == 13) {
				PermissaoUtil.gerarRelatorio();
			} else {
				System.out.println("Opção inválida, tente novamente!");
			}
		}

		leitor.close();
	}

}
