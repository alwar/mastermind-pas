package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class CompositeControllerLeaf {

    protected Session session;

    public CompositeControllerLeaf(Session session) {
        this.session = session;
    }
}
