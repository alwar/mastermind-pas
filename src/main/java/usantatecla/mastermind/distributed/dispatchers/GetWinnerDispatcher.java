package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class GetWinnerDispatcher extends Dispatcher {
    public GetWinnerDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayController controller = (PlayController) acceptorController;
        this.tcpip.send(controller.isWinner());
    }
}
