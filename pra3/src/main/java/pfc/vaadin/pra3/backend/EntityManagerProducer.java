package pfc.vaadin.pra3.backend;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que produce el gestor de entidades.
 * 
 * @author jdelgadot
 *
 */

public class EntityManagerProducer {

	@Produces
	@Dependent
	@PersistenceContext(unitName="credentialsdb")
	public EntityManager entityManager;

}
