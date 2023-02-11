package server.serverUtils;

import commands.Command;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ToClient implements Serializable {
    private ArrayList<Command> commands;
    public ToClient(ArrayList<Command> commands){
        this.commands = commands;
    }
}
