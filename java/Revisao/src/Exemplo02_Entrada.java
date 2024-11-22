import java.util.Scanner;

public class Exemplo02_Entrada {

	public static void main(String[] args) {

		var leitor = new Scanner(System.in);

		System.out.print("Digite sua idade: ");
		var idade = leitor.nextInt();

		System.out.print("Digite seu nome: ");
		leitor.nextLine();
		var nome = leitor.nextLine();

		System.out.print("Digite quanto você vale: ");
		var preco = leitor.nextDouble();

		System.out.print("Digite seu e-mail: ");
		var email = leitor.next();

		System.out.print("Digite suas duas notas: ");
		var nota1 = leitor.nextDouble();
		var nota2 = leitor.nextDouble();

		leitor.close();

		System.out.println("Você digitou:");
		System.out.println(nome);
		System.out.println(idade);
		System.out.println(preco);
		System.out.println(email);

		System.out.println("As notas foram " + nota1 + " e " + nota2);

	}

}
