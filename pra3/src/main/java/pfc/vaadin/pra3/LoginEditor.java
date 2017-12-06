package pfc.vaadin.pra3;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.server.UserError;

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
	private BeanValidationBinder<LoginBean> binder = new BeanValidationBinder<>(LoginBean.class);
	
	
	
	public LoginEditor(boolean capital, boolean digit, boolean alfa, int size) {
		
		
		binder.forField(user)
			.withValidator(new UserValidator(alfa, size))
			.withValidationStatusHandler(status -> {
				errorUser.setVisible(status.isError());
				errorUser.setValue(status.getMessage().orElse(""));
				user.setComponentError(status.isError()? new UserError(""): null);
			})
			.bind(LoginBean::getUser, LoginBean::setUser);
		
		binder.forField(pass)
			.withValidator(new PassValidator(capital, digit, alfa, size))
			.withValidationStatusHandler(status -> {
				errorPass.setVisible(status.isError());
				errorPass.setValue(status.getMessage().orElse(""));
				pass.setComponentError(status.isError()? new UserError(""): null);
			})
			.bind(LoginBean::getPass, LoginBean::setPass);
			
		binder.bindInstanceFields(this);
		
		
		/**
		// Añadimos acción al botón validar
		 */
		loginButton.addClickListener(e -> {
			if(binder.validate().isOk()) {
				boolean valido = (user.getValue().equals("j_delgadot") &&  pass.getValue().equals("j$1A56"));
				if(!valido) {
					errorUser.setVisible(true);
					errorUser.setValue("Usuario o contraseña no válidos");
				} else {
					errorUser.setVisible(false);
					errorUser.setValue("");
				}
			}
		});

	}
	
	
}
