package relacionamento_n_n_sem_atributos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// disciplina(id, nome)
public class Disciplina {

	private int id;
	private String nome;

	private List<Professor> professores;

	public Disciplina() {
		professores = new ArrayList<>();
	}

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

	public List<Professor> getProfessores() {
		return Collections.unmodifiableList(professores);
	}

	public void addProfessore(Professor professor) {
		this.professores.add(professor);
	}

}
