package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the asignar_horarios database table.
 * 
 */
@Entity
@Table(name="asignar_horarios")
@NamedQuery(name="AsignarHorario.findAll", query="SELECT a FROM AsignarHorario a")
public class AsignarHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignar_horarios")
	private Integer idAsignarHorarios;

	@Column(name="estado_h")
	private String estadoH;

	@Column(name="hora_fin_numero")
	private Time horaFinNumero;

	@Column(name="hora_inicio_numero")
	private Time horaInicioNumero;

	@Column(name="horas_fin_espacio")
	private Time horasFinEspacio;

	@Column(name="horas_inicio_espacio")
	private Time horasInicioEspacio;

	//bi-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="fk_dni_horarios")
	private Horario horario;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="fk_dni_empleados")
	private Participante participante;

	public AsignarHorario() {
	}

	public Integer getIdAsignarHorarios() {
		return this.idAsignarHorarios;
	}

	public void setIdAsignarHorarios(Integer idAsignarHorarios) {
		this.idAsignarHorarios = idAsignarHorarios;
	}

	public String getEstadoH() {
		return this.estadoH;
	}

	public void setEstadoH(String estadoH) {
		this.estadoH = estadoH;
	}

	public Time getHoraFinNumero() {
		return this.horaFinNumero;
	}

	public void setHoraFinNumero(Time horaFinNumero) {
		this.horaFinNumero = horaFinNumero;
	}

	public Time getHoraInicioNumero() {
		return this.horaInicioNumero;
	}

	public void setHoraInicioNumero(Time horaInicioNumero) {
		this.horaInicioNumero = horaInicioNumero;
	}

	public Time getHorasFinEspacio() {
		return this.horasFinEspacio;
	}

	public void setHorasFinEspacio(Time horasFinEspacio) {
		this.horasFinEspacio = horasFinEspacio;
	}

	public Time getHorasInicioEspacio() {
		return this.horasInicioEspacio;
	}

	public void setHorasInicioEspacio(Time horasInicioEspacio) {
		this.horasInicioEspacio = horasInicioEspacio;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}