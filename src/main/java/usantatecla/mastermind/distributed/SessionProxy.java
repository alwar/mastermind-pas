package usantatecla.mastermind.distributed;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.ArrayList;
import java.util.List;

public class SessionProxy implements Session {
    private MastermindSocket tcpip;

    public SessionProxy(MastermindSocket tcpip) {
        this.tcpip = tcpip;
    }


    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.GAME_WIDTH.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.STATE_NEXT.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.ADD_PROPOSED_COMBINATION.name());
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
    public void reset() {
        this.tcpip.send(FrameType.NEW_GAME.name());
    }
}
