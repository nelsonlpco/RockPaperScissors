package br.com.hbsis.nelson.jankenpo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {

	private List<Player> players;

	public Match() {
		this.players = new ArrayList<>();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void addPlayers(Player... players) {
		this.players = Arrays.asList(players);
	}

}
