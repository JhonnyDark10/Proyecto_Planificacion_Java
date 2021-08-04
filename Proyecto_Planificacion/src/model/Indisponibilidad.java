package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indisponibilidad database table.
 * 
 */
@Entity
@NamedQuery(name="Indisponibilidad.findAll", query="SELECT i FROM Indisponibilidad i")
public class Indisponibilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dni_indisponibilidad")
	private Integer dniIndisponibilidad;

	private String descripcion;

	@Column(name="estado_i")
	private String estadoI;

	//bi-directional many-to-one association to IndisponibilidadParticipante
	@OneToMany(mappedBy="indisponibilidad")
	private List<IndisponibilidadParticipante> indisponibilidadParticipantes;

	public Indisponibilidad() {
	}

	public Integer getDniIndisponibilidad() {
		return this.dniIndisponibilidad;
	}

	public void setDniIndisponibilidad(Integer dniIndisponibilidad) {
		this.dniIndisponibilidad = dniIndisponibilidad;
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

	public List<IndisponibilidadParticipante> getIndisponibilidadParticipantes() {
		return this.indisponibilidadParticipantes;
	}

	public void setIndisponibilidadParticipantes(List<IndisponibilidadParticipante> indisponibilidadParticipantes) {
		this.indisponibilidadParticipantes = indisponibilidadParticipantes;
	}

	public IndisponibilidadParticipante addIndisponibilidadParticipante(IndisponibilidadParticipante indisponibilidadParticipante) {
		getIndisponibilidadParticipantes().add(indisponibilidadParticipante);
		indisponibilidadParticipante.setIndisponibilidad(this);

		return indisponibilidadParticipante;
	}

	public IndisponibilidadParticipante removeIndisponibilidadParticipante(IndisponibilidadParticipante indisponibilidadParticipante) {
		getIndisponibilidadParticipantes().remove(indisponibilidadParticipante);
		indisponibilidadParticipante.setIndisponibilidad(null);

		return indisponibilidadParticipante;
	}

}