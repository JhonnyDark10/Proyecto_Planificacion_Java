package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="eventos")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evento")
	private Integer idEvento;

	private String descripcion;
    
	private String hora;
	
	
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	@Column(name="estado_e")
	private String estadoE;

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

	//bi-directional many-to-one association to CategoriaEvento
	@ManyToOne
	@JoinColumn(name="fk_categoria_evento")
	private CategoriaEvento categoriaEvento;
	

	
	//bi-directional many-to-one association to CategoriaEvento AQU MODIFCIUQE PEJAJAJAJ
		@ManyToOne
		@JoinColumn(name="fkempleado")
		private Participante participante;
		
	
	public Participante getParticipante() {
			return this.participante;
		}

		public void setParticipante(Participante participante) {
			this.participante = participante;
		}

	
	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Contacto contacto;

	//bi-directional many-to-one association to TipoEvento
	@ManyToOne
	@JoinColumn(name="fk_dni_tipo_evento")
	private TipoEvento tipoEvento;

	//bi-directional many-to-one association to EventosMateriale
	@OneToMany(mappedBy="evento")
	private List<EventosMateriale> eventosMateriales;

	//bi-directional many-to-one association to EventosParticipante
	@OneToMany(mappedBy="evento")
	private List<EventosParticipante> eventosParticipantes;

	public Evento() {
	}

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoE() {
		return this.estadoE;
	}

	public void setEstadoE(String estadoE) {
		this.estadoE = estadoE;
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

	public CategoriaEvento getCategoriaEvento() {
		return this.categoriaEvento;
	}

	public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
		this.categoriaEvento = categoriaEvento;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<EventosMateriale> getEventosMateriales() {
		return this.eventosMateriales;
	}

	public void setEventosMateriales(List<EventosMateriale> eventosMateriales) {
		this.eventosMateriales = eventosMateriales;
	}

	public EventosMateriale addEventosMateriale(EventosMateriale eventosMateriale) {
		getEventosMateriales().add(eventosMateriale);
		eventosMateriale.setEvento(this);

		return eventosMateriale;
	}

	public EventosMateriale removeEventosMateriale(EventosMateriale eventosMateriale) {
		getEventosMateriales().remove(eventosMateriale);
		eventosMateriale.setEvento(null);

		return eventosMateriale;
	}

	public List<EventosParticipante> getEventosParticipantes() {
		return this.eventosParticipantes;
	}

	public void setEventosParticipantes(List<EventosParticipante> eventosParticipantes) {
		this.eventosParticipantes = eventosParticipantes;
	}

	public EventosParticipante addEventosParticipante(EventosParticipante eventosParticipante) {
		getEventosParticipantes().add(eventosParticipante);
		eventosParticipante.setEvento(this);

		return eventosParticipante;
	}

	public EventosParticipante removeEventosParticipante(EventosParticipante eventosParticipante) {
		getEventosParticipantes().remove(eventosParticipante);
		eventosParticipante.setEvento(null);

		return eventosParticipante;
	}

}