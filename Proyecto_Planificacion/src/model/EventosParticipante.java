package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventos_participantes database table.
 * 
 */
@Entity
@Table(name="eventos_participantes")
@NamedQuery(name="EventosParticipante.findAll", query="SELECT e FROM EventosParticipante e")
public class EventosParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_eventos_participantes")
	private Integer idEventosParticipantes;

	@Column(name="estado_e_p")
	private String estadoEP;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="fk_dni_eventos2")
	private Evento evento;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="fk_dni_participantes")
	private Participante participante;

	public EventosParticipante() {
	}

	public Integer getIdEventosParticipantes() {
		return this.idEventosParticipantes;
	}

	public void setIdEventosParticipantes(Integer idEventosParticipantes) {
		this.idEventosParticipantes = idEventosParticipantes;
	}

	public String getEstadoEP() {
		return this.estadoEP;
	}

	public void setEstadoEP(String estadoEP) {
		this.estadoEP = estadoEP;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}