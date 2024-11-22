public class Exemplo03_Operadores {

	public static void main(String[] args) {

		var divisao1 = 5 / 2;
		var divisao2 = 5.0 / 2;
		var m = 70;
		var nf = 30;

		System.out.println(divisao1);
		System.out.println(divisao2);
		System.out.println(13 % 5);
		System.out.println(2 + 3 * 5);
		System.out.println((2 + 3) * 5);
		System.out.println(m > 60 && nf < 20);

		System.out.println(Math.PI);

		double raio = 3.5;
		System.out.println(2 * Math.PI * raio);
		System.out.println(2 * 3.14 * raio);

		System.out.println(Math.sqrt(25));
		System.out.println(Math.cbrt(27));
		System.out.println(Math.pow(2, 4));

	}

}
