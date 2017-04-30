package br.com.hbsis.nelson.jankenpo;

public class MatchValidator {

	public MatchValidator() {

	}

	public boolean validatePlayersStrategy(Match match) {
		StrategyValidator strategyValidator = new StrategyValidator();
		for (Player player : match.getPlayers()) {
			if (!strategyValidator.isValidStrategy(player.getStrategy()))
				return false;
		}
		return true;
	}

	public boolean validateNumerOfPlayers(Match match) {
		if (match.getPlayers().size() != 2)
			return false;
		return true;

	}

}
