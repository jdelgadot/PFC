package pfc.vaadin.pra3.editors;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Label;

import pfc.vaadin.pra3.backend.Person;
import pfc.vaadin.pra3.layouts.RegisterLayout;

@SuppressWarnings("serial")
public class RegisterEditor extends RegisterLayout {

	private BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

	public RegisterEditor() {
		
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
		.withValidationStatusHandler(status ->{
			setStatus(status, userStatus, user);
		})
		.bind("user");
		
		binder.forField(pass)
		.withValidationStatusHandler(status ->{
			setStatus(status, passStatus, pass);
		})
		.bind("pass");
		
		
		binder.bindInstanceFields(this);
		
		binder.addStatusChangeListener(e->{
			boolean isValid = e.getBinder().isValid();
			createAccount.setEnabled(isValid);
		});
	
		
		/**
		binder.setValidationStatusHandler(status -> {
		
			
			
			List<BindingValidationStatus<?>> fieldValidationErrors = status.getFieldValidationErrors();
			for(BindingValidationStatus<?> fieldValidationError : fieldValidationErrors) {
				String message = fieldValidationError.getMessage().get();
				HasValue<?> field = fieldValidationError.getField();
			}
				// TODO Poner el mensaje de error en la etiqueta del campo correspondiente 
				 * Intentar con el getComponentIndex para alcanzar el label
			});
		*/
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
	
	
	
	

}
