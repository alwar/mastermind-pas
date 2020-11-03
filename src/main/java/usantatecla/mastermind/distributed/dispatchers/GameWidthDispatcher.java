package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class GameWidthDispatcher extends Dispatcher {
    public GameWidthDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(acceptorController.getWidth());
    }
}
