package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.utils.TCPIP;

public abstract class Dispatcher {
	
	protected Controller acceptorController;
	
	protected TCPIP tcpip;
	
	public Dispatcher(Controller acceptorController) {
		this.acceptorController = acceptorController;
	}

	public abstract void dispatch();
	
	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
