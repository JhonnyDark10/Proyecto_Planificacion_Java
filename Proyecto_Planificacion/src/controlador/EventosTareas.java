package controlador;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import model.TipoEvento;
import model.TipoEventoDao;
import model.Participante;
import model.ParticipanteDao1;
import model.Contacto;
import model.ContactoDAO1;
import model.CategoriaEvento;
import model.CategoriaEvenyoDao;


import model.Evento;
import model.EventoDao;



public class EventosTareas extends SelectorComposer {



	//Objeto de PaisDAO
	private TipoEventoDao paisDao = new TipoEventoDao();
	private ParticipanteDao1 paisDao1 = new ParticipanteDao1();
	private ContactoDAO1 paisDao2 = new ContactoDAO1();
	private CategoriaEvenyoDao paisDao3 = new CategoriaEvenyoDao();


	// Para poder Grabar
	EventoDao personaDao = new EventoDao();
	private Evento persona;


	//CLick derecho source crear implementmetodo,  do after compose
	//Levante la ventana crear un objeto persona vacio para ingresar dato
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);


		persona=null;
		if(Executions.getCurrent().getArg().get("Evento")!=null){
			//Recupera Persona selecionada 
			persona = (Evento)Executions.getCurrent().getArg().get("Evento");
		}else{
			//Persona Nueva
			persona = new Evento();
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
			if(persona.getIdEvento()== null){
				//Si es nuevo "persist"
				personaDao.getEntityManager().persist(persona);
			}else{
				persona = (Evento) personaDao.getEntityManager().merge(persona);

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
	public List<TipoEvento> getPaises(){

		return paisDao.getindisponibilidades();

	}

	public List<Participante> getCivil(){

		return paisDao1.getCivil();

	}


	public List<Contacto> getCivilgana(){

		return paisDao2.getContactodos();

	}

	public List<CategoriaEvento> getCevento(){

		return paisDao3.getEcat();

	} 


	//Get y Set
	public Evento getPersona() {
		return persona;
	}


	public void setPersona(Evento persona) {
		this.persona = persona;
	}



}
