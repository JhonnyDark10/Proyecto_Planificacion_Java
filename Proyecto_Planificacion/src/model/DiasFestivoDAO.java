package model;

import java.util.List;

import javax.persistence.Query;

public class DiasFestivoDAO extends ClaseDAO{

	/**
	 * Busca personas en base a un patron de busqueda.
	 * @param value
	 * @return
	 */
	public List<DiasFestivo> getPersonas(String value) {
		List<DiasFestivo> resultado; 
		String patron = value;

		// Adapta el patron de busqueda.
		if (value == null || value.length() == 0) {
			patron = "%";
		}else{
			patron = "%" + patron.toLowerCase() + "%";
		}

		// Crea la consulta.
		Query query = getEntityManager().createNamedQuery("DiasFestivo.buscarPorPatron");
		
		// Para asegurar que la consulta trae lo ultimo de la base.
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		// Asigna el patron de busqueda
		query.setParameter("patron", patron);
		
		// Recupera los resultados.
		resultado = (List<DiasFestivo>) query.getResultList();
		
		return resultado;
	}
}
