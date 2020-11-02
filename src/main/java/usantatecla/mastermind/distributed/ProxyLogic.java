package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Session;

public class ProxyLogic extends Logic {
    private static MastermindSocket socket;

    public static MastermindSocket getSocket() {
        if (ProxyLogic.socket == null) {
            ProxyLogic.socket = MastermindSocket.createClientSocket();
        }
        return ProxyLogic.socket;
    }

    @Override
    protected Controller createResumeController(Session session) {
        return new ResumeControllerProxy(session, getSocket());
    }

    @Override
    protected Controller createPlayController(Session session) {
        return new PlayControllerProxy(session, getSocket());
    }

    @Override
    protected Controller createStartController(Session session) {
        return new StartControllerProxy(session, getSocket());
    }

    @Override
    protected Session createSession() {
        return new SessionProxy(getSocket());
    }
}
