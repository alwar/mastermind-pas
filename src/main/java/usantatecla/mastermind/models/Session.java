package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.List;

public class Session {
    private State state;
    private Game game;
    private GameRegistry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new GameRegistry(game);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void next() {
        this.state.next();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
        this.registry.register();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public void reset() {
        this.state.reset();
        this.game.clear();
    }
}
