package relacionamento_n_n_com_atributos;

import java.time.LocalDateTime;

/*
consulta(id_medico, id_paciente, horario_consulta)
	id_medico referencia medica(id)
	id_paciente referencia paciente(id)
*/
public class Consulta {

	private Medico medico;
	private Paciente paciente;
	private LocalDateTime horarioConsulta;

	public Consulta() {
	}

	public Consulta(Medico medico, Paciente paciente, LocalDateTime horarioConsulta) {
		this.medico = medico;
		this.paciente = paciente;
		this.horarioConsulta = horarioConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(LocalDateTime horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

}
