package model;

import java.util.List;

import javax.persistence.Query;

public class EventoDao extends ClaseDAO{

	/**
	 * Busca personas en base a un patron de busqueda.
	 * @param value
	 * @return
	 */
	public List<Evento> getPersonas(String value) {
		List<Evento> resultado; 
	
		// Crea la consulta.
		Query query = getEntityManager().createNamedQuery("Evento.findAll");
		
		// Para asegurar que la consulta trae lo ultimo de la base.
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		
		// Recupera los resultados.
		resultado = (List<Evento>) query.getResultList();
		
		return resultado;
	}
}