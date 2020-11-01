package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	public Game() {
		this.clear();
	}

	public void setProposedCombinations(List<GameMemento> proposedCombinations) {
		this.proposedCombinations = new ArrayList<>();
		this.results = new ArrayList<>();

		for(GameMemento memento: proposedCombinations) {
			this.proposedCombinations.add(memento.getProposedCombination());
			this.results.add(memento.getResult());
		}
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<>();
		this.results = new ArrayList<>();
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
	}

	public boolean isLooser() {
		return this.getAttempts() == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		return this.results.get(this.getAttempts()-1).isWinner();
	}

	public int getAttempts() {
		return this.proposedCombinations.size();
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public GameMemento createMemento() {
		int index = this.getAttempts()-1;
		return new GameMemento(
			this.proposedCombinations.get(index),
			this.results.get(index)
		);
	}
}
