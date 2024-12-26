import java.util.Scanner;

public class Exemplo05_Condicional {

	public static void main(String[] args) {

		String mes_nome;
		var leitor = new Scanner(System.in);

		System.out.print("Digite o número do mês: ");
		var mes_numero = leitor.nextInt();

		leitor.close();

		switch (mes_numero) {
		case 1:
			mes_nome = "Janeiro";
			break;
		case 2:
			mes_nome = "Fevereiro";
			break;
		case 3:
			mes_nome = "Março";
			break;
		case 4:
			mes_nome = "Abril";
			break;
		case 5:
			mes_nome = "Maio";
			break;
		case 6:
			mes_nome = "Junho";
			break;
		case 7:
			mes_nome = "Julho";
			break;
		case 8:
			mes_nome = "Agosto";
			break;
		case 9:
			mes_nome = "Setembro";
			break;
		case 10:
			mes_nome = "Outubro";
			break;
		case 11:
			mes_nome = "Novembro";
			break;
		case 12:
			mes_nome = "Dezembro";
			break;
		default:
			mes_nome = "Mês Inválido";
			break;
		}

		System.out.println(mes_numero + ": " + mes_nome);

	}

}
