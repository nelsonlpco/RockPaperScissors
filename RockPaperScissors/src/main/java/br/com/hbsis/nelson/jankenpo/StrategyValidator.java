package br.com.hbsis.nelson.jankenpo;

public class StrategyValidator {

	private final char[] strategies = { 'P', 'R', 'S' };

	public StrategyValidator() {

	}

	public boolean isValidStrategy(String strategy) {
		if (new String(strategies).indexOf(strategy.toUpperCase()) >= 0)
			return true;
		return false;
	}

}
