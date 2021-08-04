package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.TipoCliente;

import model.ClaseDAO;

public class TipoClienteDAO extends ClaseDAO {

	//Metodos para que retorne todo los tipos de clientes 
		public List<TipoCliente> getPaises(){
			List<TipoCliente> retorno = new ArrayList<TipoCliente>();
			
			//Hacer el Query
			Query query = getEntityManager().createNamedQuery("TipoCliente.findAll");
			retorno = (List<TipoCliente>)query.getResultList();
			
			return retorno;
		}

	
}
