package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventos_materiales database table.
 * 
 */
@Entity
@Table(name="eventos_materiales")
@NamedQuery(name="EventosMateriale.findAll", query="SELECT e FROM EventosMateriale e")
public class EventosMateriale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evento_materiales")
	private Integer idEventoMateriales;

	@Column(name="estado_e_m")
	private String estadoEM;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="fk_dni_eventos1")
	private Evento evento;

	//bi-directional many-to-one association to Materiale
	@ManyToOne
	@JoinColumn(name="fk_dni_materiales")
	private Materiale materiale;

	public EventosMateriale() {
	}

	public Integer getIdEventoMateriales() {
		return this.idEventoMateriales;
	}

	public void setIdEventoMateriales(Integer idEventoMateriales) {
		this.idEventoMateriales = idEventoMateriales;
	}

	public String getEstadoEM() {
		return this.estadoEM;
	}

	public void setEstadoEM(String estadoEM) {
		this.estadoEM = estadoEM;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Materiale getMateriale() {
		return this.materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

}