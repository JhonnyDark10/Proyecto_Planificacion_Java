package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.EstadoCivil;

import model.ClaseDAO;

public class EstadoCivilDAO extends ClaseDAO {

	//Metodos para que retorne todo los tipos de clientes 
		public List<EstadoCivil> getCivil(){
			List<EstadoCivil> retorno = new ArrayList<EstadoCivil>();
			
			//Hacer el Query
			Query query = getEntityManager().createNamedQuery("EstadoCivil.findAll");
			retorno = (List<EstadoCivil>)query.getResultList();
			
			return retorno;
		}
	
}