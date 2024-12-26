import java.util.Scanner;

public class Exemplo10_Excecoes {

	public static void main(String[] args) {

		var leitor = new Scanner(System.in);

		System.out.print("Digite dois números inteiros: ");
		var a = leitor.nextInt();
		var b = leitor.nextInt();

		try {
			System.out.println("A divisão é " + (a / b) + ".");
		} catch (ArithmeticException e) {
			System.out.println("Não é possível uma divisão por zero!");
		}

		leitor.close();

	}

}
