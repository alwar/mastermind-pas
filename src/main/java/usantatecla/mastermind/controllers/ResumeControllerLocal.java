package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class ResumeControllerLocal extends ResumeController {

	public ResumeControllerLocal(Session session) {
		super(session);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.session.reset();
		} else {
			this.session.next();
		}
	}
}
