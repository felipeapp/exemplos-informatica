/*
Escreva um programa que mostre uma tabela de conversão entre graus Celsius
e graus Fahrenheit. A tabela deve incluir linhas para todas as temperaturas
entre 0 e 100 graus Celsius que são múltiplas de 10. A fórmula para
converter de graus Celsius para Fahrenheit é F=1.8×C+32, sendo C a
temperatura em graus Celsius e F o resultado em graus Fahrenheit.
*/

public class Exemplo09_Conversao {

	public static double converterCparaF(double temp_c) {
		return 1.8 * temp_c + 32;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i += 10) {
			System.out.println(i + "ºC = " + converterCparaF(i) + "ºF");
		}
	}

}
