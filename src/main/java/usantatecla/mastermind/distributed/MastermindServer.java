package usantatecla.mastermind.distributed;

public class MastermindServer {
    private DispatcherRegistry dispatcherRegistry;

    public MastermindServer() {
        this.dispatcherRegistry = new DispatcherRegistry();
        new LogicImplementationServer().createDispatchers(this.dispatcherRegistry);
    }

    public static void main(String[] args) {
        new MastermindServer().listen();
    }

    private void listen() {
        this.dispatcherRegistry.serve();
    }
}
