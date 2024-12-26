import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo13_Excecoes {

	public static void main(String[] args) {

		try (Scanner leitor = new Scanner(System.in)) {
			System.out.print("Digite dois números inteiros: ");
			var a = leitor.nextInt();
			var b = leitor.nextInt();

			System.out.println("A divisão é " + (a / b) + ".");
		} catch (ArithmeticException | InputMismatchException e) {
			System.out.println("Ocorreu um erro ao executar o programa!");
			System.out.println("Mensagem: " + e.getMessage());
			// e.printStackTrace();
		}

	}

}
