package io.subham.springbootapp.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4587275134373207919L;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String s) {
		super(s);
	}

}
