package pfc.vaadin.pra3;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import pfc.vaadin.pra3.backend.CredentialService;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@CDIUI("")
public class MyUI extends UI {

	// Proveedor de vista
	@Inject CDIViewProvider viewProvider;
	
	// Clase servicio que gestiona los datos de los usuarios
	@Inject CredentialService service;	
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    		// Creamos una instancia de navegador. 
    		Navigator navigator = new Navigator(this, this);
    		
    		// Le añadimos un proveedor de vistas
    		navigator.addProvider(viewProvider);
    		
    		// Navegamos hacia la vista login
    		navigator.navigateTo("login");
    		
    }
    
    /*
     * Método que carga los datos tras instanciar la UI
     */
    @PostConstruct
    void init() {
    		service.loadData();
    }
}
