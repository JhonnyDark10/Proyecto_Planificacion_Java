package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import model.Materiale;
import model.MaterialesDAO;



public class EditarMateriales extends SelectorComposer {

		 
	

		// Para poder Grabar
		MaterialesDAO personaDao = new MaterialesDAO();
		private Materiale persona;
		
		//COntiene la ventana padre para invocar a la actualizacion
		private listaMateriales personaLista;
		

		//CLick derecho source crear implementmetodo,  do after compose
		//Levante la ventana crear un objeto persona vacio para ingresar dato
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			//Reecupera la Ventana Padre
			personaLista = (listaMateriales)Executions.getCurrent().getArg().get("VentanaPadre");
			
			persona=null;
			if(Executions.getCurrent().getArg().get("Materiale")!=null){
				//Recupera Persona selecionada 
				persona = (Materiale)Executions.getCurrent().getArg().get("Materiale");
			}else{
				//Persona Nueva
				persona = new Materiale();
			}
			
			
			
		}
		
		//Boton salir
		@Wire Window winMateriales;
		
		@Listen("onClick=#salir")
		public void salir(){
			winMateriales.detach();
		
		}


		@Listen("onClick=#grabar")
		public void grabar(){
			
			try {
				personaDao.getEntityManager().getTransaction().begin();
				//Almacena Datos
				
				if(persona.getIdMateriales()== null){
					//Si es nuevo "persist"
					personaDao.getEntityManager().persist(persona);
				}else{
					persona = (Materiale) personaDao.getEntityManager().merge(persona);
					
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
		
		
			
		//Get y Set
		public Materiale getPersona() {
			return persona;
		}


		public void setPersona(Materiale persona) {
			this.persona = persona;
		}
		

	
}
