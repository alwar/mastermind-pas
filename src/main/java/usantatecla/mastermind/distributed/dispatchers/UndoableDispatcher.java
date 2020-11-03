package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class UndoableDispatcher extends Dispatcher {
    public UndoableDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayController controller = (PlayController) acceptorController;
        this.tcpip.send(controller.undoable());
    }
}
