package controlador;


import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

import model.Opcion;
import model.OpcionDAO;
import util.SecurityUtil;

@SuppressWarnings({"serial" , "unchecked"})
public class Menu {

    /**
     * Provee los datos para las opciones
     * @return
     */
    public List<Opcion> getOpciones() {
        OpcionDAO opcionDao = new OpcionDAO();
        return opcionDao.getOpciones();
    }
    
    /**
     * Se ejecuta al dar click en la fila del grid
     * @param url
     */
    @Command
    @NotifyChange("formularioActual")
    public void cargaUrl(@BindingParam("url") String url) {
        
        // Si comienza con "http" se entiende que es una URL
        // de lo contrario es un formulario.
        if (url.substring(0, 4).toLowerCase().equals("http")) {
            
            // Limpia el atributo del formulario actual de la variable 
            // de sesion
            Sessions.getCurrent().setAttribute("FormularioActual", null);
            Executions.getCurrent().sendRedirect(url, "_blank");    
            
        }else{
            // Coloca el atributo del formulario actual en una variable 
            // de sesion
            Sessions.getCurrent().setAttribute("FormularioActual", url);
        }
    }

    /**
     * Retorna el formulario de trabajo actual, tomado desde una variable de sesion.
     * @return
     */
    public String getFormularioActual() {
        
        // Recupera el formulario actual desde la variable de sesion
        return (String) Sessions.getCurrent().getAttribute("FormularioActual");
        
    }
    
    public String getNombreUsuario() {
		String retorno = null; 
		if (SecurityUtil.getUser() != null) {
			retorno = SecurityUtil.getUser().getUsername();
		}
		return retorno;
	}

}