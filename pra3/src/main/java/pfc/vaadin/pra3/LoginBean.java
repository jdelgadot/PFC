package pfc.vaadin.pra3;

/**
 * Modelo de datos que guarda el usuario y contraseña.
 * 
 * @author jdelgadot
 * @date 02/12/17
 *
 */

public class LoginBean {

	//@NotNull(message = "Introduce tu usuario")
	//@Size(min = 4, message = "Longitud mínima 4.")
	private String user;

	// @NotNull( message = "Introduce tu contraseña")
	// @Size(min= 2, message = "al menos dos caracteres")
	private String pass;

	// getters y setters de las properties del bean.
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
