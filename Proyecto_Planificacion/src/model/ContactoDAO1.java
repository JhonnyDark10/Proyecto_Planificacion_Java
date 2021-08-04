package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import model.Contacto;

import model.ClaseDAO;
public class ContactoDAO1 extends ClaseDAO {

	
	public List<Contacto> getContactodos(){
		List<Contacto> retorno = new ArrayList<Contacto>();
		
		Query query = getEntityManager().createNamedQuery("Contacto.findAll");
		retorno = (List<Contacto>) query.getResultList();
		return retorno;
	}
	
	
}
