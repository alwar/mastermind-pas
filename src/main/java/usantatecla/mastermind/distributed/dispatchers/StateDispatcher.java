package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.distributed.Dispatcher;

public class StateDispatcher extends Dispatcher {
    public StateDispatcher(Controller playController) {
        super(playController);
    }

    public void dispatch() {
        this.tcpip.send(this.acceptorController.getValueState().ordinal());
    }

}
