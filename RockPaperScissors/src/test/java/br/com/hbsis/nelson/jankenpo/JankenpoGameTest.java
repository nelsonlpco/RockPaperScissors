package br.com.hbsis.nelson.jankenpo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.hbsis.nelson.jankenpo.exceptions.NoSuchStrategyErrorException;
import br.com.hbsis.nelson.jankenpo.exceptions.WrongNumberOfPlayersErrorException;

public class JankenpoGameTest {

	private JankenpoGame jankeypoGame;
	private Player playerOne;
	private Player playerTwo;
	private Match match;

	@Before
	public void init() {
		jankeypoGame = new JankenpoGame(new MatchValidator());
		playerOne = new Player("Dave", "P");
		playerTwo = new Player("Armando", "P");
		match = new Match();
	}

	@Test
	public void if_player_one_take_P_and_payer_two_take_P_Player_one_win() {
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerOne, winner);
	}

	@Test
	public void if_player_one_take_P_and_payer_two_take_R_Player_one_win() {
		playerOne.setStrategy("P");
		playerTwo.setStrategy("R");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerOne, winner);
	}

	@Test
	public void if_player_one_take_P_and_payer_two_take_S_Player_two_win() {
		playerOne.setStrategy("P");
		playerTwo.setStrategy("S");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerTwo, winner);
	}

	@Test
	public void if_player_one_take_S_and_payer_two_take_R_Player_two_win() {
		playerOne.setStrategy("S");
		playerTwo.setStrategy("R");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerTwo, winner);
	}

	@Test
	public void if_player_one_take_S_and_payer_two_take_P_Player_one_win() {
		playerOne.setStrategy("S");
		playerTwo.setStrategy("P");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerOne, winner);
	}

	@Test
	public void if_player_one_take_R_and_payer_two_take_S_Player_one_win() {
		playerOne.setStrategy("R");
		playerTwo.setStrategy("S");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerOne, winner);
	}

	@Test
	public void if_player_one_take_R_and_payer_two_take_P_Player_Two_win() {
		playerOne.setStrategy("R");
		playerTwo.setStrategy("P");
		match.addPlayers(playerOne, playerTwo);
		Player winner = jankeypoGame.takeWinner(match);
		Assert.assertEquals(playerTwo, winner);
	}

	@Test(expected = WrongNumberOfPlayersErrorException.class)
	public void If_less_than_2_elements_must_throw_exception() {
		match.addPlayers(playerOne);
		jankeypoGame.rpsGameWinner(match);
	}

	@Test(expected = WrongNumberOfPlayersErrorException.class)
	public void If_more_than_2_elements_must_throw_exception() {
		match.addPlayers(playerOne, playerTwo, playerOne);
		jankeypoGame.rpsGameWinner(match);
	}

	@Test
	public void if_number_of_players_are_equal_2_should_not_throw_Exception() {
		match.addPlayers(playerOne, playerTwo);
		try {
			jankeypoGame.rpsGameWinner(match);
			Assert.assertTrue(true);
		} catch (WrongNumberOfPlayersErrorException e) {
			Assert.fail();
		}
	}

	@Test(expected = NoSuchStrategyErrorException.class)
	public void if_strategy_is_different_from_R_P_S_should_throw_exception() {
		playerTwo.setStrategy("a");
		match.addPlayers(playerOne, playerTwo);
		jankeypoGame.rpsGameWinner(match);
	}

	@Test
	public void if_strategy_is_equal_to_R_P_or_S_should_not_throw_exception() {
		try {
			match.addPlayers(playerOne, playerTwo);
			jankeypoGame.rpsGameWinner(match);
			Assert.assertTrue(true);
		} catch (NoSuchStrategyErrorException e) {
			Assert.fail();
		}
	}

}
