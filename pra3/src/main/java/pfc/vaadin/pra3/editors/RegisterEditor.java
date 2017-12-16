package pfc.vaadin.pra3.editors;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.server.UserError;

import pfc.vaadin.pra3.Person;
import pfc.vaadin.pra3.layouts.RegisterLayout;

@SuppressWarnings("serial")
public class RegisterEditor extends RegisterLayout {

	private BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

	public RegisterEditor() {
		
		binder.forField(name)
		.withValidationStatusHandler(status ->{
			nameStatus.setValue(status.getMessage().orElse(""));
			nameStatus.setVisible(status.isError());
			nameStatus.setComponentError(status.isError()? new UserError("") : null);
		})
		.bind("name");
		
		binder.forField(surname)
		.withValidationStatusHandler(status ->{
			surnameStatus.setValue(status.getMessage().orElse(""));
			surnameStatus.setVisible(status.isError());
			surnameStatus.setComponentError(status.isError()? new UserError("") : null);
		})
		.withNullRepresentation("")
		.bind("surname");
		
		binder.forField(email)
		.withValidationStatusHandler(status ->{
			emailStatus.setValue(status.getMessage().orElse(""));
			emailStatus.setVisible(status.isError());
			emailStatus.setComponentError(status.isError()? new UserError("") : null);
		})
		.bind("email");
		
		
		binder.forField(pass)
		.withValidationStatusHandler(status ->{
			passStatus.setValue(status.getMessage().orElse(""));
			passStatus.setVisible(status.isError());
			passStatus.setComponentError(status.isError()? new UserError("") : null);
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
	
	

}
