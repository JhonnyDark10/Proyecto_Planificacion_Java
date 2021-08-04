package model;

import java.util.List;

import javax.persistence.Query;

public class ContactoDAO extends ClaseDAO{

	/**
	 * Busca personas en base a un patron de busqueda.
	 * @param value
	 * @return
	 */
	public List<Contacto> getPersonas(String value) {
		List<Contacto> resultado; 
		String patron = value;

		// Adapta el patron de busqueda.
		if (value == null || value.length() == 0) {
			patron = "%";
		}else{
			patron = "%" + patron.toLowerCase() + "%";
		}

		// Crea la consulta.
		Query query = getEntityManager().createNamedQuery("Contacto.buscarPorPatron");
		
		// Para asegurar que la consulta trae lo ultimo de la base.
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		// Asigna el patron de busqueda
		query.setParameter("patron", patron);
		
		// Recupera los resultados.
		resultado = (List<Contacto>) query.getResultList();
		
		return resultado;
	}
}
