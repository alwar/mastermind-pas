package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class UndoController extends CompositeControllerLeaf {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean undoable() {
        return this.session.undoable();
    }
}
