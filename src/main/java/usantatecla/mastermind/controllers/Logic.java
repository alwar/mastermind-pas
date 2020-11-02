package usantatecla.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionLocal;
import usantatecla.mastermind.models.StateValue;

public abstract class Logic {

	protected final Controller startController;
	protected final Controller playController;
	protected final Controller resumeController;
	protected final Session session;
	
	private Map<StateValue, Controller> controllers;

	public Logic() {
		this.session = this.createSession();
		this.startController = this.createStartController(this.session);
		this.playController = this.createPlayController(this.session);
		this.resumeController = this.createResumeController(this.session);

		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, startController);
		this.controllers.put(StateValue.IN_GAME, playController);
		this.controllers.put(StateValue.FINAL, resumeController);
		this.controllers.put(StateValue.EXIT, null);
	}

	protected abstract Controller createResumeController(Session session);

	protected abstract Controller createPlayController(Session session);

	protected abstract Controller createStartController(Session session);

	protected abstract Session createSession();

	public Controller getController() {
		return this.controllers.get(this.session.getValueState());
	}
	
}
