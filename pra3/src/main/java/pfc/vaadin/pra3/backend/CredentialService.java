package pfc.vaadin.pra3.backend;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Servicio EJB que nos permite ocultar la complejidad de JPA.
 * Proporciona los métodos necesario de búsqueda que se usarán en la UI.
 * Define una serie de datos a modo de ejemplos.
 * 
 * @author jdelgadot
 *
 */
@Stateless
public class CredentialService {

	@Inject CredentialRepository repo;
	
	@PersistenceContext(unitName="credentialsdb")
	EntityManager em;
	
	
	public CredentialService() {
	}
	
	/**
	 * Método para saber si un usuario está o no registrado en la plataforma.
	 * 
	 * @param user - Nombre de usuario
	 * @param pass - Contraseña del usuario
	 * @return true - si el usuario está registrado en la base de datos
	 */
	public boolean isValid(String user, String pass) {
		List<Credential> credentials = repo.findByUserAndPass(user, pass);
		return credentials.isEmpty()? false: true;	
		}
	
	
	/**
	 * Generación de datos para demo
	 */
	private static final String[] users = new String[] {"_mortadelo", "_filemón", "_elsuper"};
	private static final String[] passes = new String[] {"Pass$1", "Pass$2", "Pass$3"};
	
	public void loadData() {
		for(int i= 0; i < users.length; i++) {
			final Credential credential = new Credential(users[i], passes[i]);
			em.persist(credential);
			em.flush();
		}
	}
	
	
		
	}

