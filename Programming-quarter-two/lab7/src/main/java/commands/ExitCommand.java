package commands;

import utils.Args;

public class ExitCommand extends Command{
    @Override
    public String act(Args args) {
        return "Exit command worked";
    }
}
