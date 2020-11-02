package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.TCPIP;

import java.util.List;

public class PlayControllerProxy extends PlayController {
    private TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        this.session.addProposedCombination(colors);
        return null;
    }

    @Override
    public boolean isWinner() {
        return this.session.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.session.isLooser();
    }

    @Override
    public int getAttempts() {
        return this.session.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

    @Override
    public void undo() {
        this.session.undo();
    }

    @Override
    public void redo() {
        this.session.redo();
    }

    @Override
    public boolean undoable() {
        return this.session.undoable();
    }

    @Override
    public boolean redoable() {
        return this.session.redoable();
    }
}
