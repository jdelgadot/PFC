package pfc.vaadin.pra3.editors;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Label;

import pfc.vaadin.pra3.backend.Person;
import pfc.vaadin.pra3.layouts.RegisterLayout;
import pfc.vaadin.pra3.validators.PassValidator;
import pfc.vaadin.pra3.validators.UserValidator;

/**
 * Clase que permite editar la interfaz de registro de una nueva cuenta.
 * 
 * @author jdelgadot
 * @date 12/12/17
 * 
 */

@SuppressWarnings("serial")
public class RegisterEditor extends RegisterLayout {

	// clase que vincula el modelo de datos con el formulario de entrada.
	private BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

	/**
	 * Constructor de la clase.
	 * Vincula el formulario de registro al modelo de datos.
	 * Registra los validadores de usuario y contraseña y personaliza los errores de validación,
	 * mostrándolos las etiquetas del formulario.
	 * 
	 * @param capital - true si exigimos al menos una mayúscula en la contraseña.
	 * @param digit - true si exige al menos un dígito en contraseña.
	 * @param alfa - false si exige carácter no alfanumérico en contraseña y al menos [-_@.] en usuario.
	 * @param size - tamaño mínimo de usuario y contraseña.
	 */
	public RegisterEditor(boolean capital, boolean digit, boolean alfa, int size) {
		
		binder.forField(name)
		.withValidationStatusHandler(status ->{
			setStatus(status, nameStatus, name);
		})
		.bind("name");
		
		binder.forField(surname)
		.withValidationStatusHandler(status ->{
			setStatus(status, surnameStatus, surname);
		})
		.withNullRepresentation("")
		.bind("surname");
		
		binder.forField(email)
		.withValidationStatusHandler(status ->{
			setStatus(status, emailStatus, email);
		})
		.bind("email");
		
		binder.forField(user)
		.withValidator(new UserValidator(alfa, size))
		.withValidationStatusHandler(status ->{
			setStatus(status, userStatus, user);
		})
		.bind("user");
		
		binder.forField(pass)
		.withValidator(new PassValidator(capital, digit, alfa, size))
		.withValidationStatusHandler(status ->{
			setStatus(status, passStatus, pass);
		})
		.bind("pass");
		
		
		binder.bindInstanceFields(this);
		
		binder.addStatusChangeListener(e->{
			boolean isValid = e.getBinder().isValid();
			createAccountButton.setEnabled(isValid);
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
