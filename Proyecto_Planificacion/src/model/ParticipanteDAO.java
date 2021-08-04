package model;

import java.util.List;

import javax.persistence.Query;

public class ParticipanteDAO extends ClaseDAO{

	/**
	 * Busca personas en base a un patron de busqueda.
	 * @param value
	 * @return
	 */
	public List<Participante> getPersonas(String value) {
		List<Participante> resultado; 
		String patron = value;

		// Adapta el patron de busqueda.
		if (value == null || value.length() == 0) {
			patron = "%";
		}else{
			patron = "%" + patron.toLowerCase() + "%";
		}

		// Crea la consulta.
		Query query = getEntityManager().createNamedQuery("Participante.buscarPorPatron");
		
		// Para asegurar que la consulta trae lo ultimo de la base.
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		// Asigna el patron de busqueda
		query.setParameter("patron", patron);
		
		// Recupera los resultados.
		resultado = (List<Participante>) query.getResultList();
		
		return resultado;
	}
}

