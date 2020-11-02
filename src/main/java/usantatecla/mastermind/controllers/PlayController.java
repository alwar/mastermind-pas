package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public abstract class PlayController extends Controller {

    public PlayController(Session session) {
        super(session);
    }

    public abstract Error addProposedCombination(List<Color> colors);

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract int getAttempts();

    public abstract List<Color> getColors(int position);

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract void undo();

    public abstract boolean undoable();

    public abstract void redo();

    public abstract boolean redoable();

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
