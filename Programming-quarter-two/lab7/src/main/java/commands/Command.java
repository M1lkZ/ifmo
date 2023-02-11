package commands;

import utils.Args;

import java.io.Serializable;

public abstract class Command implements Serializable {
        public String getInfo(){
            return this.getClass().getSimpleName();
        }
        public abstract String act(Args args);

    @Override
    public int hashCode() {
        return super.hashCode() * 31;
    }
}
