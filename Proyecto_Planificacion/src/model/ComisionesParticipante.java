package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comisiones_participantes database table.
 * 
 */
@Entity
@Table(name="comisiones_participantes")
@NamedQuery(name="ComisionesParticipante.findAll", query="SELECT c FROM ComisionesParticipante c")
public class ComisionesParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comisiones_participantes")
	private Integer idComisionesParticipantes;

	private String descripcion;

	@Column(name="estado_c_p")
	private String estadoCP;

	//bi-directional many-to-one association to Comisione
	@ManyToOne
	@JoinColumn(name="fk_comisiones")
	private Comisione comisione;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="fk_participantes")
	private Participante participante;

	public ComisionesParticipante() {
	}

	public Integer getIdComisionesParticipantes() {
		return this.idComisionesParticipantes;
	}

	public void setIdComisionesParticipantes(Integer idComisionesParticipantes) {
		this.idComisionesParticipantes = idComisionesParticipantes;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoCP() {
		return this.estadoCP;
	}

	public void setEstadoCP(String estadoCP) {
		this.estadoCP = estadoCP;
	}

	public Comisione getComisione() {
		return this.comisione;
	}

	public void setComisione(Comisione comisione) {
		this.comisione = comisione;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}