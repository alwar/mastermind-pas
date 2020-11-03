package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;

public class GetBlacksDispatcher extends Dispatcher {
    public GetBlacksDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayController controller = (PlayController) acceptorController;
        this.tcpip.send(controller.getBlacks(this.tcpip.receiveInt()));
    }
}