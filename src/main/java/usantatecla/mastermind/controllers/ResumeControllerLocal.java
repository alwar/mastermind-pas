package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.LocalSession;
import usantatecla.mastermind.models.Session;

public class ResumeControllerLocal extends ResumeController {

	private LocalSession session;

	public ResumeControllerLocal(Session session) {
		super(session);
		this.session = (LocalSession) session;
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.session.reset();
		} else {
			this.session.next();
		}
	}
}
