package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_eventos database table.
 * 
 */
@Entity
@Table(name="categoria_eventos")
@NamedQuery(name="CategoriaEvento.findAll", query="SELECT c FROM CategoriaEvento c")
public class CategoriaEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria_eventos")
	private Integer idCategoriaEventos;

	private String descripcion;

	@Column(name="estado_c_e")
	private String estadoCE;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="categoriaEvento")
	private List<Evento> eventos;

	public CategoriaEvento() {
	}

	public Integer getIdCategoriaEventos() {
		return this.idCategoriaEventos;
	}

	public void setIdCategoriaEventos(Integer idCategoriaEventos) {
		this.idCategoriaEventos = idCategoriaEventos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoCE() {
		return this.estadoCE;
	}

	public void setEstadoCE(String estadoCE) {
		this.estadoCE = estadoCE;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setCategoriaEvento(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setCategoriaEvento(null);

		return evento;
	}

}