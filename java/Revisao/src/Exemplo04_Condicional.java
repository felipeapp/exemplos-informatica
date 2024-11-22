import java.util.Scanner;

public class Exemplo04_Condicional {

	public static void main(String[] args) {

		var leitor = new Scanner(System.in);

		System.out.print("Digite a primeira nota: ");
		var nota1 = leitor.nextDouble();

		System.out.print("Digite a segunda nota: ");
		var nota2 = leitor.nextDouble();

		leitor.close();

		var media = (nota1 + nota2) / 2;
		System.out.println("A média é " + media);

		if (media >= 9) {
			System.out.println("Aprovado com louvor!");
		} else if (media >= 7) {
			System.out.println("Aprovado!");
		} else if (media >= 3) {
			System.out.println("Recuperação!");
		} else {
			System.out.println("Reprovado!");
		}

	}

}
