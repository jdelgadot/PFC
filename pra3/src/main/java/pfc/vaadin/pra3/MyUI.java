package pfc.vaadin.pra3;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

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

	
	private LoginEditor editor = new LoginEditor(true, true, false, 6);
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        setContent(editor);
    }
}
