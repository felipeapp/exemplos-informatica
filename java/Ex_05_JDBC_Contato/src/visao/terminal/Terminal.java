package visao.terminal;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;
import visao.DateUtil;

public class Terminal {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		while (true) {
			System.out.println("0. Sair");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Listar contatos");
			System.out.println("3. Atualizar contato");
			System.out.println("4. Remover");
			System.out.println("5. Buscar por e-mail");
			System.out.print("Escolha sua opção: ");
			var opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao == 0) {
				break;
			} else if (opcao == 1) {
				Contato c = new Contato();

				System.out.print("Digite o nome: ");
				c.setNome(leitor.nextLine());

				System.out.print("Digite o e-mail: ");
				c.setEmail(leitor.nextLine());

				System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
				c.setNascimento(DateUtil.stringToDate(leitor.nextLine(), LocalDate.class));

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
		}

		leitor.close();

	}

}
