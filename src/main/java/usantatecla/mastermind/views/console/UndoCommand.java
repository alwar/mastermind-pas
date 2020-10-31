package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Command;

public class UndoCommand extends Command {
    private PlayController playController;

    public UndoCommand(PlayController playController) {
        super("Undo last action");
        this.playController = playController;
    }

    @Override
    protected void execute() {
        playController.undo();
    }

    @Override
    protected boolean isActive() {
        return playController.undoable();
    }
}
