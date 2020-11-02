package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
