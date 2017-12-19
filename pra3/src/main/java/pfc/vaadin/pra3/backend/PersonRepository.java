package pfc.vaadin.pra3.backend;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
/**
 * Repositorio para las entidades de tipo Credentials
 * Deltaspike Data autmáticamente implementará los métodos basados por el nombre.
 * 
 * @author jdelgadot
 *
 */
@Repository
public interface PersonRepository extends EntityRepository<Person, Long> {
	
	
	public List<Person> findByUser(String user);
	public List<Person> findByUserAndPass(String user, String pass);
}
