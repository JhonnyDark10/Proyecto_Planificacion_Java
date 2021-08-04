package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import model.Indisponibilidad;

import model.ClaseDAO;
public class IndisponibilidadDAO extends ClaseDAO {

	
	public List<Indisponibilidad> getindisponibilidades(){
		List<Indisponibilidad> retorno = new ArrayList<Indisponibilidad>();
		
		Query query = getEntityManager().createNamedQuery("Indisponibilidad.findAll");
		retorno = (List<Indisponibilidad>) query.getResultList();
		return retorno;
	}
	
	
}
