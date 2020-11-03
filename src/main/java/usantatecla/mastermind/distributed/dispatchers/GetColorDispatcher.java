package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;
import usantatecla.mastermind.types.Color;

import java.util.List;

public class GetColorDispatcher extends Dispatcher {
    public GetColorDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayController controller = (PlayController) acceptorController;
        List<Color> colors = controller.getColors(this.tcpip.receiveInt());

        for (Color color : colors) {
            this.tcpip.send(color.name());
        }
    }
}
