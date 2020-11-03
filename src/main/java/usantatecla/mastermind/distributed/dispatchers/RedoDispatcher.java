package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class RedoDispatcher extends Dispatcher {
    public RedoDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) acceptorController).redo();
    }
}
