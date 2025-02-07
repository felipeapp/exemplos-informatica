package relacionamento_1_n;

import java.time.LocalDate;

/*
funcionario(id, nome, matricula, salario, id_setor, data_contrato)
	id_setor referencia setor(id)
*/
public class Funcionario {

	private int id;
	private String nome;
	private int matricula;
	private double salario;

	private Setor setor;
	private LocalDate dataContrato;

	public LocalDate getDataContrato() {
		return dataContrato;
	}

	public int getId() {
		return id;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setDataContrato(LocalDate dataContrato) {
		this.dataContrato = dataContrato;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
