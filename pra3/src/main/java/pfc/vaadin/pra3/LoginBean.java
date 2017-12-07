package pfc.vaadin.pra3;

import javax.validation.constraints.NotNull;

/**
 * Modelo de datos que guarda el usuario y contraseña
 * de las personas que usan una plataforma.
 * 
 * @author jdelgadot
 * @date 02/12/17
 * 
 */

public class LoginBean {

	@NotNull(message = "Introduce tu usuario")
	private String user;

	@NotNull( message = "Introduce tu contraseña")
	private String pass;

	// getters y setters de las propiedades del bean.
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
