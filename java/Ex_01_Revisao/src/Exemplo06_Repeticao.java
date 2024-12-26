public class Exemplo06_Repeticao {

	public static void main(String[] args) {
		int contador = 0;
		while (contador < 10) {
			System.out.println(contador);
			++contador;
		}

		System.out.println("----------------");

		contador = 0;
		while (true) {
			if (contador == 10) {
				break;
			}

			System.out.println(contador);
			++contador;
		}

		System.out.println("----------------");

		contador = 0;
		do {
			System.out.println(contador);
			++contador;
		} while (contador < 10);

		System.out.println("----------------");

		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}

		System.out.println("----------------");

		for (int i = 0; i < 100; i += 2) {
			System.out.println(i);
		}

	}

}
