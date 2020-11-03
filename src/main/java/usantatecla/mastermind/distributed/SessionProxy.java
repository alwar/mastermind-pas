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
    public void reset() {
        this.tcpip.send(FrameType.NEW_GAME.name());
    }
}
