import java.util.Scanner;

public class Exemplo14_Excecoes {

	public static void main(String[] args) {

		/*
		 * Notação possível, mas não muito útil se seu código gera exceções. É mais
		 * interessante quando o código não possui operações que possam gerar exceções.
		 */
		try (var leitor = new Scanner(System.in)) {
			System.out.print("Digite dois números inteiros: ");
			var a = leitor.nextInt();
			var b = leitor.nextInt();

			System.out.println("A divisão é " + (a / b) + ".");
		}

	}

}
