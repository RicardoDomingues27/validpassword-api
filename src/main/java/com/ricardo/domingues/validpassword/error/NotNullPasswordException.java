package com.ricardo.domingues.validpassword.error;

public final class NotNullPasswordException extends RuntimeException {

	private static final long serialVersionUID = -7056052158073387674L;

    public NotNullPasswordException() {
        super();
    }
    
    public NotNullPasswordException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotNullPasswordException(final String message) {
        super(message);
    }

    public NotNullPasswordException(final Throwable cause) {
        super(cause);
    }

 

}