package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import controlador.listaContactos;
import model.TipoCliente;
import model.TipoClienteDAO;
import model.Contacto; 
import model.ContactoDAO; 

public class EditarContactos extends SelectorComposer {

		 
	
	//Objeto de PaisDAO
		private TipoClienteDAO paisDao = new TipoClienteDAO();
		
		// Para poder Grabar
		ContactoDAO personaDao = new ContactoDAO();
		private Contacto persona;
		
		//COntiene la ventana padre para invocar a la actualizacion
		private listaContactos personaLista;
		

		//CLick derecho source crear implementmetodo,  do after compose
		//Levante la ventana crear un objeto persona vacio para ingresar dato
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			//Reecupera la Ventana Padre
			personaLista = (listaContactos)Executions.getCurrent().getArg().get("VentanaPadre");
			
			persona=null;
			if(Executions.getCurrent().getArg().get("Contacto")!=null){
				//Recupera Persona selecionada 
				persona = (Contacto)Executions.getCurrent().getArg().get("Contacto");
			}else{
				//Persona Nueva
				persona = new Contacto();
			}
			
			
			
		}
		
		//Boton salir
		@Wire Window winContactos;
		
		@Listen("onClick=#salir")
		public void salir(){
			winContactos.detach();
		
		}


		@Listen("onClick=#grabar")
		public void grabar(){
			
			try {
				personaDao.getEntityManager().getTransaction().begin();
				//Almacena Datos
				
				if(persona.getDniCliente()== null){
					//Si es nuevo "persist"
					personaDao.getEntityManager().persist(persona);
				}else{
					persona = (Contacto) personaDao.getEntityManager().merge(persona);
					
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
		public List<TipoCliente> getPaises(){
			
			return paisDao.getPaises();
			
		}
		
		//Get y Set
		public Contacto getPersona() {
			return persona;
		}


		public void setPersona(Contacto persona) {
			this.persona = persona;
		}
		

	
}
