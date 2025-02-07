package relacionamento_n_n_sem_atributos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// professor(id, nome, matricula, titulacao)
public class Professor {

	private int id;
	private String nome;
	private int matricula;
	private String titulacao;

	private List<Disciplina> disciplinas;

	public Professor() {
		disciplinas = new ArrayList<>();
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(disciplinas);
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

}
