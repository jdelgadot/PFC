package pfc.vaadin.pra3.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

import pfc.vaadin.pra3.editors.RegisterEditor;

@CDIView("register")
public class RegisterView extends VerticalLayout implements View {

	RegisterEditor register = new RegisterEditor();
	
	public RegisterView() {
		addComponent(register);
	}
	
	
}
