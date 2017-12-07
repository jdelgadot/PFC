package pfc.vaadin.pra3;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Plantilla que contiene el formulario de entrada a la plataforma.
 * Dispone de los campos de usuario y contraseña.
 * Además de un botón que valida la entrada a la plataforma.
 * 
 * @author jdelgadot
 * @date 02/12/17
 *
 */

@SuppressWarnings("serial")
public class LoginLayout extends VerticalLayout {

	// Campos de entrada usuario y contraseña.
	protected TextField user = new TextField();
	protected PasswordField pass = new PasswordField();	
	
	// Etiquetas para recoger los errores de validación.
	protected Label errorUser = new Label();
	protected Label errorPass = new Label();
	
	// Botón de inicio de sesión.
	protected Button loginButton = new Button();
	
	// Panel que contiene el formulario en formato vertical.
	protected Panel panelLogin = new Panel("Acceso a plataforma");
	protected VerticalLayout content = new VerticalLayout();
	
	public LoginLayout() {
		// Indicamos los nombres de los campos y el botón de entrada.
		user.setPlaceholder("Usuario");
		pass.setPlaceholder("Contraseña");
		loginButton.setCaption("Acceder");
		
		// Inicialmente hacemos invisible las etiquetas de los errores.
		errorUser.setVisible(false);
		errorPass.setVisible(false);
		
		// Configuramos el tamaño del panel y su margen
		panelLogin.setWidth("400px");;
		content.setMargin(true);
		
		// Añadimos los componentes
		content.addComponents(errorUser, user, errorPass, pass, loginButton);
		
		// Insertamos el formulario en el panel
		panelLogin.setContent(content);
		
		// Añadimos el panel a la plantilla
		addComponent(panelLogin);
		
		// Alineamos verticalmente
		setComponentAlignment(panelLogin, Alignment.TOP_CENTER);	
	}

	public Label getErrorUser() {
		return errorUser;
	}

	public Label getErrorPass() {
		return errorPass;
	}

	public Button getLoginButton() {
		return loginButton;
	}
}
