package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.TCPIP;

import java.util.ArrayList;
import java.util.List;

public class PlayControllerProxy extends PlayController {
    private TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.ADD_PROPOSED_COMBINATION.name());
        return Error.valueOf(this.tcpip.receiveLine());
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.GET_WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.GET_LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public int getAttempts() {
        this.tcpip.send(FrameType.GET_ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        int width = this.getWidth();

        this.tcpip.send(FrameType.GET_COLORS.name());
        this.tcpip.send(position);

        List<Color> list = new ArrayList<>();
        for(int i = 0; i< width; i++) {
            list.add(Color.valueOf(this.tcpip.receiveLine()));
        }

        return list;
    }

    @Override
    public int getBlacks(int position) {
        this.tcpip.send(FrameType.GET_BLACKS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWhites(int position) {
        this.tcpip.send(FrameType.GET_WHITES.name());
        return this.tcpip.receiveInt();
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
