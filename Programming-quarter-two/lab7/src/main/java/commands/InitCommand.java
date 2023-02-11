package commands;

import server.serverUtils.ToClient;
import utils.Args;
import utils.Serializer;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;

public class InitCommand extends Command implements Serializable {
    @Override
    public String act(Args args) {
        DatagramChannel channel = args.getChannel();
        SocketAddress sender = args.getAddress();
        try{
            channel.send(Serializer.serialize(new ToClient(args.getServerCommands())), sender);
            return "Initialized successfully";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Initialization didn't happen";
    }
}
