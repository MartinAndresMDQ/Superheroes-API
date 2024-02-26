package com.mindata.challenge.w2m.superheroes.exception;

public class SuperheroNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperheroNotFoundException() {
        super();
    }

    public SuperheroNotFoundException(String message) {
        super(message);
    }

    public SuperheroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperheroNotFoundException(Throwable cause) {
        super(cause);
    }
}
