package pfc.vaadin.pra3;

import java.util.regex.Pattern;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

@SuppressWarnings("serial")
public class UserValidator implements Validator<String> {

	private int size = 0;
	private boolean alfa = false;
	
	
	
	public UserValidator(boolean alfa, int size) {
		this.alfa = alfa;
		this.size = size;
	}
	
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
