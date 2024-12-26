import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Exemplo19_Set {

	public static void main(String[] args) {

		// Criação de set imutável
		// var nomes = Set.of("João", "Ivo", "Maria", "Lara", "Felipe");
		// System.out.println(nomes);

		// Set<String> nomes = new HashSet<>();
		// Set<String> nomes = new LinkedHashSet<>();
		Set<String> nomes = new TreeSet<>();

		// Adicionando elementos
		nomes.add("Felipe");
		nomes.add("Iara");
		nomes.add("Lucas");
		nomes.add("Bruna");
		nomes.add("Eduarda");
		nomes.add("Felipe");
		nomes.add("João");
		nomes.add("Pedro");
		nomes.add("Maria");
		System.out.println(nomes);

		// Verificando se elemento existe
		System.out.println(nomes.contains("Iara"));
		System.out.println(nomes.contains("Carlos"));

		// Verificando se a lista está vazia
		System.out.println(nomes.isEmpty());

		// Removendo elementos
		System.out.println(nomes.remove("Eduarda"));
		System.out.println(nomes.remove("Carlos"));
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

		// Retorna uma referência que não permite modificação
		var nomes_leitura = Collections.unmodifiableSet(nomes);
		System.out.println(nomes_leitura);

		System.out.println("-------------");

		// Usando for
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
