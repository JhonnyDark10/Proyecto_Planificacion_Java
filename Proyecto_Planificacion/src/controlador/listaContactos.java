package controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.LabelElement;



import model.Contacto;
import model.ContactoDAO;

@SuppressWarnings({ "serial", "rawtypes" })
public class listaContactos extends SelectorComposer{

	@Wire 
	Textbox txtBuscar;

	@Wire 
	private Listbox lstPersonas;

	//Lamar venta de Listarpersonas
	@Wire
	Window winListaPersonas;

	// Instancia el objeto para acceso a datos.
		private ContactoDAO personaDao = new ContactoDAO();

		private List<Contacto> personas;

		private Contacto personaSelecionada;
		
		
		@Listen("onClick=#btnBuscar;onOK=#txtBuscar")
		public void buscar(){
			//System.out.println("INGRESO");

			if (personas != null) {
				personas = null; 
			}

			personas = personaDao.getPersonas(txtBuscar.getValue());

			lstPersonas.setModel(new ListModelList(personas));

			//Limpiar
			personaSelecionada = null;
		}

		
		//Getters and Setters
		
		public List<Contacto> getPersonas() {
			return personas;
		}


		public void setPersonas(List<Contacto> personas) {
			this.personas = personas;
		}
		
		//Escucha evento
		@Listen("onClick=#btnNuevo")
		public void nuevo(){

			//Enviar por parametros - para editar persona 
			Map<String, Object> params = new HashMap<String, Object>(); //Objeto Paramn tipo de objeto hasMap
			params.put("Contacto", null);
			params.put("VentanaPadre", this);


			Window ventanaCargar = (Window)Executions.createComponents("/Z-Contactos/contactos.zul", winListaPersonas,params);
			ventanaCargar.doModal();
		}
		
		
		//Editar persona 
		@Listen("onClick=#btnEditar")
		public void editar(){

			if(personaSelecionada == null){
				Clients.showNotification("Seleccione Persona a Editar");
				return;
			}

			//Actualiza la instancia antes de editar
			personaDao.getEntityManager().refresh(personaSelecionada);//berifica el ultimo valor en la BD

			//Enviar por parametros - para editar persona 
			Map<String, Object> params = new HashMap<String, Object>(); //Objeto Paramn tipo de objeto hasMap
			params.put("Contacto", personaSelecionada);
			params.put("VentanaPadre", this);

			Window ventanaCargar = (Window)Executions.createComponents("/Z-Contactos/contactos.zul", winListaPersonas,params);
			ventanaCargar.doModal();
		}

		//Get y Set de persona Seleccinada
		public Contacto getPersonaSelecionada() {
			return personaSelecionada;
		}

		public void setPersonaSelecionada(Contacto personaSelecionada) {
			this.personaSelecionada = personaSelecionada;
		}
		
		//*********************ELIMINAR*************************
		/**
		 * Escucha el evento "onClick" del objeto "btnEliminar"
		 * Elimina logicamente una persona.
		 */
		@Listen("onClick=#btnEliminar")
		public void eliminar(){

			if (personaSelecionada == null) {
				Clients.showNotification("Debe seleccionar una persona");
				return;

			}

			Messagebox.show("Desea Eliminar el Registro Seleccionado", "COnfirmacion de Eliminar", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION, new EventListener<Event>() {

				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals("onYes")) {
						try {
							//personaSeleccionada.setEstado("X");
							personaSelecionada.setEstadoC("X");
							personaDao.getEntityManager().getTransaction().begin();
							personaDao.getEntityManager().persist(personaSelecionada);
							personaDao.getEntityManager().getTransaction().commit();;
							Clients.showNotification("Transaccion ejecutada con exito.");
							buscar();
						} catch (Exception e) {
							e.printStackTrace();
							personaDao.getEntityManager().getTransaction().rollback();
						}
					}


				}
			});

		}  
		
		
	
		
				
	
}       
