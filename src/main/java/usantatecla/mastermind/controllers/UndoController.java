package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;

public class UndoController extends CompositeControllerLeaf {
    public UndoController(Game game, State state) {
        super(game, state);
    }

    public void undo() {
        throw new RuntimeException("Not implemented yet");
    }

    public boolean undoable() {
        return true;
    }
}
