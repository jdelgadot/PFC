package pfc.vaadin.pra3.backend;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
public class Person extends AbstractEntity {

	@NotNull(message = "Introduce tu nombre")
	@Size(min=4, message="al menos 4 caracteres")
	String name;
	
	@NotNull(message = "Introduce tu apellido")
	String surname;
	
	@NotNull(message = "Introduce tu email")
	//@Pattern(regexp=".*@.*\\.[a-z] {3}", message="Introduce un email válido")
	//@Email(message = "email no válido")
	String email;
	
	@NotNull(message = "Introduce un usuario")
	private String user;
	
	@NotNull(message = "Introduce una contraseña")
	private String pass;
	
	public Person() {
	}


	
	public Person(String name, String surname, String email, String user, String pass) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.user = user;
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


	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
