package br.com.hbsis.nelson.jankenpo;

import br.com.hbsis.nelson.jankenpo.exceptions.NoSuchStrategyErrorException;
import br.com.hbsis.nelson.jankenpo.exceptions.WrongNumberOfPlayersErrorException;

public class JankenpoGame {

	private MatchValidator matchValidator;

	public JankenpoGame(MatchValidator matchValidator) {
		this.matchValidator = matchValidator;
	}

	public Player rpsGameWinner(Match match) {

		if (!matchValidator.validateNumerOfPlayers(match))
			throw new WrongNumberOfPlayersErrorException();
		if (!matchValidator.validatePlayersStrategy(match))
			throw new NoSuchStrategyErrorException();

		return takeWinner(match);
	}

	public Player takeWinner(Match match) {
		Player playerOne = match.getPlayers().get(0);
		Player playerTwo = match.getPlayers().get(1);

		if (playerOne.getStrategy() == playerTwo.getStrategy())
			return playerOne;

		switch (playerOne.getStrategy()) {
		case "P":
			switch (playerTwo.getStrategy()) {
			case "S":
				return playerTwo;
			case "R":
				return playerOne;
			}
			break;
		case "S":
			switch (playerTwo.getStrategy()) {
			case "P":
				return playerOne;
			case "R":
				return playerTwo;
			}
			break;
		case "R":
			switch (playerTwo.getStrategy()) {
			case "P":
				return playerTwo;
			case "S":
				return playerOne;
			}
			break;
		}

		return playerOne;
	}
}
