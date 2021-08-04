package model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.AdditionalCriteria;

import java.util.List;


/**
 * The persistent class for the materiales database table.
 * 
 */
@Entity
@Table(name="materiales")
@NamedQueries({
	@NamedQuery(name="Materiale.buscarPorPatron", 
	            query="SELECT m FROM Materiale m "
	            		+ "WHERE LOWER(m.nombre) LIKE :patron ")
})
@AdditionalCriteria("this.estadoM IS NULL")
public class Materiale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materiales")
	private Integer idMateriales;

	@Column(name="cantidad_m")
	private Integer cantidadM;

	private String descripcion;

	@Column(name="estado_m")
	private String estadoM;

	private String nombre;

	//bi-directional many-to-one association to EventosMateriale
	@OneToMany(mappedBy="materiale")
	private List<EventosMateriale> eventosMateriales;

	public Materiale() {
	}

	public Integer getIdMateriales() {
		return this.idMateriales;
	}

	public void setIdMateriales(Integer idMateriales) {
		this.idMateriales = idMateriales;
	}

	public Integer getCantidadM() {
		return this.cantidadM;
	}

	public void setCantidadM(Integer cantidadM) {
		this.cantidadM = cantidadM;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EventosMateriale> getEventosMateriales() {
		return this.eventosMateriales;
	}

	public void setEventosMateriales(List<EventosMateriale> eventosMateriales) {
		this.eventosMateriales = eventosMateriales;
	}

	public EventosMateriale addEventosMateriale(EventosMateriale eventosMateriale) {
		getEventosMateriales().add(eventosMateriale);
		eventosMateriale.setMateriale(this);

		return eventosMateriale;
	}

	public EventosMateriale removeEventosMateriale(EventosMateriale eventosMateriale) {
		getEventosMateriales().remove(eventosMateriale);
		eventosMateriale.setMateriale(null);

		return eventosMateriale;
	}

}