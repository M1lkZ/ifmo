package server;

import Client.clientUtils.ToServer;
import commands.Command;
import lombok.Data;
import utils.Args;
import utils.Deserializer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.Arrays;

/*
* TODO
*  add commands handler
*  maybe it is possible to rethink the way of initializing connection
* */

@Data
public class ServerManager {
    private InetSocketAddress address;
    private DatagramChannel channel;
    private ArrayList<Command> serverCommands = new ArrayList<>();

    public ServerManager(InetSocketAddress address, DatagramChannel channel){
        this.address = address;
        this.channel = channel;
        try{
            channel.bind(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Listen(){
        ByteBuffer buf = ByteBuffer.allocate(1024*10);
        while(Thread.currentThread().isAlive()){
            try {
                SocketAddress sender = channel.receive(buf);
                Object des = Deserializer.deserialize(buf);
                if (des instanceof ToServer s){
                    Args args = s.getArgs();
                    args.setAddress(sender);
                    args.setChannel(channel);
                    args.setServerCommands(this.serverCommands);
                    if (!HandleCommand(s.getCommand(), args)){
                        System.out.println("Received unknown command");
                    }
                } else {
                    System.out.println("Received wrong class type");
                }
                buf.clear();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void AppendCommands(Command... command){
        this.serverCommands.addAll(Arrays.asList(command));
    }

    public boolean HandleCommand(String command, Args args){
        for (Command orig: serverCommands) {
            if (command.equals(orig.getInfo())){
                orig.act(args);
                return true;
            }
        }
        return false;

//        if (command.hashCode() == command.hashCode()){
//            System.out.println("Commands are same");
//        } else {
//            System.out.println("Commands are different");
//        }
    }

}
