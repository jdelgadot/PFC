package pfc.vaadin.pra3.layouts;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Plantilla que contiene el formulario de entrada a la plataforma.
 * Dispone de los campos de usuario y contraseña.
 * Además del botín de entrada y creación de nueva cuenta.
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
	protected Button loginButton = new Button("Iniciar Sesión");
	
	// Botón de creación de cuenta
	protected Button createAccount = new Button("Crear Cuenta");
	
	// Panel que contiene el formulario en formato vertical.
	protected Panel panelLogin = new Panel("Acceso a plataforma");
	// Contenido del panel
	protected VerticalLayout content = new VerticalLayout();
	// Layout de los botones
	protected HorizontalLayout buttons = new HorizontalLayout();
	
	
	public LoginLayout() {
		// Indicamos los nombres de los campos y el botón de entrada.
		user.setPlaceholder("Usuario");
		pass.setPlaceholder("Contraseña");
		
		// Inicialmente hacemos invisible las etiquetas de los errores.
		errorUser.setVisible(false);
		errorPass.setVisible(false);
		
		// Desactivamos el botón de entrada
		loginButton.setEnabled(false);
		
		//Expandimos los componentes
		user.setWidth("100%");
		pass.setWidth("100%");
		errorUser.setWidth("100%");
		errorPass.setWidth("100%");
		
		// Configuramos el tamaño del panel y su margen
		panelLogin.setWidth("400px");
		content.setMargin(true);
		
		// Añadimos los botones
		buttons.addComponentsAndExpand(loginButton, createAccount);
		
		// Añadimos los componentes
		content.addComponents(errorUser, user, errorPass, pass, buttons);
		
		// Establecemos el contenido del panel
		panelLogin.setContent(content);
		
		// Añadimos el panel a la plantilla
		addComponent(panelLogin);
		
		// Alineamos verticalmente
		setComponentAlignment(panelLogin, Alignment.TOP_CENTER);	
	}


	public Button getCreateAccount() {
		return createAccount;
	}

	
	public Button getLoginButton() {
		return loginButton;
	}

	
	public Label getErrorUser() {
		return errorUser;
	}
	
	public Label getErrorPass() {
		return errorPass;
	}
	
	
	public TextField getUser() {
		return user;
	}
	
	public PasswordField getPass() {
		return pass;
	}

	


	
	
	
	
}
