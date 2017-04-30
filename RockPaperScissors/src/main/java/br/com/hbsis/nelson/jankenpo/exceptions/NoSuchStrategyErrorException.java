package br.com.hbsis.nelson.jankenpo.exceptions;

public class NoSuchStrategyErrorException extends RuntimeException {

	private static final long serialVersionUID = -4710895754353992753L;

	public NoSuchStrategyErrorException() {
		super();
	}

	public NoSuchStrategyErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchStrategyErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchStrategyErrorException(String message) {
		super(message);
	}

	public NoSuchStrategyErrorException(Throwable cause) {
		super(cause);
	}

}
