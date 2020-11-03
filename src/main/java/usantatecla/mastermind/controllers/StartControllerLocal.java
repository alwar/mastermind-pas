package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.LocalSession;
import usantatecla.mastermind.models.Session;

public class StartControllerLocal extends StartController {

	private LocalSession session;

	public StartControllerLocal(Session session) {
		super(session);
		this.session = (LocalSession) session;
	}

	public void start() {
		this.session.next();
	}
}
