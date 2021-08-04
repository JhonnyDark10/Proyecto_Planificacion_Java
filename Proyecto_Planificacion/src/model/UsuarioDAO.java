package model;

import javax.persistence.Query;

public class UsuarioDAO extends ClaseDAO {

	/**
	 * Retorna un usuario en base a su nombre de usuario.
	 * @param nombreUsuario
	 * @return
	 */
	public Usuario getUsuario(String nombreUsuario) {
		Usuario usuario; 
		Query consulta;
		
		consulta = getEntityManager().createNamedQuery("Usuario.buscaUsuario");
		consulta.setParameter("nombreUsuario", nombreUsuario);
		
		usuario = (Usuario) consulta.getSingleResult();
		
		return usuario;
	}
	
}
