package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import model.DiasFestivo;
import model.DiasFestivoDAO;



public class EditarFeriados extends SelectorComposer {

		 
	

		// Para poder Grabar
		DiasFestivoDAO personaDao = new DiasFestivoDAO();
		private DiasFestivo persona;
		
		//COntiene la ventana padre para invocar a la actualizacion
		private listaFeriados personaLista;
		

		//CLick derecho source crear implementmetodo,  do after compose
		//Levante la ventana crear un objeto persona vacio para ingresar dato
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			//Reecupera la Ventana Padre
			personaLista = (listaFeriados)Executions.getCurrent().getArg().get("VentanaPadre");
			
			persona=null;
			if(Executions.getCurrent().getArg().get("DiasFestivo")!=null){
				//Recupera Persona selecionada 
				persona = (DiasFestivo)Executions.getCurrent().getArg().get("DiasFestivo");
			}else{
				//Persona Nueva
				persona = new DiasFestivo();
			}
			
			
			
		}
		
		//Boton salir
		@Wire Window winFeriados;
		
		@Listen("onClick=#salir")
		public void salir(){
			winFeriados.detach();
		
		}


		@Listen("onClick=#grabar")
		public void grabar(){
			
			try {
				personaDao.getEntityManager().getTransaction().begin();
				//Almacena Datos
				
				if(persona.getIdDiasFestivos()== null){
					//Si es nuevo "persist"
					personaDao.getEntityManager().persist(persona);
				}else{
					persona = (DiasFestivo) personaDao.getEntityManager().merge(persona);
					
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
		public DiasFestivo getPersona() {
			return persona;
		}


		public void setPersona(DiasFestivo persona) {
			this.persona = persona;
		}
		

	
}
