package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Departamento;

import model.ClaseDAO;

public class DepartamentoDao extends ClaseDAO {

	//Metodos para que retorne todo los tipos de clientes 
		public List<Departamento> getPaises(){
			List<Departamento> retorno = new ArrayList<Departamento>();
			
			//Hacer el Query
			Query query = getEntityManager().createNamedQuery("Departamento.findAll");
			retorno = (List<Departamento>)query.getResultList();
			
			return retorno;
		}
	
}
