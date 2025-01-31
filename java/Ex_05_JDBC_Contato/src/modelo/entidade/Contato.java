package modelo.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

import visao.DateUtil;

public class Contato {

	private int id;
	private String nome;
	private String email;
	private int celular;
	private LocalDate nascimento;
	private LocalDateTime cadastro;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public LocalDateTime getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", email=" + email + ", celular=" + celular + ", nascimento="
				+ DateUtil.dateToString(nascimento) + ", cadastro=" + DateUtil.dateToString(cadastro);
	}

}
