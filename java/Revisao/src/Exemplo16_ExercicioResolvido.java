import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo16_ExercicioResolvido {

	public static double lerNota(Scanner leitor, String mensagem, String erro) {
		double nota;

		while (true) {
			try {
				System.out.print(mensagem);
				nota = leitor.nextDouble();

				if (nota >= 0 && nota <= 10) {
					break;
				}

				System.out.println(erro);
			} catch (InputMismatchException e) {
				System.out.println("A nota deve ser um valor numérico!");
				leitor.nextLine();
			}
		}

		return nota;
	}

	public static int lerFaltas(Scanner leitor) {
		int faltas;

		while (true) {
			try {
				System.out.print("Digita o número de faltas: ");
				faltas = leitor.nextInt();

				if (faltas >= 0 && faltas <= 60) {
					break;
				}

				System.out.println("Número de faltas inválido!");
			} catch (InputMismatchException e) {
				System.out.println("O número de faltas deve ser um inteiro!");
				leitor.nextLine();
			}
		}

		return faltas;
	}

	public static void main(String[] args) {
		var leitor = new Scanner(System.in);

		var n1 = lerNota(leitor, "Digite a primeira nota: ", "Primeira nota inválida!");
		var n2 = lerNota(leitor, "Digite a segunda nota: ", "Segunda nota inválida!");
		var n3 = lerNota(leitor, "Digite a terceira nota: ", "Terceira nota inválida!");
		var n4 = lerNota(leitor, "Digite a quarta nota: ", "Quarta nota inválida!");
		var nf = lerFaltas(leitor);

		var media = (2 * n1 + 2 * n2 + 3 * n3 + 3 * n4) / 10;

		System.out.println("O número de faltas é " + nf);
		System.out.println("A média do aluno é " + media);

		if (nf > 20) {
			System.out.println("Reprovado por faltas");
		} else if (media >= 9) {
			System.out.println("Aprovado com louvor");
		} else if (media >= 7) {
			System.out.println("Aprovado");
		} else if (media >= 3) {
			System.out.println("Recuperação");
		} else {
			System.out.println("Reprovado");
		}

		leitor.close();

	}

}
