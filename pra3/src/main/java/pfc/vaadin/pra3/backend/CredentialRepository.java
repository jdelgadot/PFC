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
public interface CredentialRepository extends EntityRepository<Credential, Long> {

	public List<Credential> findByUserAndPass(String filter, String pass);
}
