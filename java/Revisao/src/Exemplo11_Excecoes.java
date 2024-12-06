import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo11_Excecoes {

	public static void main(String[] args) {

		var leitor = new Scanner(System.in);

		try {
			System.out.print("Digite dois números inteiros: ");
			var a = leitor.nextInt();
			var b = leitor.nextInt();

			System.out.println("A divisão é " + (a / b) + ".");
		} catch (ArithmeticException e) {
			System.out.println("Não é possível uma divisão por zero!");
		} catch (InputMismatchException e) {
			System.out.println("O valor deve ser um inteiro!");
		}

		leitor.close();

	}

}
