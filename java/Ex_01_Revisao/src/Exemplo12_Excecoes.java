import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo12_Excecoes {

	public static void main(String[] args) {

		var leitor = new Scanner(System.in);

		try {
			System.out.print("Digite dois números inteiros: ");
			var a = leitor.nextInt();
			var b = leitor.nextInt();

			System.out.println("A divisão é " + (a / b) + ".");
		} catch (ArithmeticException | InputMismatchException e) {
			System.err.println("Ocorreu um erro ao executar o programa!");
			System.err.println("Mensagem: " + e.getMessage());
			e.printStackTrace();
		}

		leitor.close();

	}

}
