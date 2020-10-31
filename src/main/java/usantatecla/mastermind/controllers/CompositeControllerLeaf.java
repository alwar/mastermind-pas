package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.State;
import usantatecla.mastermind.models.Game;

public abstract class CompositeControllerLeaf {

    protected Game game;
    protected State state;

    public CompositeControllerLeaf(Game game, State state) {
        this.game = game;
        this.state = state;
    }
}
