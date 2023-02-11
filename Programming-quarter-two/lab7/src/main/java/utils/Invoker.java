package utils;

import commands.Command;

import java.util.ArrayList;

public class Invoker {
    public static Command invoke(String input, ArrayList<Command> commands){
        for (Command cmd: commands) {
            if (input.equals(cmd.getInfo())){
                return cmd;
            }
        }
        return null;
    }
}
