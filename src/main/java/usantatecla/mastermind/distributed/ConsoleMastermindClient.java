package usantatecla.mastermind.distributed;

import usantatecla.mastermind.ConsoleMastermind;
import usantatecla.mastermind.controllers.Logic;

public class ConsoleMastermindClient extends ConsoleMastermind
{
    public static void main(String[] args) {
        new ConsoleMastermindClient().play();
    }

    @Override
    protected Logic createLogic() {
        return new ProxyLogic();
    }
}
