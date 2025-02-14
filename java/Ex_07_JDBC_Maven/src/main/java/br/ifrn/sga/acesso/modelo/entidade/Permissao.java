package br.ifrn.sga.acesso.modelo.entidade;

import java.time.LocalDateTime;

import br.ifrn.sga.acesso.visao.DateUtil;
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
public class Permissao {

	private Usuario usuario;
	private Sala sala;

	@ToString.Exclude
	private LocalDateTime horario;

	@ToString.Include(name = "horario")
	private String getHorarioFormatado() {
		return DateUtil.dateToString(this.horario);
	}

}
