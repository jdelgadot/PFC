package pfc.vaadin.pra3.editors;

import javax.inject.Inject;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.server.UserError;

import pfc.vaadin.pra3.backend.Credential;
import pfc.vaadin.pra3.backend.CredentialService;
import pfc.vaadin.pra3.layouts.LoginLayout;
import pfc.vaadin.pra3.validators.PassValidator;
import pfc.vaadin.pra3.validators.UserValidator;

/**
 * Clase que permite editar la interfaz de entrada a la plataforma.
 * 
 * @author jdelgadot
 * @date 02/12/17
 * 
 */
@SuppressWarnings("serial")
public class LoginEditor extends LoginLayout {

	// clase que vincula el modelo de datos con el formulario de entrada.
	private BeanValidationBinder<Credential> binder = new BeanValidationBinder<>(Credential.class);
	
	@Inject CredentialService service;
	
	/**
	 * Constructor de la clase.
	 * Vincula el formulario de entrada al modelo de datos.
	 * Registra los validadores de usuario y contraseña y personaliza los errores de validación,
	 * mostrándolos las etiquetas del formulario.
	 * 
	 * @param capital - true si exigimos al menos una mayúscula en la contraseña.
	 * @param digit - true si exige al menos un dígito en contraseña.
	 * @param alfa - false si exige carácter no alfanumérico en contraseña y al menos [-_@.] en usuario.
	 * @param size - tamaño mínimo de usuario y contraseña.
	 */
	public LoginEditor(boolean capital, boolean digit, boolean alfa, int size) {
		
		// Vinculación del campo de texto user con la propiedad user del modelo de datos .
		binder.forField(user)
			// Registramos el validador
			.withValidator(new UserValidator(alfa, size))
			//.withStatusLabel(errorUser)
			.withNullRepresentation("")
			// Personalizamos la salida de errores
			.withValidationStatusHandler(status -> {
				errorUser.setVisible(status.isError());
				errorUser.setValue(status.getMessage().orElse(""));
				user.setComponentError(status.isError()? new UserError(""): null);
			})
			.bind("user");
		
		// Vinculación del campo de contraseña pass con la propiedad pass del modelo de datos. 
		binder.forField(pass)
			// Registramos el validador
			.withValidator(new PassValidator(capital, digit, alfa, size))
			// Personalizamos la salida de errores por defecto
			.withValidationStatusHandler(status -> {
				errorPass.setVisible(status.isError());
				errorPass.setValue(status.getMessage().orElse(""));
				pass.setComponentError(status.isError()? new UserError(""): null);
			})
			.bind("pass");
			
		binder.bindInstanceFields(this);
		
		// Desactivamos el botón de entrada si los campos de usuario y contraseña cumplen las restricciones.
		binder.addStatusChangeListener(e ->{
			loginButton.setEnabled(e.getBinder().isValid());
		});
		
		

	}
		
	

	
	
	
	

	public BeanValidationBinder<Credential> getBinder() {
		return binder;
	}


	
	
	
}
