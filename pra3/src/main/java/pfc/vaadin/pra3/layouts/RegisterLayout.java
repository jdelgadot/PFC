package pfc.vaadin.pra3.layouts;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
/**
 * Clase que genera la plantilla de registro para crear una cuenta nueva
 * 
 * @author jdelgadot
 * @date 12/12/17
 */
@SuppressWarnings("serial")
public class RegisterLayout extends VerticalLayout {
	
	
	protected FormLayout formRegister = new FormLayout();

	// Campos del formulario
	protected TextField name = new TextField();
	protected TextField surname = new TextField();
	protected TextField email = new TextField();
	protected PasswordField pass = new PasswordField();
	
	// Etiquetas de errores de validación
	protected Label nameStatus = new Label();
	protected Label surnameStatus = new Label();
	protected Label emailStatus = new Label();
	protected Label passStatus = new Label();
	
	// Botón de creación de cuenta
	protected Button createAccount = new Button("Crear Cuenta");
	
	// Panel que contiene el formulario de registro.
	protected Panel panelRegister= new Panel("Formulario de registro.");
	// Contenido del panel
	protected VerticalLayout content = new VerticalLayout();
		
	
	public RegisterLayout() {
		// Indicamos una referencia textual a los campos
		setPlaceholder();
		
		// Dejamos invisibles las etiquetas de errores
		setNotVisible();
		
		// No activamos el botón de creación de cuenta
		createAccount.setEnabled(false);
		
		// Configuramos el tamaño del panel
		panelRegister.setWidth("400px");
		
		// Expandimos los componentes del formulario
		expandComponents();
		
		
		content.addComponents(nameStatus, name, surnameStatus, surname, emailStatus, email, passStatus, pass, createAccount);
		panelRegister.setContent(content);
		
		//Añadimos el panel a la plantilla
		addComponent(panelRegister);
		setComponentAlignment(panelRegister, Alignment.TOP_CENTER);
		
		
		
	}
	
	/**
	 * Método que expande los campos del formulario para que ocupen todo el ancho.
	 */
	private void expandComponents() {
		nameStatus.setWidth("100%");
		name.setWidth("100%");
		surname.setWidth("100%");
		surnameStatus.setWidth("100%");
		email.setWidth("100%");
		emailStatus.setWidth("100%");
		pass.setWidth("100%");
		passStatus.setWidth("100%");
	}

	/**
	 * Método que indica la leyenda de cada campo del formulario.
	 */
	private void setPlaceholder() {
		name.setPlaceholder("Nombre");
		surname.setPlaceholder("Apellidos");
		email.setPlaceholder("Correo electrónico");
		pass.setPlaceholder("Contraseña");
	}
	/**
	 * Método que deja invisibles las etiquetas de errores de validación
	 */
	private void setNotVisible() {
		nameStatus.setVisible(false);
		surnameStatus.setVisible(false);
		emailStatus.setVisible(false);
		passStatus.setVisible(false);
	}
	

}
