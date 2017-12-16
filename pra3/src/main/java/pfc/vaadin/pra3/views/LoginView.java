package pfc.vaadin.pra3.views;

import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

import pfc.vaadin.pra3.backend.CredentialService;
import pfc.vaadin.pra3.editors.LoginEditor;

@SuppressWarnings("serial")
@CDIView("login")
public class LoginView extends VerticalLayout implements View {

	
	
	@Inject CredentialService service;
	private LoginEditor editor = new LoginEditor(true, true, false, 4, service);
	
	public LoginView() {
		addComponent(editor);
		
		editor.getCreateAccount().addClickListener(e->{
			getUI().getNavigator().navigateTo("register");
		});
	}
}
