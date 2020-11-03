package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {
    private Game game;
    private List<GameMemento> gameMementoList;
    private int currentPosition;

    public GameRegistry(Game game) {
        this.game = game;
        this.reset();
    }

    public boolean undoable() {
        return this.currentPosition >= 1;
    }

    public void undo() {
        this.currentPosition--;
        this.game.setProposedCombinations(this.gameMementoList.subList(0, this.currentPosition));
    }

    public void redo() {
        this.currentPosition++;
        this.game.setProposedCombinations(this.gameMementoList.subList(0, this.currentPosition-1));
    }

    public boolean redoable() {
        return this.gameMementoList.size() > this.game.getAttempts();
    }

    public void register() {
        if (this.gameMementoList.size() > this.currentPosition) {
            this.gameMementoList.subList(this.currentPosition, this.gameMementoList.size()).clear();
        }
        this.currentPosition++;
        this.gameMementoList.add(this.game.createMemento());
    }

    public void reset() {
        this.gameMementoList = new ArrayList<>();
        this.currentPosition = 0;
    }
}
