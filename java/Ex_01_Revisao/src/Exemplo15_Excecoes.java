import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo15_Excecoes {

	public static int calcDivisao(int a, int b) throws ArithmeticException {
		return a / b;
	}

	public static void main(String[] args) {

		try (var leitor = new Scanner(System.in)) {
			System.out.print("Digite dois números inteiros: ");
			var a = leitor.nextInt();
			var b = leitor.nextInt();

			System.out.println("A divisão é " + calcDivisao(a, b) + ".");
		} catch (ArithmeticException e) {
			System.out.println("Não é possível dividir por zero!");
		} catch (InputMismatchException e) {
			System.out.println("O valor digitado deve ser inteiro!");
		}

	}

}
