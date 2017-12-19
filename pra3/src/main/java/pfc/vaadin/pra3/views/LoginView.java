package pfc.vaadin.pra3.views;

import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import pfc.vaadin.pra3.backend.PersonService;
import pfc.vaadin.pra3.editors.LoginEditor;

@SuppressWarnings("serial")
@CDIView("login")
public class LoginView extends VerticalLayout implements View {

	
	//@Inject CredentialService service;
	@Inject PersonService service;
	
	private LoginEditor editor = new LoginEditor(true, true, false, 4);
	
	public LoginView() {
		addComponent(editor);
		
		editor.getCreateAccount().addClickListener(e->{
			getUI().getNavigator().navigateTo("register");
		});
		
		/**
		 * Registramos un oyente de click al botón que da entrada a la plataforma.
		 * 
		 */
		editor.getLoginButton().addClickListener(e -> {
			if(editor.getBinder().validate().isOk()) {	
				boolean registrado = service.isValid(editor.getUser().getValue(), editor.getPass().getValue());
				if(!registrado) {
					editor.getErrorUser().setVisible(true);
					editor.getErrorUser().setValue("Usuario o contraseña no válida");
					editor.getLoginButton().setEnabled(false);
				} else {
					editor.getErrorUser().setVisible(false);
					editor.getErrorUser().setValue("");
					Notification.show("Usuario validado");
				}
			}
		});
		
		
	}
	
	
	
}
