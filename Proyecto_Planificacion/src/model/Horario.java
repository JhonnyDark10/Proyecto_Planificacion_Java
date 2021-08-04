package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horarios database table.
 * 
 */
@Entity
@Table(name="horarios")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horarios")
	private Integer idHorarios;

	private String descripcion;

	@Column(name="estado_h")
	private String estadoH;

	//bi-directional many-to-one association to AsignarHorario
	@OneToMany(mappedBy="horario")
	private List<AsignarHorario> asignarHorarios;

	public Horario() {
	}

	public Integer getIdHorarios() {
		return this.idHorarios;
	}

	public void setIdHorarios(Integer idHorarios) {
		this.idHorarios = idHorarios;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoH() {
		return this.estadoH;
	}

	public void setEstadoH(String estadoH) {
		this.estadoH = estadoH;
	}

	public List<AsignarHorario> getAsignarHorarios() {
		return this.asignarHorarios;
	}

	public void setAsignarHorarios(List<AsignarHorario> asignarHorarios) {
		this.asignarHorarios = asignarHorarios;
	}

	public AsignarHorario addAsignarHorario(AsignarHorario asignarHorario) {
		getAsignarHorarios().add(asignarHorario);
		asignarHorario.setHorario(this);

		return asignarHorario;
	}

	public AsignarHorario removeAsignarHorario(AsignarHorario asignarHorario) {
		getAsignarHorarios().remove(asignarHorario);
		asignarHorario.setHorario(null);

		return asignarHorario;
	}

}