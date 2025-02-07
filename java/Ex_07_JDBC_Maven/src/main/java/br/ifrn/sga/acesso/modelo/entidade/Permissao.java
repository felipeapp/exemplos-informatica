package br.ifrn.sga.acesso.modelo.entidade;

import java.time.LocalDateTime;

import br.ifrn.sga.acesso.visao.DateUtil;

public class Permissao {

	private Usuario usuario;
	private Sala sala;
	private LocalDateTime horario;

	public Permissao(Usuario usuario, Sala sala, LocalDateTime horario) {
		this.usuario = usuario;
		this.sala = sala;
		this.horario = horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Sala getSala() {
		return sala;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	@Override
	public String toString() {
		return "Permissao [usuario=" + usuario + ", sala=" + sala + ", horario=" + DateUtil.dateToString(horario) + "]";
	}

}
