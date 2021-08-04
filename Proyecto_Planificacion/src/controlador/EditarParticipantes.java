package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import model.Departamento;
import model.DepartamentoDao;
import model.EstadoCivil;
import model.EstadoCivilDAO;
import model.Participante;
import model.ParticipanteDAO;


public class EditarParticipantes extends SelectorComposer {

		 
	
	//Objeto de PaisDAO
		private DepartamentoDao paisDao = new DepartamentoDao();
		private EstadoCivilDAO paisDao1 = new EstadoCivilDAO();
		// Para poder Grabar
		ParticipanteDAO personaDao = new ParticipanteDAO();
		private Participante persona;
		
		//COntiene la ventana padre para invocar a la actualizacion
		private listaParticipantes personaLista;
		

		//CLick derecho source crear implementmetodo,  do after compose
		//Levante la ventana crear un objeto persona vacio para ingresar dato
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			//Reecupera la Ventana Padre
			personaLista = (listaParticipantes)Executions.getCurrent().getArg().get("VentanaPadre");
			
			persona=null;
			if(Executions.getCurrent().getArg().get("Participante")!=null){
				//Recupera Persona selecionada 
				persona = (Participante)Executions.getCurrent().getArg().get("Participante");
			}else{
				//Persona Nueva
				persona = new Participante();
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
				
				if(persona.getDniParticipantes()== null){
					//Si es nuevo "persist"
					personaDao.getEntityManager().persist(persona);
				}else{
					persona = (Participante) personaDao.getEntityManager().merge(persona);
					
				}
				

				//cierra la transaccion
				personaDao.getEntityManager().getTransaction().commit();
				Clients.showNotification("Grabado con Exito");
				
				salir();
				personaLista.buscar();
				
			} catch (Exception e) {
				//Si hay error, revierte la transaccion
				personaDao.getEntityManager().getTransaction().rollback();
				
			}
		}
		
		
		//Devuelve todo los Paises
		public List<Departamento> getPaises(){
			
			return paisDao.getPaises();
			
		}
		
           public List<EstadoCivil> getCivil(){
			
			return paisDao1.getCivil();
			
		}
		
		//Get y Set
		public Participante getPersona() {
			return persona;
		}


		public void setPersona(Participante persona) {
			this.persona = persona;
		}
		

	
}
