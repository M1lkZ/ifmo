package server;

import commands.AddCommand;
import commands.InitCommand;
import utils.Args;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

/*
* TODO
*  rework completely with using manager: done
* */

public class Server implements Runnable{
    public Server() {
    }

    @Override
    public void run() {
        try (DatagramChannel channel = DatagramChannel.open()){
            ServerManager manager = new ServerManager(new InetSocketAddress("localhost", 1234), channel);
            manager.AppendCommands(new AddCommand(), new InitCommand());
            manager.Listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}