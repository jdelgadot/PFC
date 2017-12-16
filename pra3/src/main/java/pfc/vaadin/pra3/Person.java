package pfc.vaadin.pra3;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {

	@NotNull(message = "Introduce tu nombre")
	@Size(min=4, message="al menos 4 caracteres")
	String name;
	
	@NotNull(message = "Introduce tu apellido")
	String surname;
	
	@NotNull(message = "Introduce tu email")
	@Pattern(regexp= ".+@.+\\.[a-z]", message = "email no válida")
	String email;
	
	@NotNull(message ="Introduce contraseña")
	String pass;
	
	public Person() {
	}

	
	public Person(String name, String surname, String email, String pass) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
