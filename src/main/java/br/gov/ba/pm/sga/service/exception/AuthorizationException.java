package br.gov.ba.pm.sga.service.exception;


public class AuthorizationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	

}
