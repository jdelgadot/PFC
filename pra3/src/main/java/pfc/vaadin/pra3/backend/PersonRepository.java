package pfc.vaadin.pra3.backend;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
/**
 * Repositorio para las entidades de tipo Credentials
 * Deltaspike Data autmáticamente implementará los métodos basados por el nombre.
 * 
 * @author jdelgadot
 *
 */
public interface PersonRepository extends EntityRepository<Person, Long> {
	
	public List<Person> findByUserAndPass(String filter, String pass);
}
