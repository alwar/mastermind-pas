package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.distributed.Dispatcher;

public class ResumeDispatcher extends Dispatcher {
    public ResumeDispatcher(Controller resumeController) {
        super(resumeController);
    }

    @Override
    public void dispatch() {
        boolean newGame = this.tcpip.receiveBoolean();
        ((ResumeController) acceptorController).resume(newGame);
    }
}
