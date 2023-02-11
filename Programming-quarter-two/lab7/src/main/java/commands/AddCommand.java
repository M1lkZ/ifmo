package commands;

import utils.Args;

import java.io.Serializable;

/*
* TODO
*  forget about it for now, then recreate it so it does what it has to
* */

public class AddCommand extends Command implements Serializable {
    @Override
    public String act(Args args) {
        return "You've added smth";
    }

}
