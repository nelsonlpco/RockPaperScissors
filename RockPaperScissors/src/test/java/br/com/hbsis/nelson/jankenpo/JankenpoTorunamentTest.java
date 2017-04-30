package br.com.hbsis.nelson.jankenpo;

import java.util.List;

import br.com.hbsis.nelson.jankenpo.JankenpoTournament;

import org.junit.Before;
import org.junit.Test;


import junit.framework.Assert;

public class JankenpoTorunamentTest {
	private JankenpoTournament jankenpoTorunament;

	@Before
	public void Init() {
		jankenpoTorunament = new JankenpoTournament();
		jankenpoTorunament.makeTournament();
	}

	@Test
	public void Richard_should_be_the_winner() {
		for (int i = 0; i < 3; i++) {
			jankenpoTorunament.Jogar();
		}
		List<Match> keys = jankenpoTorunament.getTournament().get(0);
		Match match = keys.get(0);
		Player winner = match.getPlayers().get(0);
		Assert.assertEquals("Richard", winner.getName());
	}

}
