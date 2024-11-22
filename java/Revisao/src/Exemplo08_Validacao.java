import java.util.Scanner;

public class Exemplo08_Validacao {

	// Exemplo de validação com while
	public static int lerInteiroPositivo(Scanner leitor, String msg) {
		int valor;

		while (true) {
			System.out.print(msg);
			valor = leitor.nextInt();

			if (valor > 0) {
				break;
			}

			System.out.println("O valor deve ser maior que zero!");
		}

		return valor;
	}

	// Exemplo de validação com do-while
	public static double lerNota(Scanner leitor, String mensagem) {
		double nota;
		boolean repetir;

		do {
			System.out.print(mensagem);
			nota = leitor.nextDouble();
			repetir = nota < 0 || nota > 10;

			if (repetir) {
				System.out.println("Nota inválida, tente novamente!");
			}

		} while (repetir);

		return nota;
	}

	public static void main(String[] args) {
		var leitor = new Scanner(System.in);
		var quantidade = lerInteiroPositivo(leitor, "Quantos alunos no diário? ");

		for (int i = 1; i <= quantidade; ++i) {
			System.out.println("-----------");
			var nota1 = lerNota(leitor, "Digite a nota 1 do aluno " + i + ": ");
			var nota2 = lerNota(leitor, "Digite a nota 2 do aluno " + i + ": ");

			var media = (nota1 + nota2) / 2;
			System.out.println("A média é " + media);

			if (media >= 6) {
				System.out.println("Está aprovado!");
			} else if (media < 2) {
				System.out.println("Está reprovado!");
			} else {
				System.out.println("Está em recuperação!");
			}
		}

		leitor.close();
		System.out.println("-----------");
		System.out.println("Finalizando, seja feliz!");
	}

}
