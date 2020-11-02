package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	public abstract void resume(boolean newGame);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
