package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Participante;

import model.ClaseDAO;

public class ParticipanteDao1 extends ClaseDAO {

	//Metodos para que retorne todo los tipos de clientes 
		public List<Participante> getCivil(){
			List<Participante> retorno = new ArrayList<Participante>();
			
			//Hacer el Query
			Query query = getEntityManager().createNamedQuery("Participante.findAll");
			retorno = (List<Participante>)query.getResultList();
			
			return retorno;
		}
	
}