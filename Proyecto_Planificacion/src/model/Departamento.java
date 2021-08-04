package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dni_departamento")
	private Integer dniDepartamento;

	private String descripcion;

	@Column(name="estado_d")
	private String estadoD;

	private String nombre;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="departamento")
	private List<Participante> participantes;

	public Departamento() {
	}

	public Integer getDniDepartamento() {
		return this.dniDepartamento;
	}

	public void setDniDepartamento(Integer dniDepartamento) {
		this.dniDepartamento = dniDepartamento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoD() {
		return this.estadoD;
	}

	public void setEstadoD(String estadoD) {
		this.estadoD = estadoD;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setDepartamento(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setDepartamento(null);

		return participante;
	}

}