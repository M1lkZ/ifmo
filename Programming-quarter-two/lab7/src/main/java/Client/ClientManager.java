package Client;

import Client.clientUtils.ToServer;
import commands.Command;
import commands.InitCommand;
import lombok.Data;
import server.serverUtils.ToClient;
import utils.Args;
import utils.Deserializer;
import utils.Serializer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.Arrays;

/*
* TODO
*  create abstract entity of managers
*  change while true loop to something more adequate (use Thread): done
*  think on how to remove send() call from constructor: done
*  add client-sided commands handling(like exit and similar)
* */

@Data
public class ClientManager {
    private DatagramChannel channel;
    private InetSocketAddress serverAddress;
    private ArrayList<Command> clientCommands = new ArrayList<>();
    private ArrayList<Command> serverCommands = new ArrayList<>();

    public ClientManager(DatagramChannel channel, InetSocketAddress serverAddress) throws IOException, ClassNotFoundException {
        this.channel = channel;
        this.serverAddress = serverAddress;
    }

    public void send() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (Thread.currentThread().isAlive()) {
                String msg = br.readLine();
                String[] arr = msg.split(" ");
                Args args = new Args();
                args.setArgs(Arrays.copyOfRange(arr, 1, arr.length));
                if(!HandleCommand(arr[0], args)) {
                    ByteBuffer buf = Serializer.serialize(new ToServer(arr[0], args));
                    channel.send(buf, serverAddress);
                    buf.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException, ClassNotFoundException {
        ByteBuffer rec = ByteBuffer.allocate(1024*4);
        Args args = new Args();
        ByteBuffer buf = Serializer.serialize(new ToServer("InitCommand", args));
        this.channel.send(buf, this.serverAddress);
        buf.clear();
        this.channel.receive(rec);
        if (Deserializer.deserialize(rec) instanceof ToClient r){
            rec.clear();
            this.serverCommands = r.getCommands();
        } else {
            throw new RuntimeException("Server answered with wrong data");
        }
    }

    public void AppendCommands(Command... command){
        this.clientCommands.addAll(Arrays.asList(command));
    }

    public void printCommands(){
        System.out.println("Client-sided commands: ");
        for (Command cmd: this.clientCommands) {
            System.out.println(cmd.getInfo());
        }
        System.out.println("Server-sided commands: ");
        for (Command cmd: this.serverCommands) {
            System.out.println(cmd.getInfo());
        }
    }

    public boolean HandleCommand(String command, Args args){
        for (Command orig: clientCommands) {
            if (command.equals(orig.getInfo())){
                orig.act(args);
                return true;
            }
        }
        return false;
    }
}
