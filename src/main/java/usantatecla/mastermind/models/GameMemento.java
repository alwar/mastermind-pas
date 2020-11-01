package usantatecla.mastermind.models;

public class GameMemento {
    private ProposedCombination combination;
    private Result result;

    public GameMemento(ProposedCombination combination, Result result) {
        this.combination = combination;
        this.result = result;
    }

    public ProposedCombination getProposedCombination() {
        return this.combination;
    }

    public Result getResult() {
        return result;
    }
}
