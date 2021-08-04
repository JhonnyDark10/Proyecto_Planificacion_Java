package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comisiones database table.
 * 
 */
@Entity
@Table(name="comisiones")
@NamedQuery(name="Comisione.findAll", query="SELECT c FROM Comisione c")
public class Comisione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comisiones")
	private Integer idComisiones;

	private String descripcion;

	@Column(name="estado_c")
	private String estadoC;

	//bi-directional many-to-one association to ComisionesParticipante
	@OneToMany(mappedBy="comisione")
	private List<ComisionesParticipante> comisionesParticipantes;

	public Comisione() {
	}

	public Integer getIdComisiones() {
		return this.idComisiones;
	}

	public void setIdComisiones(Integer idComisiones) {
		this.idComisiones = idComisiones;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoC() {
		return this.estadoC;
	}

	public void setEstadoC(String estadoC) {
		this.estadoC = estadoC;
	}

	public List<ComisionesParticipante> getComisionesParticipantes() {
		return this.comisionesParticipantes;
	}

	public void setComisionesParticipantes(List<ComisionesParticipante> comisionesParticipantes) {
		this.comisionesParticipantes = comisionesParticipantes;
	}

	public ComisionesParticipante addComisionesParticipante(ComisionesParticipante comisionesParticipante) {
		getComisionesParticipantes().add(comisionesParticipante);
		comisionesParticipante.setComisione(this);

		return comisionesParticipante;
	}

	public ComisionesParticipante removeComisionesParticipante(ComisionesParticipante comisionesParticipante) {
		getComisionesParticipantes().remove(comisionesParticipante);
		comisionesParticipante.setComisione(null);

		return comisionesParticipante;
	}

}