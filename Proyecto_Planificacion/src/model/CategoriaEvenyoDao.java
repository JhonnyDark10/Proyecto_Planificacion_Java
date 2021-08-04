package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import model.CategoriaEvento;

import model.ClaseDAO;
public class CategoriaEvenyoDao extends ClaseDAO {

	
	public List<CategoriaEvento> getEcat(){
		List<CategoriaEvento> retorno = new ArrayList<CategoriaEvento>();
		
		Query query = getEntityManager().createNamedQuery("CategoriaEvento.findAll");
		retorno = (List<CategoriaEvento>) query.getResultList();
		return retorno;
	}
	
	
}
