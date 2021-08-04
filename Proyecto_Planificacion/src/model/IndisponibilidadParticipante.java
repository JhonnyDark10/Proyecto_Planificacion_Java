package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the indisponibilidad_participante database table.
 * 
 */
@Entity
@Table(name="indisponibilidad_participante")
@NamedQuery(name="IndisponibilidadParticipante.findAll", query="SELECT i FROM IndisponibilidadParticipante i")
public class IndisponibilidadParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dni_indisponibilidad_p")
	private Integer dniIndisponibilidadP;

	private String descripcion;

	@Column(name="estado_i")
	private String estadoI;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="hora_fin")
	private Time horaFin;

	@Column(name="hora_inicio")
	private Time horaInicio;

	//bi-directional many-to-one association to Indisponibilidad
	@ManyToOne
	@JoinColumn(name="fk_indisponibilidad")
	private Indisponibilidad indisponibilidad;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="fk_participante")
	private Participante participante;

	public IndisponibilidadParticipante() {
	}

	public Integer getDniIndisponibilidadP() {
		return this.dniIndisponibilidadP;
	}

	public void setDniIndisponibilidadP(Integer dniIndisponibilidadP) {
		this.dniIndisponibilidadP = dniIndisponibilidadP;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoI() {
		return this.estadoI;
	}

	public void setEstadoI(String estadoI) {
		this.estadoI = estadoI;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Indisponibilidad getIndisponibilidad() {
		return this.indisponibilidad;
	}

	public void setIndisponibilidad(Indisponibilidad indisponibilidad) {
		this.indisponibilidad = indisponibilidad;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}