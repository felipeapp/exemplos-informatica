package relacionamento_n_n_com_atributos;

// paciente(id, nome, doenca)
public class Paciente {

	private int id;
	private String nome;
	private String doenca;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

}
