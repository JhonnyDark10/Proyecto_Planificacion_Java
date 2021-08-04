package model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.AdditionalCriteria;

import java.util.Date;


/**
 * The persistent class for the dias_festivos database table.
 * 
 */
@Entity
@Table(name="dias_festivos")
@NamedQueries({
	@NamedQuery(name="DiasFestivo.buscarPorPatron", 
	            query="SELECT d FROM DiasFestivo d "
	            		+ "WHERE LOWER(d.descripcion) LIKE :patron ")
})
@AdditionalCriteria("this.estadoF IS NULL")
public class DiasFestivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dias_festivos")
	private Integer idDiasFestivos;

	private String descripcion;

	@Column(name="estado_f")
	private String estadoF;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pedido")
	private Date fechaPedido;

	public DiasFestivo() {
	}

	public Integer getIdDiasFestivos() {
		return this.idDiasFestivos;
	}

	public void setIdDiasFestivos(Integer idDiasFestivos) {
		this.idDiasFestivos = idDiasFestivos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoF() {
		return this.estadoF;
	}

	public void setEstadoF(String estadoF) {
		this.estadoF = estadoF;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

}