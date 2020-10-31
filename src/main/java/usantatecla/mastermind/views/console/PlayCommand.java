package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Command;
import usantatecla.utils.Console;

import java.util.List;

public class PlayCommand extends Command {
    private PlayController playController;

    public PlayCommand(PlayController playController) {
        super("Enter guess combination:");
        this.playController = playController;
    }

    @Override
    protected void execute() {
        Error error;
        do {
            List<Color> colors = new ProposedCombinationView(playController).read();
            error = playController.addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        Console.instance().writeln();
        new AttemptsView(playController).writeln();
        new SecretCombinationView(playController).writeln();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}
