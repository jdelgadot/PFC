package pfc.vaadin.pra3.editors;

import javax.inject.Inject;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Label;

import pfc.vaadin.pra3.backend.Person;
import pfc.vaadin.pra3.backend.PersonService;
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
	private BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);
	
	@Inject PersonService service;
	
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
				setStatus(status, errorUser, user);
			})
			.bind("user");
		
		// Vinculación del campo de contraseña pass con la propiedad pass del modelo de datos. 
		binder.forField(pass)
			// Registramos el validador
			.withValidator(new PassValidator(capital, digit, alfa, size))
			// Personalizamos la salida de errores por defecto
			.withValidationStatusHandler(status -> {
				setStatus(status, errorPass, pass);
			})
			.bind("pass");
			
		binder.bindInstanceFields(this);
		
		// Desactivamos el botón de entrada si los campos de usuario y contraseña cumplen las restricciones.
		binder.addStatusChangeListener(e ->{
			loginButton.setEnabled(e.getBinder().isValid());
			});
		}
		
	
	/**
	 * Método que establece un comportamiento personalizado ante la validación de un campo.
	 * En caso de error:
	 *       Hace visible una etiqueta con el error se validación justo encima del campo.
	 *       Deja el campo con el indicador por defecto de error (borde rojo y signo !).
	 * 
	 * @param status - estado de la validación de un campo.
	 * @param label - Etiqueta que contendrá el mensaje de error asociado a la validación del campo.
	 * @param field - Campo a validar 
	 */
	private void setStatus(BindingValidationStatus<?> status, Label label, AbstractTextField field) {
		label.setValue(status.getMessage().orElse(""));
		label.setVisible(status.isError());
		field.setComponentError(status.isError()? new UserError("") : null);
	}
	

	
	
	
	

	public BeanValidationBinder<Person> getBinder() {
		return binder;
	}


	
	
	
}
