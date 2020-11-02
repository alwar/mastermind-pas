package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.LocalSession;
import usantatecla.mastermind.models.Session;

public class LocalLogic extends Logic{

	@Override
	protected Controller createResumeController(Session session) {
		return new ResumeControllerLocal(session);
	}

	@Override
	protected Controller createPlayController(Session session) {
		return new PlayControllerLocal(session);
	}

	@Override
	protected Controller createStartController(Session session) {
		return new StartControllerLocal(session);
	}

	@Override
	protected Session createSession() {
		return new LocalSession();
	}
}
