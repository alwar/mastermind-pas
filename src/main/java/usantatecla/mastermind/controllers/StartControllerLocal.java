package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class StartControllerLocal extends StartController {

	public StartControllerLocal(Session session) {
		super(session);
	}

	public void start() {
		this.session.next();
	}
}
