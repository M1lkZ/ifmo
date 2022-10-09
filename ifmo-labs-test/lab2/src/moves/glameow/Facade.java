package moves.glameow;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.PSYCHIC, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        if (var1.getCondition() == Status.BURN || var1.getCondition() == Status.POISON || var1.getCondition() == Status.PARALYZE){
            return (0.4 * (double)var1.getLevel() + 2.0) * this.power / 75.0;
        }
        return (0.4 * (double)var1.getLevel() + 2.0) * this.power / 150.0;
    }

    @Override
    protected String describe() {
        return "used Facade";
    }
}
