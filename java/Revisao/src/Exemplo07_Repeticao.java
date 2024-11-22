import java.util.List;
import java.util.stream.IntStream;

public class Exemplo07_Repeticao {

	public static void main(String[] args) {

		// Mais um exemplo com while
		int cont = 0;
		while (cont < 10) {
			System.out.println("while: " + cont);
			cont++;
		}

		// Mais um exemplo com do-while
		cont = 0;
		do {
			System.out.println("do-while: " + cont);
			cont++;
		} while (cont < 10);

		// Mais um exemplo com for
		for (int i = 0; i < 10; i++) {
			System.out.println("for 1: " + i);
		}

		// Exemplo de for para coleções
		for (int i : List.of(0, 3, 7, 8, 9)) {
			System.out.println("for 2: " + i);
		}

		// Mesmo exemplo usando forEach
		IntStream.range(0, 10).forEach(elem -> System.out.println("forEach 1: " + elem));

		// Outro exemplo de foreach com coleções
		List.of(0, 3, 7, 8, 9).forEach(elem -> {
			var dobro = 2 * elem;
			System.out.println("forEach 2: " + dobro);
		});

	}

}
