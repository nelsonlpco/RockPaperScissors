package br.com.hbsis.nelson.jankenpo;

public class Player {

	private String name;
	private String strategy;

	public Player() {

	}

	public Player(String name, String strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

}
