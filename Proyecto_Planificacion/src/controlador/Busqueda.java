package controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import model.Participante;
import model.ParticipanteDAO;

@SuppressWarnings({ "serial", "rawtypes" })
public class Busqueda extends SelectorComposer{

	@Wire 
	Textbox txtBuscarprincipal;
	
	@Wire 
	private Listbox lstPersonas;

	//Lamar venta de Listarpersonas

	// Instancia el objeto para acceso a datos.
		private ParticipanteDAO personaDao = new ParticipanteDAO();

		private List<Participante> personas;

		private Participante personaSelecionada;
		
		
		@Listen("onOK=#txtBuscarprincipal")
		public void buscar(){
			//System.out.println("INGRESO");

			personas = personaDao.getPersonas(txtBuscarprincipal.getValue());

			lstPersonas.setModel(new ListModelList(personas));
			//Limpiar
			personaSelecionada = null;
		}

		
		
		//Getters and Setters
		
		public List<Participante> getPersonas() {
			return personas;
		}


		public void setPersonas(List<Participante> personas) {
			this.personas = personas;
		}
		
		
}       
