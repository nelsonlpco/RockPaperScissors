package br.com.hbsis.nelson.jankenpo;

import org.junit.Before;
import org.junit.Test;

import br.com.hbsis.nelson.jankenpo.exceptions.NoSuchStrategyErrorException;
import br.com.hbsis.nelson.jankenpo.exceptions.WrongNumberOfPlayersErrorException;
import junit.framework.Assert;

public class MatchValidatorTest {
	private JankenpoGame jankeypoGame;
	private Player playerOne;
	private Player playerTwo;
	private Match match;
	private MatchValidator matchValidator;

	@Before
	public void Init() {
		matchValidator = new MatchValidator();
		playerOne = new Player("Dave", "P");
		playerTwo = new Player("Armando", "P");
		match = new Match();
	}

	@Test
	public void If_less_than_2_elements_must_be_false() {
		match.addPlayers(playerOne);
		boolean isValid = matchValidator.validateNumerOfPlayers(match);
		Assert.assertFalse(isValid);
	}

	@Test
	public void If_more_than_2_elements_must_be_false() {
		match.addPlayers(playerOne, playerTwo, playerOne);
		boolean isValid = matchValidator.validateNumerOfPlayers(match);
		Assert.assertFalse(isValid);
	}

	@Test
	public void if_number_of_players_are_equal_2_must_b_true() {
		match.addPlayers(playerOne, playerTwo);
		boolean isValid = matchValidator.validateNumerOfPlayers(match);
		Assert.assertTrue(isValid);
	}

	@Test
	public void if_strategy_is_different_from_R_P_S_must_be_false() {
		playerTwo.setStrategy("a");
		match.addPlayers(playerOne, playerTwo);
		boolean isValid = matchValidator.validatePlayersStrategy(match);
		Assert.assertFalse(isValid);
	}

	@Test
	public void if_strategy_is_equal_to_R_P_or_S_meust_be_true() {
		match.addPlayers(playerOne, playerTwo);
		boolean isValid = matchValidator.validatePlayersStrategy(match);
		Assert.assertTrue(isValid);
	}

}
