package br.gov.ba.pm.sga.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class EmailDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Email(message= "Email inválido")
	private String email;

	public EmailDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
