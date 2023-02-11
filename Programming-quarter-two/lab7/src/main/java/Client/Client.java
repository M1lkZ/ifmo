package Client;

import commands.ExitCommand;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

public class Client implements Runnable{
    public Client() {
    }
    @Override
    public void run() {
        try (DatagramChannel channel = DatagramChannel.open()) {
            InetSocketAddress address = new InetSocketAddress("localhost", 1234);
            ClientManager manager = new ClientManager(channel, address);
            manager.AppendCommands(new ExitCommand());
            manager.init();
            manager.printCommands();
            manager.send();
        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }
}

