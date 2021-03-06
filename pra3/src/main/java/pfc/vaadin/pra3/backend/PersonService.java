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
public class PersonService {
	
	@Inject PersonRepository repo;
	
	@PersistenceContext(unitName="personsdb")
	EntityManager em;
	
	
	public PersonService() {
	}
	
	/**
	 * Método para saber si el usuario y contraseñas dadas son válidas.
	 * 
	 * @param user - Nombre de usuario
	 * @param pass - Contraseña del usuario
	 * @return true - si el usuario está registrado en la base de datos
	 */
	public boolean isValid(String user, String pass) {
		List<Person> person = repo.findByUserAndPass(user, pass);
		return person.isEmpty()? false: true;	
	}
	
	/**
	 * Método para saber si el nombre de usuario ya está registrado.
	 * 
	 * @param user - nombre de usuario a buscar en la bases de datso
	 * @return true - si el usuario está en la base de datos.
	 */
	public boolean isRegistered(String user) {
		List<Person> person = repo.findByUser(user);
		return person.isEmpty()? false: true;
	}
	
	public void createAccount(Person person) {
		em.persist(person);
		em.flush();
	}
	
	
	/**
	 * Generación de datos para demo
	 */
	private static final String[] names = new String[] { "Mortadelo", "Filemón", "El Super" };
	private static final String[] surnames = new String[] {"Delgado", "Trujillo", "Martínez"}; 
	
	public void loadData() {
		for(int i= 0; i < names.length; i++) {
			final Person person = new Person(names[i], surnames[i], names[i] + "@gmail.com", "_"+names[i], "Pass$" + i);
			em.persist(person);
			em.flush();
		}
	}
}
