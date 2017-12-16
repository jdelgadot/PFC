package pfc.vaadin.pra3.validators;

import java.util.regex.Pattern;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
/**
 * Clase que valida las restricciones impuestas al campo usuario
 * implementando la Interfaz com.vaadin.data.Validator<String>.
 * 
 * @author jdelgadot
 * @date 06/12/17
 */
@SuppressWarnings("serial")
public class UserValidator implements Validator<String> {

	// Atributos para indicar si se aplican o no ciertas restricciones
	private int size = 0;
	private boolean alfa = false;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param alfa - false si exigimos algunos de los siguientes caracteres [ - _ @ . ] en el usuario.
	 * @param size - tamaño mínimo para el ususario.
	 */
	public UserValidator(boolean alfa, int size) {
		this.alfa = alfa;
		this.size = size;
	}
	
	
	/**
	 *  Método que debemos implementar de la interfaz Validator.
	 *  Validamos mediante expresiones regulares las restricciones impuestas al usuario
	 *  según el valor de la propiedad alfa.
	 *  Además imponemos una longitud superior a size.
	 *  
	 *  @param value - caracteres que compone la contraseña a validar
	 *  @param context - valor del contexto para validar
	 *  @return El resultado de la validación
	 */
	@Override
	public ValidationResult apply(String value, ValueContext context) {
		if(alfa) {
			if(! Pattern.compile("[a-zA-Z0-9]*").matcher(value).matches()) {
				return ValidationResult.error("solo caracteres alfanuméricos");
			}	
		}else {
			if(! Pattern.compile("\\w*[.@\\-_]\\w*").matcher(value).matches()) {
				return ValidationResult.error("al menos . @ - _");
			}
		}
		if(value.length() < size) {
			return ValidationResult.error("al menos " + size + " caracteres");
		}
		return ValidationResult.ok();
	}

}
