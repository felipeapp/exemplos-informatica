package br.ifrn.sga.acesso.modelo.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	private int id;
	private String nome;
	private String cpf;
	private int tag;

}
