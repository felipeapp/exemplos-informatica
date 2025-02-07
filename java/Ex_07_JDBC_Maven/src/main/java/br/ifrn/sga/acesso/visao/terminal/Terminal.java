package br.ifrn.sga.acesso.visao.terminal;

import java.time.LocalDateTime;

import br.ifrn.sga.acesso.modelo.entidade.Permissao;
import br.ifrn.sga.acesso.modelo.entidade.Sala;

public class Terminal {

	public static void main(String[] args) {
		System.out.println("Olá, mundo!");

		var sala = new Sala();

		sala.setId(1);
		System.out.println(sala);

		var p = new Permissao(null, null, LocalDateTime.now());
		System.out.println(p);
	}

}
