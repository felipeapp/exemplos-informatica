package visao.terminal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;
import visao.DateUtil;

public class Terminal {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		while (true) {
			System.out.println("---------------------------------");
			System.out.println("0. Sair");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Listar contatos");
			System.out.println("3. Atualizar contato");
			System.out.println("4. Remover por e-mail");
			System.out.println("5. Buscar por e-mail");
			System.out.println("6. Buscar por similaridade de nome");
			System.out.print("Escolha sua opção: ");
			var opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao == 0) {
				break;
			} else if (opcao == 1) {
				Contato c = new Contato();

				System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
				LocalDate nascimento = DateUtil.stringToDate(leitor.nextLine(), LocalDate.class);

				if (nascimento == null) {
					System.out.println("A data digitada não é válida!");
				} else {
					c.setNascimento(nascimento);

					System.out.print("Digite o nome: ");
					c.setNome(leitor.nextLine());

					System.out.print("Digite o e-mail: ");
					c.setEmail(leitor.nextLine());

					System.out.print("Digite o número do celular: ");
					c.setCelular(leitor.nextInt());

					ContatoDAO dao = new ContatoDAO();

					if (dao.adicionar(c)) {
						System.out.println("Contato adicionado com sucesso!");
					} else {
						System.out.println("Erro ao adicionar contato!");
					}

					dao.fechar();
				}
			} else if (opcao == 2) {
				ContatoDAO dao = new ContatoDAO();
				List<Contato> contatos = dao.listar();
				dao.fechar();

				if (contatos.isEmpty()) {
					System.out.println("Não há contatos cadastrados!");
				} else {
					contatos.forEach(System.out::println);
				}
			} else if (opcao == 3) {
				System.out.print("Digite o e-mail do contato: ");
				String email = leitor.nextLine();

				ContatoDAO dao = new ContatoDAO();

				if (dao.buscarPorEmail(email) == null) {
					System.out.println("O e-mail " + email + " não foi encontrado!");
				} else {
					System.out.print("Digite o novo nome: ");
					String novo_nome = leitor.nextLine();

					System.out.print("Digite o novo celular: ");
					int novo_celular = leitor.nextInt();

					if (dao.atualizar(email, novo_nome, novo_celular)) {
						System.out.println("Contato atualizado com sucesso!");
					} else {
						System.out.println("Erro ao atualizar contato!");
					}
				}

				dao.fechar();
			} else if (opcao == 4) {
				System.out.print("Digite o e-mail do contato: ");
				String email = leitor.nextLine();

				ContatoDAO dao = new ContatoDAO();

				if (dao.buscarPorEmail(email) == null) {
					System.out.println("O e-mail " + email + " não foi encontrado!");
				} else {
					if (dao.removerPorEmail(email)) {
						System.out.println("Contato removido com sucesso!");
					} else {
						System.out.println("Erro ao remover contato!");
					}
				}

				dao.fechar();
			} else if (opcao == 5) {
				System.out.print("Digite o e-mail do contato: ");
				String email = leitor.nextLine();

				ContatoDAO dao = new ContatoDAO();
				Contato contato = dao.buscarPorEmail(email);
				dao.fechar();

				if (contato == null) {
					System.out.println("O e-mail " + email + " não foi encontrado!");
				} else {
					System.out.println(contato);
				}
			} else if (opcao == 6) {
				System.out.print("Digite o nome ou parte do nome do contato: ");
				String nome = leitor.nextLine();

				ContatoDAO dao = new ContatoDAO();
				List<Contato> contatos = dao.buscarPorNome(nome);
				dao.fechar();

				if (contatos.isEmpty()) {
					System.out.println("A busca pelo nome " + nome + " não teve resultados!");
				} else {
					contatos.forEach(System.out::println);
				}
			} else {
				System.out.println("Opção inválida, tente novamente!");
			}
		}

		leitor.close();

	}

}
