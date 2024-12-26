import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exemplo18_List {

	public static void main(String[] args) {

		// Criação de list imutável
		// var nomes = List.of("Felipe", "Lara", "João");
		// System.out.println(nomes);

		List<String> nomes = new ArrayList<>();
		// List<String> nomes = new LinkedList<>();

		// Adicionando elementos
		nomes.add("Felipe");
		nomes.add("Lara");
		nomes.add("Lucas");
		nomes.add("Bruna");
		nomes.add("Eduarda");
		nomes.add("Felipe");
		System.out.println(nomes);

		// Recuperando elementos
		System.out.println(nomes.get(0));
		System.out.println(nomes.get(2));

		// Recuperar o índice de um elemento
		System.out.println(nomes.indexOf("Felipe"));
		System.out.println(nomes.indexOf("Lucas"));
		System.out.println(nomes.indexOf("Carlos"));
		System.out.println(nomes.lastIndexOf("Felipe"));

		// Verificando se elemento existe
		System.out.println(nomes.contains("Iara"));
		System.out.println(nomes.contains("Carlos"));

		// Verificando se a lista está vazia
		System.out.println(nomes.isEmpty());

		// Removendo elementos
		System.out.println(nomes.remove(1));
		System.out.println(nomes.remove("Eduarda"));
		System.out.println(nomes.remove("Carlos"));
		System.out.println(nomes);

		// Atualizando valores de índices
		nomes.set(1, "Carlos");
		System.out.println(nomes);

		// Verificando quantos elementos existem
		System.out.println(nomes.size());

		// Contando ocorrências dos elementos
		System.out.println(Collections.frequency(nomes, "Iara"));
		System.out.println(Collections.frequency(nomes, "Carlos"));
		System.out.println(Collections.frequency(nomes, "Felipe"));

		// Retorna o menor (min) e o maior (max) elementos
		System.out.println(Collections.min(nomes));
		System.out.println(Collections.max(nomes));

		// Inverte a ordem dos elementos
		Collections.reverse(nomes);
		System.out.println(nomes);

		// Ordena de forma crescente
		Collections.sort(nomes);
		System.out.println(nomes);

		// Ordena de forma decrescente
		Collections.sort(nomes, Collections.reverseOrder());
		System.out.println(nomes);

		// Retorna uma referência que não permite modificação
		var nomes_leitura = Collections.unmodifiableList(nomes);
		// nomes_leitura.set(2, "João"); // Não permite modificação
		System.out.println(nomes_leitura);

		System.out.println("-------------");

		// Usando for: forma 1 (preferir a forma 2 ou método forEach)
		for (int i = 0; i < nomes.size(); i++) {
			System.out.println("Índice " + i + " = " + nomes.get(i));
		}

		System.out.println("-------------");

		// Usando for: forma 2 (preferir esta ou o método forEach)
		for (var elemento : nomes) {
			System.out.println(elemento);
		}

		System.out.println("-------------");

		// Usando o método forEach
		nomes.forEach(System.out::println);
		// nomes.forEach(elemento -> System.out.println(elemento));

		// Remove todos os elementos
		nomes.clear();
		System.out.println(nomes);

	}

}
