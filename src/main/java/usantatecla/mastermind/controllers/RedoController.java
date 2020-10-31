package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;

public class RedoController extends CompositeControllerLeaf {
    public RedoController(Game game, State state) {
        super(game, state);
    }

    public void redo() {
        throw new RuntimeException("Not implemented yet");
    }

    public boolean redoable() {
        return true;
    }
}
