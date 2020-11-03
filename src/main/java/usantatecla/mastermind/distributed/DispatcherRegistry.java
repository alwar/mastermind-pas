package usantatecla.mastermind.distributed;

import usantatecla.utils.TCPIP;

import java.util.HashMap;
import java.util.Map;

public class DispatcherRegistry {

	private TCPIP tcpip;

	private Map<FrameType, Dispatcher> dispatcherMap;

	public DispatcherRegistry() {
		this.tcpip = TCPIP.createServerSocket();
		this.dispatcherMap = new HashMap<FrameType, Dispatcher>();
	}
	
	public void add (FrameType frameType, Dispatcher dispatcher) {
		this.dispatcherMap.put(frameType, dispatcher);
		dispatcher.associate(this.tcpip);
	}

	public void dispatch(FrameType frameType) {
		Dispatcher d = this.dispatcherMap.get(frameType);
		System.err.println("dispatching frame type " + frameType.name() + " to dispatcher " + d.getClass().toString());
		d.dispatch();
	}

	public void serve() {
		FrameType frameType = null;
		do {
			String string = this.tcpip.receiveLine();
			frameType = FrameType.parser(string);
			if (frameType != null && frameType != FrameType.CLOSE) {
				this.dispatch(frameType);
			} else {
				System.err.println("frame type is null or unknown: " + string);
			}
		} while (frameType != FrameType.CLOSE);
		this.tcpip.close();		
	}

}
