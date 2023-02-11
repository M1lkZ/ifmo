package utils;

import commands.Command;
import lombok.Data;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;


@Data
public class Args implements Serializable {
    private DatagramChannel channel;
    private SocketAddress address;
    private String[] args;
    private ArrayList<Command> serverCommands;
}
