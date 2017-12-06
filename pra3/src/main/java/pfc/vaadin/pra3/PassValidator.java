package pfc.vaadin.pra3;

import java.util.regex.Pattern;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

/**
 * Clase que valida las restricciones impuestas al campo contraseña
 * implementando la Interfaz com.vaadin.data.Validator<String>
 * 
 * 
 * 
 * Implementa la interfaz Validator.
 * 
 * @author jdelgadot
 * @date 06/12/17
 */


@SuppressWarnings("serial")
public class PassValidator implements Validator<String> {

	// Atributos para indicar si se aplican o no ciertas restricciones
	private boolean capital = false;
	private boolean digit = false;
	private boolean alfa = false;
	private int size = 0;
	

	/**
	 * Constructor de la clase.
	 * 
	 * @param capital - true si exigimos al menos una mayúscula en la contraseña.
	 * @param digit - true si exigimos al menos un dígito en la contraseña. 
	 * @param alfa - false si exigimos al menos un carácter no alfanumérico en la contraseña.
	 * @param size - tamaño mínimo para la contraseña
	 */
	public PassValidator(boolean capital, boolean digit, boolean alfa, int size) {
		this.capital = capital;
		this.digit = digit;
		this.alfa = alfa;
		this.size = size;
		
	}
 
	
	/**
	 *  Método que debemos implementar de la interfaz Validator.
	 *  Validamos mediante expresiones regulares las restricciones impuestas a la contraseña
	 *  según los valores de las propiedades capital, digit y alfa.
	 *  
	 *  @param value - caracteres que compone la contraseña a validar
	 *  @param context - valor del contexto para validar
	 *  @return El resultado de la validación
	 */
	@Override
	public ValidationResult apply(String value, ValueContext context) {
		if(capital) {
			if(! Pattern.compile("[\\w|\\W]*[A-Z][\\w|\\W]*").matcher(value).matches()) {
				return ValidationResult.error("al menos una mayúscula");
			}	
		}
		if(digit) {
			if(! Pattern.compile("[\\w|\\W]*\\d[\\w|\\W]*").matcher(value).matches()) {
				return ValidationResult.error("al menos un dígito");
			}	
		}
		if(alfa) {
			if(! Pattern.compile("\\w*\\W\\w*").matcher(value).matches()) {
				return ValidationResult.error("al menos un caracter no alfanumérico");
			}	
		}
		if(value.length() < size) {
				return ValidationResult.error("al menos " + size + " caracteres");
			}
		return ValidationResult.ok();
	}
}
