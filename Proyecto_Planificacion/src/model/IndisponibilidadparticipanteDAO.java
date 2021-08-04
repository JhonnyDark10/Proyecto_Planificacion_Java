package model;

import java.util.List;

import javax.persistence.Query;

public class IndisponibilidadparticipanteDAO extends ClaseDAO{

	/**
	 * Busca personas en base a un patron de busqueda.
	 * @param value
	 * @return
	 */
	public List<IndisponibilidadParticipante> getPersonas(String value) {
		List<IndisponibilidadParticipante> resultado; 
	
		// Crea la consulta.
		Query query = getEntityManager().createNamedQuery("IndisponibilidadParticipante.findAll");
		
		// Para asegurar que la consulta trae lo ultimo de la base.
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		
		// Recupera los resultados.
		resultado = (List<IndisponibilidadParticipante>) query.getResultList();
		
		return resultado;
	}
}
