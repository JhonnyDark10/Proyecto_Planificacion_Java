package model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.AdditionalCriteria;

import java.util.List;


/**
 * The persistent class for the participantes database table.
 * 
 */
@Entity
@Table(name="participantes")
@NamedQueries({
	@NamedQuery(name="Participante.buscarPorPatron", 
	            query="SELECT p FROM Participante p "
	            		+ "WHERE LOWER(p.nombre) LIKE :patron "),
	@NamedQuery(name="Participante.findAll", 
    query="SELECT p FROM Participante p")
}
)
@AdditionalCriteria("this.estadoP IS NULL")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dni_participantes")
	private Integer dniParticipantes;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	private String cedula;

	private String celular;

	private String ciudad;

	private String descripcion;

	private String direccion;

	private String email;

	@Column(name="estado_p")
	private String estadoP;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to AsignarHorario
	@OneToMany(mappedBy="participante")
	private List<AsignarHorario> asignarHorarios;

	//bi-directional many-to-one association to ComisionesParticipante
	@OneToMany(mappedBy="participante")
	private List<ComisionesParticipante> comisionesParticipantes;

	//bi-directional many-to-one association to EventosParticipante
	@OneToMany(mappedBy="participante")
	private List<EventosParticipante> eventosParticipantes;

	//bi-directional many-to-one association to EventoAQUI MODIFICQUE JAJAJAJA
		@OneToMany(mappedBy="participante")
		private List<Evento> eventos;
	
	//bi-directional many-to-one association to IndisponibilidadParticipante
	@OneToMany(mappedBy="participante")
	private List<IndisponibilidadParticipante> indisponibilidadParticipantes;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="fk_id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to EstadoCivil
	@ManyToOne
	@JoinColumn(name="fk_id_estado_civil")
	private EstadoCivil estadoCivil;

	public Participante() {
	}

	public Integer getDniParticipantes() {
		return this.dniParticipantes;
	}

	public void setDniParticipantes(Integer dniParticipantes) {
		this.dniParticipantes = dniParticipantes;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoP() {
		return this.estadoP;
	}

	public void setEstadoP(String estadoP) {
		this.estadoP = estadoP;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<AsignarHorario> getAsignarHorarios() {
		return this.asignarHorarios;
	}

	public void setAsignarHorarios(List<AsignarHorario> asignarHorarios) {
		this.asignarHorarios = asignarHorarios;
	}

	public AsignarHorario addAsignarHorario(AsignarHorario asignarHorario) {
		getAsignarHorarios().add(asignarHorario);
		asignarHorario.setParticipante(this);

		return asignarHorario;
	}

	public AsignarHorario removeAsignarHorario(AsignarHorario asignarHorario) {
		getAsignarHorarios().remove(asignarHorario);
		asignarHorario.setParticipante(null);

		return asignarHorario;
	}

	public List<ComisionesParticipante> getComisionesParticipantes() {
		return this.comisionesParticipantes;
	}

	public void setComisionesParticipantes(List<ComisionesParticipante> comisionesParticipantes) {
		this.comisionesParticipantes = comisionesParticipantes;
	}

	public ComisionesParticipante addComisionesParticipante(ComisionesParticipante comisionesParticipante) {
		getComisionesParticipantes().add(comisionesParticipante);
		comisionesParticipante.setParticipante(this);

		return comisionesParticipante;
	}

	public ComisionesParticipante removeComisionesParticipante(ComisionesParticipante comisionesParticipante) {
		getComisionesParticipantes().remove(comisionesParticipante);
		comisionesParticipante.setParticipante(null);

		return comisionesParticipante;
	}

	public List<EventosParticipante> getEventosParticipantes() {
		return this.eventosParticipantes;
	}

	public void setEventosParticipantes(List<EventosParticipante> eventosParticipantes) {
		this.eventosParticipantes = eventosParticipantes;
	}

	public EventosParticipante addEventosParticipante(EventosParticipante eventosParticipante) {
		getEventosParticipantes().add(eventosParticipante);
		eventosParticipante.setParticipante(this);

		return eventosParticipante;
	}

	public EventosParticipante removeEventosParticipante(EventosParticipante eventosParticipante) {
		getEventosParticipantes().remove(eventosParticipante);
		eventosParticipante.setParticipante(null);

		return eventosParticipante;
	}

	public List<IndisponibilidadParticipante> getIndisponibilidadParticipantes() {
		return this.indisponibilidadParticipantes;
	}

	public void setIndisponibilidadParticipantes(List<IndisponibilidadParticipante> indisponibilidadParticipantes) {
		this.indisponibilidadParticipantes = indisponibilidadParticipantes;
	}

	public IndisponibilidadParticipante addIndisponibilidadParticipante(IndisponibilidadParticipante indisponibilidadParticipante) {
		getIndisponibilidadParticipantes().add(indisponibilidadParticipante);
		indisponibilidadParticipante.setParticipante(this);

		return indisponibilidadParticipante;
	}

	public IndisponibilidadParticipante removeIndisponibilidadParticipante(IndisponibilidadParticipante indisponibilidadParticipante) {
		getIndisponibilidadParticipantes().remove(indisponibilidadParticipante);
		indisponibilidadParticipante.setParticipante(null);

		return indisponibilidadParticipante;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}