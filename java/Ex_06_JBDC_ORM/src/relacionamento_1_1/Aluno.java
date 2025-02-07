package relacionamento_1_1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
aluno(id, nome, matricula, data_ingresso, id_tcc, horario_defesa)
	id_tcc referencia tcc(id)
*/
public class Aluno {

	private int id;
	private String nome;
	private int matricula;
	private LocalDate dataIngresso;

	private TCC tcc;
	private LocalDateTime horarioDefesa;

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

	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public LocalDateTime getHorarioDefesa() {
		return horarioDefesa;
	}

	public void setHorarioDefesa(LocalDateTime horarioDefesa) {
		this.horarioDefesa = horarioDefesa;
	}

	public TCC getTcc() {
		return tcc;
	}

	public void setTcc(TCC tcc) {
		this.tcc = tcc;
	}

}
