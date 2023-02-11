package Client.clientUtils;

import commands.Command;
import lombok.Data;
import utils.Args;

import java.io.Serializable;

@Data
public class ToServer implements Serializable {
    private String command;
//    private User user;
    private Args args;

    public ToServer(String command, Args args) {
        this.command = command;
        this.args = args;
    }
}
