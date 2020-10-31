package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Command;

public class RedoCommand extends Command {
    private PlayController playController;

    public RedoCommand(PlayController playController) {
        super("Redo previous undo action");
        this.playController = playController;
    }

    @Override
    protected void execute() {
        playController.redo();
    }

    @Override
    protected boolean isActive() {
        return playController.redoable();
    }
}
