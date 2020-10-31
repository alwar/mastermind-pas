package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {
    public PlayMenu(PlayController playController) {
        this.addCommand(new PlayCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
