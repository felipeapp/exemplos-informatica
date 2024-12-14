import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Exemplo20_Map {

	public static void main(String[] args) {

		// Criação de map imutável
		// var medias = Map.of("Lara", 8.5, "Pedro", 9.4, "Felipe", 10.0);
		// System.out.println(medias);

		Map<String, Double> medias = new HashMap<>();
		// Map<String, Double> medias = new LinkedHashMap<>();
		// Map<String, Double> medias = new TreeMap<>();

		// Adicionando elementos
		medias.put("Iara", 3.5);
		medias.put("Felipe", 10.0);
		medias.put("Carlos", 9.5);
		medias.put("Clara", 9.0);
		System.out.println(medias);

		// Recuperando o valor da chave
		System.out.println(medias.get("Iara"));

		// Remover um valor
		medias.remove("Iara");
		System.out.println(medias);

		// Verificando se elemento existe
		System.out.println(medias.containsKey("Iara"));
		System.out.println(medias.containsValue(10.0));

		// Verificando se está vazia
		System.out.println(medias.isEmpty());

		// Atualizando valores
		medias.put("Felipe", 9.9);
		System.out.println(medias);

		// Verificando quantos elementos existem
		System.out.println(medias.size());

		var chaves = medias.keySet();
		System.out.println(chaves);

		var valores = medias.values();
		System.out.println(valores);

		// Retorna uma referência que não permite modificação
		var medias_leitura = Collections.unmodifiableMap(medias);
		System.out.println(medias_leitura);

		System.out.println("---------------");

		// Usando for (forma 1)
		for (var chave : medias.keySet()) {
			System.out.println("Chave: " + chave + " | Valor: " + medias.get(chave));
		}

		System.out.println("---------------");

		// Usando for (forma 2 - preferir esta ou o método forEach)
		for (var entrada : medias.entrySet()) {
			System.out.println("Chave: " + entrada.getKey() + " | Valor: " + entrada.getValue());
		}

		System.out.println("---------------");

		// Usando método forEach (preferir esta ou a forma 2)
		medias.forEach((nome, media) -> System.out.println("Chave: " + nome + " | Valor: " + media));

		// Remove todos os elementos
		medias.clear();
		System.out.println(medias);

	}

}
