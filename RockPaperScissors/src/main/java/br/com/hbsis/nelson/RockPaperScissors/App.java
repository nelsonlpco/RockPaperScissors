package br.com.hbsis.nelson.RockPaperScissors;

import br.com.hbsis.nelson.jankenpo.JankenpoTournament;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		System.out.println("------------------- Tournament ------------------------\n");
		JankenpoTournament jankenpoTournament = new JankenpoTournament();
		jankenpoTournament.makeTournament();
		jankenpoTournament.drawTournamentMatchs();

		for (int i = 0; i < 3; i++) {
			System.out.printf("------------------- match %s ------------------------\n", i + 1);
			jankenpoTournament.Jogar();
			jankenpoTournament.drawTournamentMatchs();
		}
	}
}
