package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import model.Indisponibilidad;
import model.IndisponibilidadDAO;
import model.Participante;
import model.ParticipanteDAO;
import model.ParticipanteDao1;

import model.IndisponibilidadParticipante;
import model.IndisponibilidadparticipanteDAO;



public class Indisponibilidades extends SelectorComposer {

		 
	
	//Objeto de PaisDAO
		private IndisponibilidadDAO paisDao = new IndisponibilidadDAO();
		private ParticipanteDao1 paisDao1 = new ParticipanteDao1();
		// Para poder Grabar
		IndisponibilidadparticipanteDAO personaDao = new IndisponibilidadparticipanteDAO();
		private IndisponibilidadParticipante persona;
				

		//CLick derecho source crear implementmetodo,  do after compose
		//Levante la ventana crear un objeto persona vacio para ingresar dato
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			
			persona=null;
			if(Executions.getCurrent().getArg().get("IndisponibilidadParticipante")!=null){
				//Recupera Persona selecionada 
				persona = (IndisponibilidadParticipante)Executions.getCurrent().getArg().get("IndisponibilidadParticipante");
			}else{
				//Persona Nueva
				persona = new IndisponibilidadParticipante();
			}
			
			
			
		}
		
		//Boton salir
		@Wire Window winParticipantes;
		
		@Listen("onClick=#salir")
		public void salir(){
			winParticipantes.detach();
		
		}


		@Listen("onClick=#grabar")
		public void grabar(){
			
			try {
				personaDao.getEntityManager().getTransaction().begin();
				//Almacena Datos
				if(persona.getDniIndisponibilidadP()== null){
					//Si es nuevo "persist"
					personaDao.getEntityManager().persist(persona);
				}else{
					persona = (IndisponibilidadParticipante) personaDao.getEntityManager().merge(persona);
					
				}

				//cierra la transaccion
				personaDao.getEntityManager().getTransaction().commit();
				Clients.showNotification("Grabado con Exito");
				salir();
				
			} catch (Exception e) {
				//Si hay error, revierte la transaccion
				personaDao.getEntityManager().getTransaction().rollback();
				
			}
		}
		
		
		//Devuelve todo los Paises
		public List<Indisponibilidad> getPaises(){
			
			return paisDao.getindisponibilidades();
			
		}
		
         
		public List<Participante> getCivil(){
			
			return paisDao1.getCivil();
			
		}
		
		//Get y Set
		public IndisponibilidadParticipante getPersona() {
			return persona;
		}


		public void setPersona(IndisponibilidadParticipante persona) {
			this.persona = persona;
		}
		

	
}
