package pfc.vaadin.pra3.backend;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Entidad que representa las credenciales (usuario y contraseña) de la 
 * persona que está registrada en la plataforma.
 * 
 * @author jdelgadot
 *
 */


@SuppressWarnings("serial")
@Entity
public class Credential extends AbstractEntity {

	@NotNull(message = "Introduce un usuario")
	private String user;
	
	@NotNull(message = "Introduce una contraseña")
	private String pass;
	
	
	public Credential() {
	}
	
	public Credential(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
