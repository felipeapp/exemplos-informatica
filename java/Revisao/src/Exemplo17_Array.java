public class Exemplo17_Array {

	public static void main(String[] args) {

		var nomes = new String[5];

		nomes[0] = "Felipe";
		nomes[1] = "Lara";
		nomes[2] = "Lucas";
		nomes[3] = "Bruna";
		nomes[4] = "Eduarda";

		// Não mostra o conteúdo
		System.out.println(nomes);
		System.out.println("--------------");

		// Usando for: forma 1 (preferir a forma 2)
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("[" + i + "]=" + nomes[i]);
		}

		System.out.println("--------------");

		// Usando for: forma 2 (preferir esta forma)
		for (var e : nomes) {
			System.out.println(e);
		}

	}

}
