package br.com.hbsis.nelson.jankenpo.exceptions;

public class WrongNumberOfPlayersErrorException extends RuntimeException {
	private static final long serialVersionUID = 2394703966617009340L;

	public WrongNumberOfPlayersErrorException() {
		super();
	}

	public WrongNumberOfPlayersErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongNumberOfPlayersErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongNumberOfPlayersErrorException(String message) {
		super(message);
	}

	public WrongNumberOfPlayersErrorException(Throwable cause) {
		super(cause);
	}

}
