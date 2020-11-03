package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class UndoDispatcher extends Dispatcher {
    public UndoDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) acceptorController).undo();
    }
}
