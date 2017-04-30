package br.com.hbsis.nelson.jankenpo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JankenpoTournament implements Serializable {
	private static final long serialVersionUID = -6002752596646857114L;
	private MatchValidator matchValidator;
	private JankenpoGame jankenpoGame;
	private List<List<Match>> tournament;

	public JankenpoTournament() {
		matchValidator = new MatchValidator();
		jankenpoGame = new JankenpoGame(matchValidator);

		tournament = new ArrayList<>();
	}

	public void makeTournament() {
		List<Match> key = new ArrayList<>();

		Match matchOne = new Match();
		matchOne.addPlayers(new Player("Armando", "P"), new Player("Dave", "S"));

		key.add(matchOne);

		Match matchTwo = new Match();
		matchTwo.addPlayers(new Player("Richard", "R"), new Player("Michael", "S"));
		key.add(matchTwo);

		tournament.add(key);

		List<Match> keyTwo = new ArrayList<>();

		Match matchTree = new Match();
		matchTree.addPlayers(new Player("Allen", "S"), new Player("Omer", "P"));
		keyTwo.add(matchTree);

		Match matchFour = new Match();
		matchFour.addPlayers(new Player("David E.", "R"), new Player("Richard X.", "P"));
		keyTwo.add(matchFour);

		tournament.add(keyTwo);

	}

	public void Jogar() {
		List<List<Match>> t = new ArrayList<>();

		List<Match> key = new ArrayList<>();
		for (List<Match> keys : this.tournament) {

			Match nextMatch = new Match();
			for (Match match : keys) {
				nextMatch.getPlayers().add(jankenpoGame.takeWinner(match));
			}
			key.add(nextMatch);
		}
		t.add(key);
		this.tournament = t;
	}

	public void drawTournamentMatchs() {
		System.out.println("[");
		for (List<Match> matchs : this.tournament) {
			System.out.println("  [");
			for (Match match : matchs) {
				System.out.println("    [");
				for (Player player : match.getPlayers()) {
					System.out.printf("       [%s,%s] ", player.getName(), player.getStrategy());
				}
				System.out.println("");
				System.out.println("    ]");
			}
			System.out.println("  ],");
		}
		System.out.println("]");
	}

	public MatchValidator getMatchValidator() {
		return matchValidator;
	}

	public void setMatchValidator(MatchValidator matchValidator) {
		this.matchValidator = matchValidator;
	}

	public JankenpoGame getJankenpoGame() {
		return jankenpoGame;
	}

	public void setJankenpoGame(JankenpoGame jankenpoGame) {
		this.jankenpoGame = jankenpoGame;
	}

	public List<List<Match>> getTournament() {
		return tournament;
	}

	public void setTournament(List<List<Match>> tournament) {
		this.tournament = tournament;
	}

}
