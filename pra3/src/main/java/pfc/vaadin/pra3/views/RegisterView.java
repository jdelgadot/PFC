package pfc.vaadin.pra3.views;

import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import pfc.vaadin.pra3.backend.Person;
import pfc.vaadin.pra3.backend.PersonService;
import pfc.vaadin.pra3.editors.RegisterEditor;

@SuppressWarnings("serial")
@CDIView("register")
public class RegisterView extends VerticalLayout implements View {

	@Inject
	PersonService service;

	RegisterEditor register = new RegisterEditor(true, true, false, 4);

	public RegisterView() {
		addComponent(register);

		/**
		 * Registramos un oyente click en el botón crear cuenta.
		 * Creamos una instancia nueva de Persona que insertamos en la base de datos.
		 * Notificamos la creación de la cuenta
		 * 
		 */
		register.getCreateAccountButton().addClickListener(e -> {
			boolean registrado = service.isRegistered(register.getUser().getValue());
			if(registrado) {
				
			}else {
				Person person = new Person(register.getName().getValue(),register.getSurname().getValue(),
						register.getEmail().getValue(), register.getUser().getValue(), register.getPass().getValue());
				service.createAccount(person);
				Notification.show("Cuenta creada");
			}
			
		});
		
		
		/**
		 * Registramos oyente click en el botón de vuelta al acceso a plataforma
		 * Navegamos a la vista login.
		 */
		register.getBackLoginButton().addClickListener(e->{
			getUI().getNavigator().navigateTo("login");
		});
		
	}

}
