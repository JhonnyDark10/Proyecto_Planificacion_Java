package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import model.TipoEvento;

import model.ClaseDAO;
public class TipoEventoDao extends ClaseDAO {

	
	public List<TipoEvento> getindisponibilidades(){
		List<TipoEvento> retorno = new ArrayList<TipoEvento>();
		
		Query query = getEntityManager().createNamedQuery("TipoEvento.findAll");
		retorno = (List<TipoEvento>) query.getResultList();
		return retorno;
	}
	
	
}
