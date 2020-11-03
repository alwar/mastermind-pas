package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.Dispatcher;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.ArrayList;
import java.util.List;

public class AddProposedCombinationDispatcher extends Dispatcher {
    public AddProposedCombinationDispatcher(Controller playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayController controller = (PlayController)acceptorController;

        List<Color> colors = new ArrayList<>();
        int width = controller.getWidth();
        for (int i=0; i<width; i++) {
            colors.add(Color.valueOf(this.tcpip.receiveLine()));
        }

        Error e = controller.addProposedCombination(colors);
        if (e != null) {
            this.tcpip.send(e.name());
        } else {
            this.tcpip.send("null");
        }
    }
}
