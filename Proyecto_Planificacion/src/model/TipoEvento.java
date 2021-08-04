package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_evento database table.
 * 
 */
@Entity
@Table(name="tipo_evento")
@NamedQuery(name="TipoEvento.findAll", query="SELECT t FROM TipoEvento t")
public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_evento")
	private Integer idTipoEvento;

	private String descripcion;

	@Column(name="estado_m")
	private String estadoM;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="tipoEvento")
	private List<Evento> eventos;

	public TipoEvento() {
	}

	public Integer getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(Integer idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoM() {
		return this.estadoM;
	}

	public void setEstadoM(String estadoM) {
		this.estadoM = estadoM;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setTipoEvento(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setTipoEvento(null);

		return evento;
	}

}